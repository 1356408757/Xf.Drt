package com.trust.xfyl.dao;

import com.trust.xfyl.model.po.SurgicalName;
import com.trust.xfyl.model.po.SurgicalNameExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 外科名称数据访问接口
 *
 * @Author djj
 * @Date 15:27 2024/1/25
 **/
public interface SurgicalNameMapper {
    /**
     * 根据条件获取数据总数
     *
     * @param example 查询条件示例对象
     * @return 返回符合条件的数据总数
     * @Author djj
     * @Date 15:27 2024/1/25
     **/
    int countByExample(SurgicalNameExample example);

    /**
     * 根据条件删除数据
     *
     * @param example 查询条件示例对象
     * @return 返回影响的行数
     * @Author djj
     * @Date 15:27 2024/1/25
     **/
    int deleteByExample(SurgicalNameExample example);

    /**
     * 根据主键ID删除数据
     *
     * @param id 数据主键ID
     * @return 返回影响的行数
     * @Author djj
     * @Date 15:27 2024/1/25
     **/
    int deleteByPrimaryKey(Long id);

    /**
     * 插入一条新数据
     *
     * @param record 要插入的数据记录对象
     * @return 返回影响的行数
     * @Author djj
     * @Date 15:28 2024/1/25
     **/
    int insert(SurgicalName record);

    /**
     * 插入一条数据，忽略空字段
     *
     * @param record 要插入的数据记录对象
     * @return 返回影响的行数
     * @Author djj
     * @Date 15:28 2024/1/25
     **/
    int insertSelective(SurgicalName record);

    /**
     * 根据条件获取所有数据
     *
     * @param example 查询条件示例对象
     * @return 返回符合条件的所有数据列表
     * @Author djj
     * @Date 15:28 2024/1/25
     **/
    List<SurgicalName> selectByExample(SurgicalNameExample example);

    /**
     * 根据主键ID获取数据
     *
     * @param id 数据主键ID
     * @return 返回对应ID的数据记录对象
     * @Author djj
     * @Date 15:28 2024/1/25
     **/
    SurgicalName selectByPrimaryKey(Long id);

    /**
     * 根据条件更新数据，可选择性更新字段
     *
     * @param record  要更新的数据记录对象
     * @param example 查询条件示例对象
     * @return 返回影响的行数
     * @Author djj
     * @Date 15:28 2024/1/25
     **/
    int updateByExampleSelective(@Param("record") SurgicalName record, @Param("example") SurgicalNameExample example);

    /**
     * 根据条件更新数据
     *
     * @param record  要更新的数据记录对象
     * @param example 查询条件示例对象
     * @return 返回影响的行数
     * @Author djj
     * @Date 15:28 2024/1/25
     **/
    int updateByExample(@Param("record") SurgicalName record, @Param("example") SurgicalNameExample example);

    /**
     * 根据主键ID选择性更新数据
     *
     * @param record 要更新的数据记录对象
     * @return 返回影响的行数
     * @Author djj
     * @Date 15:28 2024/1/25
     **/
    int updateByPrimaryKeySelective(SurgicalName record);

    /**
     * 根据主键ID更新数据
     *
     * @param record 要更新的数据记录对象
     * @return 返回影响的行数
     * @Author djj
     * @Date 15:28 2024/1/25
     **/
    int updateByPrimaryKey(SurgicalName record);
}
