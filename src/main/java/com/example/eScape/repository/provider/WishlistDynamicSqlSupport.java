package com.example.eScape.repository.provider;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import java.util.Date;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class WishlistDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.5979838+07:00", comments="Source Table: wishlist")
    public static final Wishlist wishlist = new Wishlist();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.5979838+07:00", comments="Source field: wishlist.wishlistid")
    public static final SqlColumn<String> wishlistid = wishlist.wishlistid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.5979838+07:00", comments="Source field: wishlist.userid")
    public static final SqlColumn<String> userid = wishlist.userid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.5979838+07:00", comments="Source field: wishlist.productdetailid")
    public static final SqlColumn<String> productdetailid = wishlist.productdetailid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.5979838+07:00", comments="Source field: wishlist.createdat")
    public static final SqlColumn<Date> createdat = wishlist.createdat;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.5979838+07:00", comments="Source field: wishlist.deletedat")
    public static final SqlColumn<Date> deletedat = wishlist.deletedat;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.5979838+07:00", comments="Source field: wishlist.isdeleted")
    public static final SqlColumn<Boolean> isdeleted = wishlist.isdeleted;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.5979838+07:00", comments="Source Table: wishlist")
    public static final class Wishlist extends AliasableSqlTable<Wishlist> {
        public final SqlColumn<String> wishlistid = column("wishlistid", JDBCType.VARCHAR);

        public final SqlColumn<String> userid = column("userid", JDBCType.VARCHAR);

        public final SqlColumn<String> productdetailid = column("productdetailid", JDBCType.VARCHAR);

        public final SqlColumn<Date> createdat = column("createdat", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> deletedat = column("deletedat", JDBCType.TIMESTAMP);

        public final SqlColumn<Boolean> isdeleted = column("isdeleted", JDBCType.BIT);

        public Wishlist() {
            super("wishlist", Wishlist::new);
        }
    }
}