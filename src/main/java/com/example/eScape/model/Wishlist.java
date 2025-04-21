package com.example.eScape.model;

import jakarta.annotation.Generated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wishlist {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.5979838+07:00", comments="Source field: wishlist.wishlistid")
    private String wishlistid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.5979838+07:00", comments="Source field: wishlist.userid")
    private String userid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.5979838+07:00", comments="Source field: wishlist.productdetailid")
    private String productdetailid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.5979838+07:00", comments="Source field: wishlist.createdat")
    private Date createdat;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.5979838+07:00", comments="Source field: wishlist.deletedat")
    private Date deletedat;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.5979838+07:00", comments="Source field: wishlist.isdeleted")
    private Boolean isdeleted;

}