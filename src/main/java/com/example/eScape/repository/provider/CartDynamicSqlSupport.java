package com.example.eScape.repository.provider;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import java.util.Date;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class CartDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.586267+07:00", comments="Source Table: cart")
    public static final Cart cart = new Cart();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.586267+07:00", comments="Source field: cart.cartid")
    public static final SqlColumn<String> cartid = cart.cartid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.586267+07:00", comments="Source field: cart.userid")
    public static final SqlColumn<String> userid = cart.userid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.586267+07:00", comments="Source field: cart.productdetailid")
    public static final SqlColumn<String> productdetailid = cart.productdetailid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.586267+07:00", comments="Source field: cart.quantity")
    public static final SqlColumn<Integer> quantity = cart.quantity;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.586267+07:00", comments="Source field: cart.createdat")
    public static final SqlColumn<Date> createdat = cart.createdat;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.586267+07:00", comments="Source field: cart.deletedat")
    public static final SqlColumn<Date> deletedat = cart.deletedat;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.586267+07:00", comments="Source field: cart.isdeleted")
    public static final SqlColumn<Boolean> isdeleted = cart.isdeleted;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.586267+07:00", comments="Source Table: cart")
    public static final class Cart extends AliasableSqlTable<Cart> {
        public final SqlColumn<String> cartid = column("cartid", JDBCType.VARCHAR);

        public final SqlColumn<String> userid = column("userid", JDBCType.VARCHAR);

        public final SqlColumn<String> productdetailid = column("productdetailid", JDBCType.VARCHAR);

        public final SqlColumn<Integer> quantity = column("quantity", JDBCType.INTEGER);

        public final SqlColumn<Date> createdat = column("createdat", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> deletedat = column("deletedat", JDBCType.TIMESTAMP);

        public final SqlColumn<Boolean> isdeleted = column("isdeleted", JDBCType.BIT);

        public Cart() {
            super("cart", Cart::new);
        }
    }
}