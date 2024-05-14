package com.trust.xfyl.service.impl;

import com.trust.xfyl.dao.SurgeryMapper;
import com.trust.xfyl.model.po.Surgery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * SurgeryService类，提供手术信息的增删改查服务
 * @author Bay-max
 * @date 2024/4/22 15:37
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class SurgeryService {
    // SurgeryMapper的注入，用于执行数据库操作
    private final SurgeryMapper surgeryMapper;

    /**
     * SurgeryService的构造函数，依赖注入SurgeryMapper
     * @param surgeryMapper 手术信息映射器
     */
    public SurgeryService(SurgeryMapper surgeryMapper) {
        this.surgeryMapper = surgeryMapper;
    }

    /**
     * 基于手术信息对象，选择性插入数据库
     * @param surgery 手术信息对象，包含待插入的数据
     * @return 返回插入手术信息后的手术ID
     */
    public Long insertSelective(Surgery surgery) {
        surgeryMapper.insertSelective(surgery);
        return surgery.getSurgeryId();
    }

    /**
     * 基于手术ID，选择性更新数据库中的手术信息
     * @param surgery 手术信息对象，包含待更新的数据
     * @return 返回更新后的手术ID
     */
    public Long updateByPrimaryKeySelective(Surgery surgery) {
        surgeryMapper.updateByPrimaryKeySelective(surgery);
        return surgery.getSurgeryId();
    }
}
