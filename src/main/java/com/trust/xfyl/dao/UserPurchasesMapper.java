package com.trust.xfyl.dao;

import com.trust.xfyl.entity.UserPurchases;
import com.trust.xfyl.entity.UserPurchasesExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * UserPurchases数据访问接口
 * @author LENOVO
 */
public interface UserPurchasesMapper {
    /**
     * 根据条件查询记录总数
     * @param example 查询条件实例
     * @return 符合条件的记录数
     */
    int countByExample(UserPurchasesExample example);

    /**
     * 根据条件删除记录
     * @param example 查询条件实例
     * @return 影响的记录数
     */
    int deleteByExample(UserPurchasesExample example);

    /**
     * 根据主键删除记录
     * @param purchaseId 主键ID
     * @return 影响的记录数
     */
    int deleteByPrimaryKey(Integer purchaseId);

    /**
     * 插入一条记录
     * @param record 数据记录实例
     * @return 影响的记录数
     */
    int insert(UserPurchases record);

    /**
     * 选择性插入一条记录
     * @param record 数据记录实例
     * @return 影响的记录数
     */
    int insertSelective(UserPurchases record);

    /**
     * 根据条件查询记录列表
     * @param example 查询条件实例
     * @return 记录列表
     */
    List<UserPurchases> selectByExample(UserPurchasesExample example);

    /**
     * 根据主键查询一条记录
     * @param purchaseId 主键ID
     * @return 记录实例
     */
    UserPurchases selectByPrimaryKey(Integer purchaseId);

    /**
     * 根据条件选择性更新记录
     * @param record 数据记录实例
     * @param example 查询条件实例
     * @return 影响的记录数
     */
    int updateByExampleSelective(@Param("record") UserPurchases record, @Param("example") UserPurchasesExample example);

    /**
     * 根据条件更新记录
     * @param record 数据记录实例
     * @param example 查询条件实例
     * @return 影响的记录数
     */
    int updateByExample(@Param("record") UserPurchases record, @Param("example") UserPurchasesExample example);

    /**
     * 根据主键选择性更新记录
     * @param record 数据记录实例
     * @return 影响的记录数
     */
    int updateByPrimaryKeySelective(UserPurchases record);

    /**
     * 根据主键更新记录
     * @param record 数据记录实例
     * @return 影响的记录数
     */
    int updateByPrimaryKey(UserPurchases record);
}
