package com.example.eScape.model;

import com.example.eScape.common.Constants;
import jakarta.annotation.Generated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.586267+07:00", comments="Source field: cart.cartid")
    private String cartid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.586267+07:00", comments="Source field: cart.userid")
    private String userid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.586267+07:00", comments="Source field: cart.productdetailid")
    private String productdetailid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.586267+07:00", comments="Source field: cart.quantity")
    private Integer quantity = Constants.CART_ITEM_QUANTITY;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.586267+07:00", comments="Source field: cart.createdat")
    private Date createdat;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.586267+07:00", comments="Source field: cart.deletedat")
    private Date deletedat;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.586267+07:00", comments="Source field: cart.isdeleted")
    private Boolean isdeleted;
}