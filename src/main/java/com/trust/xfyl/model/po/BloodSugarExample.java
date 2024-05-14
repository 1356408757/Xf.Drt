package com.trust.xfyl.model.po;

import com.trust.xfyl.model.BaseBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * TODO
 *
 * @author Bay-max
 * @Description
 * @date 2024/5/20 13:47
 **/

public class BloodSugarExample extends BaseBean {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BloodSugarExample() {
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

        public Criteria andBloodIdIsNull() {
            addCriterion("blood_id is null");
            return (Criteria) this;
        }

        public Criteria andBloodIdIsNotNull() {
            addCriterion("blood_id is not null");
            return (Criteria) this;
        }

        public Criteria andBloodIdEqualTo(Integer value) {
            addCriterion("blood_id =", value, "bloodId");
            return (Criteria) this;
        }

        public Criteria andBloodIdNotEqualTo(Integer value) {
            addCriterion("blood_id <>", value, "bloodId");
            return (Criteria) this;
        }

        public Criteria andBloodIdGreaterThan(Integer value) {
            addCriterion("blood_id >", value, "bloodId");
            return (Criteria) this;
        }

        public Criteria andBloodIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("blood_id >=", value, "bloodId");
            return (Criteria) this;
        }

        public Criteria andBloodIdLessThan(Integer value) {
            addCriterion("blood_id <", value, "bloodId");
            return (Criteria) this;
        }

        public Criteria andBloodIdLessThanOrEqualTo(Integer value) {
            addCriterion("blood_id <=", value, "bloodId");
            return (Criteria) this;
        }

        public Criteria andBloodIdIn(List<Integer> values) {
            addCriterion("blood_id in", values, "bloodId");
            return (Criteria) this;
        }

        public Criteria andBloodIdNotIn(List<Integer> values) {
            addCriterion("blood_id not in", values, "bloodId");
            return (Criteria) this;
        }

        public Criteria andBloodIdBetween(Integer value1, Integer value2) {
            addCriterion("blood_id between", value1, value2, "bloodId");
            return (Criteria) this;
        }

