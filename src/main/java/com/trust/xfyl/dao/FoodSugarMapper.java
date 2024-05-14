package com.trust.xfyl.dao;

import com.trust.xfyl.model.po.FoodSugar;
import com.trust.xfyl.model.po.FoodSugarExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * FoodSugarMapper接口定义了与FoodSugar表相关的数据库操作。
 */
public interface FoodSugarMapper {
    /**
     * 根据example条件统计FoodSugar表中的记录数。
     *
     * @param example 用于查询条件的FoodSugarExample对象
     * @return 符合条件的记录数
     */
    int countByExample(FoodSugarExample example);

    /**
     * 根据example条件删除FoodSugar表中的记录。
     *
     * @param example 用于删除条件的FoodSugarExample对象
     * @return 影响的记录数
     */
    int deleteByExample(FoodSugarExample example);

    /**
     * 根据foodId删除FoodSugar表中的一条记录。
     *
     * @param foodId 要删除的记录的主键ID
     * @return 影响的记录数
     */
    int deleteByPrimaryKey(Integer foodId);

    /**
     * 插入一条FoodSugar记录到数据库。
     *
     * @param record 要插入的FoodSugar对象
     * @return 影响的记录数
     */
    int insert(FoodSugar record);

    /**
     * 选择性插入一条FoodSugar记录到数据库。
     *
     * @param record 要插入的FoodSugar对象
     * @return 影响的记录数
     */
    int insertSelective(FoodSugar record);

    /**
     * 根据example条件查询FoodSugar表中的记录列表。
     *
     * @param example 用于查询条件的FoodSugarExample对象
     * @return 符合条件的记录列表
     */
    List<FoodSugar> selectByExample(FoodSugarExample example);

    /**
     * 根据foodId查询FoodSugar表中的一条记录。
     *
     * @param foodId 要查询的记录的主键ID
     * @return 查询到的FoodSugar对象
     */
    FoodSugar selectByPrimaryKey(Integer foodId);

    /**
     * 根据example条件和record对象选择性更新FoodSugar表中的记录。
     *
     * @param record  要更新的数据记录
     * @param example 用于更新条件的FoodSugarExample对象
     * @return 影响的记录数
     */
    int updateByExampleSelective(@Param("record") FoodSugar record, @Param("example") FoodSugarExample example);

    /**
     * 根据example条件和record对象更新FoodSugar表中的记录。
     *
     * @param record  要更新的数据记录
     * @param example 用于更新条件的FoodSugarExample对象
     * @return 影响的记录数
     */
    int updateByExample(@Param("record") FoodSugar record, @Param("example") FoodSugarExample example);

    /**
     * 根据foodId选择性更新FoodSugar表中的一条记录。
     *
     * @param record 要更新的数据记录
     * @return 影响的记录数
     */
    int updateByPrimaryKeySelective(FoodSugar record);

    /**
     * 根据foodId更新FoodSugar表中的一条记录。
     *
     * @param record 要更新的数据记录
     * @return 影响的记录数
     */
    int updateByPrimaryKey(FoodSugar record);

    /**
     * 根据FoodSugarExample条件统计记录数。
     *
     * @param example 用于查询条件的FoodSugarExample对象
     * @return 符合条件的记录数
     */
    Long count(FoodSugarExample example);
}
