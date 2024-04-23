package com.trust.xfyl.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * @author Bay-max
 * @date 2024/4/22 14:01
 **/
public class DoctorExample extends BaseBean {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DoctorExample() {
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

        public Criteria andDoctorTypeIsNull() {
            addCriterion("doctor_type is null");
            return (Criteria) this;
        }

        public Criteria andDoctorTypeIsNotNull() {
            addCriterion("doctor_type is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorTypeEqualTo(String value) {
            addCriterion("doctor_type =", value, "doctorType");
            return (Criteria) this;
        }

        public Criteria andDoctorTypeNotEqualTo(String value) {
            addCriterion("doctor_type <>", value, "doctorType");
            return (Criteria) this;
        }

        public Criteria andDoctorTypeGreaterThan(String value) {
            addCriterion("doctor_type >", value, "doctorType");
            return (Criteria) this;
        }

        public Criteria andDoctorTypeGreaterThanOrEqualTo(String value) {
            addCriterion("doctor_type >=", value, "doctorType");
            return (Criteria) this;
        }

        public Criteria andDoctorTypeLessThan(String value) {
            addCriterion("doctor_type <", value, "doctorType");
            return (Criteria) this;
        }

        public Criteria andDoctorTypeLessThanOrEqualTo(String value) {
            addCriterion("doctor_type <=", value, "doctorType");
            return (Criteria) this;
        }

        public Criteria andDoctorTypeLike(String value) {
            addCriterion("doctor_type like", value, "doctorType");
            return (Criteria) this;
        }

        public Criteria andDoctorTypeNotLike(String value) {
            addCriterion("doctor_type not like", value, "doctorType");
            return (Criteria) this;
        }

        public Criteria andDoctorTypeIn(List<String> values) {
            addCriterion("doctor_type in", values, "doctorType");
            return (Criteria) this;
        }

        public Criteria andDoctorTypeNotIn(List<String> values) {
            addCriterion("doctor_type not in", values, "doctorType");
            return (Criteria) this;
        }

        public Criteria andDoctorTypeBetween(String value1, String value2) {
            addCriterion("doctor_type between", value1, value2, "doctorType");
            return (Criteria) this;
        }

        public Criteria andDoctorTypeNotBetween(String value1, String value2) {
            addCriterion("doctor_type not between", value1, value2, "doctorType");
            return (Criteria) this;
        }

        public Criteria andDoctorIntroduceIsNull() {
            addCriterion("doctor_introduce is null");
            return (Criteria) this;
        }

        public Criteria andDoctorIntroduceIsNotNull() {
            addCriterion("doctor_introduce is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorIntroduceEqualTo(String value) {
            addCriterion("doctor_introduce =", value, "doctorIntroduce");
            return (Criteria) this;
        }

        public Criteria andDoctorIntroduceNotEqualTo(String value) {
            addCriterion("doctor_introduce <>", value, "doctorIntroduce");
            return (Criteria) this;
        }

        public Criteria andDoctorIntroduceGreaterThan(String value) {
            addCriterion("doctor_introduce >", value, "doctorIntroduce");
            return (Criteria) this;
        }

        public Criteria andDoctorIntroduceGreaterThanOrEqualTo(String value) {
            addCriterion("doctor_introduce >=", value, "doctorIntroduce");
            return (Criteria) this;
        }

        public Criteria andDoctorIntroduceLessThan(String value) {
            addCriterion("doctor_introduce <", value, "doctorIntroduce");
            return (Criteria) this;
        }

        public Criteria andDoctorIntroduceLessThanOrEqualTo(String value) {
            addCriterion("doctor_introduce <=", value, "doctorIntroduce");
            return (Criteria) this;
        }

        public Criteria andDoctorIntroduceLike(String value) {
            addCriterion("doctor_introduce like", value, "doctorIntroduce");
            return (Criteria) this;
        }

        public Criteria andDoctorIntroduceNotLike(String value) {
            addCriterion("doctor_introduce not like", value, "doctorIntroduce");
            return (Criteria) this;
        }

        public Criteria andDoctorIntroduceIn(List<String> values) {
            addCriterion("doctor_introduce in", values, "doctorIntroduce");
            return (Criteria) this;
        }

        public Criteria andDoctorIntroduceNotIn(List<String> values) {
            addCriterion("doctor_introduce not in", values, "doctorIntroduce");
            return (Criteria) this;
        }

        public Criteria andDoctorIntroduceBetween(String value1, String value2) {
            addCriterion("doctor_introduce between", value1, value2, "doctorIntroduce");
            return (Criteria) this;
        }

        public Criteria andDoctorIntroduceNotBetween(String value1, String value2) {
            addCriterion("doctor_introduce not between", value1, value2, "doctorIntroduce");
            return (Criteria) this;
        }

        public Criteria andDoctorPhotoIsNull() {
            addCriterion("doctor_photo is null");
            return (Criteria) this;
        }

        public Criteria andDoctorPhotoIsNotNull() {
            addCriterion("doctor_photo is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorPhotoEqualTo(String value) {
            addCriterion("doctor_photo =", value, "doctorPhoto");
            return (Criteria) this;
        }

        public Criteria andDoctorPhotoNotEqualTo(String value) {
            addCriterion("doctor_photo <>", value, "doctorPhoto");
            return (Criteria) this;
        }

        public Criteria andDoctorPhotoGreaterThan(String value) {
            addCriterion("doctor_photo >", value, "doctorPhoto");
            return (Criteria) this;
        }

        public Criteria andDoctorPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("doctor_photo >=", value, "doctorPhoto");
            return (Criteria) this;
        }

        public Criteria andDoctorPhotoLessThan(String value) {
            addCriterion("doctor_photo <", value, "doctorPhoto");
            return (Criteria) this;
        }

        public Criteria andDoctorPhotoLessThanOrEqualTo(String value) {
            addCriterion("doctor_photo <=", value, "doctorPhoto");
            return (Criteria) this;
        }

        public Criteria andDoctorPhotoLike(String value) {
            addCriterion("doctor_photo like", value, "doctorPhoto");
            return (Criteria) this;
        }

        public Criteria andDoctorPhotoNotLike(String value) {
            addCriterion("doctor_photo not like", value, "doctorPhoto");
            return (Criteria) this;
        }

        public Criteria andDoctorPhotoIn(List<String> values) {
            addCriterion("doctor_photo in", values, "doctorPhoto");
            return (Criteria) this;
        }

        public Criteria andDoctorPhotoNotIn(List<String> values) {
            addCriterion("doctor_photo not in", values, "doctorPhoto");
            return (Criteria) this;
        }

        public Criteria andDoctorPhotoBetween(String value1, String value2) {
            addCriterion("doctor_photo between", value1, value2, "doctorPhoto");
            return (Criteria) this;
        }

        public Criteria andDoctorPhotoNotBetween(String value1, String value2) {
            addCriterion("doctor_photo not between", value1, value2, "doctorPhoto");
            return (Criteria) this;
        }

        public Criteria andDoctorServicesIsNull() {
            addCriterion("doctor_services is null");
            return (Criteria) this;
        }

        public Criteria andDoctorServicesIsNotNull() {
            addCriterion("doctor_services is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorServicesEqualTo(String value) {
            addCriterion("doctor_services =", value, "doctorServices");
            return (Criteria) this;
        }

        public Criteria andDoctorServicesNotEqualTo(String value) {
            addCriterion("doctor_services <>", value, "doctorServices");
            return (Criteria) this;
        }

        public Criteria andDoctorServicesGreaterThan(String value) {
            addCriterion("doctor_services >", value, "doctorServices");
            return (Criteria) this;
        }

        public Criteria andDoctorServicesGreaterThanOrEqualTo(String value) {
            addCriterion("doctor_services >=", value, "doctorServices");
            return (Criteria) this;
        }

        public Criteria andDoctorServicesLessThan(String value) {
            addCriterion("doctor_services <", value, "doctorServices");
            return (Criteria) this;
        }

        public Criteria andDoctorServicesLessThanOrEqualTo(String value) {
            addCriterion("doctor_services <=", value, "doctorServices");
            return (Criteria) this;
        }

        public Criteria andDoctorServicesLike(String value) {
            addCriterion("doctor_services like", value, "doctorServices");
            return (Criteria) this;
        }

        public Criteria andDoctorServicesNotLike(String value) {
            addCriterion("doctor_services not like", value, "doctorServices");
            return (Criteria) this;
        }

        public Criteria andDoctorServicesIn(List<String> values) {
            addCriterion("doctor_services in", values, "doctorServices");
            return (Criteria) this;
        }

        public Criteria andDoctorServicesNotIn(List<String> values) {
            addCriterion("doctor_services not in", values, "doctorServices");
            return (Criteria) this;
        }

        public Criteria andDoctorServicesBetween(String value1, String value2) {
            addCriterion("doctor_services between", value1, value2, "doctorServices");
            return (Criteria) this;
        }

        public Criteria andDoctorServicesNotBetween(String value1, String value2) {
            addCriterion("doctor_services not between", value1, value2, "doctorServices");
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

        public Criteria andUpdatorIsNull() {
            addCriterion("updator is null");
            return (Criteria) this;
        }

        public Criteria andUpdatorIsNotNull() {
            addCriterion("updator is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatorEqualTo(String value) {
            addCriterion("updator =", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorNotEqualTo(String value) {
            addCriterion("updator <>", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorGreaterThan(String value) {
            addCriterion("updator >", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorGreaterThanOrEqualTo(String value) {
            addCriterion("updator >=", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorLessThan(String value) {
            addCriterion("updator <", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorLessThanOrEqualTo(String value) {
            addCriterion("updator <=", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorLike(String value) {
            addCriterion("updator like", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorNotLike(String value) {
            addCriterion("updator not like", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorIn(List<String> values) {
            addCriterion("updator in", values, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorNotIn(List<String> values) {
            addCriterion("updator not in", values, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorBetween(String value1, String value2) {
            addCriterion("updator between", value1, value2, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorNotBetween(String value1, String value2) {
            addCriterion("updator not between", value1, value2, "updator");
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

        public Criteria andIsDeleteEqualTo(String value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(String value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(String value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(String value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(String value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(String value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLike(String value) {
            addCriterion("is_delete like", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotLike(String value) {
            addCriterion("is_delete not like", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<String> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<String> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(String value1, String value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(String value1, String value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
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