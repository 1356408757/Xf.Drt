package com.trust.xfyl.dao;

import com.trust.xfyl.entity.Doctor;
import com.trust.xfyl.entity.DoctorExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author djj
 * @Description //TODO 医生maqpper
 * @Date 18:15 2024/2/2
 * @Param
 * @return
 **/
public interface DoctorMapper {
    /**
     * @return int
     * @Author djj
     * @Description //TODO 根据条件查询医生总数
     * @Date 18:15 2024/2/2
     * @Param [example]
     **/
    int countByExample(DoctorExample example);

    /**
     * @return int
     * @Author djj
     * @Description //TODO 根据条件删除医生
     * @Date 18:15 2024/2/2
     * @Param [example]
     **/

    int deleteByExample(DoctorExample example);

    /**
     * @return int
     * @Author djj
     * @Description //TODO 根据id删除数据
     * @Date 18:17 2024/2/2
     * @Param [id]
     **/

    int deleteByPrimaryKey(Long id);

    /**
     * @return int
     * @Author djj
     * @Description //TODO 保存一条医生的数据，不去涉及字段空值的判断
     * @Date 18:18 2024/2/2
     * @Param [record]
     **/

    int insert(Doctor record);

    /**
     * @return int
     * @Author djj
     * @Description //TODO 保存一条数据，带有对字段空值的判断
     * @Date 18:18 2024/2/2
     * @Param [record]
     **/

    int insertSelective(Doctor record);

    /**
     * @return java.util.List<com.trust.xfyl.entity.Doctor>
     * @Author djj
     * @Description //TODO 查询医生列表，带有条件查询
     * @Date 18:19 2024/2/2
     * @Param [example]
     **/

    List<Doctor> selectByExample(DoctorExample example);

    /**
     * @return com.trust.xfyl.entity.Doctor
     * @Author djj
     * @Description //TODO 根据主键查询一条医生的信息
     * @Date 18:19 2024/2/2
     * @Param [id]
     **/

    Doctor selectByPrimaryKey(Long id);

    /**
     * @return int
     * @Author djj
     * @Description //TODO 根据条件修改数据
     * @Date 18:19 2024/2/2
     * @Param [record, example]
     **/

    int updateByExampleSelective(@Param("record") Doctor record, @Param("example") DoctorExample example);

    /**
     * @return int
     * @Author djj
     * @Description //TODO 根据条件修改数据
     * @Date 18:19 2024/2/2
     * @Param [record, example]
     **/

    int updateByExample(@Param("record") Doctor record, @Param("example") DoctorExample example);

    /**
     * @return int
     * @Author djj
     * @Description //TODO 根据条件修改数据
     * @Date 18:19 2024/2/2
     * @Param [record, example]
     **/

    int updateByPrimaryKeySelective(Doctor record);

    /**
     * @return int
     * @Author djj
     * @Description //TODO 根据主键修改数据
     * @Date 18:19 2024/2/2
     * @Param [record, example]
     **/

    int updateByPrimaryKey(Doctor record);


}