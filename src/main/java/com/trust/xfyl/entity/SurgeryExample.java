package com.trust.xfyl.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * @author Bay-max
 * @date 2024/4/22 14:01
 **/
public class SurgeryExample extends BaseBean {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SurgeryExample() {
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

        public Criteria andSurgeryIdIsNull() {
            addCriterion("surgery_id is null");
            return (Criteria) this;
        }

        public Criteria andSurgeryIdIsNotNull() {
            addCriterion("surgery_id is not null");
            return (Criteria) this;
        }

        public Criteria andSurgeryIdEqualTo(Long value) {
            addCriterion("surgery_id =", value, "surgeryId");
            return (Criteria) this;
        }

        public Criteria andSurgeryIdNotEqualTo(Long value) {
            addCriterion("surgery_id <>", value, "surgeryId");
            return (Criteria) this;
        }

        public Criteria andSurgeryIdGreaterThan(Long value) {
            addCriterion("surgery_id >", value, "surgeryId");
            return (Criteria) this;
        }

        public Criteria andSurgeryIdGreaterThanOrEqualTo(Long value) {
            addCriterion("surgery_id >=", value, "surgeryId");
            return (Criteria) this;
        }

        public Criteria andSurgeryIdLessThan(Long value) {
            addCriterion("surgery_id <", value, "surgeryId");
            return (Criteria) this;
        }

        public Criteria andSurgeryIdLessThanOrEqualTo(Long value) {
            addCriterion("surgery_id <=", value, "surgeryId");
            return (Criteria) this;
        }

        public Criteria andSurgeryIdIn(List<Long> values) {
            addCriterion("surgery_id in", values, "surgeryId");
            return (Criteria) this;
        }

        public Criteria andSurgeryIdNotIn(List<Long> values) {
            addCriterion("surgery_id not in", values, "surgeryId");
            return (Criteria) this;
        }

        public Criteria andSurgeryIdBetween(Long value1, Long value2) {
            addCriterion("surgery_id between", value1, value2, "surgeryId");
            return (Criteria) this;
        }

