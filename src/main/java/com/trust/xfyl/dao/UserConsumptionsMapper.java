package com.trust.xfyl.dao;

import com.trust.xfyl.model.po.UserConsumptions;
import com.trust.xfyl.model.po.UserConsumptionsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户消费数据的映射接口
 */
public interface UserConsumptionsMapper {
    /**
     * 根据条件查询用户消费记录的数量
     *
     * @param example 包含查询条件的实例
     * @return 符合条件的记录数
     */
    int countByExample(UserConsumptionsExample example);

    /**
     * 根据条件删除用户消费记录
     *
     * @param example 包含删除条件的实例
     * @return 影响的记录数
     */
    int deleteByExample(UserConsumptionsExample example);

    /**
     * 根据消费ID删除用户消费记录
     *
     * @param consumptionId 消费记录的ID
     * @return 影响的记录数
     */
    int deleteByPrimaryKey(Integer consumptionId);

    /**
     * 插入一条用户消费记录
     *
     * @param record 要插入的用户消费记录
     * @return 影响的记录数
     */
    int insert(UserConsumptions record);

    /**
     * 选择性插入一条用户消费记录
     *
     * @param record 要插入的用户消费记录
     * @return 影响的记录数
     */
    int insertSelective(UserConsumptions record);

    /**
     * 根据条件查询用户消费记录
     *
     * @param example 包含查询条件的实例
     * @return 符合条件的用户消费记录列表
     */
    List<UserConsumptions> selectByExample(UserConsumptionsExample example);

    /**
     * 根据消费ID查询用户消费记录
     *
     * @param consumptionId 消费记录的ID
     * @return 对应的用户消费记录
     */
    UserConsumptions selectByPrimaryKey(Integer consumptionId);

    /**
     * 根据条件选择性更新用户消费记录
     *
     * @param record  要更新的用户消费记录
     * @param example 包含更新条件的实例
     * @return 影响的记录数
     */
    int updateByExampleSelective(@Param("record") UserConsumptions record, @Param("example") UserConsumptionsExample example);

    /**
     * 根据条件更新用户消费记录
     *
     * @param record  要更新的用户消费记录
     * @param example 包含更新条件的实例
     * @return 影响的记录数
     */
    int updateByExample(@Param("record") UserConsumptions record, @Param("example") UserConsumptionsExample example);

    /**
     * 根据消费ID选择性更新用户消费记录
     *
     * @param record 要更新的用户消费记录
     * @return 影响的记录数
     */
    int updateByPrimaryKeySelective(UserConsumptions record);

    /**
     * 根据消费ID更新用户消费记录
     *
     * @param record 要更新的用户消费记录
     * @return 影响的记录数
     */
    int updateByPrimaryKey(UserConsumptions record);
}
