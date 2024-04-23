package com.trust.xfyl.dao;

import com.trust.xfyl.entity.Surgery;
import com.trust.xfyl.entity.SurgeryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 外科信息映射接口
 * @author LENOVO
 */
public interface SurgeryMapper {
    /**
     * 根据条件统计记录数
     *
     * @param example 查询条件
     * @return 记录数
     */
    int countByExample(SurgeryExample example);

    /**
     * 根据条件删除数据
     *
     * @param example 查询条件
     * @return 影响的行数
     */
    int deleteByExample(SurgeryExample example);

    /**
     * 根据主键删除数据
     *
     * @param surgeryId 主键ID
     * @return 影响的行数
     */
    int deleteByPrimaryKey(Long surgeryId);

    /**
     * 插入一条新数据
     *
     * @param record 数据记录
     * @return 影响的行数
     */
    int insert(Surgery record);

    /**
     * 有选择性地插入一条新数据，忽略空字段
     *
     * @param record 数据记录
     * @return 影响的行数
     */
    int insertSelective(Surgery record);

    /**
     * 根据条件查询数据
     *
     * @param example 查询条件
     * @return 数据列表
     */
    List<Surgery> selectByExample(SurgeryExample example);

    /**
     * 根据主键查询数据
     *
     * @param surgeryId 主键ID
     * @return 数据记录
     */
    Surgery selectByPrimaryKey(Long surgeryId);

    /**
     * 有选择性地根据条件更新数据
     *
     * @param record 数据记录
     * @param example 查询条件
     * @return 影响的行数
     */
    int updateByExampleSelective(@Param("record") Surgery record, @Param("example") SurgeryExample example);

    /**
     * 根据条件更新数据
     *
     * @param record 数据记录
     * @param example 查询条件
     * @return 影响的行数
     */
    int updateByExample(@Param("record") Surgery record, @Param("example") SurgeryExample example);

    /**
     * 有选择性地更新数据
     *
     * @param record 数据记录
     * @return 影响的行数
     */
    int updateByPrimaryKeySelective(Surgery record);

    /**
     * 根据主键更新数据
     *
     * @param record 数据记录
     * @return 影响的行数
     */
    int updateByPrimaryKey(Surgery record);

    /**
     * 根据条件查询总数
     *
     * @param surgeryExample 查询条件
     * @return 总数
     */
    Long count(SurgeryExample surgeryExample);
}
