/**
 * CreditPackagesMapper 接口定义了对信用套餐表进行数据库操作的方法
 */
package com.trust.xfyl.dao;

import com.trust.xfyl.model.po.CreditPackages;
import com.trust.xfyl.model.po.CreditPackagesExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Bay-max
 * @date 2024/4/22 15:04
 **/


public interface CreditPackagesMapper {
    /**
     * 根据条件查询记录数
     *
     * @param example 包含查询条件的对象
     * @return 符合条件的记录数
     */
    int countByExample(CreditPackagesExample example);

    /**
     * 根据条件删除记录
     *
     * @param example 包含删除条件的对象
     * @return 影响的记录数
     */
    int deleteByExample(CreditPackagesExample example);

    /**
     * 根据主键删除记录
     *
     * @param packageId 要删除的记录的主键
     * @return 影响的记录数
     */
    int deleteByPrimaryKey(Integer packageId);

    /**
     * 插入一条记录
     *
     * @param record 要插入的数据对象
     * @return 影响的记录数
     */
    int insert(CreditPackages record);

    /**
     * 选择性插入一条记录
     *
     * @param record 要插入的数据对象
     * @return 影响的记录数
     */
    int insertSelective(CreditPackages record);

    /**
     * 根据条件查询记录列表
     *
     * @param example 包含查询条件的对象
     * @return 符合条件的记录列表
     */
    List<CreditPackages> selectByExample(CreditPackagesExample example);

    /**
     * 根据主键查询一条记录
     *
     * @param packageId 要查询的记录的主键
     * @return 查询到的记录对象
     */
    CreditPackages selectByPrimaryKey(Integer packageId);

    /**
     * 根据条件选择性更新记录
     *
     * @param record  要更新的数据对象
     * @param example 包含更新条件的对象
     * @return 影响的记录数
     */
    int updateByExampleSelective(@Param("record") CreditPackages record, @Param("example") CreditPackagesExample example);

    /**
     * 根据条件更新记录
     *
     * @param record  要更新的数据对象
     * @param example 包含更新条件的对象
     * @return 影响的记录数
     */
    int updateByExample(@Param("record") CreditPackages record, @Param("example") CreditPackagesExample example);

    /**
     * 根据主键选择性更新记录
     *
     * @param record 要更新的数据对象
     * @return 影响的记录数
     */
    int updateByPrimaryKeySelective(CreditPackages record);

    /**
     * 根据主键更新记录
     *
     * @param record 要更新的数据对象
     * @return 影响的记录数
     */
    int updateByPrimaryKey(CreditPackages record);

    Long count(CreditPackagesExample example);
}
