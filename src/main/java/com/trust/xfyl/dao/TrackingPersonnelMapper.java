package com.trust.xfyl.dao;

import com.trust.xfyl.entity.TrackingPersonnel;
import com.trust.xfyl.entity.TrackingPersonnelExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author djj
 * @Description //TODO
 * @Date 17:53 2024/2/2
 * @Param
 * @return
 **/
public interface TrackingPersonnelMapper {
    /**
     * @return int
     * @Author djj
     * @Description //TODO 根据条件查询数据总数
     * @Date 17:54 2024/2/2
     * @Param [example]
     **/
    int countByExample(TrackingPersonnelExample example);

    /**
     * @return int
     * @Author djj
     * @Description //TODO 根据条件删除数据
     * @Date 17:54 2024/2/2
     * @Param [example]
     **/

    int deleteByExample(TrackingPersonnelExample example);

    /**
     * @return int
     * @Author djj
     * @Description //TODO 根据id删除数据
     * @Date 17:54 2024/2/2
     * @Param [id]
     **/

    int deleteByPrimaryKey(Long id);

    /**
     * @return int
     * @Author djj
     * @Description //TODO 爆粗拿数据不涉及数据空的判断
     * @Date 17:55 2024/2/2
     * @Param [record]
     **/

    int insert(TrackingPersonnel record);

    /**
     * @return int
     * @Author djj
     * @Description //TODO 保存数据设置及字段空值的判断
     * @Date 17:55 2024/2/2
     * @Param [record]
     **/

    int insertSelective(TrackingPersonnel record);

    /**
     * @return java.util.List<com.trust.xfyl.entity.TrackingPersonnel>
     * @Author djj
     * @Description //TODO 查询列表，以及模糊查询
     * @Date 17:55 2024/2/2
     * @Param [example]
     **/

    List<TrackingPersonnel> selectByExample(TrackingPersonnelExample example);

    /**
     * @return com.trust.xfyl.entity.TrackingPersonnel
     * @Author djj
     * @Description //TODO 根据主键查询数据
     * @Date 17:56 2024/2/2
     * @Param [id]
     **/

    TrackingPersonnel selectByPrimaryKey(Long id);

    /**
     * @return int
     * @Author djj
     * @Description //TODO 更新数据根据条件
     * @Date 17:56 2024/2/2
     * @Param [record, example]
     **/

    int updateByExampleSelective(@Param("record") TrackingPersonnel record, @Param("example") TrackingPersonnelExample example);

    /**
     * @return int
     * @Author djj
     * @Description //TODO 根据条件更新数据
     * @Date 17:56 2024/2/2
     * @Param [record, example]
     **/
    int updateByExample(@Param("record") TrackingPersonnel record, @Param("example") TrackingPersonnelExample example);

    /**
     * @return int
     * @Author djj
     * @Description //TODO 根据条件更新数据
     * @Date 17:57 2024/2/2
     * @Param [record]
     **/
    int updateByPrimaryKeySelective(TrackingPersonnel record);

    /**
     * @return int
     * @Author djj
     * @Description //TODO 根据主键更新数据
     * @Date 17:57 2024/2/2
     * @Param [record]
     **/
    int updateByPrimaryKey(TrackingPersonnel record);

    /**
     * @return java.lang.Long
     * @Author djj
     * @Description //TODO 根据主键更新数据
     * @Date 17:57 2024/2/2
     * @Param [trackingPersonnelExample]
     **/
    Long count(TrackingPersonnelExample trackingPersonnelExample);
}