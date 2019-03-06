package com.yy.POJO;

import java.util.ArrayList;
import java.util.List;

public class Menu1Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Menu1Example() {
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

        public Criteria andM1idIsNull() {
            addCriterion("m1id is null");
            return (Criteria) this;
        }

        public Criteria andM1idIsNotNull() {
            addCriterion("m1id is not null");
            return (Criteria) this;
        }

        public Criteria andM1idEqualTo(Integer value) {
            addCriterion("m1id =", value, "m1id");
            return (Criteria) this;
        }

        public Criteria andM1idNotEqualTo(Integer value) {
            addCriterion("m1id <>", value, "m1id");
            return (Criteria) this;
        }

        public Criteria andM1idGreaterThan(Integer value) {
            addCriterion("m1id >", value, "m1id");
            return (Criteria) this;
        }

        public Criteria andM1idGreaterThanOrEqualTo(Integer value) {
            addCriterion("m1id >=", value, "m1id");
            return (Criteria) this;
        }

        public Criteria andM1idLessThan(Integer value) {
            addCriterion("m1id <", value, "m1id");
            return (Criteria) this;
        }

        public Criteria andM1idLessThanOrEqualTo(Integer value) {
            addCriterion("m1id <=", value, "m1id");
            return (Criteria) this;
        }

        public Criteria andM1idIn(List<Integer> values) {
            addCriterion("m1id in", values, "m1id");
            return (Criteria) this;
        }

        public Criteria andM1idNotIn(List<Integer> values) {
            addCriterion("m1id not in", values, "m1id");
            return (Criteria) this;
        }

        public Criteria andM1idBetween(Integer value1, Integer value2) {
            addCriterion("m1id between", value1, value2, "m1id");
            return (Criteria) this;
        }

        public Criteria andM1idNotBetween(Integer value1, Integer value2) {
            addCriterion("m1id not between", value1, value2, "m1id");
            return (Criteria) this;
        }

        public Criteria andM1nameIsNull() {
            addCriterion("m1Name is null");
            return (Criteria) this;
        }

        public Criteria andM1nameIsNotNull() {
            addCriterion("m1Name is not null");
            return (Criteria) this;
        }

        public Criteria andM1nameEqualTo(String value) {
            addCriterion("m1Name =", value, "m1name");
            return (Criteria) this;
        }

        public Criteria andM1nameNotEqualTo(String value) {
            addCriterion("m1Name <>", value, "m1name");
            return (Criteria) this;
        }

        public Criteria andM1nameGreaterThan(String value) {
            addCriterion("m1Name >", value, "m1name");
            return (Criteria) this;
        }

        public Criteria andM1nameGreaterThanOrEqualTo(String value) {
            addCriterion("m1Name >=", value, "m1name");
            return (Criteria) this;
        }

        public Criteria andM1nameLessThan(String value) {
            addCriterion("m1Name <", value, "m1name");
            return (Criteria) this;
        }

        public Criteria andM1nameLessThanOrEqualTo(String value) {
            addCriterion("m1Name <=", value, "m1name");
            return (Criteria) this;
        }

        public Criteria andM1nameLike(String value) {
            addCriterion("m1Name like", value, "m1name");
            return (Criteria) this;
        }

        public Criteria andM1nameNotLike(String value) {
            addCriterion("m1Name not like", value, "m1name");
            return (Criteria) this;
        }

        public Criteria andM1nameIn(List<String> values) {
            addCriterion("m1Name in", values, "m1name");
            return (Criteria) this;
        }

        public Criteria andM1nameNotIn(List<String> values) {
            addCriterion("m1Name not in", values, "m1name");
            return (Criteria) this;
        }

        public Criteria andM1nameBetween(String value1, String value2) {
            addCriterion("m1Name between", value1, value2, "m1name");
            return (Criteria) this;
        }

        public Criteria andM1nameNotBetween(String value1, String value2) {
            addCriterion("m1Name not between", value1, value2, "m1name");
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