        public Criteria andSurgeryIdNotBetween(Long value1, Long value2) {
            addCriterion("surgery_id not between", value1, value2, "surgeryId");
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

        public Criteria andSurgeryTypeIsNull() {
            addCriterion("surgery_type is null");
            return (Criteria) this;
        }

        public Criteria andSurgeryTypeIsNotNull() {
            addCriterion("surgery_type is not null");
            return (Criteria) this;
        }

        public Criteria andSurgeryTypeEqualTo(String value) {
            addCriterion("surgery_type =", value, "surgeryType");
            return (Criteria) this;
        }

        public Criteria andSurgeryTypeNotEqualTo(String value) {
            addCriterion("surgery_type <>", value, "surgeryType");
            return (Criteria) this;
        }

        public Criteria andSurgeryTypeGreaterThan(String value) {
            addCriterion("surgery_type >", value, "surgeryType");
            return (Criteria) this;
        }

        public Criteria andSurgeryTypeGreaterThanOrEqualTo(String value) {
            addCriterion("surgery_type >=", value, "surgeryType");
            return (Criteria) this;
        }

        public Criteria andSurgeryTypeLessThan(String value) {
            addCriterion("surgery_type <", value, "surgeryType");
            return (Criteria) this;
        }

        public Criteria andSurgeryTypeLessThanOrEqualTo(String value) {
            addCriterion("surgery_type <=", value, "surgeryType");
            return (Criteria) this;
        }

        public Criteria andSurgeryTypeLike(String value) {
            addCriterion("surgery_type like", value, "surgeryType");
            return (Criteria) this;
        }

        public Criteria andSurgeryTypeNotLike(String value) {
            addCriterion("surgery_type not like", value, "surgeryType");
            return (Criteria) this;
        }

        public Criteria andSurgeryTypeIn(List<String> values) {
            addCriterion("surgery_type in", values, "surgeryType");
            return (Criteria) this;
        }

        public Criteria andSurgeryTypeNotIn(List<String> values) {
            addCriterion("surgery_type not in", values, "surgeryType");
            return (Criteria) this;
        }

        public Criteria andSurgeryTypeBetween(String value1, String value2) {
            addCriterion("surgery_type between", value1, value2, "surgeryType");
            return (Criteria) this;
        }

        public Criteria andSurgeryTypeNotBetween(String value1, String value2) {
            addCriterion("surgery_type not between", value1, value2, "surgeryType");
            return (Criteria) this;
        }

        public Criteria andSurgeryNameIsNull() {
            addCriterion("surgery_name is null");
            return (Criteria) this;
        }

        public Criteria andSurgeryNameIsNotNull() {
            addCriterion("surgery_name is not null");
            return (Criteria) this;
        }

        public Criteria andSurgeryNameEqualTo(String value) {
            addCriterion("surgery_name =", value, "surgeryName");
            return (Criteria) this;
        }

        public Criteria andSurgeryNameNotEqualTo(String value) {
            addCriterion("surgery_name <>", value, "surgeryName");
            return (Criteria) this;
        }

        public Criteria andSurgeryNameGreaterThan(String value) {
            addCriterion("surgery_name >", value, "surgeryName");
            return (Criteria) this;
        }

        public Criteria andSurgeryNameGreaterThanOrEqualTo(String value) {
            addCriterion("surgery_name >=", value, "surgeryName");
            return (Criteria) this;
        }

        public Criteria andSurgeryNameLessThan(String value) {
            addCriterion("surgery_name <", value, "surgeryName");
            return (Criteria) this;
        }

        public Criteria andSurgeryNameLessThanOrEqualTo(String value) {
            addCriterion("surgery_name <=", value, "surgeryName");
            return (Criteria) this;
        }

        public Criteria andSurgeryNameLike(String value) {
            addCriterion("surgery_name like", value, "surgeryName");
            return (Criteria) this;
        }

        public Criteria andSurgeryNameNotLike(String value) {
            addCriterion("surgery_name not like", value, "surgeryName");
            return (Criteria) this;
        }

        public Criteria andSurgeryNameIn(List<String> values) {
            addCriterion("surgery_name in", values, "surgeryName");
            return (Criteria) this;
        }

        public Criteria andSurgeryNameNotIn(List<String> values) {
            addCriterion("surgery_name not in", values, "surgeryName");
            return (Criteria) this;
        }

        public Criteria andSurgeryNameBetween(String value1, String value2) {
            addCriterion("surgery_name between", value1, value2, "surgeryName");
            return (Criteria) this;
        }

        public Criteria andSurgeryNameNotBetween(String value1, String value2) {
            addCriterion("surgery_name not between", value1, value2, "surgeryName");
            return (Criteria) this;
        }

        public Criteria andOperatingPhysicianIsNull() {
            addCriterion("operating_physician is null");
            return (Criteria) this;
        }

        public Criteria andOperatingPhysicianIsNotNull() {
            addCriterion("operating_physician is not null");
            return (Criteria) this;
        }

        public Criteria andOperatingPhysicianEqualTo(String value) {
            addCriterion("operating_physician =", value, "operatingPhysician");
            return (Criteria) this;
        }

        public Criteria andOperatingPhysicianNotEqualTo(String value) {
            addCriterion("operating_physician <>", value, "operatingPhysician");
            return (Criteria) this;
        }

        public Criteria andOperatingPhysicianGreaterThan(String value) {
            addCriterion("operating_physician >", value, "operatingPhysician");
            return (Criteria) this;
        }

        public Criteria andOperatingPhysicianGreaterThanOrEqualTo(String value) {
            addCriterion("operating_physician >=", value, "operatingPhysician");
            return (Criteria) this;
        }

        public Criteria andOperatingPhysicianLessThan(String value) {
            addCriterion("operating_physician <", value, "operatingPhysician");
            return (Criteria) this;
        }

        public Criteria andOperatingPhysicianLessThanOrEqualTo(String value) {
            addCriterion("operating_physician <=", value, "operatingPhysician");
            return (Criteria) this;
        }

        public Criteria andOperatingPhysicianLike(String value) {
            addCriterion("operating_physician like", value, "operatingPhysician");
            return (Criteria) this;
        }

        public Criteria andOperatingPhysicianNotLike(String value) {
            addCriterion("operating_physician not like", value, "operatingPhysician");
            return (Criteria) this;
        }

        public Criteria andOperatingPhysicianIn(List<String> values) {
            addCriterion("operating_physician in", values, "operatingPhysician");
            return (Criteria) this;
        }

        public Criteria andOperatingPhysicianNotIn(List<String> values) {
            addCriterion("operating_physician not in", values, "operatingPhysician");
            return (Criteria) this;
        }

        public Criteria andOperatingPhysicianBetween(String value1, String value2) {
            addCriterion("operating_physician between", value1, value2, "operatingPhysician");
            return (Criteria) this;
        }

        public Criteria andOperatingPhysicianNotBetween(String value1, String value2) {
            addCriterion("operating_physician not between", value1, value2, "operatingPhysician");
            return (Criteria) this;
        }

        public Criteria andWoundPhotoUploadIsNull() {
            addCriterion("wound_photo_upload is null");
            return (Criteria) this;
        }

        public Criteria andWoundPhotoUploadIsNotNull() {
            addCriterion("wound_photo_upload is not null");
            return (Criteria) this;
        }

        public Criteria andWoundPhotoUploadEqualTo(String value) {
            addCriterion("wound_photo_upload =", value, "woundPhotoUpload");
            return (Criteria) this;
        }

        public Criteria andWoundPhotoUploadNotEqualTo(String value) {
            addCriterion("wound_photo_upload <>", value, "woundPhotoUpload");
            return (Criteria) this;
        }

        public Criteria andWoundPhotoUploadGreaterThan(String value) {
            addCriterion("wound_photo_upload >", value, "woundPhotoUpload");
            return (Criteria) this;
        }

        public Criteria andWoundPhotoUploadGreaterThanOrEqualTo(String value) {
            addCriterion("wound_photo_upload >=", value, "woundPhotoUpload");
            return (Criteria) this;
        }

        public Criteria andWoundPhotoUploadLessThan(String value) {
            addCriterion("wound_photo_upload <", value, "woundPhotoUpload");
            return (Criteria) this;
        }

        public Criteria andWoundPhotoUploadLessThanOrEqualTo(String value) {
            addCriterion("wound_photo_upload <=", value, "woundPhotoUpload");
            return (Criteria) this;
        }

        public Criteria andWoundPhotoUploadLike(String value) {
            addCriterion("wound_photo_upload like", value, "woundPhotoUpload");
            return (Criteria) this;
        }

        public Criteria andWoundPhotoUploadNotLike(String value) {
            addCriterion("wound_photo_upload not like", value, "woundPhotoUpload");
            return (Criteria) this;
        }

        public Criteria andWoundPhotoUploadIn(List<String> values) {
            addCriterion("wound_photo_upload in", values, "woundPhotoUpload");
            return (Criteria) this;
        }

        public Criteria andWoundPhotoUploadNotIn(List<String> values) {
            addCriterion("wound_photo_upload not in", values, "woundPhotoUpload");
            return (Criteria) this;
        }

        public Criteria andWoundPhotoUploadBetween(String value1, String value2) {
            addCriterion("wound_photo_upload between", value1, value2, "woundPhotoUpload");
            return (Criteria) this;
        }

        public Criteria andWoundPhotoUploadNotBetween(String value1, String value2) {
            addCriterion("wound_photo_upload not between", value1, value2, "woundPhotoUpload");
            return (Criteria) this;
        }

        public Criteria andSurgeryTimeIsNull() {
            addCriterion("surgery_time is null");
            return (Criteria) this;
        }

        public Criteria andSurgeryTimeIsNotNull() {
            addCriterion("surgery_time is not null");
            return (Criteria) this;
        }

        public Criteria andSurgeryTimeEqualTo(Date value) {
            addCriterion("surgery_time =", value, "surgeryTime");
            return (Criteria) this;
        }

        public Criteria andSurgeryTimeNotEqualTo(Date value) {
            addCriterion("surgery_time <>", value, "surgeryTime");
            return (Criteria) this;
        }

        public Criteria andSurgeryTimeGreaterThan(Date value) {
            addCriterion("surgery_time >", value, "surgeryTime");
            return (Criteria) this;
        }

        public Criteria andSurgeryTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("surgery_time >=", value, "surgeryTime");
            return (Criteria) this;
        }

