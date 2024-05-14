package com.trust.xfyl.dao;

import com.trust.xfyl.model.po.Doctor;
import com.trust.xfyl.model.po.DoctorExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 医生数据访问接口
 **/
public interface DoctorMapper {
    /**
     * 根据条件查询医生总数
     *
     * @param example 查询条件
     * @return 医生总数
     **/
    int countByExample(DoctorExample example);

    /**
     * 根据条件删除医生
     *
     * @param example 查询条件
     * @return 影响的记录数
     **/
    int deleteByExample(DoctorExample example);

    /**
     * 根据id删除医生信息
     *
     * @param id 医生主键ID
     * @return 影响的记录数
     **/
    int deleteByPrimaryKey(Long id);

    /**
     * 插入一条医生信息，不判断字段空值
     *
     * @param record 医生记录
     * @return 影响的记录数
     **/
    int insert(Doctor record);

    /**
     * 插入一条医生信息，带有字段空值判断
     *
     * @param record 医生记录
     * @return 影响的记录数
     **/
    int insertSelective(Doctor record);

    /**
     * 根据条件查询医生列表
     *
     * @param example 查询条件
     * @return 医生列表
     **/
    List<Doctor> selectByExample(DoctorExample example);

    /**
     * 根据主键查询一条医生信息
     *
     * @param id 医生主键ID
     * @return 医生记录
     **/
    Doctor selectByPrimaryKey(Long id);

    /**
     * 根据条件更新医生信息，可选更新字段
     *
     * @param record  医生记录（更新数据）
     * @param example 查询条件
     * @return 影响的记录数
     **/
    int updateByExampleSelective(@Param("record") Doctor record, @Param("example") DoctorExample example);

    /**
     * 根据条件更新医生信息
     *
     * @param record  医生记录（更新数据）
     * @param example 查询条件
     * @return 影响的记录数
     **/
    int updateByExample(@Param("record") Doctor record, @Param("example") DoctorExample example);

    /**
     * 根据条件更新医生信息，可选更新字段
     *
     * @param record 医生记录（更新数据）
     * @return 影响的记录数
     **/
    int updateByPrimaryKeySelective(Doctor record);

    /**
     * 根据主键更新医生信息
     *
     * @param record 医生记录（更新数据）
     * @return 影响的记录数
     **/
    int updateByPrimaryKey(Doctor record);
}
