package com.trust.xfyl.dao;

import com.trust.xfyl.model.po.BloodSugar;
import com.trust.xfyl.model.po.BloodSugarExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * TODO BloodSugarMapper接口定义了与血糖相关数据的操作方法。
 *
 * @author Bay-max
 * @Description
 * @date 2024/5/20 13:42
 **/

public interface BloodSugarMapper {
    /**
     * 根据条件统计血糖记录数量。
     *
     * @param example 包含查询条件的BloodSugarExample对象
     * @return 血糖记录数量
     */
    int countByExample(BloodSugarExample example);

    /**
     * 根据条件删除血糖记录。
     *
     * @param example 包含删除条件的BloodSugarExample对象
     * @return 影响的记录数
     */
    int deleteByExample(BloodSugarExample example);

    /**
     * 根据主键删除血糖记录。
     *
     * @param bloodId 血糖记录的主键
     * @return 影响的记录数
     */
    int deleteByPrimaryKey(Integer bloodId);

    /**
     * 插入一条血糖记录。
     *
     * @param record 血糖记录对象
     * @return 影响的记录数
     */
    int insert(BloodSugar record);

    /**
     * 选择性插入一条血糖记录。
     *
     * @param record 血糖记录对象
     * @return 影响的记录数
     */
    int insertSelective(BloodSugar record);

    /**
     * 根据条件查询血糖记录列表。
     *
     * @param example 包含查询条件的BloodSugarExample对象
     * @return 血糖记录列表
     */
    List<BloodSugar> selectByExample(BloodSugarExample example);

    /**
     * 根据主键查询一条血糖记录。
     *
     * @param bloodId 血糖记录的主键
     * @return 血糖记录对象
     */
    BloodSugar selectByPrimaryKey(Integer bloodId);

    /**
     * 根据条件选择性更新血糖记录。
     *
     * @param record  要更新的血糖记录对象
     * @param example 包含更新条件的BloodSugarExample对象
     * @return 影响的记录数
     */
    int updateByExampleSelective(@Param("record") BloodSugar record, @Param("example") BloodSugarExample example);

    /**
     * 根据条件更新血糖记录。
     *
     * @param record  要更新的血糖记录对象
     * @param example 包含更新条件的BloodSugarExample对象
     * @return 影响的记录数
     */
    int updateByExample(@Param("record") BloodSugar record, @Param("example") BloodSugarExample example);

    /**
     * 根据记录对象选择性更新血糖记录。
     *
     * @param record 血糖记录对象
     * @return 影响的记录数
     */
    int updateByPrimaryKeySelective(BloodSugar record);

    /**
     * 根据主键更新血糖记录。
     *
     * @param record 血糖记录对象
     * @return 影响的记录数
     */
    int updateByPrimaryKey(BloodSugar record);

    /**
     * 根据条件统计血糖记录数量。
     *
     * @param example 包含查询条件的BloodSugarExample对象
     * @return 血糖记录数量
     */
    Long count(BloodSugarExample example);
}
