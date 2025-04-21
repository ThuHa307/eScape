package com.example.eScape.service.impl;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.example.eScape.common.ApiConstants;
import com.example.eScape.dto.WishlistDTO.WishlistRequestDTO;
import com.example.eScape.dto.WishlistDTO.WishlistResponseDTO;
import com.example.eScape.exception.BadRequestException;
import com.example.eScape.exception.DuplicateResourceException;
import com.example.eScape.exception.ResourceNotFoundException;
import com.example.eScape.mapper.WishlistMapper;
import com.example.eScape.repository.WishlistRepository;
import com.example.eScape.repository.provider.WishlistDynamicSqlSupport;
import com.example.eScape.service.WishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WishlistServiceImpl implements WishlistService {
    private final WishlistRepository wishlistRepository;
    private final WishlistMapper wishlistMapper;

    @Override
    public List<WishlistResponseDTO> findAllByUser(String userId) {
        if (userId == null) {
            throw new BadRequestException("UserId is required!");
        }
        return wishlistRepository.findByUser(userId);
    }

    @Override
    public void createWishlist(WishlistRequestDTO wishlist) {
        validateDuplicateWishlist(wishlist.getUserid(), wishlist.getProductdetailid());
        wishlist.setWishlistid(UUID.randomUUID().toString());
        wishlistRepository.insert(wishlistMapper.toEntity(wishlist));
    }

    @Override
    public void deleteWishlist(String wishlistId) {
        validateNotFoundWishlist(wishlistId);
        wishlistRepository.deleteByPrimaryKey(wishlistId);
    }

    private void validateDuplicateWishlist(String userId, String productDetailId) {
        var wishlist = wishlistRepository.selectOne(
            completer ->
                completer.where(WishlistDynamicSqlSupport.userid, isEqualTo(userId))
                        .and(WishlistDynamicSqlSupport.productdetailid, isEqualTo(productDetailId))
                        .limit(1)
        );
        if(wishlist.isPresent()) {
            throw new DuplicateResourceException(ApiConstants.WISHLIST_DUPLICATE);
        }
    }

    private void validateNotFoundWishlist(String wishlistId) {
        var existingWishlist = wishlistRepository.selectOne(
            completer -> completer.where(WishlistDynamicSqlSupport.wishlistid, isEqualTo(wishlistId))
        );
        if(existingWishlist.isEmpty()) {
            throw new ResourceNotFoundException(ApiConstants.RESOURCE_NOT_FOUND);
        }
    }

}
