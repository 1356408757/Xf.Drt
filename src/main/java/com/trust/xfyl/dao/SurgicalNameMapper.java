package com.trust.xfyl.dao;

import com.trust.xfyl.entity.SurgicalName;
import com.trust.xfyl.entity.SurgicalNameExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author djj
 * @Description //TODO
 * @Date 15:27 2024/1/25
 **/

public interface SurgicalNameMapper {
    /**
     * @return int
     * @Author djj
     * @Description 获取总数
     * @Date 15:27 2024/1/25
     * @Param [example]
     **/
    int countByExample(SurgicalNameExample example);

    /**
     * @return int
     * @Author djj
     * @Description 根据条件删除数据
     * @Date 15:27 2024/1/25
     * @Param [example]
     **/

    int deleteByExample(SurgicalNameExample example);

    /**
     * @return int
     * @Author djj
     * @Description 根据id删除数据
     * @Date 15:27 2024/1/25
     * @Param [id]
     **/

    int deleteByPrimaryKey(Long id);

    /**
     * @return int
     * @Author djj
     * @Description 保存一条数据
     * @Date 15:28 2024/1/25
     * @Param [record]
     **/

    int insert(SurgicalName record);

    /**
     * @return int
     * @Author djj
     * @Description 保存一条数据，过滤空的字段
     * @Date 15:28 2024/1/25
     * @Param [record]
     **/

    int insertSelective(SurgicalName record);

    /**
     * @return java.util.List<com.trust.xfyl.entity.SurgicalName>
     * @Author djj
     * @Description 根据条件获取所有数据
     * @Date 15:28 2024/1/25
     * @Param [example]
     **/

    List<SurgicalName> selectByExample(SurgicalNameExample example);

    /**
     * @return com.trust.xfyl.entity.SurgicalName
     * @Author djj
     * @Description 根据id获取数据
     * @Date 15:28 2024/1/25
     * @Param [id]
     **/

    SurgicalName selectByPrimaryKey(Long id);

    /**
     * @return int
     * @Author djj
     * @Description 根据条件修改数据
     * @Date 15:28 2024/1/25
     * @Param [record, example]
     **/

    int updateByExampleSelective(@Param("record") SurgicalName record, @Param("example") SurgicalNameExample example);

    /**
     * @return int
     * @Author djj
     * @Description 根据条件修改数据
     * @Date 15:28 2024/1/25
     * @Param [record, example]
     **/

    int updateByExample(@Param("record") SurgicalName record, @Param("example") SurgicalNameExample example);

    /**
     * @return int
     * @Author djj
     * @Description 根据条件修改数据
     * @Date 15:28 2024/1/25
     * @Param [record]
     **/

    int updateByPrimaryKeySelective(SurgicalName record);

    /**
     * @return int
     * @Author djj
     * @Description 根据条件修改数据
     * @Date 15:28 2024/1/25
     * @Param [record]
     **/

    int updateByPrimaryKey(SurgicalName record);
}