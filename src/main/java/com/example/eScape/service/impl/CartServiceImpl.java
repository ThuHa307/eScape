package com.example.eScape.service.impl;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.example.eScape.dto.CartDTO.CartRequestDTO;
import com.example.eScape.dto.CartDTO.CartResponseDTO;
import com.example.eScape.exception.BadRequestException;
import com.example.eScape.mapper.CartMapper;
import com.example.eScape.model.Cart;
import com.example.eScape.repository.CartRepository;
import com.example.eScape.repository.provider.CartDynamicSqlSupport;
import com.example.eScape.service.CartService;
import com.example.eScape.service.ProductDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final CartMapper cartMapper;
    private final ProductDetailsService productDetailsService;

    @Override
    public List<CartResponseDTO> findByUserId(String userId) {
        if (userId == null) {
            throw new BadRequestException("UserId is required!");
        }
        return cartRepository.getCartByUserId(userId);
    }

    @Override
    @Transactional
    public void updateCart(CartRequestDTO cartRequestDTO) {
        if (cartRequestDTO.getQuantity() <= 0) {
            throw new BadRequestException("Quantity must be greater than 0");
        }

        var productDetails =
            productDetailsService
                .findByCriteria(cartRequestDTO.getProductId(), cartRequestDTO.getColor(), cartRequestDTO.getSize());

        if (productDetails.isPresent()) {
            var existingCart = readExistingCart(cartRequestDTO.getUserId(), productDetails.get().getProductDetailId());
            if (existingCart.isPresent()) {
                cartRepository.update(c ->
                        c.set(CartDynamicSqlSupport.quantity).equalTo(existingCart.get().getQuantity() + cartRequestDTO.getQuantity())
                         .where(CartDynamicSqlSupport.cartid, isEqualTo(existingCart.get().getCartid()))
                );
            } else {
                deleteCart(cartRequestDTO.getCartId());
                cartRequestDTO.setProductDetailId(productDetails.get().getProductDetailId());
                insertWithoutChecking(cartRequestDTO);
            }
        }
        else throw new BadRequestException("Product details not found!");
    }

    @Override
    @Transactional
    public void insertCart(CartRequestDTO cartRequestDTO) {
        if (cartRequestDTO.getQuantity() <= 0) {
            throw new BadRequestException("Quantity must be greater than 0");
        }
        var productDetails
                = productDetailsService
                    .findByCriteria(cartRequestDTO.getProductId(), cartRequestDTO.getColor(), cartRequestDTO.getSize());
        if (productDetails.isPresent()) {
            var existingCart = readExistingCart(cartRequestDTO.getUserId(), productDetails.get().getProductDetailId());
            if (existingCart.isPresent()) {
                Cart cart = existingCart.get();
                cartRepository.update(c ->
                        c.set(CartDynamicSqlSupport.quantity)
                         .equalTo(cart.getQuantity() + cartRequestDTO.getQuantity())
                         .where(CartDynamicSqlSupport.cartid, isEqualTo(cart.getCartid()))
                );
            }
            else {
                Cart cart = new Cart();
                cart.setCartid(UUID.randomUUID().toString());
                cart.setUserid(cartRequestDTO.getUserId());
                cart.setProductdetailid(productDetails.get().getProductDetailId());
                cart.setQuantity(cartRequestDTO.getQuantity());
                cartRepository.insert(cart);
            }
        }
        else throw new BadRequestException("Product details not found!");
    }

    @Override
    public void deleteCart(String cartId) {
        cartRepository
            .delete(completer -> completer.where(CartDynamicSqlSupport.cartid, isEqualTo(cartId)));
    }

    private Optional<Cart> readExistingCart(String userId, String productDetailId) {
        return cartRepository
                .selectOne(
                    completer ->
                        completer.where(CartDynamicSqlSupport.userid, isEqualTo(userId))
                                .and(CartDynamicSqlSupport.productdetailid, isEqualTo(productDetailId)));
    }

    private void insertWithoutChecking(CartRequestDTO cartRequestDTO) {
        Cart cart = new Cart();
        cart.setCartid(UUID.randomUUID().toString());
        cart.setUserid(cartRequestDTO.getUserId());
        cart.setProductdetailid(cartRequestDTO.getProductDetailId());
        cart.setQuantity(cartRequestDTO.getQuantity());
        cartRepository.insert(cart);
    }
}
