package com.trust.xfyl.service.impl;

import com.trust.xfyl.dao.DoctorMapper;
import com.trust.xfyl.model.po.Doctor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * DoctorService类，负责医生相关的业务处理。
 * @author Bay-max
 * @date 2024/4/22 15:37
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class DoctorService {
     private final DoctorMapper doctorMapper;

    /**
     * 构造函数，注入DoctorMapper依赖。
     * @param doctorMapper 用于数据操作的DoctorMapper接口实例。
     */
    public DoctorService(DoctorMapper doctorMapper) {
        this.doctorMapper = doctorMapper;
    }

    /**
     * 插入医生信息（选择性插入）。
     * @param doctor 医生实体对象，包含待插入的数据。
     * @return 返回插入后的医生ID。
     */
    public Long insertSelective(Doctor doctor) {
        doctorMapper.insertSelective(doctor);
        return doctor.getId();
    }

    /**
     * 根据主键选择性更新医生信息。
     * @param doctor 医生实体对象，包含待更新的数据。
     * @return 返回更新后的医生ID。
     */
    public Long updateByPrimaryKeySelective(Doctor doctor) {
        doctorMapper.updateByPrimaryKeySelective(doctor);
        return doctor.getId();
    }
}

