package com.trust.xfyl.service;

import com.trust.xfyl.dao.DoctorMapper;
import com.trust.xfyl.entity.Doctor;
import org.springframework.stereotype.Service;
/**
 * @author Bay-max
 * @date 2024/4/22 15:37
 **/
@Service
public class DoctorService {
     private final DoctorMapper doctorMapper;

    public DoctorService(DoctorMapper doctorMapper) {
        this.doctorMapper = doctorMapper;
    }

    public Long insertSelective(Doctor doctor) {
        doctorMapper.insertSelective(doctor);
        return doctor.getId();
    }

    public Long updateByPrimaryKeySelective(Doctor doctor) {
        doctorMapper.updateByPrimaryKeySelective(doctor);
        return doctor.getId();
    }
}
