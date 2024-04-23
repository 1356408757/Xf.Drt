package com.trust.xfyl.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * @author Bay-max
 * @date 2024/4/22 14:01
 **/
public class WoundFollowExample extends BaseBean {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WoundFollowExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTrackingPersonnelIdIsNull() {
            addCriterion("tracking_personnel_id is null");
            return (Criteria) this;
        }

        public Criteria andTrackingPersonnelIdIsNotNull() {
            addCriterion("tracking_personnel_id is not null");
            return (Criteria) this;
        }

        public Criteria andTrackingPersonnelIdEqualTo(Long value) {
            addCriterion("tracking_personnel_id =", value, "trackingPersonnelId");
            return (Criteria) this;
        }

        public Criteria andTrackingPersonnelIdNotEqualTo(Long value) {
            addCriterion("tracking_personnel_id <>", value, "trackingPersonnelId");
            return (Criteria) this;
        }

        public Criteria andTrackingPersonnelIdGreaterThan(Long value) {
            addCriterion("tracking_personnel_id >", value, "trackingPersonnelId");
            return (Criteria) this;
        }

        public Criteria andTrackingPersonnelIdGreaterThanOrEqualTo(Long value) {
            addCriterion("tracking_personnel_id >=", value, "trackingPersonnelId");
            return (Criteria) this;
        }

        public Criteria andTrackingPersonnelIdLessThan(Long value) {
            addCriterion("tracking_personnel_id <", value, "trackingPersonnelId");
            return (Criteria) this;
        }

        public Criteria andTrackingPersonnelIdLessThanOrEqualTo(Long value) {
            addCriterion("tracking_personnel_id <=", value, "trackingPersonnelId");
            return (Criteria) this;
        }

        public Criteria andTrackingPersonnelIdIn(List<Long> values) {
            addCriterion("tracking_personnel_id in", values, "trackingPersonnelId");
            return (Criteria) this;
        }

        public Criteria andTrackingPersonnelIdNotIn(List<Long> values) {
            addCriterion("tracking_personnel_id not in", values, "trackingPersonnelId");
            return (Criteria) this;
        }

        public Criteria andTrackingPersonnelIdBetween(Long value1, Long value2) {
            addCriterion("tracking_personnel_id between", value1, value2, "trackingPersonnelId");
            return (Criteria) this;
        }

        public Criteria andTrackingPersonnelIdNotBetween(Long value1, Long value2) {
            addCriterion("tracking_personnel_id not between", value1, value2, "trackingPersonnelId");
            return (Criteria) this;
        }

        public Criteria andMedicalNumberIsNull() {
            addCriterion("medical_number is null");
            return (Criteria) this;
        }

        public Criteria andMedicalNumberIsNotNull() {
            addCriterion("medical_number is not null");
            return (Criteria) this;
        }

        public Criteria andMedicalNumberEqualTo(String value) {
            addCriterion("medical_number =", value, "medicalNumber");
            return (Criteria) this;
        }

        public Criteria andMedicalNumberNotEqualTo(String value) {
            addCriterion("medical_number <>", value, "medicalNumber");
            return (Criteria) this;
        }

        public Criteria andMedicalNumberGreaterThan(String value) {
            addCriterion("medical_number >", value, "medicalNumber");
            return (Criteria) this;
        }

        public Criteria andMedicalNumberGreaterThanOrEqualTo(String value) {
            addCriterion("medical_number >=", value, "medicalNumber");
            return (Criteria) this;
        }

        public Criteria andMedicalNumberLessThan(String value) {
            addCriterion("medical_number <", value, "medicalNumber");
            return (Criteria) this;
        }

        public Criteria andMedicalNumberLessThanOrEqualTo(String value) {
            addCriterion("medical_number <=", value, "medicalNumber");
            return (Criteria) this;
        }

        public Criteria andMedicalNumberLike(String value) {
            addCriterion("medical_number like", value, "medicalNumber");
            return (Criteria) this;
        }

        public Criteria andMedicalNumberNotLike(String value) {
            addCriterion("medical_number not like", value, "medicalNumber");
            return (Criteria) this;
        }

        public Criteria andMedicalNumberIn(List<String> values) {
            addCriterion("medical_number in", values, "medicalNumber");
            return (Criteria) this;
        }

        public Criteria andMedicalNumberNotIn(List<String> values) {
            addCriterion("medical_number not in", values, "medicalNumber");
            return (Criteria) this;
        }

