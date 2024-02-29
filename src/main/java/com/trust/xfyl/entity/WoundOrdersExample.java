package com.trust.xfyl.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WoundOrdersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WoundOrdersExample() {
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

        public Criteria andOrderNumberIsNull() {
            addCriterion("order_number is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIsNotNull() {
            addCriterion("order_number is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberEqualTo(String value) {
            addCriterion("order_number =", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotEqualTo(String value) {
            addCriterion("order_number <>", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThan(String value) {
            addCriterion("order_number >", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThanOrEqualTo(String value) {
            addCriterion("order_number >=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThan(String value) {
            addCriterion("order_number <", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThanOrEqualTo(String value) {
            addCriterion("order_number <=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLike(String value) {
            addCriterion("order_number like", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotLike(String value) {
            addCriterion("order_number not like", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIn(List<String> values) {
            addCriterion("order_number in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotIn(List<String> values) {
            addCriterion("order_number not in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberBetween(String value1, String value2) {
            addCriterion("order_number between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotBetween(String value1, String value2) {
            addCriterion("order_number not between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(Long value) {
            addCriterion("task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(Long value) {
            addCriterion("task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(Long value) {
            addCriterion("task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(Long value) {
            addCriterion("task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(Long value) {
            addCriterion("task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(Long value) {
            addCriterion("task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<Long> values) {
            addCriterion("task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<Long> values) {
            addCriterion("task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(Long value1, Long value2) {
            addCriterion("task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(Long value1, Long value2) {
            addCriterion("task_id not between", value1, value2, "taskId");
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

        public Criteria andDoctorIdEqualTo(Long value) {
            addCriterion("doctor_id =", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdNotEqualTo(Long value) {
            addCriterion("doctor_id <>", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdGreaterThan(Long value) {
            addCriterion("doctor_id >", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("doctor_id >=", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdLessThan(Long value) {
            addCriterion("doctor_id <", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdLessThanOrEqualTo(Long value) {
            addCriterion("doctor_id <=", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdIn(List<Long> values) {
            addCriterion("doctor_id in", values, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdNotIn(List<Long> values) {
            addCriterion("doctor_id not in", values, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdBetween(Long value1, Long value2) {
            addCriterion("doctor_id between", value1, value2, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdNotBetween(Long value1, Long value2) {
            addCriterion("doctor_id not between", value1, value2, "doctorId");
            return (Criteria) this;
        }

        public Criteria andOrdTypeIsNull() {
            addCriterion("ord_type is null");
            return (Criteria) this;
        }

        public Criteria andOrdTypeIsNotNull() {
            addCriterion("ord_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrdTypeEqualTo(String value) {
            addCriterion("ord_type =", value, "ordType");
            return (Criteria) this;
        }

        public Criteria andOrdTypeNotEqualTo(String value) {
            addCriterion("ord_type <>", value, "ordType");
            return (Criteria) this;
        }

        public Criteria andOrdTypeGreaterThan(String value) {
            addCriterion("ord_type >", value, "ordType");
            return (Criteria) this;
        }

        public Criteria andOrdTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ord_type >=", value, "ordType");
            return (Criteria) this;
        }

        public Criteria andOrdTypeLessThan(String value) {
            addCriterion("ord_type <", value, "ordType");
            return (Criteria) this;
        }

        public Criteria andOrdTypeLessThanOrEqualTo(String value) {
            addCriterion("ord_type <=", value, "ordType");
            return (Criteria) this;
        }

        public Criteria andOrdTypeLike(String value) {
            addCriterion("ord_type like", value, "ordType");
            return (Criteria) this;
        }

        public Criteria andOrdTypeNotLike(String value) {
            addCriterion("ord_type not like", value, "ordType");
            return (Criteria) this;
        }

        public Criteria andOrdTypeIn(List<String> values) {
            addCriterion("ord_type in", values, "ordType");
            return (Criteria) this;
        }

        public Criteria andOrdTypeNotIn(List<String> values) {
            addCriterion("ord_type not in", values, "ordType");
            return (Criteria) this;
        }

        public Criteria andOrdTypeBetween(String value1, String value2) {
            addCriterion("ord_type between", value1, value2, "ordType");
            return (Criteria) this;
        }

        public Criteria andOrdTypeNotBetween(String value1, String value2) {
            addCriterion("ord_type not between", value1, value2, "ordType");
            return (Criteria) this;
        }

        public Criteria andOrderPriceIsNull() {
            addCriterion("order_price is null");
            return (Criteria) this;
        }

        public Criteria andOrderPriceIsNotNull() {
            addCriterion("order_price is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPriceEqualTo(BigDecimal value) {
            addCriterion("order_price =", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceNotEqualTo(BigDecimal value) {
            addCriterion("order_price <>", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceGreaterThan(BigDecimal value) {
            addCriterion("order_price >", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_price >=", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceLessThan(BigDecimal value) {
            addCriterion("order_price <", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_price <=", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceIn(List<BigDecimal> values) {
            addCriterion("order_price in", values, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceNotIn(List<BigDecimal> values) {
            addCriterion("order_price not in", values, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_price between", value1, value2, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_price not between", value1, value2, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andBusinessIsNull() {
            addCriterion("business is null");
            return (Criteria) this;
        }

        public Criteria andBusinessIsNotNull() {
            addCriterion("business is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessEqualTo(String value) {
            addCriterion("business =", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessNotEqualTo(String value) {
            addCriterion("business <>", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessGreaterThan(String value) {
            addCriterion("business >", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessGreaterThanOrEqualTo(String value) {
            addCriterion("business >=", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessLessThan(String value) {
            addCriterion("business <", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessLessThanOrEqualTo(String value) {
            addCriterion("business <=", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessLike(String value) {
            addCriterion("business like", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessNotLike(String value) {
            addCriterion("business not like", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessIn(List<String> values) {
            addCriterion("business in", values, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessNotIn(List<String> values) {
            addCriterion("business not in", values, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessBetween(String value1, String value2) {
            addCriterion("business between", value1, value2, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessNotBetween(String value1, String value2) {
            addCriterion("business not between", value1, value2, "business");
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

        public Criteria andAppointmentTypeIsNull() {
            addCriterion("appointment_type is null");
            return (Criteria) this;
        }

        public Criteria andAppointmentTypeIsNotNull() {
            addCriterion("appointment_type is not null");
            return (Criteria) this;
        }

        public Criteria andAppointmentTypeEqualTo(String value) {
            addCriterion("appointment_type =", value, "appointmentType");
            return (Criteria) this;
        }

        public Criteria andAppointmentTypeNotEqualTo(String value) {
            addCriterion("appointment_type <>", value, "appointmentType");
            return (Criteria) this;
        }

        public Criteria andAppointmentTypeGreaterThan(String value) {
            addCriterion("appointment_type >", value, "appointmentType");
            return (Criteria) this;
        }

        public Criteria andAppointmentTypeGreaterThanOrEqualTo(String value) {
            addCriterion("appointment_type >=", value, "appointmentType");
            return (Criteria) this;
        }

        public Criteria andAppointmentTypeLessThan(String value) {
            addCriterion("appointment_type <", value, "appointmentType");
            return (Criteria) this;
        }

        public Criteria andAppointmentTypeLessThanOrEqualTo(String value) {
            addCriterion("appointment_type <=", value, "appointmentType");
            return (Criteria) this;
        }

        public Criteria andAppointmentTypeLike(String value) {
            addCriterion("appointment_type like", value, "appointmentType");
            return (Criteria) this;
        }

        public Criteria andAppointmentTypeNotLike(String value) {
            addCriterion("appointment_type not like", value, "appointmentType");
            return (Criteria) this;
        }

        public Criteria andAppointmentTypeIn(List<String> values) {
            addCriterion("appointment_type in", values, "appointmentType");
            return (Criteria) this;
        }

        public Criteria andAppointmentTypeNotIn(List<String> values) {
            addCriterion("appointment_type not in", values, "appointmentType");
            return (Criteria) this;
        }

        public Criteria andAppointmentTypeBetween(String value1, String value2) {
            addCriterion("appointment_type between", value1, value2, "appointmentType");
            return (Criteria) this;
        }

        public Criteria andAppointmentTypeNotBetween(String value1, String value2) {
            addCriterion("appointment_type not between", value1, value2, "appointmentType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNull() {
            addCriterion("order_type is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNotNull() {
            addCriterion("order_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeEqualTo(String value) {
            addCriterion("order_type =", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotEqualTo(String value) {
            addCriterion("order_type <>", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThan(String value) {
            addCriterion("order_type >", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThanOrEqualTo(String value) {
            addCriterion("order_type >=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThan(String value) {
            addCriterion("order_type <", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThanOrEqualTo(String value) {
            addCriterion("order_type <=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLike(String value) {
            addCriterion("order_type like", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotLike(String value) {
            addCriterion("order_type not like", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIn(List<String> values) {
            addCriterion("order_type in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotIn(List<String> values) {
            addCriterion("order_type not in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeBetween(String value1, String value2) {
            addCriterion("order_type between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotBetween(String value1, String value2) {
            addCriterion("order_type not between", value1, value2, "orderType");
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

        public Criteria andPerioperativeSurgeryIsNull() {
            addCriterion("perioperative_surgery is null");
            return (Criteria) this;
        }

        public Criteria andPerioperativeSurgeryIsNotNull() {
            addCriterion("perioperative_surgery is not null");
            return (Criteria) this;
        }

        public Criteria andPerioperativeSurgeryEqualTo(String value) {
            addCriterion("perioperative_surgery =", value, "perioperativeSurgery");
            return (Criteria) this;
        }

        public Criteria andPerioperativeSurgeryNotEqualTo(String value) {
            addCriterion("perioperative_surgery <>", value, "perioperativeSurgery");
            return (Criteria) this;
        }

        public Criteria andPerioperativeSurgeryGreaterThan(String value) {
            addCriterion("perioperative_surgery >", value, "perioperativeSurgery");
            return (Criteria) this;
        }

        public Criteria andPerioperativeSurgeryGreaterThanOrEqualTo(String value) {
            addCriterion("perioperative_surgery >=", value, "perioperativeSurgery");
            return (Criteria) this;
        }

        public Criteria andPerioperativeSurgeryLessThan(String value) {
            addCriterion("perioperative_surgery <", value, "perioperativeSurgery");
            return (Criteria) this;
        }

        public Criteria andPerioperativeSurgeryLessThanOrEqualTo(String value) {
            addCriterion("perioperative_surgery <=", value, "perioperativeSurgery");
            return (Criteria) this;
        }

        public Criteria andPerioperativeSurgeryLike(String value) {
            addCriterion("perioperative_surgery like", value, "perioperativeSurgery");
            return (Criteria) this;
        }

        public Criteria andPerioperativeSurgeryNotLike(String value) {
            addCriterion("perioperative_surgery not like", value, "perioperativeSurgery");
            return (Criteria) this;
        }

        public Criteria andPerioperativeSurgeryIn(List<String> values) {
            addCriterion("perioperative_surgery in", values, "perioperativeSurgery");
            return (Criteria) this;
        }

        public Criteria andPerioperativeSurgeryNotIn(List<String> values) {
            addCriterion("perioperative_surgery not in", values, "perioperativeSurgery");
            return (Criteria) this;
        }

        public Criteria andPerioperativeSurgeryBetween(String value1, String value2) {
            addCriterion("perioperative_surgery between", value1, value2, "perioperativeSurgery");
            return (Criteria) this;
        }

        public Criteria andPerioperativeSurgeryNotBetween(String value1, String value2) {
            addCriterion("perioperative_surgery not between", value1, value2, "perioperativeSurgery");
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

        public Criteria andWoundPhotoIdsIsNull() {
            addCriterion("wound_photo_ids is null");
            return (Criteria) this;
        }

        public Criteria andWoundPhotoIdsIsNotNull() {
            addCriterion("wound_photo_ids is not null");
            return (Criteria) this;
        }

        public Criteria andWoundPhotoIdsEqualTo(String value) {
            addCriterion("wound_photo_ids =", value, "woundPhotoIds");
            return (Criteria) this;
        }

        public Criteria andWoundPhotoIdsNotEqualTo(String value) {
            addCriterion("wound_photo_ids <>", value, "woundPhotoIds");
            return (Criteria) this;
        }

        public Criteria andWoundPhotoIdsGreaterThan(String value) {
            addCriterion("wound_photo_ids >", value, "woundPhotoIds");
            return (Criteria) this;
        }

        public Criteria andWoundPhotoIdsGreaterThanOrEqualTo(String value) {
            addCriterion("wound_photo_ids >=", value, "woundPhotoIds");
            return (Criteria) this;
        }

        public Criteria andWoundPhotoIdsLessThan(String value) {
            addCriterion("wound_photo_ids <", value, "woundPhotoIds");
            return (Criteria) this;
        }

        public Criteria andWoundPhotoIdsLessThanOrEqualTo(String value) {
            addCriterion("wound_photo_ids <=", value, "woundPhotoIds");
            return (Criteria) this;
        }

        public Criteria andWoundPhotoIdsLike(String value) {
            addCriterion("wound_photo_ids like", value, "woundPhotoIds");
            return (Criteria) this;
        }

        public Criteria andWoundPhotoIdsNotLike(String value) {
            addCriterion("wound_photo_ids not like", value, "woundPhotoIds");
            return (Criteria) this;
        }

        public Criteria andWoundPhotoIdsIn(List<String> values) {
            addCriterion("wound_photo_ids in", values, "woundPhotoIds");
            return (Criteria) this;
        }

        public Criteria andWoundPhotoIdsNotIn(List<String> values) {
            addCriterion("wound_photo_ids not in", values, "woundPhotoIds");
            return (Criteria) this;
        }

        public Criteria andWoundPhotoIdsBetween(String value1, String value2) {
            addCriterion("wound_photo_ids between", value1, value2, "woundPhotoIds");
            return (Criteria) this;
        }

        public Criteria andWoundPhotoIdsNotBetween(String value1, String value2) {
            addCriterion("wound_photo_ids not between", value1, value2, "woundPhotoIds");
            return (Criteria) this;
        }

        public Criteria andWoundPhotographyTimeIsNull() {
            addCriterion("wound_photography_time is null");
            return (Criteria) this;
        }

        public Criteria andWoundPhotographyTimeIsNotNull() {
            addCriterion("wound_photography_time is not null");
            return (Criteria) this;
        }

        public Criteria andWoundPhotographyTimeEqualTo(Date value) {
            addCriterion("wound_photography_time =", value, "woundPhotographyTime");
            return (Criteria) this;
        }

        public Criteria andWoundPhotographyTimeNotEqualTo(Date value) {
            addCriterion("wound_photography_time <>", value, "woundPhotographyTime");
            return (Criteria) this;
        }

        public Criteria andWoundPhotographyTimeGreaterThan(Date value) {
            addCriterion("wound_photography_time >", value, "woundPhotographyTime");
            return (Criteria) this;
        }

        public Criteria andWoundPhotographyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("wound_photography_time >=", value, "woundPhotographyTime");
            return (Criteria) this;
        }

        public Criteria andWoundPhotographyTimeLessThan(Date value) {
            addCriterion("wound_photography_time <", value, "woundPhotographyTime");
            return (Criteria) this;
        }

        public Criteria andWoundPhotographyTimeLessThanOrEqualTo(Date value) {
            addCriterion("wound_photography_time <=", value, "woundPhotographyTime");
            return (Criteria) this;
        }

        public Criteria andWoundPhotographyTimeIn(List<Date> values) {
            addCriterion("wound_photography_time in", values, "woundPhotographyTime");
            return (Criteria) this;
        }

        public Criteria andWoundPhotographyTimeNotIn(List<Date> values) {
            addCriterion("wound_photography_time not in", values, "woundPhotographyTime");
            return (Criteria) this;
        }

        public Criteria andWoundPhotographyTimeBetween(Date value1, Date value2) {
            addCriterion("wound_photography_time between", value1, value2, "woundPhotographyTime");
            return (Criteria) this;
        }

        public Criteria andWoundPhotographyTimeNotBetween(Date value1, Date value2) {
            addCriterion("wound_photography_time not between", value1, value2, "woundPhotographyTime");
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

        public Criteria andIsReservationIsNull() {
            addCriterion("is_reservation is null");
            return (Criteria) this;
        }

        public Criteria andIsReservationIsNotNull() {
            addCriterion("is_reservation is not null");
            return (Criteria) this;
        }

        public Criteria andIsReservationEqualTo(String value) {
            addCriterion("is_reservation =", value, "isReservation");
            return (Criteria) this;
        }

        public Criteria andIsReservationNotEqualTo(String value) {
            addCriterion("is_reservation <>", value, "isReservation");
            return (Criteria) this;
        }

        public Criteria andIsReservationGreaterThan(String value) {
            addCriterion("is_reservation >", value, "isReservation");
            return (Criteria) this;
        }

        public Criteria andIsReservationGreaterThanOrEqualTo(String value) {
            addCriterion("is_reservation >=", value, "isReservation");
            return (Criteria) this;
        }

        public Criteria andIsReservationLessThan(String value) {
            addCriterion("is_reservation <", value, "isReservation");
            return (Criteria) this;
        }

        public Criteria andIsReservationLessThanOrEqualTo(String value) {
            addCriterion("is_reservation <=", value, "isReservation");
            return (Criteria) this;
        }

        public Criteria andIsReservationLike(String value) {
            addCriterion("is_reservation like", value, "isReservation");
            return (Criteria) this;
        }

        public Criteria andIsReservationNotLike(String value) {
            addCriterion("is_reservation not like", value, "isReservation");
            return (Criteria) this;
        }

        public Criteria andIsReservationIn(List<String> values) {
            addCriterion("is_reservation in", values, "isReservation");
            return (Criteria) this;
        }

        public Criteria andIsReservationNotIn(List<String> values) {
            addCriterion("is_reservation not in", values, "isReservation");
            return (Criteria) this;
        }

        public Criteria andIsReservationBetween(String value1, String value2) {
            addCriterion("is_reservation between", value1, value2, "isReservation");
            return (Criteria) this;
        }

        public Criteria andIsReservationNotBetween(String value1, String value2) {
            addCriterion("is_reservation not between", value1, value2, "isReservation");
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

        public Criteria andAssociationIdIsNull() {
            addCriterion("association_id is null");
            return (Criteria) this;
        }

        public Criteria andAssociationIdIsNotNull() {
            addCriterion("association_id is not null");
            return (Criteria) this;
        }

        public Criteria andAssociationIdEqualTo(Long value) {
            addCriterion("association_id =", value, "associationId");
            return (Criteria) this;
        }

        public Criteria andAssociationIdNotEqualTo(Long value) {
            addCriterion("association_id <>", value, "associationId");
            return (Criteria) this;
        }

        public Criteria andAssociationIdGreaterThan(Long value) {
            addCriterion("association_id >", value, "associationId");
            return (Criteria) this;
        }

        public Criteria andAssociationIdGreaterThanOrEqualTo(Long value) {
            addCriterion("association_id >=", value, "associationId");
            return (Criteria) this;
        }

        public Criteria andAssociationIdLessThan(Long value) {
            addCriterion("association_id <", value, "associationId");
            return (Criteria) this;
        }

        public Criteria andAssociationIdLessThanOrEqualTo(Long value) {
            addCriterion("association_id <=", value, "associationId");
            return (Criteria) this;
        }

        public Criteria andAssociationIdIn(List<Long> values) {
            addCriterion("association_id in", values, "associationId");
            return (Criteria) this;
        }

        public Criteria andAssociationIdNotIn(List<Long> values) {
            addCriterion("association_id not in", values, "associationId");
            return (Criteria) this;
        }

        public Criteria andAssociationIdBetween(Long value1, Long value2) {
            addCriterion("association_id between", value1, value2, "associationId");
            return (Criteria) this;
        }

        public Criteria andAssociationIdNotBetween(Long value1, Long value2) {
            addCriterion("association_id not between", value1, value2, "associationId");
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

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private final String typeHandler;

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