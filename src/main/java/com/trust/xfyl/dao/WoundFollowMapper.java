package com.trust.xfyl.dao;

import com.trust.xfyl.entity.WoundFollow;
import com.trust.xfyl.entity.WoundFollowExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * TODO 伤口跟进数据访问接口
 *
 * @author Bay-max
 * @date 2024/4/22 15:08
 **/

public interface WoundFollowMapper {
    /**
     * 根据条件计算记录数
     *
     * @param example 查询条件实例
     * @return 符合条件的记录数
     **/


    int countByExample(WoundFollowExample example);

    /**
     * 根据条件删除记录
     *
     * @param example 查询条件实例
     * @return 影响的记录数
     **/
    int deleteByExample(WoundFollowExample example);

    /**
     * 根据主键删除记录
     *
     * @param id 主键ID
     * @return 影响的记录数
     **/
    int deleteByPrimaryKey(Long id);

    /**
     * 插入一条记录
     *
     * @param record 数据记录实例
     * @return 影响的记录数
     **/
    int insert(WoundFollow record);

    /**
     * 选择性插入一条记录
     *
     * @param record 数据记录实例
     * @return 影响的记录数
     **/
    int insertSelective(WoundFollow record);

    /**
     * 根据条件查询记录列表
     *
     * @param example 查询条件实例
     * @return 符合条件的记录列表
     **/
    List<WoundFollow> selectByExample(WoundFollowExample example);

    /**
     * 根据主键查询一条记录
     *
     * @param id 主键ID
     * @return 对应的记录实例
     **/
    WoundFollow selectByPrimaryKey(Long id);

    /**
     * 根据条件选择性更新记录
     *
     * @param record  数据记录实例
     * @param example 查询条件实例
     * @return 影响的记录数
     **/
    int updateByExampleSelective(@Param("record") WoundFollow record, @Param("example") WoundFollowExample example);

    /**
     * 根据条件更新记录
     *
     * @param record  数据记录实例
     * @param example 查询条件实例
     * @return 影响的记录数
     **/
    int updateByExample(@Param("record") WoundFollow record, @Param("example") WoundFollowExample example);

    /**
     * 根据主键选择性更新记录
     *
     * @param record 数据记录实例
     * @return 影响的记录数
     **/
    int updateByPrimaryKeySelective(WoundFollow record);

    /**
     * 根据主键更新记录
     *
     * @param record 数据记录实例
     * @return 影响的记录数
     **/
    int updateByPrimaryKey(WoundFollow record);

    /**
     * 根据条件计算记录数
     *
     * @param woundFollowExample 查询条件实例
     * @return 符合条件的记录数
     **/
    Long count(WoundFollowExample woundFollowExample);
}