        public Criteria andMedicalNumberBetween(String value1, String value2) {
            addCriterion("medical_number between", value1, value2, "medicalNumber");
            return (Criteria) this;
        }

        public Criteria andMedicalNumberNotBetween(String value1, String value2) {
            addCriterion("medical_number not between", value1, value2, "medicalNumber");
            return (Criteria) this;
        }

        public Criteria andDoctorIdIsNull() {
            addCriterion("doctor_id is null");
            return (Criteria) this;
        }

        public Criteria andDoctorIdIsNotNull() {
            addCriterion("doctor_id is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorIdEqualTo(Integer value) {
            addCriterion("doctor_id =", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdNotEqualTo(Integer value) {
            addCriterion("doctor_id <>", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdGreaterThan(Integer value) {
            addCriterion("doctor_id >", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("doctor_id >=", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdLessThan(Integer value) {
            addCriterion("doctor_id <", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdLessThanOrEqualTo(Integer value) {
            addCriterion("doctor_id <=", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdIn(List<Integer> values) {
            addCriterion("doctor_id in", values, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdNotIn(List<Integer> values) {
            addCriterion("doctor_id not in", values, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdBetween(Integer value1, Integer value2) {
            addCriterion("doctor_id between", value1, value2, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("doctor_id not between", value1, value2, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorNameIsNull() {
            addCriterion("doctor_name is null");
            return (Criteria) this;
        }

        public Criteria andDoctorNameIsNotNull() {
            addCriterion("doctor_name is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorNameEqualTo(String value) {
            addCriterion("doctor_name =", value, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameNotEqualTo(String value) {
            addCriterion("doctor_name <>", value, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameGreaterThan(String value) {
            addCriterion("doctor_name >", value, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameGreaterThanOrEqualTo(String value) {
            addCriterion("doctor_name >=", value, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameLessThan(String value) {
            addCriterion("doctor_name <", value, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameLessThanOrEqualTo(String value) {
            addCriterion("doctor_name <=", value, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameLike(String value) {
            addCriterion("doctor_name like", value, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameNotLike(String value) {
            addCriterion("doctor_name not like", value, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameIn(List<String> values) {
            addCriterion("doctor_name in", values, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameNotIn(List<String> values) {
            addCriterion("doctor_name not in", values, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameBetween(String value1, String value2) {
            addCriterion("doctor_name between", value1, value2, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameNotBetween(String value1, String value2) {
            addCriterion("doctor_name not between", value1, value2, "doctorName");
            return (Criteria) this;
        }

        public Criteria andPostoperativeStageIsNull() {
            addCriterion("postoperative_stage is null");
            return (Criteria) this;
        }

        public Criteria andPostoperativeStageIsNotNull() {
            addCriterion("postoperative_stage is not null");
            return (Criteria) this;
        }

        public Criteria andPostoperativeStageEqualTo(String value) {
            addCriterion("postoperative_stage =", value, "postoperativeStage");
            return (Criteria) this;
        }

        public Criteria andPostoperativeStageNotEqualTo(String value) {
            addCriterion("postoperative_stage <>", value, "postoperativeStage");
            return (Criteria) this;
        }

        public Criteria andPostoperativeStageGreaterThan(String value) {
            addCriterion("postoperative_stage >", value, "postoperativeStage");
            return (Criteria) this;
        }

        public Criteria andPostoperativeStageGreaterThanOrEqualTo(String value) {
            addCriterion("postoperative_stage >=", value, "postoperativeStage");
            return (Criteria) this;
        }

        public Criteria andPostoperativeStageLessThan(String value) {
            addCriterion("postoperative_stage <", value, "postoperativeStage");
            return (Criteria) this;
        }

        public Criteria andPostoperativeStageLessThanOrEqualTo(String value) {
            addCriterion("postoperative_stage <=", value, "postoperativeStage");
            return (Criteria) this;
        }

        public Criteria andPostoperativeStageLike(String value) {
            addCriterion("postoperative_stage like", value, "postoperativeStage");
            return (Criteria) this;
        }

        public Criteria andPostoperativeStageNotLike(String value) {
            addCriterion("postoperative_stage not like", value, "postoperativeStage");
            return (Criteria) this;
        }

        public Criteria andPostoperativeStageIn(List<String> values) {
            addCriterion("postoperative_stage in", values, "postoperativeStage");
            return (Criteria) this;
        }

        public Criteria andPostoperativeStageNotIn(List<String> values) {
            addCriterion("postoperative_stage not in", values, "postoperativeStage");
            return (Criteria) this;
        }

        public Criteria andPostoperativeStageBetween(String value1, String value2) {
            addCriterion("postoperative_stage between", value1, value2, "postoperativeStage");
            return (Criteria) this;
        }

        public Criteria andPostoperativeStageNotBetween(String value1, String value2) {
            addCriterion("postoperative_stage not between", value1, value2, "postoperativeStage");
            return (Criteria) this;
        }

        public Criteria andWoundShootingDateIsNull() {
            addCriterion("wound_shooting_date is null");
            return (Criteria) this;
        }

        public Criteria andWoundShootingDateIsNotNull() {
            addCriterion("wound_shooting_date is not null");
            return (Criteria) this;
        }

        public Criteria andWoundShootingDateEqualTo(Date value) {
            addCriterion("wound_shooting_date =", value, "woundShootingDate");
            return (Criteria) this;
        }

        public Criteria andWoundShootingDateNotEqualTo(Date value) {
            addCriterion("wound_shooting_date <>", value, "woundShootingDate");
            return (Criteria) this;
        }

        public Criteria andWoundShootingDateGreaterThan(Date value) {
            addCriterion("wound_shooting_date >", value, "woundShootingDate");
            return (Criteria) this;
        }

        public Criteria andWoundShootingDateGreaterThanOrEqualTo(Date value) {
            addCriterion("wound_shooting_date >=", value, "woundShootingDate");
            return (Criteria) this;
        }

        public Criteria andWoundShootingDateLessThan(Date value) {
            addCriterion("wound_shooting_date <", value, "woundShootingDate");
            return (Criteria) this;
        }

        public Criteria andWoundShootingDateLessThanOrEqualTo(Date value) {
            addCriterion("wound_shooting_date <=", value, "woundShootingDate");
            return (Criteria) this;
        }

        public Criteria andWoundShootingDateIn(List<Date> values) {
            addCriterion("wound_shooting_date in", values, "woundShootingDate");
            return (Criteria) this;
        }

        public Criteria andWoundShootingDateNotIn(List<Date> values) {
            addCriterion("wound_shooting_date not in", values, "woundShootingDate");
            return (Criteria) this;
        }

        public Criteria andWoundShootingDateBetween(Date value1, Date value2) {
            addCriterion("wound_shooting_date between", value1, value2, "woundShootingDate");
            return (Criteria) this;
        }

        public Criteria andWoundShootingDateNotBetween(Date value1, Date value2) {
            addCriterion("wound_shooting_date not between", value1, value2, "woundShootingDate");
            return (Criteria) this;
        }

        public Criteria andTakingLensIsNull() {
            addCriterion("taking_lens is null");
            return (Criteria) this;
        }

        public Criteria andTakingLensIsNotNull() {
            addCriterion("taking_lens is not null");
            return (Criteria) this;
        }

        public Criteria andTakingLensEqualTo(String value) {
            addCriterion("taking_lens =", value, "takingLens");
            return (Criteria) this;
        }

        public Criteria andTakingLensNotEqualTo(String value) {
            addCriterion("taking_lens <>", value, "takingLens");
            return (Criteria) this;
        }

        public Criteria andTakingLensGreaterThan(String value) {
            addCriterion("taking_lens >", value, "takingLens");
            return (Criteria) this;
        }

        public Criteria andTakingLensGreaterThanOrEqualTo(String value) {
            addCriterion("taking_lens >=", value, "takingLens");
            return (Criteria) this;
        }

        public Criteria andTakingLensLessThan(String value) {
            addCriterion("taking_lens <", value, "takingLens");
            return (Criteria) this;
        }

        public Criteria andTakingLensLessThanOrEqualTo(String value) {
            addCriterion("taking_lens <=", value, "takingLens");
            return (Criteria) this;
        }

        public Criteria andTakingLensLike(String value) {
            addCriterion("taking_lens like", value, "takingLens");
            return (Criteria) this;
        }

        public Criteria andTakingLensNotLike(String value) {
            addCriterion("taking_lens not like", value, "takingLens");
            return (Criteria) this;
        }

        public Criteria andTakingLensIn(List<String> values) {
            addCriterion("taking_lens in", values, "takingLens");
            return (Criteria) this;
        }

        public Criteria andTakingLensNotIn(List<String> values) {
            addCriterion("taking_lens not in", values, "takingLens");
            return (Criteria) this;
        }

        public Criteria andTakingLensBetween(String value1, String value2) {
            addCriterion("taking_lens between", value1, value2, "takingLens");
            return (Criteria) this;
        }

        public Criteria andTakingLensNotBetween(String value1, String value2) {
            addCriterion("taking_lens not between", value1, value2, "takingLens");
            return (Criteria) this;
        }

        public Criteria andWoundPhotoIsNull() {
            addCriterion("wound_photo is null");
            return (Criteria) this;
        }

        public Criteria andWoundPhotoIsNotNull() {
            addCriterion("wound_photo is not null");
            return (Criteria) this;
        }

        public Criteria andWoundPhotoEqualTo(String value) {
            addCriterion("wound_photo =", value, "woundPhoto");
            return (Criteria) this;
        }

        public Criteria andWoundPhotoNotEqualTo(String value) {
            addCriterion("wound_photo <>", value, "woundPhoto");
            return (Criteria) this;
        }

        public Criteria andWoundPhotoGreaterThan(String value) {
            addCriterion("wound_photo >", value, "woundPhoto");
            return (Criteria) this;
        }

        public Criteria andWoundPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("wound_photo >=", value, "woundPhoto");
            return (Criteria) this;
        }

        public Criteria andWoundPhotoLessThan(String value) {
            addCriterion("wound_photo <", value, "woundPhoto");
            return (Criteria) this;
        }

        public Criteria andWoundPhotoLessThanOrEqualTo(String value) {
            addCriterion("wound_photo <=", value, "woundPhoto");
            return (Criteria) this;
        }

        public Criteria andWoundPhotoLike(String value) {
            addCriterion("wound_photo like", value, "woundPhoto");
            return (Criteria) this;
        }

        public Criteria andWoundPhotoNotLike(String value) {
            addCriterion("wound_photo not like", value, "woundPhoto");
            return (Criteria) this;
        }

        public Criteria andWoundPhotoIn(List<String> values) {
            addCriterion("wound_photo in", values, "woundPhoto");
            return (Criteria) this;
        }

        public Criteria andWoundPhotoNotIn(List<String> values) {
            addCriterion("wound_photo not in", values, "woundPhoto");
            return (Criteria) this;
        }

        public Criteria andWoundPhotoBetween(String value1, String value2) {
            addCriterion("wound_photo between", value1, value2, "woundPhoto");
            return (Criteria) this;
        }

        public Criteria andWoundPhotoNotBetween(String value1, String value2) {
            addCriterion("wound_photo not between", value1, value2, "woundPhoto");
            return (Criteria) this;
        }

        public Criteria andWoundConditionIsNull() {
            addCriterion("wound_condition is null");
            return (Criteria) this;
        }

        public Criteria andWoundConditionIsNotNull() {
            addCriterion("wound_condition is not null");
            return (Criteria) this;
        }

        public Criteria andWoundConditionEqualTo(String value) {
            addCriterion("wound_condition =", value, "woundCondition");
            return (Criteria) this;
        }

        public Criteria andWoundConditionNotEqualTo(String value) {
            addCriterion("wound_condition <>", value, "woundCondition");
            return (Criteria) this;
        }

        public Criteria andWoundConditionGreaterThan(String value) {
            addCriterion("wound_condition >", value, "woundCondition");
            return (Criteria) this;
        }

        public Criteria andWoundConditionGreaterThanOrEqualTo(String value) {
            addCriterion("wound_condition >=", value, "woundCondition");
            return (Criteria) this;
        }

        public Criteria andWoundConditionLessThan(String value) {
            addCriterion("wound_condition <", value, "woundCondition");
            return (Criteria) this;
        }

        public Criteria andWoundConditionLessThanOrEqualTo(String value) {
            addCriterion("wound_condition <=", value, "woundCondition");
            return (Criteria) this;
        }

        public Criteria andWoundConditionLike(String value) {
            addCriterion("wound_condition like", value, "woundCondition");
            return (Criteria) this;
        }

        public Criteria andWoundConditionNotLike(String value) {
            addCriterion("wound_condition not like", value, "woundCondition");
            return (Criteria) this;
        }

        public Criteria andWoundConditionIn(List<String> values) {
            addCriterion("wound_condition in", values, "woundCondition");
            return (Criteria) this;
        }

        public Criteria andWoundConditionNotIn(List<String> values) {
            addCriterion("wound_condition not in", values, "woundCondition");
            return (Criteria) this;
        }

        public Criteria andWoundConditionBetween(String value1, String value2) {
            addCriterion("wound_condition between", value1, value2, "woundCondition");
            return (Criteria) this;
        }

        public Criteria andWoundConditionNotBetween(String value1, String value2) {
            addCriterion("wound_condition not between", value1, value2, "woundCondition");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("creator is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("creator is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("creator =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("creator <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("creator >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("creator >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("creator <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("creator <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("creator like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("creator not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("creator in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("creator not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("creator between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("creator not between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateNameIsNull() {
            addCriterion("update_name is null");
            return (Criteria) this;
        }

        public Criteria andUpdateNameIsNotNull() {
            addCriterion("update_name is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateNameEqualTo(String value) {
            addCriterion("update_name =", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameNotEqualTo(String value) {
            addCriterion("update_name <>", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameGreaterThan(String value) {
            addCriterion("update_name >", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameGreaterThanOrEqualTo(String value) {
            addCriterion("update_name >=", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameLessThan(String value) {
            addCriterion("update_name <", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameLessThanOrEqualTo(String value) {
            addCriterion("update_name <=", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameLike(String value) {
            addCriterion("update_name like", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameNotLike(String value) {
            addCriterion("update_name not like", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameIn(List<String> values) {
            addCriterion("update_name in", values, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameNotIn(List<String> values) {
            addCriterion("update_name not in", values, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameBetween(String value1, String value2) {
            addCriterion("update_name between", value1, value2, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameNotBetween(String value1, String value2) {
            addCriterion("update_name not between", value1, value2, "updateName");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Integer value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Integer value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Integer value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Integer value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Integer value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Integer> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Integer> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Integer value1, Integer value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsConfirmIsNull() {
            addCriterion("is_confirm is null");
            return (Criteria) this;
        }

        public Criteria andIsConfirmIsNotNull() {
            addCriterion("is_confirm is not null");
            return (Criteria) this;
        }

        public Criteria andIsConfirmEqualTo(String value) {
            addCriterion("is_confirm =", value, "isConfirm");
            return (Criteria) this;
        }

        public Criteria andIsConfirmNotEqualTo(String value) {
            addCriterion("is_confirm <>", value, "isConfirm");
            return (Criteria) this;
        }

        public Criteria andIsConfirmGreaterThan(String value) {
            addCriterion("is_confirm >", value, "isConfirm");
            return (Criteria) this;
        }

        public Criteria andIsConfirmGreaterThanOrEqualTo(String value) {
            addCriterion("is_confirm >=", value, "isConfirm");
            return (Criteria) this;
        }

        public Criteria andIsConfirmLessThan(String value) {
            addCriterion("is_confirm <", value, "isConfirm");
            return (Criteria) this;
        }

        public Criteria andIsConfirmLessThanOrEqualTo(String value) {
            addCriterion("is_confirm <=", value, "isConfirm");
            return (Criteria) this;
        }

        public Criteria andIsConfirmLike(String value) {
            addCriterion("is_confirm like", value, "isConfirm");
            return (Criteria) this;
        }

        public Criteria andIsConfirmNotLike(String value) {
            addCriterion("is_confirm not like", value, "isConfirm");
            return (Criteria) this;
        }

        public Criteria andIsConfirmIn(List<String> values) {
            addCriterion("is_confirm in", values, "isConfirm");
            return (Criteria) this;
        }

        public Criteria andIsConfirmNotIn(List<String> values) {
            addCriterion("is_confirm not in", values, "isConfirm");
            return (Criteria) this;
        }

        public Criteria andIsConfirmBetween(String value1, String value2) {
            addCriterion("is_confirm between", value1, value2, "isConfirm");
            return (Criteria) this;
        }

        public Criteria andIsConfirmNotBetween(String value1, String value2) {
            addCriterion("is_confirm not between", value1, value2, "isConfirm");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private final String condition;
        private final String typeHandler;
        private Object value;
        private Object secondValue;
        private boolean noValue;
        private boolean singleValue;
        private boolean betweenValue;
        private boolean listValue;

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }
    }
}