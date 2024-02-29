package com.trust.xfyl.service;

import com.trust.xfyl.dao.SurgeryMapper;
import com.trust.xfyl.entity.Surgery;
import org.springframework.stereotype.Service;

/**
 * @author LENOVO
 */
@Service
public class SurgeryService {
    private final SurgeryMapper surgeryMapper;

    public SurgeryService(SurgeryMapper surgeryMapper) {
        this.surgeryMapper = surgeryMapper;
    }

    public Long insertSelective(Surgery surgery) {
        surgeryMapper.insertSelective(surgery);
        return surgery.getSurgeryId();
    }

    public Long updateByPrimaryKeySelective(Surgery surgery) {
        surgeryMapper.updateByPrimaryKeySelective(surgery);
        return  surgery.getSurgeryId();
    }
}
