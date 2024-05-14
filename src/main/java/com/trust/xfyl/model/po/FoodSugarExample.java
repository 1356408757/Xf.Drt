package com.trust.xfyl.model.po;

import com.trust.xfyl.model.BaseBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FoodSugarExample extends BaseBean {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FoodSugarExample() {
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

        public Criteria andFoodIdIsNull() {
            addCriterion("food_id is null");
            return (Criteria) this;
        }

        public Criteria andFoodIdIsNotNull() {
            addCriterion("food_id is not null");
            return (Criteria) this;
        }

        public Criteria andFoodIdEqualTo(Integer value) {
            addCriterion("food_id =", value, "foodId");
            return (Criteria) this;
        }

        public Criteria andFoodIdNotEqualTo(Integer value) {
            addCriterion("food_id <>", value, "foodId");
            return (Criteria) this;
        }

        public Criteria andFoodIdGreaterThan(Integer value) {
            addCriterion("food_id >", value, "foodId");
            return (Criteria) this;
        }

        public Criteria andFoodIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("food_id >=", value, "foodId");
            return (Criteria) this;
        }

        public Criteria andFoodIdLessThan(Integer value) {
            addCriterion("food_id <", value, "foodId");
            return (Criteria) this;
        }

        public Criteria andFoodIdLessThanOrEqualTo(Integer value) {
            addCriterion("food_id <=", value, "foodId");
            return (Criteria) this;
        }

        public Criteria andFoodIdIn(List<Integer> values) {
            addCriterion("food_id in", values, "foodId");
            return (Criteria) this;
        }

        public Criteria andFoodIdNotIn(List<Integer> values) {
            addCriterion("food_id not in", values, "foodId");
            return (Criteria) this;
        }

        public Criteria andFoodIdBetween(Integer value1, Integer value2) {
            addCriterion("food_id between", value1, value2, "foodId");
            return (Criteria) this;
        }

        public Criteria andFoodIdNotBetween(Integer value1, Integer value2) {
            addCriterion("food_id not between", value1, value2, "foodId");
            return (Criteria) this;
        }

        public Criteria andFoodNameIsNull() {
            addCriterion("food_name is null");
            return (Criteria) this;
        }

        public Criteria andFoodNameIsNotNull() {
            addCriterion("food_name is not null");
            return (Criteria) this;
        }

        public Criteria andFoodNameEqualTo(String value) {
            addCriterion("food_name =", value, "foodName");
            return (Criteria) this;
        }

        public Criteria andFoodNameNotEqualTo(String value) {
            addCriterion("food_name <>", value, "foodName");
            return (Criteria) this;
        }

        public Criteria andFoodNameGreaterThan(String value) {
            addCriterion("food_name >", value, "foodName");
            return (Criteria) this;
        }

        public Criteria andFoodNameGreaterThanOrEqualTo(String value) {
            addCriterion("food_name >=", value, "foodName");
            return (Criteria) this;
        }

        public Criteria andFoodNameLessThan(String value) {
            addCriterion("food_name <", value, "foodName");
            return (Criteria) this;
        }

        public Criteria andFoodNameLessThanOrEqualTo(String value) {
            addCriterion("food_name <=", value, "foodName");
            return (Criteria) this;
        }

        public Criteria andFoodNameLike(String value) {
            addCriterion("food_name like", value, "foodName");
            return (Criteria) this;
        }

        public Criteria andFoodNameNotLike(String value) {
            addCriterion("food_name not like", value, "foodName");
            return (Criteria) this;
        }

        public Criteria andFoodNameIn(List<String> values) {
            addCriterion("food_name in", values, "foodName");
            return (Criteria) this;
        }

        public Criteria andFoodNameNotIn(List<String> values) {
            addCriterion("food_name not in", values, "foodName");
            return (Criteria) this;
        }

        public Criteria andFoodNameBetween(String value1, String value2) {
            addCriterion("food_name between", value1, value2, "foodName");
            return (Criteria) this;
        }

        public Criteria andFoodNameNotBetween(String value1, String value2) {
            addCriterion("food_name not between", value1, value2, "foodName");
            return (Criteria) this;
        }

        public Criteria andEdiblePartIsNull() {
            addCriterion("edible_part is null");
            return (Criteria) this;
        }

        public Criteria andEdiblePartIsNotNull() {
            addCriterion("edible_part is not null");
            return (Criteria) this;
        }

        public Criteria andEdiblePartEqualTo(String value) {
            addCriterion("edible_part =", value, "ediblePart");
            return (Criteria) this;
        }

        public Criteria andEdiblePartNotEqualTo(String value) {
            addCriterion("edible_part <>", value, "ediblePart");
            return (Criteria) this;
        }

        public Criteria andEdiblePartGreaterThan(String value) {
            addCriterion("edible_part >", value, "ediblePart");
            return (Criteria) this;
        }

        public Criteria andEdiblePartGreaterThanOrEqualTo(String value) {
            addCriterion("edible_part >=", value, "ediblePart");
            return (Criteria) this;
        }

        public Criteria andEdiblePartLessThan(String value) {
            addCriterion("edible_part <", value, "ediblePart");
            return (Criteria) this;
        }

        public Criteria andEdiblePartLessThanOrEqualTo(String value) {
            addCriterion("edible_part <=", value, "ediblePart");
            return (Criteria) this;
        }

        public Criteria andEdiblePartLike(String value) {
            addCriterion("edible_part like", value, "ediblePart");
            return (Criteria) this;
        }

        public Criteria andEdiblePartNotLike(String value) {
            addCriterion("edible_part not like", value, "ediblePart");
            return (Criteria) this;
        }

        public Criteria andEdiblePartIn(List<String> values) {
            addCriterion("edible_part in", values, "ediblePart");
            return (Criteria) this;
        }

        public Criteria andEdiblePartNotIn(List<String> values) {
            addCriterion("edible_part not in", values, "ediblePart");
            return (Criteria) this;
        }

        public Criteria andEdiblePartBetween(String value1, String value2) {
            addCriterion("edible_part between", value1, value2, "ediblePart");
            return (Criteria) this;
        }

        public Criteria andEdiblePartNotBetween(String value1, String value2) {
            addCriterion("edible_part not between", value1, value2, "ediblePart");
            return (Criteria) this;
        }

        public Criteria andEnergyIsNull() {
            addCriterion("energy is null");
            return (Criteria) this;
        }

        public Criteria andEnergyIsNotNull() {
            addCriterion("energy is not null");
            return (Criteria) this;
        }

        public Criteria andEnergyEqualTo(String value) {
            addCriterion("energy =", value, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyNotEqualTo(String value) {
            addCriterion("energy <>", value, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyGreaterThan(String value) {
            addCriterion("energy >", value, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyGreaterThanOrEqualTo(String value) {
            addCriterion("energy >=", value, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyLessThan(String value) {
            addCriterion("energy <", value, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyLessThanOrEqualTo(String value) {
            addCriterion("energy <=", value, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyLike(String value) {
            addCriterion("energy like", value, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyNotLike(String value) {
            addCriterion("energy not like", value, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyIn(List<String> values) {
            addCriterion("energy in", values, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyNotIn(List<String> values) {
            addCriterion("energy not in", values, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyBetween(String value1, String value2) {
            addCriterion("energy between", value1, value2, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyNotBetween(String value1, String value2) {
            addCriterion("energy not between", value1, value2, "energy");
            return (Criteria) this;
        }

        public Criteria andWaterIsNull() {
            addCriterion("water is null");
            return (Criteria) this;
        }

        public Criteria andWaterIsNotNull() {
            addCriterion("water is not null");
            return (Criteria) this;
        }

        public Criteria andWaterEqualTo(String value) {
            addCriterion("water =", value, "water");
            return (Criteria) this;
        }

        public Criteria andWaterNotEqualTo(String value) {
            addCriterion("water <>", value, "water");
            return (Criteria) this;
        }

        public Criteria andWaterGreaterThan(String value) {
            addCriterion("water >", value, "water");
            return (Criteria) this;
        }

        public Criteria andWaterGreaterThanOrEqualTo(String value) {
            addCriterion("water >=", value, "water");
            return (Criteria) this;
        }

        public Criteria andWaterLessThan(String value) {
            addCriterion("water <", value, "water");
            return (Criteria) this;
        }

        public Criteria andWaterLessThanOrEqualTo(String value) {
            addCriterion("water <=", value, "water");
            return (Criteria) this;
        }

        public Criteria andWaterLike(String value) {
            addCriterion("water like", value, "water");
            return (Criteria) this;
        }

        public Criteria andWaterNotLike(String value) {
            addCriterion("water not like", value, "water");
            return (Criteria) this;
        }

        public Criteria andWaterIn(List<String> values) {
            addCriterion("water in", values, "water");
            return (Criteria) this;
        }

        public Criteria andWaterNotIn(List<String> values) {
            addCriterion("water not in", values, "water");
            return (Criteria) this;
        }

        public Criteria andWaterBetween(String value1, String value2) {
            addCriterion("water between", value1, value2, "water");
            return (Criteria) this;
        }

        public Criteria andWaterNotBetween(String value1, String value2) {
            addCriterion("water not between", value1, value2, "water");
            return (Criteria) this;
        }

        public Criteria andProteinIsNull() {
            addCriterion("protein is null");
            return (Criteria) this;
        }

        public Criteria andProteinIsNotNull() {
            addCriterion("protein is not null");
            return (Criteria) this;
        }

        public Criteria andProteinEqualTo(String value) {
            addCriterion("protein =", value, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinNotEqualTo(String value) {
            addCriterion("protein <>", value, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinGreaterThan(String value) {
            addCriterion("protein >", value, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinGreaterThanOrEqualTo(String value) {
            addCriterion("protein >=", value, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinLessThan(String value) {
            addCriterion("protein <", value, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinLessThanOrEqualTo(String value) {
            addCriterion("protein <=", value, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinLike(String value) {
            addCriterion("protein like", value, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinNotLike(String value) {
            addCriterion("protein not like", value, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinIn(List<String> values) {
            addCriterion("protein in", values, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinNotIn(List<String> values) {
            addCriterion("protein not in", values, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinBetween(String value1, String value2) {
            addCriterion("protein between", value1, value2, "protein");
            return (Criteria) this;
        }

        public Criteria andProteinNotBetween(String value1, String value2) {
            addCriterion("protein not between", value1, value2, "protein");
            return (Criteria) this;
        }

        public Criteria andFatIsNull() {
            addCriterion("fat is null");
            return (Criteria) this;
        }

        public Criteria andFatIsNotNull() {
            addCriterion("fat is not null");
            return (Criteria) this;
        }

        public Criteria andFatEqualTo(String value) {
            addCriterion("fat =", value, "fat");
            return (Criteria) this;
        }

        public Criteria andFatNotEqualTo(String value) {
            addCriterion("fat <>", value, "fat");
            return (Criteria) this;
        }

        public Criteria andFatGreaterThan(String value) {
            addCriterion("fat >", value, "fat");
            return (Criteria) this;
        }

        public Criteria andFatGreaterThanOrEqualTo(String value) {
            addCriterion("fat >=", value, "fat");
            return (Criteria) this;
        }

        public Criteria andFatLessThan(String value) {
            addCriterion("fat <", value, "fat");
            return (Criteria) this;
        }

        public Criteria andFatLessThanOrEqualTo(String value) {
            addCriterion("fat <=", value, "fat");
            return (Criteria) this;
        }

        public Criteria andFatLike(String value) {
            addCriterion("fat like", value, "fat");
            return (Criteria) this;
        }

        public Criteria andFatNotLike(String value) {
            addCriterion("fat not like", value, "fat");
            return (Criteria) this;
        }

        public Criteria andFatIn(List<String> values) {
            addCriterion("fat in", values, "fat");
            return (Criteria) this;
        }

        public Criteria andFatNotIn(List<String> values) {
            addCriterion("fat not in", values, "fat");
            return (Criteria) this;
        }

        public Criteria andFatBetween(String value1, String value2) {
            addCriterion("fat between", value1, value2, "fat");
            return (Criteria) this;
        }

        public Criteria andFatNotBetween(String value1, String value2) {
            addCriterion("fat not between", value1, value2, "fat");
            return (Criteria) this;
        }

        public Criteria andDietaryFiberIsNull() {
            addCriterion("dietary_fiber is null");
            return (Criteria) this;
        }

        public Criteria andDietaryFiberIsNotNull() {
            addCriterion("dietary_fiber is not null");
            return (Criteria) this;
        }

        public Criteria andDietaryFiberEqualTo(String value) {
            addCriterion("dietary_fiber =", value, "dietaryFiber");
            return (Criteria) this;
        }

        public Criteria andDietaryFiberNotEqualTo(String value) {
            addCriterion("dietary_fiber <>", value, "dietaryFiber");
            return (Criteria) this;
        }

        public Criteria andDietaryFiberGreaterThan(String value) {
            addCriterion("dietary_fiber >", value, "dietaryFiber");
            return (Criteria) this;
        }

        public Criteria andDietaryFiberGreaterThanOrEqualTo(String value) {
            addCriterion("dietary_fiber >=", value, "dietaryFiber");
            return (Criteria) this;
        }

        public Criteria andDietaryFiberLessThan(String value) {
            addCriterion("dietary_fiber <", value, "dietaryFiber");
            return (Criteria) this;
        }

        public Criteria andDietaryFiberLessThanOrEqualTo(String value) {
            addCriterion("dietary_fiber <=", value, "dietaryFiber");
            return (Criteria) this;
        }

        public Criteria andDietaryFiberLike(String value) {
            addCriterion("dietary_fiber like", value, "dietaryFiber");
            return (Criteria) this;
        }

        public Criteria andDietaryFiberNotLike(String value) {
            addCriterion("dietary_fiber not like", value, "dietaryFiber");
            return (Criteria) this;
        }

        public Criteria andDietaryFiberIn(List<String> values) {
            addCriterion("dietary_fiber in", values, "dietaryFiber");
            return (Criteria) this;
        }

        public Criteria andDietaryFiberNotIn(List<String> values) {
            addCriterion("dietary_fiber not in", values, "dietaryFiber");
            return (Criteria) this;
        }

        public Criteria andDietaryFiberBetween(String value1, String value2) {
            addCriterion("dietary_fiber between", value1, value2, "dietaryFiber");
            return (Criteria) this;
        }

        public Criteria andDietaryFiberNotBetween(String value1, String value2) {
            addCriterion("dietary_fiber not between", value1, value2, "dietaryFiber");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateIsNull() {
            addCriterion("carbohydrate is null");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateIsNotNull() {
            addCriterion("carbohydrate is not null");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateEqualTo(String value) {
            addCriterion("carbohydrate =", value, "carbohydrate");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateNotEqualTo(String value) {
            addCriterion("carbohydrate <>", value, "carbohydrate");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateGreaterThan(String value) {
            addCriterion("carbohydrate >", value, "carbohydrate");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateGreaterThanOrEqualTo(String value) {
            addCriterion("carbohydrate >=", value, "carbohydrate");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateLessThan(String value) {
            addCriterion("carbohydrate <", value, "carbohydrate");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateLessThanOrEqualTo(String value) {
            addCriterion("carbohydrate <=", value, "carbohydrate");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateLike(String value) {
            addCriterion("carbohydrate like", value, "carbohydrate");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateNotLike(String value) {
            addCriterion("carbohydrate not like", value, "carbohydrate");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateIn(List<String> values) {
            addCriterion("carbohydrate in", values, "carbohydrate");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateNotIn(List<String> values) {
            addCriterion("carbohydrate not in", values, "carbohydrate");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateBetween(String value1, String value2) {
            addCriterion("carbohydrate between", value1, value2, "carbohydrate");
            return (Criteria) this;
        }

        public Criteria andCarbohydrateNotBetween(String value1, String value2) {
            addCriterion("carbohydrate not between", value1, value2, "carbohydrate");
            return (Criteria) this;
        }

        public Criteria andVitaminAIsNull() {
            addCriterion("vitamin_a is null");
            return (Criteria) this;
        }

        public Criteria andVitaminAIsNotNull() {
            addCriterion("vitamin_a is not null");
            return (Criteria) this;
        }

        public Criteria andVitaminAEqualTo(String value) {
            addCriterion("vitamin_a =", value, "vitaminA");
            return (Criteria) this;
        }

        public Criteria andVitaminANotEqualTo(String value) {
            addCriterion("vitamin_a <>", value, "vitaminA");
            return (Criteria) this;
        }

        public Criteria andVitaminAGreaterThan(String value) {
            addCriterion("vitamin_a >", value, "vitaminA");
            return (Criteria) this;
        }

        public Criteria andVitaminAGreaterThanOrEqualTo(String value) {
            addCriterion("vitamin_a >=", value, "vitaminA");
            return (Criteria) this;
        }

        public Criteria andVitaminALessThan(String value) {
            addCriterion("vitamin_a <", value, "vitaminA");
            return (Criteria) this;
        }

        public Criteria andVitaminALessThanOrEqualTo(String value) {
            addCriterion("vitamin_a <=", value, "vitaminA");
            return (Criteria) this;
        }

        public Criteria andVitaminALike(String value) {
            addCriterion("vitamin_a like", value, "vitaminA");
            return (Criteria) this;
        }

        public Criteria andVitaminANotLike(String value) {
            addCriterion("vitamin_a not like", value, "vitaminA");
            return (Criteria) this;
        }

        public Criteria andVitaminAIn(List<String> values) {
            addCriterion("vitamin_a in", values, "vitaminA");
            return (Criteria) this;
        }

        public Criteria andVitaminANotIn(List<String> values) {
            addCriterion("vitamin_a not in", values, "vitaminA");
            return (Criteria) this;
        }

        public Criteria andVitaminABetween(String value1, String value2) {
            addCriterion("vitamin_a between", value1, value2, "vitaminA");
            return (Criteria) this;
        }

        public Criteria andVitaminANotBetween(String value1, String value2) {
            addCriterion("vitamin_a not between", value1, value2, "vitaminA");
            return (Criteria) this;
        }

        public Criteria andVitaminB1IsNull() {
            addCriterion("vitamin_b1 is null");
            return (Criteria) this;
        }

        public Criteria andVitaminB1IsNotNull() {
            addCriterion("vitamin_b1 is not null");
            return (Criteria) this;
        }

        public Criteria andVitaminB1EqualTo(String value) {
            addCriterion("vitamin_b1 =", value, "vitaminB1");
            return (Criteria) this;
        }

        public Criteria andVitaminB1NotEqualTo(String value) {
            addCriterion("vitamin_b1 <>", value, "vitaminB1");
            return (Criteria) this;
        }

        public Criteria andVitaminB1GreaterThan(String value) {
            addCriterion("vitamin_b1 >", value, "vitaminB1");
            return (Criteria) this;
        }

        public Criteria andVitaminB1GreaterThanOrEqualTo(String value) {
            addCriterion("vitamin_b1 >=", value, "vitaminB1");
            return (Criteria) this;
        }

        public Criteria andVitaminB1LessThan(String value) {
            addCriterion("vitamin_b1 <", value, "vitaminB1");
            return (Criteria) this;
        }

        public Criteria andVitaminB1LessThanOrEqualTo(String value) {
            addCriterion("vitamin_b1 <=", value, "vitaminB1");
            return (Criteria) this;
        }

        public Criteria andVitaminB1Like(String value) {
            addCriterion("vitamin_b1 like", value, "vitaminB1");
            return (Criteria) this;
        }

        public Criteria andVitaminB1NotLike(String value) {
            addCriterion("vitamin_b1 not like", value, "vitaminB1");
            return (Criteria) this;
        }

        public Criteria andVitaminB1In(List<String> values) {
            addCriterion("vitamin_b1 in", values, "vitaminB1");
            return (Criteria) this;
        }

        public Criteria andVitaminB1NotIn(List<String> values) {
            addCriterion("vitamin_b1 not in", values, "vitaminB1");
            return (Criteria) this;
        }

        public Criteria andVitaminB1Between(String value1, String value2) {
            addCriterion("vitamin_b1 between", value1, value2, "vitaminB1");
            return (Criteria) this;
        }

        public Criteria andVitaminB1NotBetween(String value1, String value2) {
            addCriterion("vitamin_b1 not between", value1, value2, "vitaminB1");
            return (Criteria) this;
        }

        public Criteria andVitaminB2IsNull() {
            addCriterion("vitamin_b2 is null");
            return (Criteria) this;
        }

        public Criteria andVitaminB2IsNotNull() {
            addCriterion("vitamin_b2 is not null");
            return (Criteria) this;
        }

        public Criteria andVitaminB2EqualTo(String value) {
            addCriterion("vitamin_b2 =", value, "vitaminB2");
            return (Criteria) this;
        }

        public Criteria andVitaminB2NotEqualTo(String value) {
            addCriterion("vitamin_b2 <>", value, "vitaminB2");
            return (Criteria) this;
        }

        public Criteria andVitaminB2GreaterThan(String value) {
            addCriterion("vitamin_b2 >", value, "vitaminB2");
            return (Criteria) this;
        }

        public Criteria andVitaminB2GreaterThanOrEqualTo(String value) {
            addCriterion("vitamin_b2 >=", value, "vitaminB2");
            return (Criteria) this;
        }

        public Criteria andVitaminB2LessThan(String value) {
            addCriterion("vitamin_b2 <", value, "vitaminB2");
            return (Criteria) this;
        }

        public Criteria andVitaminB2LessThanOrEqualTo(String value) {
            addCriterion("vitamin_b2 <=", value, "vitaminB2");
            return (Criteria) this;
        }

        public Criteria andVitaminB2Like(String value) {
            addCriterion("vitamin_b2 like", value, "vitaminB2");
            return (Criteria) this;
        }

        public Criteria andVitaminB2NotLike(String value) {
            addCriterion("vitamin_b2 not like", value, "vitaminB2");
            return (Criteria) this;
        }

        public Criteria andVitaminB2In(List<String> values) {
            addCriterion("vitamin_b2 in", values, "vitaminB2");
            return (Criteria) this;
        }

        public Criteria andVitaminB2NotIn(List<String> values) {
            addCriterion("vitamin_b2 not in", values, "vitaminB2");
            return (Criteria) this;
        }

        public Criteria andVitaminB2Between(String value1, String value2) {
            addCriterion("vitamin_b2 between", value1, value2, "vitaminB2");
            return (Criteria) this;
        }

        public Criteria andVitaminB2NotBetween(String value1, String value2) {
            addCriterion("vitamin_b2 not between", value1, value2, "vitaminB2");
            return (Criteria) this;
        }

        public Criteria andNiacinIsNull() {
            addCriterion("niacin is null");
            return (Criteria) this;
        }

        public Criteria andNiacinIsNotNull() {
            addCriterion("niacin is not null");
            return (Criteria) this;
        }

        public Criteria andNiacinEqualTo(String value) {
            addCriterion("niacin =", value, "niacin");
            return (Criteria) this;
        }

        public Criteria andNiacinNotEqualTo(String value) {
            addCriterion("niacin <>", value, "niacin");
            return (Criteria) this;
        }

        public Criteria andNiacinGreaterThan(String value) {
            addCriterion("niacin >", value, "niacin");
            return (Criteria) this;
        }

        public Criteria andNiacinGreaterThanOrEqualTo(String value) {
            addCriterion("niacin >=", value, "niacin");
            return (Criteria) this;
        }

        public Criteria andNiacinLessThan(String value) {
            addCriterion("niacin <", value, "niacin");
            return (Criteria) this;
        }

        public Criteria andNiacinLessThanOrEqualTo(String value) {
            addCriterion("niacin <=", value, "niacin");
            return (Criteria) this;
        }

        public Criteria andNiacinLike(String value) {
            addCriterion("niacin like", value, "niacin");
            return (Criteria) this;
        }

        public Criteria andNiacinNotLike(String value) {
            addCriterion("niacin not like", value, "niacin");
            return (Criteria) this;
        }

        public Criteria andNiacinIn(List<String> values) {
            addCriterion("niacin in", values, "niacin");
            return (Criteria) this;
        }

        public Criteria andNiacinNotIn(List<String> values) {
            addCriterion("niacin not in", values, "niacin");
            return (Criteria) this;
        }

        public Criteria andNiacinBetween(String value1, String value2) {
            addCriterion("niacin between", value1, value2, "niacin");
            return (Criteria) this;
        }

        public Criteria andNiacinNotBetween(String value1, String value2) {
            addCriterion("niacin not between", value1, value2, "niacin");
            return (Criteria) this;
        }

        public Criteria andVitaminEIsNull() {
            addCriterion("vitamin_e is null");
            return (Criteria) this;
        }

        public Criteria andVitaminEIsNotNull() {
            addCriterion("vitamin_e is not null");
            return (Criteria) this;
        }

        public Criteria andVitaminEEqualTo(String value) {
            addCriterion("vitamin_e =", value, "vitaminE");
            return (Criteria) this;
        }

        public Criteria andVitaminENotEqualTo(String value) {
            addCriterion("vitamin_e <>", value, "vitaminE");
            return (Criteria) this;
        }

        public Criteria andVitaminEGreaterThan(String value) {
            addCriterion("vitamin_e >", value, "vitaminE");
            return (Criteria) this;
        }

        public Criteria andVitaminEGreaterThanOrEqualTo(String value) {
            addCriterion("vitamin_e >=", value, "vitaminE");
            return (Criteria) this;
        }

        public Criteria andVitaminELessThan(String value) {
            addCriterion("vitamin_e <", value, "vitaminE");
            return (Criteria) this;
        }

        public Criteria andVitaminELessThanOrEqualTo(String value) {
            addCriterion("vitamin_e <=", value, "vitaminE");
            return (Criteria) this;
        }

        public Criteria andVitaminELike(String value) {
            addCriterion("vitamin_e like", value, "vitaminE");
            return (Criteria) this;
        }

        public Criteria andVitaminENotLike(String value) {
            addCriterion("vitamin_e not like", value, "vitaminE");
            return (Criteria) this;
        }

        public Criteria andVitaminEIn(List<String> values) {
            addCriterion("vitamin_e in", values, "vitaminE");
            return (Criteria) this;
        }

        public Criteria andVitaminENotIn(List<String> values) {
            addCriterion("vitamin_e not in", values, "vitaminE");
            return (Criteria) this;
        }

        public Criteria andVitaminEBetween(String value1, String value2) {
            addCriterion("vitamin_e between", value1, value2, "vitaminE");
            return (Criteria) this;
        }

        public Criteria andVitaminENotBetween(String value1, String value2) {
            addCriterion("vitamin_e not between", value1, value2, "vitaminE");
            return (Criteria) this;
        }

        public Criteria andSodiumIsNull() {
            addCriterion("sodium is null");
            return (Criteria) this;
        }

        public Criteria andSodiumIsNotNull() {
            addCriterion("sodium is not null");
            return (Criteria) this;
        }

        public Criteria andSodiumEqualTo(String value) {
            addCriterion("sodium =", value, "sodium");
            return (Criteria) this;
        }

        public Criteria andSodiumNotEqualTo(String value) {
            addCriterion("sodium <>", value, "sodium");
            return (Criteria) this;
        }

        public Criteria andSodiumGreaterThan(String value) {
            addCriterion("sodium >", value, "sodium");
            return (Criteria) this;
        }

        public Criteria andSodiumGreaterThanOrEqualTo(String value) {
            addCriterion("sodium >=", value, "sodium");
            return (Criteria) this;
        }

        public Criteria andSodiumLessThan(String value) {
            addCriterion("sodium <", value, "sodium");
            return (Criteria) this;
        }

        public Criteria andSodiumLessThanOrEqualTo(String value) {
            addCriterion("sodium <=", value, "sodium");
            return (Criteria) this;
        }

        public Criteria andSodiumLike(String value) {
            addCriterion("sodium like", value, "sodium");
            return (Criteria) this;
        }

        public Criteria andSodiumNotLike(String value) {
            addCriterion("sodium not like", value, "sodium");
            return (Criteria) this;
        }

        public Criteria andSodiumIn(List<String> values) {
            addCriterion("sodium in", values, "sodium");
            return (Criteria) this;
        }

        public Criteria andSodiumNotIn(List<String> values) {
            addCriterion("sodium not in", values, "sodium");
            return (Criteria) this;
        }

        public Criteria andSodiumBetween(String value1, String value2) {
            addCriterion("sodium between", value1, value2, "sodium");
            return (Criteria) this;
        }

        public Criteria andSodiumNotBetween(String value1, String value2) {
            addCriterion("sodium not between", value1, value2, "sodium");
            return (Criteria) this;
        }

        public Criteria andCalciumIsNull() {
            addCriterion("calcium is null");
            return (Criteria) this;
        }

        public Criteria andCalciumIsNotNull() {
            addCriterion("calcium is not null");
            return (Criteria) this;
        }

        public Criteria andCalciumEqualTo(String value) {
            addCriterion("calcium =", value, "calcium");
            return (Criteria) this;
        }

        public Criteria andCalciumNotEqualTo(String value) {
            addCriterion("calcium <>", value, "calcium");
            return (Criteria) this;
        }

        public Criteria andCalciumGreaterThan(String value) {
            addCriterion("calcium >", value, "calcium");
            return (Criteria) this;
        }

        public Criteria andCalciumGreaterThanOrEqualTo(String value) {
            addCriterion("calcium >=", value, "calcium");
            return (Criteria) this;
        }

        public Criteria andCalciumLessThan(String value) {
            addCriterion("calcium <", value, "calcium");
            return (Criteria) this;
        }

        public Criteria andCalciumLessThanOrEqualTo(String value) {
            addCriterion("calcium <=", value, "calcium");
            return (Criteria) this;
        }

        public Criteria andCalciumLike(String value) {
            addCriterion("calcium like", value, "calcium");
            return (Criteria) this;
        }

        public Criteria andCalciumNotLike(String value) {
            addCriterion("calcium not like", value, "calcium");
            return (Criteria) this;
        }

        public Criteria andCalciumIn(List<String> values) {
            addCriterion("calcium in", values, "calcium");
            return (Criteria) this;
        }

        public Criteria andCalciumNotIn(List<String> values) {
            addCriterion("calcium not in", values, "calcium");
            return (Criteria) this;
        }

        public Criteria andCalciumBetween(String value1, String value2) {
            addCriterion("calcium between", value1, value2, "calcium");
            return (Criteria) this;
        }

        public Criteria andCalciumNotBetween(String value1, String value2) {
            addCriterion("calcium not between", value1, value2, "calcium");
            return (Criteria) this;
        }

        public Criteria andIronIsNull() {
            addCriterion("iron is null");
            return (Criteria) this;
        }

        public Criteria andIronIsNotNull() {
            addCriterion("iron is not null");
            return (Criteria) this;
        }

        public Criteria andIronEqualTo(String value) {
            addCriterion("iron =", value, "iron");
            return (Criteria) this;
        }

        public Criteria andIronNotEqualTo(String value) {
            addCriterion("iron <>", value, "iron");
            return (Criteria) this;
        }

        public Criteria andIronGreaterThan(String value) {
            addCriterion("iron >", value, "iron");
            return (Criteria) this;
        }

        public Criteria andIronGreaterThanOrEqualTo(String value) {
            addCriterion("iron >=", value, "iron");
            return (Criteria) this;
        }

        public Criteria andIronLessThan(String value) {
            addCriterion("iron <", value, "iron");
            return (Criteria) this;
        }

        public Criteria andIronLessThanOrEqualTo(String value) {
            addCriterion("iron <=", value, "iron");
            return (Criteria) this;
        }

        public Criteria andIronLike(String value) {
            addCriterion("iron like", value, "iron");
            return (Criteria) this;
        }

        public Criteria andIronNotLike(String value) {
            addCriterion("iron not like", value, "iron");
            return (Criteria) this;
        }

        public Criteria andIronIn(List<String> values) {
            addCriterion("iron in", values, "iron");
            return (Criteria) this;
        }

        public Criteria andIronNotIn(List<String> values) {
            addCriterion("iron not in", values, "iron");
            return (Criteria) this;
        }

        public Criteria andIronBetween(String value1, String value2) {
            addCriterion("iron between", value1, value2, "iron");
            return (Criteria) this;
        }

        public Criteria andIronNotBetween(String value1, String value2) {
            addCriterion("iron not between", value1, value2, "iron");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNull() {
            addCriterion("category is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("category is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(String value) {
            addCriterion("category =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(String value) {
            addCriterion("category <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(String value) {
            addCriterion("category >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("category >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(String value) {
            addCriterion("category <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(String value) {
            addCriterion("category <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLike(String value) {
            addCriterion("category like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotLike(String value) {
            addCriterion("category not like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<String> values) {
            addCriterion("category in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<String> values) {
            addCriterion("category not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(String value1, String value2) {
            addCriterion("category between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(String value1, String value2) {
            addCriterion("category not between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andVitaminCIsNull() {
            addCriterion("vitamin_c is null");
            return (Criteria) this;
        }

        public Criteria andVitaminCIsNotNull() {
            addCriterion("vitamin_c is not null");
            return (Criteria) this;
        }

        public Criteria andVitaminCEqualTo(String value) {
            addCriterion("vitamin_c =", value, "vitaminC");
            return (Criteria) this;
        }

        public Criteria andVitaminCNotEqualTo(String value) {
            addCriterion("vitamin_c <>", value, "vitaminC");
            return (Criteria) this;
        }

        public Criteria andVitaminCGreaterThan(String value) {
            addCriterion("vitamin_c >", value, "vitaminC");
            return (Criteria) this;
        }

        public Criteria andVitaminCGreaterThanOrEqualTo(String value) {
            addCriterion("vitamin_c >=", value, "vitaminC");
            return (Criteria) this;
        }

        public Criteria andVitaminCLessThan(String value) {
            addCriterion("vitamin_c <", value, "vitaminC");
            return (Criteria) this;
        }

        public Criteria andVitaminCLessThanOrEqualTo(String value) {
            addCriterion("vitamin_c <=", value, "vitaminC");
            return (Criteria) this;
        }

        public Criteria andVitaminCLike(String value) {
            addCriterion("vitamin_c like", value, "vitaminC");
            return (Criteria) this;
        }

        public Criteria andVitaminCNotLike(String value) {
            addCriterion("vitamin_c not like", value, "vitaminC");
            return (Criteria) this;
        }

        public Criteria andVitaminCIn(List<String> values) {
            addCriterion("vitamin_c in", values, "vitaminC");
            return (Criteria) this;
        }

        public Criteria andVitaminCNotIn(List<String> values) {
            addCriterion("vitamin_c not in", values, "vitaminC");
            return (Criteria) this;
        }

        public Criteria andVitaminCBetween(String value1, String value2) {
            addCriterion("vitamin_c between", value1, value2, "vitaminC");
            return (Criteria) this;
        }

        public Criteria andVitaminCNotBetween(String value1, String value2) {
            addCriterion("vitamin_c not between", value1, value2, "vitaminC");
            return (Criteria) this;
        }

        public Criteria andCholesterolIsNull() {
            addCriterion("cholesterol is null");
            return (Criteria) this;
        }

        public Criteria andCholesterolIsNotNull() {
            addCriterion("cholesterol is not null");
            return (Criteria) this;
        }

        public Criteria andCholesterolEqualTo(String value) {
            addCriterion("cholesterol =", value, "cholesterol");
            return (Criteria) this;
        }

        public Criteria andCholesterolNotEqualTo(String value) {
            addCriterion("cholesterol <>", value, "cholesterol");
            return (Criteria) this;
        }

        public Criteria andCholesterolGreaterThan(String value) {
            addCriterion("cholesterol >", value, "cholesterol");
            return (Criteria) this;
        }

        public Criteria andCholesterolGreaterThanOrEqualTo(String value) {
            addCriterion("cholesterol >=", value, "cholesterol");
            return (Criteria) this;
        }

        public Criteria andCholesterolLessThan(String value) {
            addCriterion("cholesterol <", value, "cholesterol");
            return (Criteria) this;
        }

        public Criteria andCholesterolLessThanOrEqualTo(String value) {
            addCriterion("cholesterol <=", value, "cholesterol");
            return (Criteria) this;
        }

        public Criteria andCholesterolLike(String value) {
            addCriterion("cholesterol like", value, "cholesterol");
            return (Criteria) this;
        }

        public Criteria andCholesterolNotLike(String value) {
            addCriterion("cholesterol not like", value, "cholesterol");
            return (Criteria) this;
        }

        public Criteria andCholesterolIn(List<String> values) {
            addCriterion("cholesterol in", values, "cholesterol");
            return (Criteria) this;
        }

        public Criteria andCholesterolNotIn(List<String> values) {
            addCriterion("cholesterol not in", values, "cholesterol");
            return (Criteria) this;
        }

        public Criteria andCholesterolBetween(String value1, String value2) {
            addCriterion("cholesterol between", value1, value2, "cholesterol");
            return (Criteria) this;
        }

        public Criteria andCholesterolNotBetween(String value1, String value2) {
            addCriterion("cholesterol not between", value1, value2, "cholesterol");
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

        public Criteria andFoodPhotoIsNull() {
            addCriterion("food_photo is null");
            return (Criteria) this;
        }

        public Criteria andFoodPhotoIsNotNull() {
            addCriterion("food_photo is not null");
            return (Criteria) this;
        }

        public Criteria andFoodPhotoEqualTo(String value) {
            addCriterion("food_photo =", value, "foodPhoto");
            return (Criteria) this;
        }

        public Criteria andFoodPhotoNotEqualTo(String value) {
            addCriterion("food_photo <>", value, "foodPhoto");
            return (Criteria) this;
        }

        public Criteria andFoodPhotoGreaterThan(String value) {
            addCriterion("food_photo >", value, "foodPhoto");
            return (Criteria) this;
        }

        public Criteria andFoodPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("food_photo >=", value, "foodPhoto");
            return (Criteria) this;
        }

        public Criteria andFoodPhotoLessThan(String value) {
            addCriterion("food_photo <", value, "foodPhoto");
            return (Criteria) this;
        }

        public Criteria andFoodPhotoLessThanOrEqualTo(String value) {
            addCriterion("food_photo <=", value, "foodPhoto");
            return (Criteria) this;
        }

        public Criteria andFoodPhotoLike(String value) {
            addCriterion("food_photo like", value, "foodPhoto");
            return (Criteria) this;
        }

        public Criteria andFoodPhotoNotLike(String value) {
            addCriterion("food_photo not like", value, "foodPhoto");
            return (Criteria) this;
        }

        public Criteria andFoodPhotoIn(List<String> values) {
            addCriterion("food_photo in", values, "foodPhoto");
            return (Criteria) this;
        }

        public Criteria andFoodPhotoNotIn(List<String> values) {
            addCriterion("food_photo not in", values, "foodPhoto");
            return (Criteria) this;
        }

        public Criteria andFoodPhotoBetween(String value1, String value2) {
            addCriterion("food_photo between", value1, value2, "foodPhoto");
            return (Criteria) this;
        }

        public Criteria andFoodPhotoNotBetween(String value1, String value2) {
            addCriterion("food_photo not between", value1, value2, "foodPhoto");
            return (Criteria) this;
        }

        public Criteria andFoodSugarIsNull() {
            addCriterion("food_sugar is null");
            return (Criteria) this;
        }

        public Criteria andFoodSugarIsNotNull() {
            addCriterion("food_sugar is not null");
            return (Criteria) this;
        }

        public Criteria andFoodSugarEqualTo(String value) {
            addCriterion("food_sugar =", value, "foodSugar");
            return (Criteria) this;
        }

        public Criteria andFoodSugarNotEqualTo(String value) {
            addCriterion("food_sugar <>", value, "foodSugar");
            return (Criteria) this;
        }

        public Criteria andFoodSugarGreaterThan(String value) {
            addCriterion("food_sugar >", value, "foodSugar");
            return (Criteria) this;
        }

        public Criteria andFoodSugarGreaterThanOrEqualTo(String value) {
            addCriterion("food_sugar >=", value, "foodSugar");
            return (Criteria) this;
        }

        public Criteria andFoodSugarLessThan(String value) {
            addCriterion("food_sugar <", value, "foodSugar");
            return (Criteria) this;
        }

        public Criteria andFoodSugarLessThanOrEqualTo(String value) {
            addCriterion("food_sugar <=", value, "foodSugar");
            return (Criteria) this;
        }

        public Criteria andFoodSugarLike(String value) {
            addCriterion("food_sugar like", value, "foodSugar");
            return (Criteria) this;
        }

        public Criteria andFoodSugarNotLike(String value) {
            addCriterion("food_sugar not like", value, "foodSugar");
            return (Criteria) this;
        }

        public Criteria andFoodSugarIn(List<String> values) {
            addCriterion("food_sugar in", values, "foodSugar");
            return (Criteria) this;
        }

        public Criteria andFoodSugarNotIn(List<String> values) {
            addCriterion("food_sugar not in", values, "foodSugar");
            return (Criteria) this;
        }

        public Criteria andFoodSugarBetween(String value1, String value2) {
            addCriterion("food_sugar between", value1, value2, "foodSugar");
            return (Criteria) this;
        }

        public Criteria andFoodSugarNotBetween(String value1, String value2) {
            addCriterion("food_sugar not between", value1, value2, "foodSugar");
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