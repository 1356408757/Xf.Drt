package com.trust.xfyl.dao;

import com.trust.xfyl.entity.WoundFollow;
import com.trust.xfyl.entity.WoundFollowExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author djj
 * @Description //TODO
 * @Date 9:47 2024/1/26
 **/
public interface WoundFollowMapper {
    /**
     * @return int
     * @Author djj
     * @Description //TODO
     * @Date 9:47 2024/1/26
     * @Param [example]
     **/
    int countByExample(WoundFollowExample example);

    /**
     * @return int
     * @Author djj
     * @Description //TODO
     * @Date 9:47 2024/1/26
     * @Param [example]
     **/

    int deleteByExample(WoundFollowExample example);

    /**
     * @return int
     * @Author djj
     * @Description //TODO
     * @Date 9:47 2024/1/26
     * @Param [id]
     **/

    int deleteByPrimaryKey(Long id);

    /**
     * @return int
     * @Author djj
     * @Description //TODO
     * @Date 9:47 2024/1/26
     * @Param [record]
     **/

    int insert(WoundFollow record);

    /**
     * @return int
     * @Author djj
     * @Description //TODO
     * @Date 9:48 2024/1/26
     * @Param [record]
     **/

    int insertSelective(WoundFollow record);

    /**
     * @return java.util.List<com.trust.xfyl.entity.WoundFollow>
     * @Author djj
     * @Description //TODO
     * @Date 9:48 2024/1/26
     * @Param [example]
     **/

    List<WoundFollow> selectByExample(WoundFollowExample example);

    /**
     * @return com.trust.xfyl.entity.WoundFollow
     * @Author djj
     * @Description //TODO
     * @Date 9:48 2024/1/26
     * @Param [id]
     **/

    WoundFollow selectByPrimaryKey(Long id);

    /**
     * @return int
     * @Author djj
     * @Description //TODO
     * @Date 9:48 2024/1/26
     * @Param [record, example]
     **/

    int updateByExampleSelective(@Param("record") WoundFollow record, @Param("example") WoundFollowExample example);

    /**
     * @return int
     * @Author djj
     * @Description //TODO
     * @Date 9:48 2024/1/26
     * @Param [record, example]
     **/

    int updateByExample(@Param("record") WoundFollow record, @Param("example") WoundFollowExample example);

    /**
     * @return int
     * @Author djj
     * @Description //TODO
     * @Date 9:48 2024/1/26
     * @Param [record]
     **/

    int updateByPrimaryKeySelective(WoundFollow record);

    /**
     * @return int
     * @Author djj
     * @Description //TODO
     * @Date 9:48 2024/1/26
     * @Param [record]
     **/

    int updateByPrimaryKey(WoundFollow record);

    /**
     * @return java.lang.Long
     * @Author djj
     * @Description //TODO
     * @Date 16:56 2024/1/26
     * @Param [woundFollowExample]
     **/
    Long count(WoundFollowExample woundFollowExample);
}