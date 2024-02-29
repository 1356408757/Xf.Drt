package com.trust.xfyl.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TrackingPersonnelExample extends BaseBean {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TrackingPersonnelExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("`name` is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("`name` is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("`name` =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("`name` <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("`name` >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("`name` >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("`name` <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("`name` <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("`name` like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("`name` not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("`name` in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("`name` not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("`name` between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("`name` not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andBarcodePhotoIsNull() {
            addCriterion("barcode_photo is null");
            return (Criteria) this;
        }

        public Criteria andBarcodePhotoIsNotNull() {
            addCriterion("barcode_photo is not null");
            return (Criteria) this;
        }

        public Criteria andBarcodePhotoEqualTo(String value) {
            addCriterion("barcode_photo =", value, "barcodePhoto");
            return (Criteria) this;
        }

        public Criteria andBarcodePhotoNotEqualTo(String value) {
            addCriterion("barcode_photo <>", value, "barcodePhoto");
            return (Criteria) this;
        }

        public Criteria andBarcodePhotoGreaterThan(String value) {
            addCriterion("barcode_photo >", value, "barcodePhoto");
            return (Criteria) this;
        }

        public Criteria andBarcodePhotoGreaterThanOrEqualTo(String value) {
            addCriterion("barcode_photo >=", value, "barcodePhoto");
            return (Criteria) this;
        }

        public Criteria andBarcodePhotoLessThan(String value) {
            addCriterion("barcode_photo <", value, "barcodePhoto");
            return (Criteria) this;
        }

        public Criteria andBarcodePhotoLessThanOrEqualTo(String value) {
            addCriterion("barcode_photo <=", value, "barcodePhoto");
            return (Criteria) this;
        }

        public Criteria andBarcodePhotoLike(String value) {
            addCriterion("barcode_photo like", value, "barcodePhoto");
            return (Criteria) this;
        }

        public Criteria andBarcodePhotoNotLike(String value) {
            addCriterion("barcode_photo not like", value, "barcodePhoto");
            return (Criteria) this;
        }

        public Criteria andBarcodePhotoIn(List<String> values) {
            addCriterion("barcode_photo in", values, "barcodePhoto");
            return (Criteria) this;
        }

        public Criteria andBarcodePhotoNotIn(List<String> values) {
            addCriterion("barcode_photo not in", values, "barcodePhoto");
            return (Criteria) this;
        }

        public Criteria andBarcodePhotoBetween(String value1, String value2) {
            addCriterion("barcode_photo between", value1, value2, "barcodePhoto");
            return (Criteria) this;
        }

        public Criteria andBarcodePhotoNotBetween(String value1, String value2) {
            addCriterion("barcode_photo not between", value1, value2, "barcodePhoto");
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

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andOperationNameIsNull() {
            addCriterion("operation_name is null");
            return (Criteria) this;
        }

        public Criteria andOperationNameIsNotNull() {
            addCriterion("operation_name is not null");
            return (Criteria) this;
        }

        public Criteria andOperationNameEqualTo(String value) {
            addCriterion("operation_name =", value, "operationName");
            return (Criteria) this;
        }

        public Criteria andOperationNameNotEqualTo(String value) {
            addCriterion("operation_name <>", value, "operationName");
            return (Criteria) this;
        }

        public Criteria andOperationNameGreaterThan(String value) {
            addCriterion("operation_name >", value, "operationName");
            return (Criteria) this;
        }

        public Criteria andOperationNameGreaterThanOrEqualTo(String value) {
            addCriterion("operation_name >=", value, "operationName");
            return (Criteria) this;
        }

        public Criteria andOperationNameLessThan(String value) {
            addCriterion("operation_name <", value, "operationName");
            return (Criteria) this;
        }

        public Criteria andOperationNameLessThanOrEqualTo(String value) {
            addCriterion("operation_name <=", value, "operationName");
            return (Criteria) this;
        }

        public Criteria andOperationNameLike(String value) {
            addCriterion("operation_name like", value, "operationName");
            return (Criteria) this;
        }

        public Criteria andOperationNameNotLike(String value) {
            addCriterion("operation_name not like", value, "operationName");
            return (Criteria) this;
        }

        public Criteria andOperationNameIn(List<String> values) {
            addCriterion("operation_name in", values, "operationName");
            return (Criteria) this;
        }

        public Criteria andOperationNameNotIn(List<String> values) {
            addCriterion("operation_name not in", values, "operationName");
            return (Criteria) this;
        }

        public Criteria andOperationNameBetween(String value1, String value2) {
            addCriterion("operation_name between", value1, value2, "operationName");
            return (Criteria) this;
        }

        public Criteria andOperationNameNotBetween(String value1, String value2) {
            addCriterion("operation_name not between", value1, value2, "operationName");
            return (Criteria) this;
        }

        public Criteria andOperationDateIsNull() {
            addCriterion("operation_date is null");
            return (Criteria) this;
        }

        public Criteria andOperationDateIsNotNull() {
            addCriterion("operation_date is not null");
            return (Criteria) this;
        }

        public Criteria andOperationDateEqualTo(Date value) {
            addCriterion("operation_date =", value, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationDateNotEqualTo(Date value) {
            addCriterion("operation_date <>", value, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationDateGreaterThan(Date value) {
            addCriterion("operation_date >", value, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationDateGreaterThanOrEqualTo(Date value) {
            addCriterion("operation_date >=", value, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationDateLessThan(Date value) {
            addCriterion("operation_date <", value, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationDateLessThanOrEqualTo(Date value) {
            addCriterion("operation_date <=", value, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationDateIn(List<Date> values) {
            addCriterion("operation_date in", values, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationDateNotIn(List<Date> values) {
            addCriterion("operation_date not in", values, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationDateBetween(Date value1, Date value2) {
            addCriterion("operation_date between", value1, value2, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationDateNotBetween(Date value1, Date value2) {
            addCriterion("operation_date not between", value1, value2, "operationDate");
            return (Criteria) this;
        }

        public Criteria andSurgeonNameIsNull() {
            addCriterion("surgeon_name is null");
            return (Criteria) this;
        }

        public Criteria andSurgeonNameIsNotNull() {
            addCriterion("surgeon_name is not null");
            return (Criteria) this;
        }

        public Criteria andSurgeonNameEqualTo(String value) {
            addCriterion("surgeon_name =", value, "surgeonName");
            return (Criteria) this;
        }

        public Criteria andSurgeonNameNotEqualTo(String value) {
            addCriterion("surgeon_name <>", value, "surgeonName");
            return (Criteria) this;
        }

        public Criteria andSurgeonNameGreaterThan(String value) {
            addCriterion("surgeon_name >", value, "surgeonName");
            return (Criteria) this;
        }

        public Criteria andSurgeonNameGreaterThanOrEqualTo(String value) {
            addCriterion("surgeon_name >=", value, "surgeonName");
            return (Criteria) this;
        }

        public Criteria andSurgeonNameLessThan(String value) {
            addCriterion("surgeon_name <", value, "surgeonName");
            return (Criteria) this;
        }

        public Criteria andSurgeonNameLessThanOrEqualTo(String value) {
            addCriterion("surgeon_name <=", value, "surgeonName");
            return (Criteria) this;
        }

        public Criteria andSurgeonNameLike(String value) {
            addCriterion("surgeon_name like", value, "surgeonName");
            return (Criteria) this;
        }

        public Criteria andSurgeonNameNotLike(String value) {
            addCriterion("surgeon_name not like", value, "surgeonName");
            return (Criteria) this;
        }

        public Criteria andSurgeonNameIn(List<String> values) {
            addCriterion("surgeon_name in", values, "surgeonName");
            return (Criteria) this;
        }

        public Criteria andSurgeonNameNotIn(List<String> values) {
            addCriterion("surgeon_name not in", values, "surgeonName");
            return (Criteria) this;
        }

        public Criteria andSurgeonNameBetween(String value1, String value2) {
            addCriterion("surgeon_name between", value1, value2, "surgeonName");
            return (Criteria) this;
        }

        public Criteria andSurgeonNameNotBetween(String value1, String value2) {
            addCriterion("surgeon_name not between", value1, value2, "surgeonName");
            return (Criteria) this;
        }

        public Criteria andAttendingDoctorNameIsNull() {
            addCriterion("attending_doctor_name is null");
            return (Criteria) this;
        }

        public Criteria andAttendingDoctorNameIsNotNull() {
            addCriterion("attending_doctor_name is not null");
            return (Criteria) this;
        }

        public Criteria andAttendingDoctorNameEqualTo(String value) {
            addCriterion("attending_doctor_name =", value, "attendingDoctorName");
            return (Criteria) this;
        }

        public Criteria andAttendingDoctorNameNotEqualTo(String value) {
            addCriterion("attending_doctor_name <>", value, "attendingDoctorName");
            return (Criteria) this;
        }

        public Criteria andAttendingDoctorNameGreaterThan(String value) {
            addCriterion("attending_doctor_name >", value, "attendingDoctorName");
            return (Criteria) this;
        }

        public Criteria andAttendingDoctorNameGreaterThanOrEqualTo(String value) {
            addCriterion("attending_doctor_name >=", value, "attendingDoctorName");
            return (Criteria) this;
        }

        public Criteria andAttendingDoctorNameLessThan(String value) {
            addCriterion("attending_doctor_name <", value, "attendingDoctorName");
            return (Criteria) this;
        }

        public Criteria andAttendingDoctorNameLessThanOrEqualTo(String value) {
            addCriterion("attending_doctor_name <=", value, "attendingDoctorName");
            return (Criteria) this;
        }

        public Criteria andAttendingDoctorNameLike(String value) {
            addCriterion("attending_doctor_name like", value, "attendingDoctorName");
            return (Criteria) this;
        }

        public Criteria andAttendingDoctorNameNotLike(String value) {
            addCriterion("attending_doctor_name not like", value, "attendingDoctorName");
            return (Criteria) this;
        }

        public Criteria andAttendingDoctorNameIn(List<String> values) {
            addCriterion("attending_doctor_name in", values, "attendingDoctorName");
            return (Criteria) this;
        }

        public Criteria andAttendingDoctorNameNotIn(List<String> values) {
            addCriterion("attending_doctor_name not in", values, "attendingDoctorName");
            return (Criteria) this;
        }

        public Criteria andAttendingDoctorNameBetween(String value1, String value2) {
            addCriterion("attending_doctor_name between", value1, value2, "attendingDoctorName");
            return (Criteria) this;
        }

        public Criteria andAttendingDoctorNameNotBetween(String value1, String value2) {
            addCriterion("attending_doctor_name not between", value1, value2, "attendingDoctorName");
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

        public Criteria andCreatNameIsNull() {
            addCriterion("creat_name is null");
            return (Criteria) this;
        }

        public Criteria andCreatNameIsNotNull() {
            addCriterion("creat_name is not null");
            return (Criteria) this;
        }

        public Criteria andCreatNameEqualTo(String value) {
            addCriterion("creat_name =", value, "creatName");
            return (Criteria) this;
        }

        public Criteria andCreatNameNotEqualTo(String value) {
            addCriterion("creat_name <>", value, "creatName");
            return (Criteria) this;
        }

        public Criteria andCreatNameGreaterThan(String value) {
            addCriterion("creat_name >", value, "creatName");
            return (Criteria) this;
        }

        public Criteria andCreatNameGreaterThanOrEqualTo(String value) {
            addCriterion("creat_name >=", value, "creatName");
            return (Criteria) this;
        }

        public Criteria andCreatNameLessThan(String value) {
            addCriterion("creat_name <", value, "creatName");
            return (Criteria) this;
        }

        public Criteria andCreatNameLessThanOrEqualTo(String value) {
            addCriterion("creat_name <=", value, "creatName");
            return (Criteria) this;
        }

        public Criteria andCreatNameLike(String value) {
            addCriterion("creat_name like", value, "creatName");
            return (Criteria) this;
        }

        public Criteria andCreatNameNotLike(String value) {
            addCriterion("creat_name not like", value, "creatName");
            return (Criteria) this;
        }

        public Criteria andCreatNameIn(List<String> values) {
            addCriterion("creat_name in", values, "creatName");
            return (Criteria) this;
        }

        public Criteria andCreatNameNotIn(List<String> values) {
            addCriterion("creat_name not in", values, "creatName");
            return (Criteria) this;
        }

        public Criteria andCreatNameBetween(String value1, String value2) {
            addCriterion("creat_name between", value1, value2, "creatName");
            return (Criteria) this;
        }

        public Criteria andCreatNameNotBetween(String value1, String value2) {
            addCriterion("creat_name not between", value1, value2, "creatName");
            return (Criteria) this;
        }

        public Criteria andSurgeonIdIsNull() {
            addCriterion("surgeon_id is null");
            return (Criteria) this;
        }

        public Criteria andSurgeonIdIsNotNull() {
            addCriterion("surgeon_id is not null");
            return (Criteria) this;
        }

        public Criteria andSurgeonIdEqualTo(Long value) {
            addCriterion("surgeon_id =", value, "surgeonId");
            return (Criteria) this;
        }

        public Criteria andSurgeonIdNotEqualTo(Long value) {
            addCriterion("surgeon_id <>", value, "surgeonId");
            return (Criteria) this;
        }

        public Criteria andSurgeonIdGreaterThan(Long value) {
            addCriterion("surgeon_id >", value, "surgeonId");
            return (Criteria) this;
        }

        public Criteria andSurgeonIdGreaterThanOrEqualTo(Long value) {
            addCriterion("surgeon_id >=", value, "surgeonId");
            return (Criteria) this;
        }

        public Criteria andSurgeonIdLessThan(Long value) {
            addCriterion("surgeon_id <", value, "surgeonId");
            return (Criteria) this;
        }

        public Criteria andSurgeonIdLessThanOrEqualTo(Long value) {
            addCriterion("surgeon_id <=", value, "surgeonId");
            return (Criteria) this;
        }

        public Criteria andSurgeonIdIn(List<Long> values) {
            addCriterion("surgeon_id in", values, "surgeonId");
            return (Criteria) this;
        }

        public Criteria andSurgeonIdNotIn(List<Long> values) {
            addCriterion("surgeon_id not in", values, "surgeonId");
            return (Criteria) this;
        }

        public Criteria andSurgeonIdBetween(Long value1, Long value2) {
            addCriterion("surgeon_id between", value1, value2, "surgeonId");
            return (Criteria) this;
        }

        public Criteria andSurgeonIdNotBetween(Long value1, Long value2) {
            addCriterion("surgeon_id not between", value1, value2, "surgeonId");
            return (Criteria) this;
        }

        public Criteria andAttendingDoctorIsNull() {
            addCriterion("attending_doctor is null");
            return (Criteria) this;
        }

        public Criteria andAttendingDoctorIsNotNull() {
            addCriterion("attending_doctor is not null");
            return (Criteria) this;
        }

        public Criteria andAttendingDoctorEqualTo(Long value) {
            addCriterion("attending_doctor =", value, "attendingDoctor");
            return (Criteria) this;
        }

        public Criteria andAttendingDoctorNotEqualTo(Long value) {
            addCriterion("attending_doctor <>", value, "attendingDoctor");
            return (Criteria) this;
        }

        public Criteria andAttendingDoctorGreaterThan(Long value) {
            addCriterion("attending_doctor >", value, "attendingDoctor");
            return (Criteria) this;
        }

        public Criteria andAttendingDoctorGreaterThanOrEqualTo(Long value) {
            addCriterion("attending_doctor >=", value, "attendingDoctor");
            return (Criteria) this;
        }

        public Criteria andAttendingDoctorLessThan(Long value) {
            addCriterion("attending_doctor <", value, "attendingDoctor");
            return (Criteria) this;
        }

        public Criteria andAttendingDoctorLessThanOrEqualTo(Long value) {
            addCriterion("attending_doctor <=", value, "attendingDoctor");
            return (Criteria) this;
        }

        public Criteria andAttendingDoctorIn(List<Long> values) {
            addCriterion("attending_doctor in", values, "attendingDoctor");
            return (Criteria) this;
        }

        public Criteria andAttendingDoctorNotIn(List<Long> values) {
            addCriterion("attending_doctor not in", values, "attendingDoctor");
            return (Criteria) this;
        }

        public Criteria andAttendingDoctorBetween(Long value1, Long value2) {
            addCriterion("attending_doctor between", value1, value2, "attendingDoctor");
            return (Criteria) this;
        }

        public Criteria andAttendingDoctorNotBetween(Long value1, Long value2) {
            addCriterion("attending_doctor not between", value1, value2, "attendingDoctor");
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