        public Criteria andBloodIdNotBetween(Integer value1, Integer value2) {
            addCriterion("blood_id not between", value1, value2, "bloodId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andSugarLevelIsNull() {
            addCriterion("sugar_level is null");
            return (Criteria) this;
        }

        public Criteria andSugarLevelIsNotNull() {
            addCriterion("sugar_level is not null");
            return (Criteria) this;
        }

        public Criteria andSugarLevelEqualTo(Double value) {
            addCriterion("sugar_level =", value, "sugarLevel");
            return (Criteria) this;
        }

        public Criteria andSugarLevelNotEqualTo(Double value) {
            addCriterion("sugar_level <>", value, "sugarLevel");
            return (Criteria) this;
        }

        public Criteria andSugarLevelGreaterThan(Double value) {
            addCriterion("sugar_level >", value, "sugarLevel");
            return (Criteria) this;
        }

        public Criteria andSugarLevelGreaterThanOrEqualTo(Double value) {
            addCriterion("sugar_level >=", value, "sugarLevel");
            return (Criteria) this;
        }

        public Criteria andSugarLevelLessThan(Double value) {
            addCriterion("sugar_level <", value, "sugarLevel");
            return (Criteria) this;
        }

        public Criteria andSugarLevelLessThanOrEqualTo(Double value) {
            addCriterion("sugar_level <=", value, "sugarLevel");
            return (Criteria) this;
        }

        public Criteria andSugarLevelIn(List<Double> values) {
            addCriterion("sugar_level in", values, "sugarLevel");
            return (Criteria) this;
        }

        public Criteria andSugarLevelNotIn(List<Double> values) {
            addCriterion("sugar_level not in", values, "sugarLevel");
            return (Criteria) this;
        }

        public Criteria andSugarLevelBetween(Double value1, Double value2) {
            addCriterion("sugar_level between", value1, value2, "sugarLevel");
            return (Criteria) this;
        }

        public Criteria andSugarLevelNotBetween(Double value1, Double value2) {
            addCriterion("sugar_level not between", value1, value2, "sugarLevel");
            return (Criteria) this;
        }

        public Criteria andSugarTimeIsNull() {
            addCriterion("sugar_time is null");
            return (Criteria) this;
        }

        public Criteria andSugarTimeIsNotNull() {
            addCriterion("sugar_time is not null");
            return (Criteria) this;
        }

        public Criteria andSugarTimeEqualTo(String value) {
            addCriterion("sugar_time =", value, "sugarTime");
            return (Criteria) this;
        }

        public Criteria andSugarTimeNotEqualTo(String value) {
            addCriterion("sugar_time <>", value, "sugarTime");
            return (Criteria) this;
        }

        public Criteria andSugarTimeGreaterThan(String value) {
            addCriterion("sugar_time >", value, "sugarTime");
            return (Criteria) this;
        }

        public Criteria andSugarTimeGreaterThanOrEqualTo(String value) {
            addCriterion("sugar_time >=", value, "sugarTime");
            return (Criteria) this;
        }

        public Criteria andSugarTimeLessThan(String value) {
            addCriterion("sugar_time <", value, "sugarTime");
            return (Criteria) this;
        }

        public Criteria andSugarTimeLessThanOrEqualTo(String value) {
            addCriterion("sugar_time <=", value, "sugarTime");
            return (Criteria) this;
        }

        public Criteria andSugarTimeLike(String value) {
            addCriterion("sugar_time like", value, "sugarTime");
            return (Criteria) this;
        }

        public Criteria andSugarTimeNotLike(String value) {
            addCriterion("sugar_time not like", value, "sugarTime");
            return (Criteria) this;
        }

        public Criteria andSugarTimeIn(List<String> values) {
            addCriterion("sugar_time in", values, "sugarTime");
            return (Criteria) this;
        }

        public Criteria andSugarTimeNotIn(List<String> values) {
            addCriterion("sugar_time not in", values, "sugarTime");
            return (Criteria) this;
        }

        public Criteria andSugarTimeBetween(String value1, String value2) {
            addCriterion("sugar_time between", value1, value2, "sugarTime");
            return (Criteria) this;
        }

        public Criteria andSugarTimeNotBetween(String value1, String value2) {
            addCriterion("sugar_time not between", value1, value2, "sugarTime");
            return (Criteria) this;
        }

        public Criteria andSugarDateIsNull() {
            addCriterion("sugar_date is null");
            return (Criteria) this;
        }

        public Criteria andSugarDateIsNotNull() {
            addCriterion("sugar_date is not null");
            return (Criteria) this;
        }

        public Criteria andSugarDateEqualTo(Date value) {
            addCriterion("sugar_date =", value, "sugarDate");
            return (Criteria) this;
        }

        public Criteria andSugarDateNotEqualTo(Date value) {
            addCriterion("sugar_date <>", value, "sugarDate");
            return (Criteria) this;
        }

        public Criteria andSugarDateGreaterThan(Date value) {
            addCriterion("sugar_date >", value, "sugarDate");
            return (Criteria) this;
        }

        public Criteria andSugarDateGreaterThanOrEqualTo(Date value) {
            addCriterion("sugar_date >=", value, "sugarDate");
            return (Criteria) this;
        }

        public Criteria andSugarDateLessThan(Date value) {
            addCriterion("sugar_date <", value, "sugarDate");
            return (Criteria) this;
        }

        public Criteria andSugarDateLessThanOrEqualTo(Date value) {
            addCriterion("sugar_date <=", value, "sugarDate");
            return (Criteria) this;
        }

        public Criteria andSugarDateIn(List<Date> values) {
            addCriterion("sugar_date in", values, "sugarDate");
            return (Criteria) this;
        }

        public Criteria andSugarDateNotIn(List<Date> values) {
            addCriterion("sugar_date not in", values, "sugarDate");
            return (Criteria) this;
        }

        public Criteria andSugarDateBetween(Date value1, Date value2) {
            addCriterion("sugar_date between", value1, value2, "sugarDate");
            return (Criteria) this;
        }

        public Criteria andSugarDateNotBetween(Date value1, Date value2) {
            addCriterion("sugar_date not between", value1, value2, "sugarDate");
            return (Criteria) this;
        }

        public Criteria andSugarDietIsNull() {
            addCriterion("sugar_diet is null");
            return (Criteria) this;
        }

        public Criteria andSugarDietIsNotNull() {
            addCriterion("sugar_diet is not null");
            return (Criteria) this;
        }

        public Criteria andSugarDietEqualTo(String value) {
            addCriterion("sugar_diet =", value, "sugarDiet");
            return (Criteria) this;
        }

        public Criteria andSugarDietNotEqualTo(String value) {
            addCriterion("sugar_diet <>", value, "sugarDiet");
            return (Criteria) this;
        }

        public Criteria andSugarDietGreaterThan(String value) {
            addCriterion("sugar_diet >", value, "sugarDiet");
            return (Criteria) this;
        }

        public Criteria andSugarDietGreaterThanOrEqualTo(String value) {
            addCriterion("sugar_diet >=", value, "sugarDiet");
            return (Criteria) this;
        }

        public Criteria andSugarDietLessThan(String value) {
            addCriterion("sugar_diet <", value, "sugarDiet");
            return (Criteria) this;
        }

        public Criteria andSugarDietLessThanOrEqualTo(String value) {
            addCriterion("sugar_diet <=", value, "sugarDiet");
            return (Criteria) this;
        }

        public Criteria andSugarDietLike(String value) {
            addCriterion("sugar_diet like", value, "sugarDiet");
            return (Criteria) this;
        }

        public Criteria andSugarDietNotLike(String value) {
            addCriterion("sugar_diet not like", value, "sugarDiet");
            return (Criteria) this;
        }

        public Criteria andSugarDietIn(List<String> values) {
            addCriterion("sugar_diet in", values, "sugarDiet");
            return (Criteria) this;
        }

        public Criteria andSugarDietNotIn(List<String> values) {
            addCriterion("sugar_diet not in", values, "sugarDiet");
            return (Criteria) this;
        }

        public Criteria andSugarDietBetween(String value1, String value2) {
            addCriterion("sugar_diet between", value1, value2, "sugarDiet");
            return (Criteria) this;
        }

        public Criteria andSugarDietNotBetween(String value1, String value2) {
            addCriterion("sugar_diet not between", value1, value2, "sugarDiet");
            return (Criteria) this;
        }

        public Criteria andSugarExerciseIsNull() {
            addCriterion("sugar_exercise is null");
            return (Criteria) this;
        }

        public Criteria andSugarExerciseIsNotNull() {
            addCriterion("sugar_exercise is not null");
            return (Criteria) this;
        }

        public Criteria andSugarExerciseEqualTo(String value) {
            addCriterion("sugar_exercise =", value, "sugarExercise");
            return (Criteria) this;
        }

        public Criteria andSugarExerciseNotEqualTo(String value) {
            addCriterion("sugar_exercise <>", value, "sugarExercise");
            return (Criteria) this;
        }

        public Criteria andSugarExerciseGreaterThan(String value) {
            addCriterion("sugar_exercise >", value, "sugarExercise");
            return (Criteria) this;
        }

        public Criteria andSugarExerciseGreaterThanOrEqualTo(String value) {
            addCriterion("sugar_exercise >=", value, "sugarExercise");
            return (Criteria) this;
        }

        public Criteria andSugarExerciseLessThan(String value) {
            addCriterion("sugar_exercise <", value, "sugarExercise");
            return (Criteria) this;
        }

        public Criteria andSugarExerciseLessThanOrEqualTo(String value) {
            addCriterion("sugar_exercise <=", value, "sugarExercise");
            return (Criteria) this;
        }

        public Criteria andSugarExerciseLike(String value) {
            addCriterion("sugar_exercise like", value, "sugarExercise");
            return (Criteria) this;
        }

        public Criteria andSugarExerciseNotLike(String value) {
            addCriterion("sugar_exercise not like", value, "sugarExercise");
            return (Criteria) this;
        }

        public Criteria andSugarExerciseIn(List<String> values) {
            addCriterion("sugar_exercise in", values, "sugarExercise");
            return (Criteria) this;
        }

        public Criteria andSugarExerciseNotIn(List<String> values) {
            addCriterion("sugar_exercise not in", values, "sugarExercise");
            return (Criteria) this;
        }

        public Criteria andSugarExerciseBetween(String value1, String value2) {
            addCriterion("sugar_exercise between", value1, value2, "sugarExercise");
            return (Criteria) this;
        }

        public Criteria andSugarExerciseNotBetween(String value1, String value2) {
            addCriterion("sugar_exercise not between", value1, value2, "sugarExercise");
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

        public Criteria andSugarRemarkIsNull() {
            addCriterion("sugar_remark is null");
            return (Criteria) this;
        }

        public Criteria andSugarRemarkIsNotNull() {
            addCriterion("sugar_remark is not null");
            return (Criteria) this;
        }

        public Criteria andSugarRemarkEqualTo(String value) {
            addCriterion("sugar_remark =", value, "sugarRemark");
            return (Criteria) this;
        }

        public Criteria andSugarRemarkNotEqualTo(String value) {
            addCriterion("sugar_remark <>", value, "sugarRemark");
            return (Criteria) this;
        }

        public Criteria andSugarRemarkGreaterThan(String value) {
            addCriterion("sugar_remark >", value, "sugarRemark");
            return (Criteria) this;
        }

        public Criteria andSugarRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("sugar_remark >=", value, "sugarRemark");
            return (Criteria) this;
        }

        public Criteria andSugarRemarkLessThan(String value) {
            addCriterion("sugar_remark <", value, "sugarRemark");
            return (Criteria) this;
        }

        public Criteria andSugarRemarkLessThanOrEqualTo(String value) {
            addCriterion("sugar_remark <=", value, "sugarRemark");
            return (Criteria) this;
        }

        public Criteria andSugarRemarkLike(String value) {
            addCriterion("sugar_remark like", value, "sugarRemark");
            return (Criteria) this;
        }

        public Criteria andSugarRemarkNotLike(String value) {
            addCriterion("sugar_remark not like", value, "sugarRemark");
            return (Criteria) this;
        }

        public Criteria andSugarRemarkIn(List<String> values) {
            addCriterion("sugar_remark in", values, "sugarRemark");
            return (Criteria) this;
        }

        public Criteria andSugarRemarkNotIn(List<String> values) {
            addCriterion("sugar_remark not in", values, "sugarRemark");
            return (Criteria) this;
        }

        public Criteria andSugarRemarkBetween(String value1, String value2) {
            addCriterion("sugar_remark between", value1, value2, "sugarRemark");
            return (Criteria) this;
        }

        public Criteria andSugarRemarkNotBetween(String value1, String value2) {
            addCriterion("sugar_remark not between", value1, value2, "sugarRemark");
            return (Criteria) this;
        }

        public Criteria andRemarkPhotoIsNull() {
            addCriterion("remark_photo is null");
            return (Criteria) this;
        }

        public Criteria andRemarkPhotoIsNotNull() {
            addCriterion("remark_photo is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkPhotoEqualTo(String value) {
            addCriterion("remark_photo =", value, "remarkPhoto");
            return (Criteria) this;
        }

        public Criteria andRemarkPhotoNotEqualTo(String value) {
            addCriterion("remark_photo <>", value, "remarkPhoto");
            return (Criteria) this;
        }

        public Criteria andRemarkPhotoGreaterThan(String value) {
            addCriterion("remark_photo >", value, "remarkPhoto");
            return (Criteria) this;
        }

        public Criteria andRemarkPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("remark_photo >=", value, "remarkPhoto");
            return (Criteria) this;
        }

        public Criteria andRemarkPhotoLessThan(String value) {
            addCriterion("remark_photo <", value, "remarkPhoto");
            return (Criteria) this;
        }

        public Criteria andRemarkPhotoLessThanOrEqualTo(String value) {
            addCriterion("remark_photo <=", value, "remarkPhoto");
            return (Criteria) this;
        }

        public Criteria andRemarkPhotoLike(String value) {
            addCriterion("remark_photo like", value, "remarkPhoto");
            return (Criteria) this;
        }

        public Criteria andRemarkPhotoNotLike(String value) {
            addCriterion("remark_photo not like", value, "remarkPhoto");
            return (Criteria) this;
        }

        public Criteria andRemarkPhotoIn(List<String> values) {
            addCriterion("remark_photo in", values, "remarkPhoto");
            return (Criteria) this;
        }

        public Criteria andRemarkPhotoNotIn(List<String> values) {
            addCriterion("remark_photo not in", values, "remarkPhoto");
            return (Criteria) this;
        }

        public Criteria andRemarkPhotoBetween(String value1, String value2) {
            addCriterion("remark_photo between", value1, value2, "remarkPhoto");
            return (Criteria) this;
        }

        public Criteria andRemarkPhotoNotBetween(String value1, String value2) {
            addCriterion("remark_photo not between", value1, value2, "remarkPhoto");
            return (Criteria) this;
        }

        public Criteria andSugarTimeIdIsNull() {
            addCriterion("sugar_time_id is null");
            return (Criteria) this;
        }

        public Criteria andSugarTimeIdIsNotNull() {
            addCriterion("sugar_time_id is not null");
            return (Criteria) this;
        }

        public Criteria andSugarTimeIdEqualTo(Integer value) {
            addCriterion("sugar_time_id =", value, "sugarTimeId");
            return (Criteria) this;
        }

        public Criteria andSugarTimeIdNotEqualTo(Integer value) {
            addCriterion("sugar_time_id <>", value, "sugarTimeId");
            return (Criteria) this;
        }

        public Criteria andSugarTimeIdGreaterThan(Integer value) {
            addCriterion("sugar_time_id >", value, "sugarTimeId");
            return (Criteria) this;
        }

        public Criteria andSugarTimeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sugar_time_id >=", value, "sugarTimeId");
            return (Criteria) this;
        }

