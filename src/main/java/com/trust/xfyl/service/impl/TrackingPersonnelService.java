package com.trust.xfyl.service.impl;

import com.trust.xfyl.dao.TrackingPersonnelMapper;
import com.trust.xfyl.model.po.TrackingPersonnel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 跟踪人员服务类
 * 用于处理与跟踪人员相关的业务逻辑
 * @author Bay-max
 * @date 2024/4/22 15:37
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class TrackingPersonnelService {
    // 数据访问对象，用于执行数据库操作
    private final TrackingPersonnelMapper trackingPersonnelMapper;

    /**
     * 构造函数
     * 依赖注入TrackingPersonnelMapper
     * @param trackingPersonnelMapper 跟踪人员数据访问对象
     */
    public TrackingPersonnelService(TrackingPersonnelMapper trackingPersonnelMapper) {
        this.trackingPersonnelMapper = trackingPersonnelMapper;
    }

    /**
     * 增加或更新跟踪人员信息
     * @param trackingPersonnel 跟踪人员实体，包含要插入或更新的数据
     * @return 插入或更新后跟踪人员的ID
     */
    public Long insertSelective(TrackingPersonnel trackingPersonnel) {
        trackingPersonnelMapper.insertSelective(trackingPersonnel);
        return trackingPersonnel.getId();
    }

    /**
     * 根据主键更新跟踪人员信息
     * @param trackingPersonnel 跟踪人员实体，包含要更新的数据
     * @return 更新后的跟踪人员的ID
     */
    public Long updateByPrimaryKeySelective(TrackingPersonnel trackingPersonnel) {
        trackingPersonnelMapper.updateByPrimaryKeySelective(trackingPersonnel);
        return trackingPersonnel.getId();
    }
}