        public Criteria andSurgeryTimeLessThan(Date value) {
            addCriterion("surgery_time <", value, "surgeryTime");
            return (Criteria) this;
        }

        public Criteria andSurgeryTimeLessThanOrEqualTo(Date value) {
            addCriterion("surgery_time <=", value, "surgeryTime");
            return (Criteria) this;
        }

        public Criteria andSurgeryTimeIn(List<Date> values) {
            addCriterion("surgery_time in", values, "surgeryTime");
            return (Criteria) this;
        }

        public Criteria andSurgeryTimeNotIn(List<Date> values) {
            addCriterion("surgery_time not in", values, "surgeryTime");
            return (Criteria) this;
        }

        public Criteria andSurgeryTimeBetween(Date value1, Date value2) {
            addCriterion("surgery_time between", value1, value2, "surgeryTime");
            return (Criteria) this;
        }

        public Criteria andSurgeryTimeNotBetween(Date value1, Date value2) {
            addCriterion("surgery_time not between", value1, value2, "surgeryTime");
            return (Criteria) this;
        }

        public Criteria andPhotoUploadTimeIsNull() {
            addCriterion("photo_upload_time is null");
            return (Criteria) this;
        }

        public Criteria andPhotoUploadTimeIsNotNull() {
            addCriterion("photo_upload_time is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoUploadTimeEqualTo(Date value) {
            addCriterion("photo_upload_time =", value, "photoUploadTime");
            return (Criteria) this;
        }

        public Criteria andPhotoUploadTimeNotEqualTo(Date value) {
            addCriterion("photo_upload_time <>", value, "photoUploadTime");
            return (Criteria) this;
        }

        public Criteria andPhotoUploadTimeGreaterThan(Date value) {
            addCriterion("photo_upload_time >", value, "photoUploadTime");
            return (Criteria) this;
        }

        public Criteria andPhotoUploadTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("photo_upload_time >=", value, "photoUploadTime");
            return (Criteria) this;
        }