        public Criteria andSugarTimeIdLessThan(Integer value) {
            addCriterion("sugar_time_id <", value, "sugarTimeId");
            return (Criteria) this;
        }

        public Criteria andSugarTimeIdLessThanOrEqualTo(Integer value) {
            addCriterion("sugar_time_id <=", value, "sugarTimeId");
            return (Criteria) this;
        }

        public Criteria andSugarTimeIdIn(List<Integer> values) {
            addCriterion("sugar_time_id in", values, "sugarTimeId");
            return (Criteria) this;
        }

        public Criteria andSugarTimeIdNotIn(List<Integer> values) {
            addCriterion("sugar_time_id not in", values, "sugarTimeId");
            return (Criteria) this;
        }

        public Criteria andSugarTimeIdBetween(Integer value1, Integer value2) {
            addCriterion("sugar_time_id between", value1, value2, "sugarTimeId");
            return (Criteria) this;
        }

        public Criteria andSugarTimeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sugar_time_id not between", value1, value2, "sugarTimeId");
            return (Criteria) this;
        }

        public Criteria andSugarDietIdIsNull() {
            addCriterion("sugar_diet_id is null");
            return (Criteria) this;
        }

        public Criteria andSugarDietIdIsNotNull() {
            addCriterion("sugar_diet_id is not null");
            return (Criteria) this;
        }

        public Criteria andSugarDietIdEqualTo(Integer value) {
            addCriterion("sugar_diet_id =", value, "sugarDietId");
            return (Criteria) this;
        }

        public Criteria andSugarDietIdNotEqualTo(Integer value) {
            addCriterion("sugar_diet_id <>", value, "sugarDietId");
            return (Criteria) this;
        }

        public Criteria andSugarDietIdGreaterThan(Integer value) {
            addCriterion("sugar_diet_id >", value, "sugarDietId");
            return (Criteria) this;
        }

        public Criteria andSugarDietIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sugar_diet_id >=", value, "sugarDietId");
            return (Criteria) this;
        }

        public Criteria andSugarDietIdLessThan(Integer value) {
            addCriterion("sugar_diet_id <", value, "sugarDietId");
            return (Criteria) this;
        }

        public Criteria andSugarDietIdLessThanOrEqualTo(Integer value) {
            addCriterion("sugar_diet_id <=", value, "sugarDietId");
            return (Criteria) this;
        }

        public Criteria andSugarDietIdIn(List<Integer> values) {
            addCriterion("sugar_diet_id in", values, "sugarDietId");
            return (Criteria) this;
        }

        public Criteria andSugarDietIdNotIn(List<Integer> values) {
            addCriterion("sugar_diet_id not in", values, "sugarDietId");
            return (Criteria) this;
        }

        public Criteria andSugarDietIdBetween(Integer value1, Integer value2) {
            addCriterion("sugar_diet_id between", value1, value2, "sugarDietId");
            return (Criteria) this;
        }

        public Criteria andSugarDietIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sugar_diet_id not between", value1, value2, "sugarDietId");
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