package com.example.eScape.repository;

import static com.example.eScape.repository.provider.WishlistDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import com.example.eScape.dto.WishlistDTO.WishlistResponseDTO;
import com.example.eScape.model.Wishlist;
import jakarta.annotation.Generated;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonInsertMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface WishlistRepository extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<Wishlist>, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.5979838+07:00", comments="Source Table: wishlist")
    BasicColumn[] selectList = BasicColumn.columnList(wishlistid, userid, productdetailid, createdat, deletedat, isdeleted);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.5979838+07:00", comments="Source Table: wishlist")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="WishlistResult", value = {
        @Result(column="wishlistid", property="wishlistid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="userid", property="userid", jdbcType=JdbcType.VARCHAR),
        @Result(column="productdetailid", property="productdetailid", jdbcType=JdbcType.VARCHAR),
        @Result(column="createdat", property="createdat", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deletedat", property="deletedat", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="isdeleted", property="isdeleted", jdbcType=JdbcType.BIT)
    })
    List<Wishlist> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.5979838+07:00", comments="Source Table: wishlist")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("WishlistResult")
    Optional<Wishlist> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.5979838+07:00", comments="Source Table: wishlist")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, wishlist, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.5979838+07:00", comments="Source Table: wishlist")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, wishlist, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.5979838+07:00", comments="Source Table: wishlist")
    default int deleteByPrimaryKey(String wishlistid_) {
        return delete(c -> 
            c.where(wishlistid, isEqualTo(wishlistid_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.5979838+07:00", comments="Source Table: wishlist")
    default int insert(Wishlist row) {
        return MyBatis3Utils.insert(this::insert, row, wishlist, c ->
            c.map(wishlistid).toProperty("wishlistid")
            .map(userid).toProperty("userid")
            .map(productdetailid).toProperty("productdetailid")
            .map(createdat).toProperty("createdat")
            .map(deletedat).toProperty("deletedat")
            .map(isdeleted).toProperty("isdeleted")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.5979838+07:00", comments="Source Table: wishlist")
    default int insertMultiple(Collection<Wishlist> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, wishlist, c ->
            c.map(wishlistid).toProperty("wishlistid")
            .map(userid).toProperty("userid")
            .map(productdetailid).toProperty("productdetailid")
            .map(createdat).toProperty("createdat")
            .map(deletedat).toProperty("deletedat")
            .map(isdeleted).toProperty("isdeleted")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.5979838+07:00", comments="Source Table: wishlist")
    default int insertSelective(Wishlist row) {
        return MyBatis3Utils.insert(this::insert, row, wishlist, c ->
            c.map(wishlistid).toPropertyWhenPresent("wishlistid", row::getWishlistid)
            .map(userid).toPropertyWhenPresent("userid", row::getUserid)
            .map(productdetailid).toPropertyWhenPresent("productdetailid", row::getProductdetailid)
            .map(createdat).toPropertyWhenPresent("createdat", row::getCreatedat)
            .map(deletedat).toPropertyWhenPresent("deletedat", row::getDeletedat)
            .map(isdeleted).toPropertyWhenPresent("isdeleted", row::getIsdeleted)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.5979838+07:00", comments="Source Table: wishlist")
    default Optional<Wishlist> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, wishlist, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.5979838+07:00", comments="Source Table: wishlist")
    default List<Wishlist> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, wishlist, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.5979838+07:00", comments="Source Table: wishlist")
    default List<Wishlist> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, wishlist, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.5979838+07:00", comments="Source Table: wishlist")
    default Optional<Wishlist> selectByPrimaryKey(String wishlistid_) {
        return selectOne(c ->
            c.where(wishlistid, isEqualTo(wishlistid_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.5979838+07:00", comments="Source Table: wishlist")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, wishlist, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.5979838+07:00", comments="Source Table: wishlist")
    static UpdateDSL<UpdateModel> updateAllColumns(Wishlist row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(wishlistid).equalTo(row::getWishlistid)
                .set(userid).equalTo(row::getUserid)
                .set(productdetailid).equalTo(row::getProductdetailid)
                .set(createdat).equalTo(row::getCreatedat)
                .set(deletedat).equalTo(row::getDeletedat)
                .set(isdeleted).equalTo(row::getIsdeleted);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.5979838+07:00", comments="Source Table: wishlist")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Wishlist row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(wishlistid).equalToWhenPresent(row::getWishlistid)
                .set(userid).equalToWhenPresent(row::getUserid)
                .set(productdetailid).equalToWhenPresent(row::getProductdetailid)
                .set(createdat).equalToWhenPresent(row::getCreatedat)
                .set(deletedat).equalToWhenPresent(row::getDeletedat)
                .set(isdeleted).equalToWhenPresent(row::getIsdeleted);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.5979838+07:00", comments="Source Table: wishlist")
    default int updateByPrimaryKey(Wishlist row) {
        return update(c ->
            c.set(userid).equalTo(row::getUserid)
            .set(productdetailid).equalTo(row::getProductdetailid)
            .set(createdat).equalTo(row::getCreatedat)
            .set(deletedat).equalTo(row::getDeletedat)
            .set(isdeleted).equalTo(row::getIsdeleted)
            .where(wishlistid, isEqualTo(row::getWishlistid))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.5979838+07:00", comments="Source Table: wishlist")
    default int updateByPrimaryKeySelective(Wishlist row) {
        return update(c ->
            c.set(userid).equalToWhenPresent(row::getUserid)
            .set(productdetailid).equalToWhenPresent(row::getProductdetailid)
            .set(createdat).equalToWhenPresent(row::getCreatedat)
            .set(deletedat).equalToWhenPresent(row::getDeletedat)
            .set(isdeleted).equalToWhenPresent(row::getIsdeleted)
            .where(wishlistid, isEqualTo(row::getWishlistid))
        );
    }

    @Select("""
        SELECT wishlistid, pd.productdetailid , p.productid,  productname, price, quantity, pd.productimage, subimage
        FROM wishlist w
        JOIN productdetails pd ON w.productdetailid = pd.productdetailid
        JOIN product p ON pd.productid = p.productid
        WHERE userid = #{userid}
    """)
    List<WishlistResponseDTO> findByUser(String userid);
}