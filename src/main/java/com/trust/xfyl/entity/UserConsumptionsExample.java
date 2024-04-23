package com.trust.xfyl.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * @author Bay-max
 * @date 2024/4/22 14:01
 **/
public class UserConsumptionsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserConsumptionsExample() {
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

        public Criteria andConsumptionIdIsNull() {
            addCriterion("consumption_id is null");
            return (Criteria) this;
        }

        public Criteria andConsumptionIdIsNotNull() {
            addCriterion("consumption_id is not null");
            return (Criteria) this;
        }

        public Criteria andConsumptionIdEqualTo(Integer value) {
            addCriterion("consumption_id =", value, "consumptionId");
            return (Criteria) this;
        }

        public Criteria andConsumptionIdNotEqualTo(Integer value) {
            addCriterion("consumption_id <>", value, "consumptionId");
            return (Criteria) this;
        }

        public Criteria andConsumptionIdGreaterThan(Integer value) {
            addCriterion("consumption_id >", value, "consumptionId");
            return (Criteria) this;
        }

        public Criteria andConsumptionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("consumption_id >=", value, "consumptionId");
            return (Criteria) this;
        }

        public Criteria andConsumptionIdLessThan(Integer value) {
            addCriterion("consumption_id <", value, "consumptionId");
            return (Criteria) this;
        }

        public Criteria andConsumptionIdLessThanOrEqualTo(Integer value) {
            addCriterion("consumption_id <=", value, "consumptionId");
            return (Criteria) this;
        }

        public Criteria andConsumptionIdIn(List<Integer> values) {
            addCriterion("consumption_id in", values, "consumptionId");
            return (Criteria) this;
        }

        public Criteria andConsumptionIdNotIn(List<Integer> values) {
            addCriterion("consumption_id not in", values, "consumptionId");
            return (Criteria) this;
        }

        public Criteria andConsumptionIdBetween(Integer value1, Integer value2) {
            addCriterion("consumption_id between", value1, value2, "consumptionId");
            return (Criteria) this;
        }

        public Criteria andConsumptionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("consumption_id not between", value1, value2, "consumptionId");
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

        public Criteria andConsumptionTimeIsNull() {
            addCriterion("consumption_time is null");
            return (Criteria) this;
        }

        public Criteria andConsumptionTimeIsNotNull() {
            addCriterion("consumption_time is not null");
            return (Criteria) this;
        }

        public Criteria andConsumptionTimeEqualTo(Date value) {
            addCriterion("consumption_time =", value, "consumptionTime");
            return (Criteria) this;
        }

        public Criteria andConsumptionTimeNotEqualTo(Date value) {
            addCriterion("consumption_time <>", value, "consumptionTime");
            return (Criteria) this;
        }

        public Criteria andConsumptionTimeGreaterThan(Date value) {
            addCriterion("consumption_time >", value, "consumptionTime");
            return (Criteria) this;
        }

        public Criteria andConsumptionTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("consumption_time >=", value, "consumptionTime");
            return (Criteria) this;
        }

        public Criteria andConsumptionTimeLessThan(Date value) {
            addCriterion("consumption_time <", value, "consumptionTime");
            return (Criteria) this;
        }

        public Criteria andConsumptionTimeLessThanOrEqualTo(Date value) {
            addCriterion("consumption_time <=", value, "consumptionTime");
            return (Criteria) this;
        }

        public Criteria andConsumptionTimeIn(List<Date> values) {
            addCriterion("consumption_time in", values, "consumptionTime");
            return (Criteria) this;
        }

        public Criteria andConsumptionTimeNotIn(List<Date> values) {
            addCriterion("consumption_time not in", values, "consumptionTime");
            return (Criteria) this;
        }

        public Criteria andConsumptionTimeBetween(Date value1, Date value2) {
            addCriterion("consumption_time between", value1, value2, "consumptionTime");
            return (Criteria) this;
        }

        public Criteria andConsumptionTimeNotBetween(Date value1, Date value2) {
            addCriterion("consumption_time not between", value1, value2, "consumptionTime");
            return (Criteria) this;
        }

        public Criteria andMessageSentCountIsNull() {
            addCriterion("message_sent_count is null");
            return (Criteria) this;
        }

        public Criteria andMessageSentCountIsNotNull() {
            addCriterion("message_sent_count is not null");
            return (Criteria) this;
        }

        public Criteria andMessageSentCountEqualTo(Integer value) {
            addCriterion("message_sent_count =", value, "messageSentCount");
            return (Criteria) this;
        }

        public Criteria andMessageSentCountNotEqualTo(Integer value) {
            addCriterion("message_sent_count <>", value, "messageSentCount");
            return (Criteria) this;
        }

        public Criteria andMessageSentCountGreaterThan(Integer value) {
            addCriterion("message_sent_count >", value, "messageSentCount");
            return (Criteria) this;
        }

        public Criteria andMessageSentCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("message_sent_count >=", value, "messageSentCount");
            return (Criteria) this;
        }

        public Criteria andMessageSentCountLessThan(Integer value) {
            addCriterion("message_sent_count <", value, "messageSentCount");
            return (Criteria) this;
        }

        public Criteria andMessageSentCountLessThanOrEqualTo(Integer value) {
            addCriterion("message_sent_count <=", value, "messageSentCount");
            return (Criteria) this;
        }

        public Criteria andMessageSentCountIn(List<Integer> values) {
            addCriterion("message_sent_count in", values, "messageSentCount");
            return (Criteria) this;
        }

        public Criteria andMessageSentCountNotIn(List<Integer> values) {
            addCriterion("message_sent_count not in", values, "messageSentCount");
            return (Criteria) this;
        }

        public Criteria andMessageSentCountBetween(Integer value1, Integer value2) {
            addCriterion("message_sent_count between", value1, value2, "messageSentCount");
            return (Criteria) this;
        }

        public Criteria andMessageSentCountNotBetween(Integer value1, Integer value2) {
            addCriterion("message_sent_count not between", value1, value2, "messageSentCount");
            return (Criteria) this;
        }

        public Criteria andPurchaseIdIsNull() {
            addCriterion("purchase_id is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseIdIsNotNull() {
            addCriterion("purchase_id is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseIdEqualTo(Integer value) {
            addCriterion("purchase_id =", value, "purchaseId");
            return (Criteria) this;
        }

        public Criteria andPurchaseIdNotEqualTo(Integer value) {
            addCriterion("purchase_id <>", value, "purchaseId");
            return (Criteria) this;
        }

        public Criteria andPurchaseIdGreaterThan(Integer value) {
            addCriterion("purchase_id >", value, "purchaseId");
            return (Criteria) this;
        }

        public Criteria andPurchaseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("purchase_id >=", value, "purchaseId");
            return (Criteria) this;
        }

        public Criteria andPurchaseIdLessThan(Integer value) {
            addCriterion("purchase_id <", value, "purchaseId");
            return (Criteria) this;
        }

        public Criteria andPurchaseIdLessThanOrEqualTo(Integer value) {
            addCriterion("purchase_id <=", value, "purchaseId");
            return (Criteria) this;
        }

        public Criteria andPurchaseIdIn(List<Integer> values) {
            addCriterion("purchase_id in", values, "purchaseId");
            return (Criteria) this;
        }

        public Criteria andPurchaseIdNotIn(List<Integer> values) {
            addCriterion("purchase_id not in", values, "purchaseId");
            return (Criteria) this;
        }

        public Criteria andPurchaseIdBetween(Integer value1, Integer value2) {
            addCriterion("purchase_id between", value1, value2, "purchaseId");
            return (Criteria) this;
        }

        public Criteria andPurchaseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("purchase_id not between", value1, value2, "purchaseId");
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