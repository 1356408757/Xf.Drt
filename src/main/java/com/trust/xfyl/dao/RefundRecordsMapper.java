package com.trust.xfyl.dao;

import com.trust.xfyl.model.po.RefundRecords;
import com.trust.xfyl.model.po.RefundRecordsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 退款记录数据访问接口
 *
 * @Description 提供了对退款记录表进行增删改查等操作的方法
 * @Author Bay-max
 * @Date 2024/4/22 14:30
 **/
public interface RefundRecordsMapper {
    /**
     * 根据条件统计记录数
     *
     * @param example 查询条件实例
     * @return 记录数
     */
    int countByExample(RefundRecordsExample example);

    /**
     * 根据条件删除记录
     *
     * @param example 查询条件实例
     * @return 影响的记录数
     */
    int deleteByExample(RefundRecordsExample example);

    /**
     * 根据主键删除记录
     *
     * @param refundId 主键ID
     * @return 影响的记录数
     */
    int deleteByPrimaryKey(Integer refundId);

    /**
     * 插入一条记录
     *
     * @param record 记录实体
     * @return 影响的记录数
     */
    int insert(RefundRecords record);

    /**
     * 选择性插入一条记录
     *
     * @param record 记录实体
     * @return 影响的记录数
     */
    int insertSelective(RefundRecords record);

    /**
     * 根据条件选择性地查询记录列表，包括BLOBs字段
     *
     * @param example 查询条件实例
     * @return 记录列表
     */
    List<RefundRecords> selectByExampleWithBLOBs(RefundRecordsExample example);

    /**
     * 根据条件查询记录列表
     *
     * @param example 查询条件实例
     * @return 记录列表
     */
    List<RefundRecords> selectByExample(RefundRecordsExample example);

    /**
     * 根据主键查询一条记录
     *
     * @param refundId 主键ID
     * @return 记录实体
     */
    RefundRecords selectByPrimaryKey(Integer refundId);

    /**
     * 根据条件选择性更新记录
     *
     * @param record  记录实体
     * @param example 查询条件实例
     * @return 影响的记录数
     */
    int updateByExampleSelective(@Param("record") RefundRecords record, @Param("example") RefundRecordsExample example);

    /**
     * 根据条件带BLOBs字段选择性更新记录
     *
     * @param record  记录实体
     * @param example 查询条件实例
     * @return 影响的记录数
     */
    int updateByExampleWithBLOBs(@Param("record") RefundRecords record, @Param("example") RefundRecordsExample example);

    /**
     * 根据条件更新记录
     *
     * @param record  记录实体
     * @param example 查询条件实例
     * @return 影响的记录数
     */
    int updateByExample(@Param("record") RefundRecords record, @Param("example") RefundRecordsExample example);

    /**
     * 根据记录实体选择性更新记录
     *
     * @param record 记录实体
     * @return 影响的记录数
     */
    int updateByPrimaryKeySelective(RefundRecords record);

    /**
     * 根据记录实体带BLOBs字段更新记录
     *
     * @param record 记录实体
     * @return 影响的记录数
     */
    int updateByPrimaryKeyWithBLOBs(RefundRecords record);

    /**
     * 根据记录实体更新记录
     *
     * @param record 记录实体
     * @return 影响的记录数
     */
    int updateByPrimaryKey(RefundRecords record);
}
