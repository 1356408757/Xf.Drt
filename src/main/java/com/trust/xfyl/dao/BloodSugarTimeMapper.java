package com.trust.xfyl.dao;

import com.trust.xfyl.model.po.BloodSugarTime;
import com.trust.xfyl.model.po.BloodSugarTimeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * BloodSugarTimeMapper接口定义了与BloodSugarTime表相关的数据库操作。
 *
 * @author Bay-max
 * @Description
 * @date 2024/5/14 15:28
 */


public interface BloodSugarTimeMapper {
    /**
     * 根据example条件统计表中记录的数量。
     *
     * @param example 用于查询条件的实例，包含各种过滤条件。
     * @return 返回满足条件的记录数。
     */
    int countByExample(BloodSugarTimeExample example);

    /**
     * 根据example条件删除符合条件的所有记录。
     *
     * @param example 用于查询条件的实例，包含各种过滤条件。
     * @return 返回删除的记录数。
     */
    int deleteByExample(BloodSugarTimeExample example);

    /**
     * 根据主键id删除指定的记录。
     *
     * @param id 表记录的主键ID。
     * @return 返回删除的记录数。
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入一条新的记录到表中。
     *
     * @param record 包含要插入的数据的实例。
     * @return 返回插入的记录数。
     */
    int insert(BloodSugarTime record);

    /**
     * 选择性地插入一条新的记录到表中，只会插入非null的字段。
     *
     * @param record 包含要插入的数据的实例。
     * @return 返回插入的记录数。
     */
    int insertSelective(BloodSugarTime record);

    /**
     * 根据example条件查询符合条件的所有记录。
     *
     * @param example 用于查询条件的实例，包含各种过滤条件。
     * @return 返回满足条件的所有记录列表。
     */
    List<BloodSugarTime> selectByExample(BloodSugarTimeExample example);

    /**
     * 根据主键id查询指定记录。
     *
     * @param id 表记录的主键ID。
     * @return 返回匹配指定ID的记录，如果不存在则返回null。
     */
    BloodSugarTime selectByPrimaryKey(Integer id);

    /**
     * 根据example条件选择性地更新符合条件的所有记录。
     *
     * @param record  包含要更新的数据的实例。
     * @param example 用于查询条件的实例，包含各种过滤条件。
     * @return 返回更新的记录数。
     */
    int updateByExampleSelective(@Param("record") BloodSugarTime record, @Param("example") BloodSugarTimeExample example);

    /**
     * 根据example条件更新符合条件的所有记录。
     *
     * @param record  包含要更新的数据的实例。
     * @param example 用于查询条件的实例，包含各种过滤条件。
     * @return 返回更新的记录数。
     */
    int updateByExample(@Param("record") BloodSugarTime record, @Param("example") BloodSugarTimeExample example);

    /**
     * 根据主键id选择性地更新指定记录。
     *
     * @param record 包含要更新的数据的实例。
     * @return 返回更新的记录数。
     */
    int updateByPrimaryKeySelective(BloodSugarTime record);

    /**
     * 根据主键id更新指定记录。
     *
     * @param record 包含要更新的数据的实例。
     * @return 返回更新的记录数。
     */
    int updateByPrimaryKey(BloodSugarTime record);
    Long count(BloodSugarTimeExample example);
}
