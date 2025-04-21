package com.example.eScape.repository;

import static com.example.eScape.repository.provider.CartDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import com.example.eScape.dto.CartDTO.CartResponseDTO;
import com.example.eScape.model.Cart;
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
public interface CartRepository extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<Cart>, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.5979838+07:00", comments="Source Table: cart")
    BasicColumn[] selectList = BasicColumn.columnList(cartid, userid, productdetailid, quantity, createdat, deletedat, isdeleted);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.586267+07:00", comments="Source Table: cart")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="CartResult", value = {
        @Result(column="cartid", property="cartid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="userid", property="userid", jdbcType=JdbcType.VARCHAR),
        @Result(column="productdetailid", property="productdetailid", jdbcType=JdbcType.VARCHAR),
        @Result(column="quantity", property="quantity", jdbcType=JdbcType.INTEGER),
        @Result(column="createdat", property="createdat", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deletedat", property="deletedat", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="isdeleted", property="isdeleted", jdbcType=JdbcType.BIT)
    })
    List<Cart> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.5959084+07:00", comments="Source Table: cart")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("CartResult")
    Optional<Cart> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.5959084+07:00", comments="Source Table: cart")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, cart, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.5959084+07:00", comments="Source Table: cart")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, cart, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.5959084+07:00", comments="Source Table: cart")
    default int deleteByPrimaryKey(String cartid_) {
        return delete(c -> 
            c.where(cartid, isEqualTo(cartid_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.5959084+07:00", comments="Source Table: cart")
    default int insert(Cart row) {
        return MyBatis3Utils.insert(this::insert, row, cart, c ->
            c.map(cartid).toProperty("cartid")
            .map(userid).toProperty("userid")
            .map(productdetailid).toProperty("productdetailid")
            .map(quantity).toProperty("quantity")
            .map(createdat).toProperty("createdat")
            .map(deletedat).toProperty("deletedat")
            .map(isdeleted).toProperty("isdeleted")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.5979838+07:00", comments="Source Table: cart")
    default int insertMultiple(Collection<Cart> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, cart, c ->
            c.map(cartid).toProperty("cartid")
            .map(userid).toProperty("userid")
            .map(productdetailid).toProperty("productdetailid")
            .map(quantity).toProperty("quantity")
            .map(createdat).toProperty("createdat")
            .map(deletedat).toProperty("deletedat")
            .map(isdeleted).toProperty("isdeleted")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.5979838+07:00", comments="Source Table: cart")
    default int insertSelective(Cart row) {
        return MyBatis3Utils.insert(this::insert, row, cart, c ->
            c.map(cartid).toPropertyWhenPresent("cartid", row::getCartid)
            .map(userid).toPropertyWhenPresent("userid", row::getUserid)
            .map(productdetailid).toPropertyWhenPresent("productdetailid", row::getProductdetailid)
            .map(quantity).toPropertyWhenPresent("quantity", row::getQuantity)
            .map(createdat).toPropertyWhenPresent("createdat", row::getCreatedat)
            .map(deletedat).toPropertyWhenPresent("deletedat", row::getDeletedat)
            .map(isdeleted).toPropertyWhenPresent("isdeleted", row::getIsdeleted)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.5979838+07:00", comments="Source Table: cart")
    default Optional<Cart> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, cart, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.5979838+07:00", comments="Source Table: cart")
    default List<Cart> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, cart, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.5979838+07:00", comments="Source Table: cart")
    default List<Cart> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, cart, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.5979838+07:00", comments="Source Table: cart")
    default Optional<Cart> selectByPrimaryKey(String cartid_) {
        return selectOne(c ->
            c.where(cartid, isEqualTo(cartid_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.5979838+07:00", comments="Source Table: cart")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, cart, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.5979838+07:00", comments="Source Table: cart")
    static UpdateDSL<UpdateModel> updateAllColumns(Cart row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(cartid).equalTo(row::getCartid)
                .set(userid).equalTo(row::getUserid)
                .set(productdetailid).equalTo(row::getProductdetailid)
                .set(quantity).equalTo(row::getQuantity)
                .set(createdat).equalTo(row::getCreatedat)
                .set(deletedat).equalTo(row::getDeletedat)
                .set(isdeleted).equalTo(row::getIsdeleted);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.5979838+07:00", comments="Source Table: cart")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Cart row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(cartid).equalToWhenPresent(row::getCartid)
                .set(userid).equalToWhenPresent(row::getUserid)
                .set(productdetailid).equalToWhenPresent(row::getProductdetailid)
                .set(quantity).equalToWhenPresent(row::getQuantity)
                .set(createdat).equalToWhenPresent(row::getCreatedat)
                .set(deletedat).equalToWhenPresent(row::getDeletedat)
                .set(isdeleted).equalToWhenPresent(row::getIsdeleted);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.5979838+07:00", comments="Source Table: cart")
    default int updateByPrimaryKey(Cart row) {
        return update(c ->
            c.set(userid).equalTo(row::getUserid)
            .set(productdetailid).equalTo(row::getProductdetailid)
            .set(quantity).equalTo(row::getQuantity)
            .set(createdat).equalTo(row::getCreatedat)
            .set(deletedat).equalTo(row::getDeletedat)
            .set(isdeleted).equalTo(row::getIsdeleted)
            .where(cartid, isEqualTo(row::getCartid))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-04-20T16:15:35.5979838+07:00", comments="Source Table: cart")
    default int updateByPrimaryKeySelective(Cart row) {
        return update(c ->
            c.set(userid).equalToWhenPresent(row::getUserid)
            .set(productdetailid).equalToWhenPresent(row::getProductdetailid)
            .set(quantity).equalToWhenPresent(row::getQuantity)
            .set(createdat).equalToWhenPresent(row::getCreatedat)
            .set(deletedat).equalToWhenPresent(row::getDeletedat)
            .set(isdeleted).equalToWhenPresent(row::getIsdeleted)
            .where(cartid, isEqualTo(row::getCartid))
        );
    }

    @Select("""
        SELECT cartid, pd.productdetailid, pd.productid, productname, color, pd.size, price, c.quantity, pd.productimage
        FROM cart c
        JOIN productdetails pd ON c.productdetailid = pd.productdetailid
        JOIN product p ON pd.productid = p.productid
        WHERE userid = #{userid}
    """)
    List<CartResponseDTO> getCartByUserId(String userid);
}