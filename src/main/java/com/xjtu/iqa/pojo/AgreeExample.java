package com.xjtu.iqa.pojo;

import java.util.ArrayList;
import java.util.List;

public class AgreeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AgreeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
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

        public Criteria andAGREEIDIsNull() {
            addCriterion("AGREEID is null");
            return (Criteria) this;
        }

        public Criteria andAGREEIDIsNotNull() {
            addCriterion("AGREEID is not null");
            return (Criteria) this;
        }

        public Criteria andAGREEIDEqualTo(String value) {
            addCriterion("AGREEID =", value, "AGREEID");
            return (Criteria) this;
        }

        public Criteria andAGREEIDNotEqualTo(String value) {
            addCriterion("AGREEID <>", value, "AGREEID");
            return (Criteria) this;
        }

        public Criteria andAGREEIDGreaterThan(String value) {
            addCriterion("AGREEID >", value, "AGREEID");
            return (Criteria) this;
        }

        public Criteria andAGREEIDGreaterThanOrEqualTo(String value) {
            addCriterion("AGREEID >=", value, "AGREEID");
            return (Criteria) this;
        }

        public Criteria andAGREEIDLessThan(String value) {
            addCriterion("AGREEID <", value, "AGREEID");
            return (Criteria) this;
        }

        public Criteria andAGREEIDLessThanOrEqualTo(String value) {
            addCriterion("AGREEID <=", value, "AGREEID");
            return (Criteria) this;
        }

        public Criteria andAGREEIDLike(String value) {
            addCriterion("AGREEID like", value, "AGREEID");
            return (Criteria) this;
        }

        public Criteria andAGREEIDNotLike(String value) {
            addCriterion("AGREEID not like", value, "AGREEID");
            return (Criteria) this;
        }

        public Criteria andAGREEIDIn(List<String> values) {
            addCriterion("AGREEID in", values, "AGREEID");
            return (Criteria) this;
        }

        public Criteria andAGREEIDNotIn(List<String> values) {
            addCriterion("AGREEID not in", values, "AGREEID");
            return (Criteria) this;
        }

        public Criteria andAGREEIDBetween(String value1, String value2) {
            addCriterion("AGREEID between", value1, value2, "AGREEID");
            return (Criteria) this;
        }

        public Criteria andAGREEIDNotBetween(String value1, String value2) {
            addCriterion("AGREEID not between", value1, value2, "AGREEID");
            return (Criteria) this;
        }

        public Criteria andCOMMUNITYANSWERIDIsNull() {
            addCriterion("COMMUNITYANSWERID is null");
            return (Criteria) this;
        }

        public Criteria andCOMMUNITYANSWERIDIsNotNull() {
            addCriterion("COMMUNITYANSWERID is not null");
            return (Criteria) this;
        }

        public Criteria andCOMMUNITYANSWERIDEqualTo(String value) {
            addCriterion("COMMUNITYANSWERID =", value, "COMMUNITYANSWERID");
            return (Criteria) this;
        }

        public Criteria andCOMMUNITYANSWERIDNotEqualTo(String value) {
            addCriterion("COMMUNITYANSWERID <>", value, "COMMUNITYANSWERID");
            return (Criteria) this;
        }

        public Criteria andCOMMUNITYANSWERIDGreaterThan(String value) {
            addCriterion("COMMUNITYANSWERID >", value, "COMMUNITYANSWERID");
            return (Criteria) this;
        }

        public Criteria andCOMMUNITYANSWERIDGreaterThanOrEqualTo(String value) {
            addCriterion("COMMUNITYANSWERID >=", value, "COMMUNITYANSWERID");
            return (Criteria) this;
        }

        public Criteria andCOMMUNITYANSWERIDLessThan(String value) {
            addCriterion("COMMUNITYANSWERID <", value, "COMMUNITYANSWERID");
            return (Criteria) this;
        }

        public Criteria andCOMMUNITYANSWERIDLessThanOrEqualTo(String value) {
            addCriterion("COMMUNITYANSWERID <=", value, "COMMUNITYANSWERID");
            return (Criteria) this;
        }

        public Criteria andCOMMUNITYANSWERIDLike(String value) {
            addCriterion("COMMUNITYANSWERID like", value, "COMMUNITYANSWERID");
            return (Criteria) this;
        }

        public Criteria andCOMMUNITYANSWERIDNotLike(String value) {
            addCriterion("COMMUNITYANSWERID not like", value, "COMMUNITYANSWERID");
            return (Criteria) this;
        }

        public Criteria andCOMMUNITYANSWERIDIn(List<String> values) {
            addCriterion("COMMUNITYANSWERID in", values, "COMMUNITYANSWERID");
            return (Criteria) this;
        }

        public Criteria andCOMMUNITYANSWERIDNotIn(List<String> values) {
            addCriterion("COMMUNITYANSWERID not in", values, "COMMUNITYANSWERID");
            return (Criteria) this;
        }

        public Criteria andCOMMUNITYANSWERIDBetween(String value1, String value2) {
            addCriterion("COMMUNITYANSWERID between", value1, value2, "COMMUNITYANSWERID");
            return (Criteria) this;
        }

        public Criteria andCOMMUNITYANSWERIDNotBetween(String value1, String value2) {
            addCriterion("COMMUNITYANSWERID not between", value1, value2, "COMMUNITYANSWERID");
            return (Criteria) this;
        }

        public Criteria andUSERIDIsNull() {
            addCriterion("USERID is null");
            return (Criteria) this;
        }

        public Criteria andUSERIDIsNotNull() {
            addCriterion("USERID is not null");
            return (Criteria) this;
        }

        public Criteria andUSERIDEqualTo(String value) {
            addCriterion("USERID =", value, "USERID");
            return (Criteria) this;
        }

        public Criteria andUSERIDNotEqualTo(String value) {
            addCriterion("USERID <>", value, "USERID");
            return (Criteria) this;
        }

        public Criteria andUSERIDGreaterThan(String value) {
            addCriterion("USERID >", value, "USERID");
            return (Criteria) this;
        }

        public Criteria andUSERIDGreaterThanOrEqualTo(String value) {
            addCriterion("USERID >=", value, "USERID");
            return (Criteria) this;
        }

        public Criteria andUSERIDLessThan(String value) {
            addCriterion("USERID <", value, "USERID");
            return (Criteria) this;
        }

        public Criteria andUSERIDLessThanOrEqualTo(String value) {
            addCriterion("USERID <=", value, "USERID");
            return (Criteria) this;
        }

        public Criteria andUSERIDLike(String value) {
            addCriterion("USERID like", value, "USERID");
            return (Criteria) this;
        }

        public Criteria andUSERIDNotLike(String value) {
            addCriterion("USERID not like", value, "USERID");
            return (Criteria) this;
        }

        public Criteria andUSERIDIn(List<String> values) {
            addCriterion("USERID in", values, "USERID");
            return (Criteria) this;
        }

        public Criteria andUSERIDNotIn(List<String> values) {
            addCriterion("USERID not in", values, "USERID");
            return (Criteria) this;
        }

        public Criteria andUSERIDBetween(String value1, String value2) {
            addCriterion("USERID between", value1, value2, "USERID");
            return (Criteria) this;
        }

        public Criteria andUSERIDNotBetween(String value1, String value2) {
            addCriterion("USERID not between", value1, value2, "USERID");
            return (Criteria) this;
        }

        public Criteria andTOUSERIDIsNull() {
            addCriterion("TOUSERID is null");
            return (Criteria) this;
        }

        public Criteria andTOUSERIDIsNotNull() {
            addCriterion("TOUSERID is not null");
            return (Criteria) this;
        }

        public Criteria andTOUSERIDEqualTo(String value) {
            addCriterion("TOUSERID =", value, "TOUSERID");
            return (Criteria) this;
        }

        public Criteria andTOUSERIDNotEqualTo(String value) {
            addCriterion("TOUSERID <>", value, "TOUSERID");
            return (Criteria) this;
        }

        public Criteria andTOUSERIDGreaterThan(String value) {
            addCriterion("TOUSERID >", value, "TOUSERID");
            return (Criteria) this;
        }

        public Criteria andTOUSERIDGreaterThanOrEqualTo(String value) {
            addCriterion("TOUSERID >=", value, "TOUSERID");
            return (Criteria) this;
        }

        public Criteria andTOUSERIDLessThan(String value) {
            addCriterion("TOUSERID <", value, "TOUSERID");
            return (Criteria) this;
        }

        public Criteria andTOUSERIDLessThanOrEqualTo(String value) {
            addCriterion("TOUSERID <=", value, "TOUSERID");
            return (Criteria) this;
        }

        public Criteria andTOUSERIDLike(String value) {
            addCriterion("TOUSERID like", value, "TOUSERID");
            return (Criteria) this;
        }

        public Criteria andTOUSERIDNotLike(String value) {
            addCriterion("TOUSERID not like", value, "TOUSERID");
            return (Criteria) this;
        }

        public Criteria andTOUSERIDIn(List<String> values) {
            addCriterion("TOUSERID in", values, "TOUSERID");
            return (Criteria) this;
        }

        public Criteria andTOUSERIDNotIn(List<String> values) {
            addCriterion("TOUSERID not in", values, "TOUSERID");
            return (Criteria) this;
        }

        public Criteria andTOUSERIDBetween(String value1, String value2) {
            addCriterion("TOUSERID between", value1, value2, "TOUSERID");
            return (Criteria) this;
        }

        public Criteria andTOUSERIDNotBetween(String value1, String value2) {
            addCriterion("TOUSERID not between", value1, value2, "TOUSERID");
            return (Criteria) this;
        }

        public Criteria andTIMEIsNull() {
            addCriterion("TIME is null");
            return (Criteria) this;
        }

        public Criteria andTIMEIsNotNull() {
            addCriterion("TIME is not null");
            return (Criteria) this;
        }

        public Criteria andTIMEEqualTo(String value) {
            addCriterion("TIME =", value, "TIME");
            return (Criteria) this;
        }

        public Criteria andTIMENotEqualTo(String value) {
            addCriterion("TIME <>", value, "TIME");
            return (Criteria) this;
        }

        public Criteria andTIMEGreaterThan(String value) {
            addCriterion("TIME >", value, "TIME");
            return (Criteria) this;
        }

        public Criteria andTIMEGreaterThanOrEqualTo(String value) {
            addCriterion("TIME >=", value, "TIME");
            return (Criteria) this;
        }

        public Criteria andTIMELessThan(String value) {
            addCriterion("TIME <", value, "TIME");
            return (Criteria) this;
        }

        public Criteria andTIMELessThanOrEqualTo(String value) {
            addCriterion("TIME <=", value, "TIME");
            return (Criteria) this;
        }

        public Criteria andTIMELike(String value) {
            addCriterion("TIME like", value, "TIME");
            return (Criteria) this;
        }

        public Criteria andTIMENotLike(String value) {
            addCriterion("TIME not like", value, "TIME");
            return (Criteria) this;
        }

        public Criteria andTIMEIn(List<String> values) {
            addCriterion("TIME in", values, "TIME");
            return (Criteria) this;
        }

        public Criteria andTIMENotIn(List<String> values) {
            addCriterion("TIME not in", values, "TIME");
            return (Criteria) this;
        }

        public Criteria andTIMEBetween(String value1, String value2) {
            addCriterion("TIME between", value1, value2, "TIME");
            return (Criteria) this;
        }

        public Criteria andTIMENotBetween(String value1, String value2) {
            addCriterion("TIME not between", value1, value2, "TIME");
            return (Criteria) this;
        }

        public Criteria andISNOTICEIsNull() {
            addCriterion("ISNOTICE is null");
            return (Criteria) this;
        }

        public Criteria andISNOTICEIsNotNull() {
            addCriterion("ISNOTICE is not null");
            return (Criteria) this;
        }

        public Criteria andISNOTICEEqualTo(Integer value) {
            addCriterion("ISNOTICE =", value, "ISNOTICE");
            return (Criteria) this;
        }

        public Criteria andISNOTICENotEqualTo(Integer value) {
            addCriterion("ISNOTICE <>", value, "ISNOTICE");
            return (Criteria) this;
        }

        public Criteria andISNOTICEGreaterThan(Integer value) {
            addCriterion("ISNOTICE >", value, "ISNOTICE");
            return (Criteria) this;
        }

        public Criteria andISNOTICEGreaterThanOrEqualTo(Integer value) {
            addCriterion("ISNOTICE >=", value, "ISNOTICE");
            return (Criteria) this;
        }

        public Criteria andISNOTICELessThan(Integer value) {
            addCriterion("ISNOTICE <", value, "ISNOTICE");
            return (Criteria) this;
        }

        public Criteria andISNOTICELessThanOrEqualTo(Integer value) {
            addCriterion("ISNOTICE <=", value, "ISNOTICE");
            return (Criteria) this;
        }

        public Criteria andISNOTICEIn(List<Integer> values) {
            addCriterion("ISNOTICE in", values, "ISNOTICE");
            return (Criteria) this;
        }

        public Criteria andISNOTICENotIn(List<Integer> values) {
            addCriterion("ISNOTICE not in", values, "ISNOTICE");
            return (Criteria) this;
        }

        public Criteria andISNOTICEBetween(Integer value1, Integer value2) {
            addCriterion("ISNOTICE between", value1, value2, "ISNOTICE");
            return (Criteria) this;
        }

        public Criteria andISNOTICENotBetween(Integer value1, Integer value2) {
            addCriterion("ISNOTICE not between", value1, value2, "ISNOTICE");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

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
    }
}