        public Criteria andPhotoUploadTimeLessThan(Date value) {
            addCriterion("photo_upload_time <", value, "photoUploadTime");
            return (Criteria) this;
        }

        public Criteria andPhotoUploadTimeLessThanOrEqualTo(Date value) {
            addCriterion("photo_upload_time <=", value, "photoUploadTime");
            return (Criteria) this;
        }

        public Criteria andPhotoUploadTimeIn(List<Date> values) {
            addCriterion("photo_upload_time in", values, "photoUploadTime");
            return (Criteria) this;
        }

        public Criteria andPhotoUploadTimeNotIn(List<Date> values) {
            addCriterion("photo_upload_time not in", values, "photoUploadTime");
            return (Criteria) this;
        }

        public Criteria andPhotoUploadTimeBetween(Date value1, Date value2) {
            addCriterion("photo_upload_time between", value1, value2, "photoUploadTime");
            return (Criteria) this;
        }

        public Criteria andPhotoUploadTimeNotBetween(Date value1, Date value2) {
            addCriterion("photo_upload_time not between", value1, value2, "photoUploadTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIsNull() {
            addCriterion("creat_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIsNotNull() {
            addCriterion("creat_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatTimeEqualTo(Date value) {
            addCriterion("creat_time =", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotEqualTo(Date value) {
            addCriterion("creat_time <>", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeGreaterThan(Date value) {
            addCriterion("creat_time >", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("creat_time >=", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeLessThan(Date value) {
            addCriterion("creat_time <", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeLessThanOrEqualTo(Date value) {
            addCriterion("creat_time <=", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIn(List<Date> values) {
            addCriterion("creat_time in", values, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotIn(List<Date> values) {
            addCriterion("creat_time not in", values, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeBetween(Date value1, Date value2) {
            addCriterion("creat_time between", value1, value2, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotBetween(Date value1, Date value2) {
            addCriterion("creat_time not between", value1, value2, "creatTime");
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