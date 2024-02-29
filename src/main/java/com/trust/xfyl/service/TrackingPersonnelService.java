package com.trust.xfyl.service;

import com.trust.xfyl.dao.TrackingPersonnelMapper;
import com.trust.xfyl.entity.TrackingPersonnel;
import org.springframework.stereotype.Service;

/**
 * @author LENOVO
 */
@Service
public class TrackingPersonnelService {
    private final TrackingPersonnelMapper trackingPersonnelMapper;

    public TrackingPersonnelService(TrackingPersonnelMapper trackingPersonnelMapper) {
        this.trackingPersonnelMapper = trackingPersonnelMapper;
    }

    public Long insertSelective(TrackingPersonnel trackingPersonnel) {
        trackingPersonnelMapper.insertSelective(trackingPersonnel);
        return trackingPersonnel.getId();
    }

    public Long updateByPrimaryKeySelective(TrackingPersonnel trackingPersonnel) {
        trackingPersonnelMapper.updateByPrimaryKeySelective(trackingPersonnel);
        return trackingPersonnel.getId();
    }
}
