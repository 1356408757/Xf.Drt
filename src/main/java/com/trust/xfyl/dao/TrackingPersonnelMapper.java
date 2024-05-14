package com.trust.xfyl.dao;

import com.trust.xfyl.model.po.TrackingPersonnel;
import com.trust.xfyl.model.po.TrackingPersonnelExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 跟踪人员数据访问接口
 **/
public interface TrackingPersonnelMapper {
    /**
     * 根据条件查询数据总数
     *
     * @param example 查询条件
     * @return 数据总数
     **/
    int countByExample(TrackingPersonnelExample example);

    /**
     * 根据条件删除数据
     *
     * @param example 删除条件
     * @return 影响行数
     **/
    int deleteByExample(TrackingPersonnelExample example);

    /**
     * 根据id删除数据
     *
     * @param id 人员ID
     * @return 影响行数
     **/
    int deleteByPrimaryKey(Long id);

    /**
     * 插入数据，不判断字段是否为空
     *
     * @param record 要插入的数据记录
     * @return 影响行数
     **/
    int insert(TrackingPersonnel record);

    /**
     * 保存数据，设置及字段空值的判断
     *
     * @param record 要保存的数据记录
     * @return 影响行数
     **/
    int insertSelective(TrackingPersonnel record);

    /**
     * 查询列表，以及模糊查询
     *
     * @param example 查询和筛选条件
     * @return 数据列表
     **/
    List<TrackingPersonnel> selectByExample(TrackingPersonnelExample example);

    /**
     * 根据主键查询数据
     *
     * @param id 人员ID
     * @return 查询到的数据记录
     **/
    TrackingPersonnel selectByPrimaryKey(Long id);

    /**
     * 根据条件更新数据，可选择性更新字段
     *
     * @param record  要更新的数据记录
     * @param example 更新条件
     * @return 影响行数
     **/
    int updateByExampleSelective(@Param("record") TrackingPersonnel record, @Param("example") TrackingPersonnelExample example);

    /**
     * 根据条件更新数据
     *
     * @param record  要更新的数据记录
     * @param example 更新条件
     * @return 影响行数
     **/
    int updateByExample(@Param("record") TrackingPersonnel record, @Param("example") TrackingPersonnelExample example);

    /**
     * 根据条件更新数据，可选择性更新字段
     *
     * @param record 要更新的数据记录
     * @return 影响行数
     **/
    int updateByPrimaryKeySelective(TrackingPersonnel record);

    /**
     * 根据主键更新数据
     *
     * @param record 要更新的数据记录
     * @return 影响行数
     **/
    int updateByPrimaryKey(TrackingPersonnel record);

    /**
     * 根据条件查询数据总数
     *
     * @param trackingPersonnelExample 查询条件
     * @return 数据总数
     **/
    Long count(TrackingPersonnelExample trackingPersonnelExample);
}
