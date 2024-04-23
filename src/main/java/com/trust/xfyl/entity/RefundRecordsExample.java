package com.trust.xfyl.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * @author Bay-max
 * @date 2024/4/22 14:01
 **/
public class RefundRecordsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RefundRecordsExample() {
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

        public Criteria andRefundIdIsNull() {
            addCriterion("refund_id is null");
            return (Criteria) this;
        }

        public Criteria andRefundIdIsNotNull() {
            addCriterion("refund_id is not null");
            return (Criteria) this;
        }

        public Criteria andRefundIdEqualTo(Integer value) {
            addCriterion("refund_id =", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdNotEqualTo(Integer value) {
            addCriterion("refund_id <>", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdGreaterThan(Integer value) {
            addCriterion("refund_id >", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("refund_id >=", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdLessThan(Integer value) {
            addCriterion("refund_id <", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdLessThanOrEqualTo(Integer value) {
            addCriterion("refund_id <=", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdIn(List<Integer> values) {
            addCriterion("refund_id in", values, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdNotIn(List<Integer> values) {
            addCriterion("refund_id not in", values, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdBetween(Integer value1, Integer value2) {
            addCriterion("refund_id between", value1, value2, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdNotBetween(Integer value1, Integer value2) {
            addCriterion("refund_id not between", value1, value2, "refundId");
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

        public Criteria andRefundStatusIsNull() {
            addCriterion("refund_status is null");
            return (Criteria) this;
        }

        public Criteria andRefundStatusIsNotNull() {
            addCriterion("refund_status is not null");
            return (Criteria) this;
        }

        public Criteria andRefundStatusEqualTo(String value) {
            addCriterion("refund_status =", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusNotEqualTo(String value) {
            addCriterion("refund_status <>", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusGreaterThan(String value) {
            addCriterion("refund_status >", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusGreaterThanOrEqualTo(String value) {
            addCriterion("refund_status >=", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusLessThan(String value) {
            addCriterion("refund_status <", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusLessThanOrEqualTo(String value) {
            addCriterion("refund_status <=", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusLike(String value) {
            addCriterion("refund_status like", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusNotLike(String value) {
            addCriterion("refund_status not like", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusIn(List<String> values) {
            addCriterion("refund_status in", values, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusNotIn(List<String> values) {
            addCriterion("refund_status not in", values, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusBetween(String value1, String value2) {
            addCriterion("refund_status between", value1, value2, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusNotBetween(String value1, String value2) {
            addCriterion("refund_status not between", value1, value2, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundRequestTimeIsNull() {
            addCriterion("refund_request_time is null");
            return (Criteria) this;
        }

        public Criteria andRefundRequestTimeIsNotNull() {
            addCriterion("refund_request_time is not null");
            return (Criteria) this;
        }

        public Criteria andRefundRequestTimeEqualTo(Date value) {
            addCriterion("refund_request_time =", value, "refundRequestTime");
            return (Criteria) this;
        }

        public Criteria andRefundRequestTimeNotEqualTo(Date value) {
            addCriterion("refund_request_time <>", value, "refundRequestTime");
            return (Criteria) this;
        }

        public Criteria andRefundRequestTimeGreaterThan(Date value) {
            addCriterion("refund_request_time >", value, "refundRequestTime");
            return (Criteria) this;
        }

        public Criteria andRefundRequestTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("refund_request_time >=", value, "refundRequestTime");
            return (Criteria) this;
        }

        public Criteria andRefundRequestTimeLessThan(Date value) {
            addCriterion("refund_request_time <", value, "refundRequestTime");
            return (Criteria) this;
        }

        public Criteria andRefundRequestTimeLessThanOrEqualTo(Date value) {
            addCriterion("refund_request_time <=", value, "refundRequestTime");
            return (Criteria) this;
        }

        public Criteria andRefundRequestTimeIn(List<Date> values) {
            addCriterion("refund_request_time in", values, "refundRequestTime");
            return (Criteria) this;
        }

        public Criteria andRefundRequestTimeNotIn(List<Date> values) {
            addCriterion("refund_request_time not in", values, "refundRequestTime");
            return (Criteria) this;
        }

        public Criteria andRefundRequestTimeBetween(Date value1, Date value2) {
            addCriterion("refund_request_time between", value1, value2, "refundRequestTime");
            return (Criteria) this;
        }

        public Criteria andRefundRequestTimeNotBetween(Date value1, Date value2) {
            addCriterion("refund_request_time not between", value1, value2, "refundRequestTime");
            return (Criteria) this;
        }

        public Criteria andRefundApprovalTimeIsNull() {
            addCriterion("refund_approval_time is null");
            return (Criteria) this;
        }

        public Criteria andRefundApprovalTimeIsNotNull() {
            addCriterion("refund_approval_time is not null");
            return (Criteria) this;
        }

        public Criteria andRefundApprovalTimeEqualTo(Date value) {
            addCriterion("refund_approval_time =", value, "refundApprovalTime");
            return (Criteria) this;
        }

        public Criteria andRefundApprovalTimeNotEqualTo(Date value) {
            addCriterion("refund_approval_time <>", value, "refundApprovalTime");
            return (Criteria) this;
        }

        public Criteria andRefundApprovalTimeGreaterThan(Date value) {
            addCriterion("refund_approval_time >", value, "refundApprovalTime");
            return (Criteria) this;
        }

        public Criteria andRefundApprovalTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("refund_approval_time >=", value, "refundApprovalTime");
            return (Criteria) this;
        }

        public Criteria andRefundApprovalTimeLessThan(Date value) {
            addCriterion("refund_approval_time <", value, "refundApprovalTime");
            return (Criteria) this;
        }

        public Criteria andRefundApprovalTimeLessThanOrEqualTo(Date value) {
            addCriterion("refund_approval_time <=", value, "refundApprovalTime");
            return (Criteria) this;
        }

        public Criteria andRefundApprovalTimeIn(List<Date> values) {
            addCriterion("refund_approval_time in", values, "refundApprovalTime");
            return (Criteria) this;
        }

        public Criteria andRefundApprovalTimeNotIn(List<Date> values) {
            addCriterion("refund_approval_time not in", values, "refundApprovalTime");
            return (Criteria) this;
        }

        public Criteria andRefundApprovalTimeBetween(Date value1, Date value2) {
            addCriterion("refund_approval_time between", value1, value2, "refundApprovalTime");
            return (Criteria) this;
        }

        public Criteria andRefundApprovalTimeNotBetween(Date value1, Date value2) {
            addCriterion("refund_approval_time not between", value1, value2, "refundApprovalTime");
            return (Criteria) this;
        }

        public Criteria andRefundedAmountIsNull() {
            addCriterion("refunded_amount is null");
            return (Criteria) this;
        }

        public Criteria andRefundedAmountIsNotNull() {
            addCriterion("refunded_amount is not null");
            return (Criteria) this;
        }

        public Criteria andRefundedAmountEqualTo(BigDecimal value) {
            addCriterion("refunded_amount =", value, "refundedAmount");
            return (Criteria) this;
        }

        public Criteria andRefundedAmountNotEqualTo(BigDecimal value) {
            addCriterion("refunded_amount <>", value, "refundedAmount");
            return (Criteria) this;
        }

        public Criteria andRefundedAmountGreaterThan(BigDecimal value) {
            addCriterion("refunded_amount >", value, "refundedAmount");
            return (Criteria) this;
        }

        public Criteria andRefundedAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("refunded_amount >=", value, "refundedAmount");
            return (Criteria) this;
        }

        public Criteria andRefundedAmountLessThan(BigDecimal value) {
            addCriterion("refunded_amount <", value, "refundedAmount");
            return (Criteria) this;
        }

        public Criteria andRefundedAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("refunded_amount <=", value, "refundedAmount");
            return (Criteria) this;
        }

        public Criteria andRefundedAmountIn(List<BigDecimal> values) {
            addCriterion("refunded_amount in", values, "refundedAmount");
            return (Criteria) this;
        }

        public Criteria andRefundedAmountNotIn(List<BigDecimal> values) {
            addCriterion("refunded_amount not in", values, "refundedAmount");
            return (Criteria) this;
        }

        public Criteria andRefundedAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refunded_amount between", value1, value2, "refundedAmount");
            return (Criteria) this;
        }

        public Criteria andRefundedAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refunded_amount not between", value1, value2, "refundedAmount");
            return (Criteria) this;
        }

        public Criteria andAdminContactedIsNull() {
            addCriterion("admin_contacted is null");
            return (Criteria) this;
        }

        public Criteria andAdminContactedIsNotNull() {
            addCriterion("admin_contacted is not null");
            return (Criteria) this;
        }

        public Criteria andAdminContactedEqualTo(Boolean value) {
            addCriterion("admin_contacted =", value, "adminContacted");
            return (Criteria) this;
        }

        public Criteria andAdminContactedNotEqualTo(Boolean value) {
            addCriterion("admin_contacted <>", value, "adminContacted");
            return (Criteria) this;
        }

        public Criteria andAdminContactedGreaterThan(Boolean value) {
            addCriterion("admin_contacted >", value, "adminContacted");
            return (Criteria) this;
        }

        public Criteria andAdminContactedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("admin_contacted >=", value, "adminContacted");
            return (Criteria) this;
        }

        public Criteria andAdminContactedLessThan(Boolean value) {
            addCriterion("admin_contacted <", value, "adminContacted");
            return (Criteria) this;
        }

        public Criteria andAdminContactedLessThanOrEqualTo(Boolean value) {
            addCriterion("admin_contacted <=", value, "adminContacted");
            return (Criteria) this;
        }

        public Criteria andAdminContactedIn(List<Boolean> values) {
            addCriterion("admin_contacted in", values, "adminContacted");
            return (Criteria) this;
        }

        public Criteria andAdminContactedNotIn(List<Boolean> values) {
            addCriterion("admin_contacted not in", values, "adminContacted");
            return (Criteria) this;
        }

        public Criteria andAdminContactedBetween(Boolean value1, Boolean value2) {
            addCriterion("admin_contacted between", value1, value2, "adminContacted");
            return (Criteria) this;
        }

        public Criteria andAdminContactedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("admin_contacted not between", value1, value2, "adminContacted");
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