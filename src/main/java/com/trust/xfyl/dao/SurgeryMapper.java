package com.trust.xfyl.dao;

import com.trust.xfyl.entity.Surgery;
import com.trust.xfyl.entity.SurgeryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author LENOVO
 */
public interface SurgeryMapper {
    /**
     * @return int
     * @Author djj
     * @Description //TODO
     * @Date 15:02 2024/1/25
     * @Param [example]
     **/
    int countByExample(SurgeryExample example);

    /**
     * 根据条件删除数据
     *
     * @param example
     * @return int
     */
    int deleteByExample(SurgeryExample example);

    /**
     * 根据条件删除数据
     *
     * @param surgeryId
     * @return int
     */
    int deleteByPrimaryKey(Long surgeryId);

    /**
     * 添加一条新的数据
     *
     * @param record
     * @return Integer
     */
    int insert(Surgery record);

    /**
     * 添加一条新的数据，且过滤空的字段
     *
     * @param record
     * @return Integer
     */
    int insertSelective(Surgery record);

    /**
     * 根据条件查询数据
     *
     * @param example
     * @return Integer
     */
    List<Surgery> selectByExample(SurgeryExample example);

    /**
     * 根据id查询数据
     *
     * @param surgeryId
     * @return TrackingPersonnel
     */
    Surgery selectByPrimaryKey(Long surgeryId);

    /**
     * 根据条件修改数据
     *
     * @param example
     * @param record
     * @return int
     */
    int updateByExampleSelective(@Param("record") Surgery record, @Param("example") SurgeryExample example);

    /**
     * 根据条件修改数据
     *
     * @param example
     * @param record
     * @return int
     */
    int updateByExample(@Param("record") Surgery record, @Param("example") SurgeryExample example);

    /**
     * 根据条件修改数据
     *
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(Surgery record);

    /**
     * 根据条件修改数据
     *
     * @param record
     * @return int
     */
    int updateByPrimaryKey(Surgery record);

    /**
     * 查询总数
     *
     * @param surgeryExample
     * @return Long
     */
    Long count(SurgeryExample surgeryExample);
}