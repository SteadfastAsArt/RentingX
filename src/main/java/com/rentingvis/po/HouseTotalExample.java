package com.rentingvis.po;

import java.util.ArrayList;
import java.util.List;

public class HouseTotalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HouseTotalExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCommnameIsNull() {
            addCriterion("commname is null");
            return (Criteria) this;
        }

        public Criteria andCommnameIsNotNull() {
            addCriterion("commname is not null");
            return (Criteria) this;
        }

        public Criteria andCommnameEqualTo(String value) {
            addCriterion("commname =", value, "commname");
            return (Criteria) this;
        }

        public Criteria andCommnameNotEqualTo(String value) {
            addCriterion("commname <>", value, "commname");
            return (Criteria) this;
        }

        public Criteria andCommnameGreaterThan(String value) {
            addCriterion("commname >", value, "commname");
            return (Criteria) this;
        }

        public Criteria andCommnameGreaterThanOrEqualTo(String value) {
            addCriterion("commname >=", value, "commname");
            return (Criteria) this;
        }

        public Criteria andCommnameLessThan(String value) {
            addCriterion("commname <", value, "commname");
            return (Criteria) this;
        }

        public Criteria andCommnameLessThanOrEqualTo(String value) {
            addCriterion("commname <=", value, "commname");
            return (Criteria) this;
        }

        public Criteria andCommnameLike(String value) {
            addCriterion("commname like", value, "commname");
            return (Criteria) this;
        }

        public Criteria andCommnameNotLike(String value) {
            addCriterion("commname not like", value, "commname");
            return (Criteria) this;
        }

        public Criteria andCommnameIn(List<String> values) {
            addCriterion("commname in", values, "commname");
            return (Criteria) this;
        }

        public Criteria andCommnameNotIn(List<String> values) {
            addCriterion("commname not in", values, "commname");
            return (Criteria) this;
        }

        public Criteria andCommnameBetween(String value1, String value2) {
            addCriterion("commname between", value1, value2, "commname");
            return (Criteria) this;
        }

        public Criteria andCommnameNotBetween(String value1, String value2) {
            addCriterion("commname not between", value1, value2, "commname");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Double value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Double value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Double value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Double value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Double value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Double> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Double> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Double value1, Double value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Double value1, Double value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andStructureIsNull() {
            addCriterion("structure is null");
            return (Criteria) this;
        }

        public Criteria andStructureIsNotNull() {
            addCriterion("structure is not null");
            return (Criteria) this;
        }

        public Criteria andStructureEqualTo(String value) {
            addCriterion("structure =", value, "structure");
            return (Criteria) this;
        }

        public Criteria andStructureNotEqualTo(String value) {
            addCriterion("structure <>", value, "structure");
            return (Criteria) this;
        }

        public Criteria andStructureGreaterThan(String value) {
            addCriterion("structure >", value, "structure");
            return (Criteria) this;
        }

        public Criteria andStructureGreaterThanOrEqualTo(String value) {
            addCriterion("structure >=", value, "structure");
            return (Criteria) this;
        }

        public Criteria andStructureLessThan(String value) {
            addCriterion("structure <", value, "structure");
            return (Criteria) this;
        }

        public Criteria andStructureLessThanOrEqualTo(String value) {
            addCriterion("structure <=", value, "structure");
            return (Criteria) this;
        }

        public Criteria andStructureLike(String value) {
            addCriterion("structure like", value, "structure");
            return (Criteria) this;
        }

        public Criteria andStructureNotLike(String value) {
            addCriterion("structure not like", value, "structure");
            return (Criteria) this;
        }

        public Criteria andStructureIn(List<String> values) {
            addCriterion("structure in", values, "structure");
            return (Criteria) this;
        }

        public Criteria andStructureNotIn(List<String> values) {
            addCriterion("structure not in", values, "structure");
            return (Criteria) this;
        }

        public Criteria andStructureBetween(String value1, String value2) {
            addCriterion("structure between", value1, value2, "structure");
            return (Criteria) this;
        }

        public Criteria andStructureNotBetween(String value1, String value2) {
            addCriterion("structure not between", value1, value2, "structure");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(Double value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(Double value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(Double value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(Double value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(Double value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(Double value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<Double> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<Double> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(Double value1, Double value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(Double value1, Double value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andHpartIsNull() {
            addCriterion("hpart is null");
            return (Criteria) this;
        }

        public Criteria andHpartIsNotNull() {
            addCriterion("hpart is not null");
            return (Criteria) this;
        }

        public Criteria andHpartEqualTo(String value) {
            addCriterion("hpart =", value, "hpart");
            return (Criteria) this;
        }

        public Criteria andHpartNotEqualTo(String value) {
            addCriterion("hpart <>", value, "hpart");
            return (Criteria) this;
        }

        public Criteria andHpartGreaterThan(String value) {
            addCriterion("hpart >", value, "hpart");
            return (Criteria) this;
        }

        public Criteria andHpartGreaterThanOrEqualTo(String value) {
            addCriterion("hpart >=", value, "hpart");
            return (Criteria) this;
        }

        public Criteria andHpartLessThan(String value) {
            addCriterion("hpart <", value, "hpart");
            return (Criteria) this;
        }

        public Criteria andHpartLessThanOrEqualTo(String value) {
            addCriterion("hpart <=", value, "hpart");
            return (Criteria) this;
        }

        public Criteria andHpartLike(String value) {
            addCriterion("hpart like", value, "hpart");
            return (Criteria) this;
        }

        public Criteria andHpartNotLike(String value) {
            addCriterion("hpart not like", value, "hpart");
            return (Criteria) this;
        }

        public Criteria andHpartIn(List<String> values) {
            addCriterion("hpart in", values, "hpart");
            return (Criteria) this;
        }

        public Criteria andHpartNotIn(List<String> values) {
            addCriterion("hpart not in", values, "hpart");
            return (Criteria) this;
        }

        public Criteria andHpartBetween(String value1, String value2) {
            addCriterion("hpart between", value1, value2, "hpart");
            return (Criteria) this;
        }

        public Criteria andHpartNotBetween(String value1, String value2) {
            addCriterion("hpart not between", value1, value2, "hpart");
            return (Criteria) this;
        }

        public Criteria andDirectionIsNull() {
            addCriterion("direction is null");
            return (Criteria) this;
        }

        public Criteria andDirectionIsNotNull() {
            addCriterion("direction is not null");
            return (Criteria) this;
        }

        public Criteria andDirectionEqualTo(String value) {
            addCriterion("direction =", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotEqualTo(String value) {
            addCriterion("direction <>", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionGreaterThan(String value) {
            addCriterion("direction >", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionGreaterThanOrEqualTo(String value) {
            addCriterion("direction >=", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionLessThan(String value) {
            addCriterion("direction <", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionLessThanOrEqualTo(String value) {
            addCriterion("direction <=", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionLike(String value) {
            addCriterion("direction like", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotLike(String value) {
            addCriterion("direction not like", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionIn(List<String> values) {
            addCriterion("direction in", values, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotIn(List<String> values) {
            addCriterion("direction not in", values, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionBetween(String value1, String value2) {
            addCriterion("direction between", value1, value2, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotBetween(String value1, String value2) {
            addCriterion("direction not between", value1, value2, "direction");
            return (Criteria) this;
        }

        public Criteria andDecorationIsNull() {
            addCriterion("decoration is null");
            return (Criteria) this;
        }

        public Criteria andDecorationIsNotNull() {
            addCriterion("decoration is not null");
            return (Criteria) this;
        }

        public Criteria andDecorationEqualTo(String value) {
            addCriterion("decoration =", value, "decoration");
            return (Criteria) this;
        }

        public Criteria andDecorationNotEqualTo(String value) {
            addCriterion("decoration <>", value, "decoration");
            return (Criteria) this;
        }

        public Criteria andDecorationGreaterThan(String value) {
            addCriterion("decoration >", value, "decoration");
            return (Criteria) this;
        }

        public Criteria andDecorationGreaterThanOrEqualTo(String value) {
            addCriterion("decoration >=", value, "decoration");
            return (Criteria) this;
        }

        public Criteria andDecorationLessThan(String value) {
            addCriterion("decoration <", value, "decoration");
            return (Criteria) this;
        }

        public Criteria andDecorationLessThanOrEqualTo(String value) {
            addCriterion("decoration <=", value, "decoration");
            return (Criteria) this;
        }

        public Criteria andDecorationLike(String value) {
            addCriterion("decoration like", value, "decoration");
            return (Criteria) this;
        }

        public Criteria andDecorationNotLike(String value) {
            addCriterion("decoration not like", value, "decoration");
            return (Criteria) this;
        }

        public Criteria andDecorationIn(List<String> values) {
            addCriterion("decoration in", values, "decoration");
            return (Criteria) this;
        }

        public Criteria andDecorationNotIn(List<String> values) {
            addCriterion("decoration not in", values, "decoration");
            return (Criteria) this;
        }

        public Criteria andDecorationBetween(String value1, String value2) {
            addCriterion("decoration between", value1, value2, "decoration");
            return (Criteria) this;
        }

        public Criteria andDecorationNotBetween(String value1, String value2) {
            addCriterion("decoration not between", value1, value2, "decoration");
            return (Criteria) this;
        }

        public Criteria andXIsNull() {
            addCriterion("x is null");
            return (Criteria) this;
        }

        public Criteria andXIsNotNull() {
            addCriterion("x is not null");
            return (Criteria) this;
        }

        public Criteria andXEqualTo(Double value) {
            addCriterion("x =", value, "x");
            return (Criteria) this;
        }

        public Criteria andXNotEqualTo(Double value) {
            addCriterion("x <>", value, "x");
            return (Criteria) this;
        }

        public Criteria andXGreaterThan(Double value) {
            addCriterion("x >", value, "x");
            return (Criteria) this;
        }

        public Criteria andXGreaterThanOrEqualTo(Double value) {
            addCriterion("x >=", value, "x");
            return (Criteria) this;
        }

        public Criteria andXLessThan(Double value) {
            addCriterion("x <", value, "x");
            return (Criteria) this;
        }

        public Criteria andXLessThanOrEqualTo(Double value) {
            addCriterion("x <=", value, "x");
            return (Criteria) this;
        }

        public Criteria andXIn(List<Double> values) {
            addCriterion("x in", values, "x");
            return (Criteria) this;
        }

        public Criteria andXNotIn(List<Double> values) {
            addCriterion("x not in", values, "x");
            return (Criteria) this;
        }

        public Criteria andXBetween(Double value1, Double value2) {
            addCriterion("x between", value1, value2, "x");
            return (Criteria) this;
        }

        public Criteria andXNotBetween(Double value1, Double value2) {
            addCriterion("x not between", value1, value2, "x");
            return (Criteria) this;
        }

        public Criteria andYIsNull() {
            addCriterion("y is null");
            return (Criteria) this;
        }

        public Criteria andYIsNotNull() {
            addCriterion("y is not null");
            return (Criteria) this;
        }

        public Criteria andYEqualTo(Double value) {
            addCriterion("y =", value, "y");
            return (Criteria) this;
        }

        public Criteria andYNotEqualTo(Double value) {
            addCriterion("y <>", value, "y");
            return (Criteria) this;
        }

        public Criteria andYGreaterThan(Double value) {
            addCriterion("y >", value, "y");
            return (Criteria) this;
        }

        public Criteria andYGreaterThanOrEqualTo(Double value) {
            addCriterion("y >=", value, "y");
            return (Criteria) this;
        }

        public Criteria andYLessThan(Double value) {
            addCriterion("y <", value, "y");
            return (Criteria) this;
        }

        public Criteria andYLessThanOrEqualTo(Double value) {
            addCriterion("y <=", value, "y");
            return (Criteria) this;
        }

        public Criteria andYIn(List<Double> values) {
            addCriterion("y in", values, "y");
            return (Criteria) this;
        }

        public Criteria andYNotIn(List<Double> values) {
            addCriterion("y not in", values, "y");
            return (Criteria) this;
        }

        public Criteria andYBetween(Double value1, Double value2) {
            addCriterion("y between", value1, value2, "y");
            return (Criteria) this;
        }

        public Criteria andYNotBetween(Double value1, Double value2) {
            addCriterion("y not between", value1, value2, "y");
            return (Criteria) this;
        }

        public Criteria andLatIsNull() {
            addCriterion("lat is null");
            return (Criteria) this;
        }

        public Criteria andLatIsNotNull() {
            addCriterion("lat is not null");
            return (Criteria) this;
        }

        public Criteria andLatEqualTo(Double value) {
            addCriterion("lat =", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotEqualTo(Double value) {
            addCriterion("lat <>", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThan(Double value) {
            addCriterion("lat >", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThanOrEqualTo(Double value) {
            addCriterion("lat >=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThan(Double value) {
            addCriterion("lat <", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThanOrEqualTo(Double value) {
            addCriterion("lat <=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatIn(List<Double> values) {
            addCriterion("lat in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotIn(List<Double> values) {
            addCriterion("lat not in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatBetween(Double value1, Double value2) {
            addCriterion("lat between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotBetween(Double value1, Double value2) {
            addCriterion("lat not between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andLonIsNull() {
            addCriterion("lon is null");
            return (Criteria) this;
        }

        public Criteria andLonIsNotNull() {
            addCriterion("lon is not null");
            return (Criteria) this;
        }

        public Criteria andLonEqualTo(Double value) {
            addCriterion("lon =", value, "lon");
            return (Criteria) this;
        }

        public Criteria andLonNotEqualTo(Double value) {
            addCriterion("lon <>", value, "lon");
            return (Criteria) this;
        }

        public Criteria andLonGreaterThan(Double value) {
            addCriterion("lon >", value, "lon");
            return (Criteria) this;
        }

        public Criteria andLonGreaterThanOrEqualTo(Double value) {
            addCriterion("lon >=", value, "lon");
            return (Criteria) this;
        }

        public Criteria andLonLessThan(Double value) {
            addCriterion("lon <", value, "lon");
            return (Criteria) this;
        }

        public Criteria andLonLessThanOrEqualTo(Double value) {
            addCriterion("lon <=", value, "lon");
            return (Criteria) this;
        }

        public Criteria andLonIn(List<Double> values) {
            addCriterion("lon in", values, "lon");
            return (Criteria) this;
        }

        public Criteria andLonNotIn(List<Double> values) {
            addCriterion("lon not in", values, "lon");
            return (Criteria) this;
        }

        public Criteria andLonBetween(Double value1, Double value2) {
            addCriterion("lon between", value1, value2, "lon");
            return (Criteria) this;
        }

        public Criteria andLonNotBetween(Double value1, Double value2) {
            addCriterion("lon not between", value1, value2, "lon");
            return (Criteria) this;
        }

        public Criteria andPriceperIsNull() {
            addCriterion("priceper is null");
            return (Criteria) this;
        }

        public Criteria andPriceperIsNotNull() {
            addCriterion("priceper is not null");
            return (Criteria) this;
        }

        public Criteria andPriceperEqualTo(Double value) {
            addCriterion("priceper =", value, "priceper");
            return (Criteria) this;
        }

        public Criteria andPriceperNotEqualTo(Double value) {
            addCriterion("priceper <>", value, "priceper");
            return (Criteria) this;
        }

        public Criteria andPriceperGreaterThan(Double value) {
            addCriterion("priceper >", value, "priceper");
            return (Criteria) this;
        }

        public Criteria andPriceperGreaterThanOrEqualTo(Double value) {
            addCriterion("priceper >=", value, "priceper");
            return (Criteria) this;
        }

        public Criteria andPriceperLessThan(Double value) {
            addCriterion("priceper <", value, "priceper");
            return (Criteria) this;
        }

        public Criteria andPriceperLessThanOrEqualTo(Double value) {
            addCriterion("priceper <=", value, "priceper");
            return (Criteria) this;
        }

        public Criteria andPriceperIn(List<Double> values) {
            addCriterion("priceper in", values, "priceper");
            return (Criteria) this;
        }

        public Criteria andPriceperNotIn(List<Double> values) {
            addCriterion("priceper not in", values, "priceper");
            return (Criteria) this;
        }

        public Criteria andPriceperBetween(Double value1, Double value2) {
            addCriterion("priceper between", value1, value2, "priceper");
            return (Criteria) this;
        }

        public Criteria andPriceperNotBetween(Double value1, Double value2) {
            addCriterion("priceper not between", value1, value2, "priceper");
            return (Criteria) this;
        }

        public Criteria andPricescoleIsNull() {
            addCriterion("pricescole is null");
            return (Criteria) this;
        }

        public Criteria andPricescoleIsNotNull() {
            addCriterion("pricescole is not null");
            return (Criteria) this;
        }

        public Criteria andPricescoleEqualTo(Double value) {
            addCriterion("pricescole =", value, "pricescole");
            return (Criteria) this;
        }

        public Criteria andPricescoleNotEqualTo(Double value) {
            addCriterion("pricescole <>", value, "pricescole");
            return (Criteria) this;
        }

        public Criteria andPricescoleGreaterThan(Double value) {
            addCriterion("pricescole >", value, "pricescole");
            return (Criteria) this;
        }

        public Criteria andPricescoleGreaterThanOrEqualTo(Double value) {
            addCriterion("pricescole >=", value, "pricescole");
            return (Criteria) this;
        }

        public Criteria andPricescoleLessThan(Double value) {
            addCriterion("pricescole <", value, "pricescole");
            return (Criteria) this;
        }

        public Criteria andPricescoleLessThanOrEqualTo(Double value) {
            addCriterion("pricescole <=", value, "pricescole");
            return (Criteria) this;
        }

        public Criteria andPricescoleIn(List<Double> values) {
            addCriterion("pricescole in", values, "pricescole");
            return (Criteria) this;
        }

        public Criteria andPricescoleNotIn(List<Double> values) {
            addCriterion("pricescole not in", values, "pricescole");
            return (Criteria) this;
        }

        public Criteria andPricescoleBetween(Double value1, Double value2) {
            addCriterion("pricescole between", value1, value2, "pricescole");
            return (Criteria) this;
        }

        public Criteria andPricescoleNotBetween(Double value1, Double value2) {
            addCriterion("pricescole not between", value1, value2, "pricescole");
            return (Criteria) this;
        }

        public Criteria andDecorationscoleIsNull() {
            addCriterion("decorationscole is null");
            return (Criteria) this;
        }

        public Criteria andDecorationscoleIsNotNull() {
            addCriterion("decorationscole is not null");
            return (Criteria) this;
        }

        public Criteria andDecorationscoleEqualTo(Double value) {
            addCriterion("decorationscole =", value, "decorationscole");
            return (Criteria) this;
        }

        public Criteria andDecorationscoleNotEqualTo(Double value) {
            addCriterion("decorationscole <>", value, "decorationscole");
            return (Criteria) this;
        }

        public Criteria andDecorationscoleGreaterThan(Double value) {
            addCriterion("decorationscole >", value, "decorationscole");
            return (Criteria) this;
        }

        public Criteria andDecorationscoleGreaterThanOrEqualTo(Double value) {
            addCriterion("decorationscole >=", value, "decorationscole");
            return (Criteria) this;
        }

        public Criteria andDecorationscoleLessThan(Double value) {
            addCriterion("decorationscole <", value, "decorationscole");
            return (Criteria) this;
        }

        public Criteria andDecorationscoleLessThanOrEqualTo(Double value) {
            addCriterion("decorationscole <=", value, "decorationscole");
            return (Criteria) this;
        }

        public Criteria andDecorationscoleIn(List<Double> values) {
            addCriterion("decorationscole in", values, "decorationscole");
            return (Criteria) this;
        }

        public Criteria andDecorationscoleNotIn(List<Double> values) {
            addCriterion("decorationscole not in", values, "decorationscole");
            return (Criteria) this;
        }

        public Criteria andDecorationscoleBetween(Double value1, Double value2) {
            addCriterion("decorationscole between", value1, value2, "decorationscole");
            return (Criteria) this;
        }

        public Criteria andDecorationscoleNotBetween(Double value1, Double value2) {
            addCriterion("decorationscole not between", value1, value2, "decorationscole");
            return (Criteria) this;
        }

        public Criteria andHeightscoleIsNull() {
            addCriterion("heightscole is null");
            return (Criteria) this;
        }

        public Criteria andHeightscoleIsNotNull() {
            addCriterion("heightscole is not null");
            return (Criteria) this;
        }

        public Criteria andHeightscoleEqualTo(Double value) {
            addCriterion("heightscole =", value, "heightscole");
            return (Criteria) this;
        }

        public Criteria andHeightscoleNotEqualTo(Double value) {
            addCriterion("heightscole <>", value, "heightscole");
            return (Criteria) this;
        }

        public Criteria andHeightscoleGreaterThan(Double value) {
            addCriterion("heightscole >", value, "heightscole");
            return (Criteria) this;
        }

        public Criteria andHeightscoleGreaterThanOrEqualTo(Double value) {
            addCriterion("heightscole >=", value, "heightscole");
            return (Criteria) this;
        }

        public Criteria andHeightscoleLessThan(Double value) {
            addCriterion("heightscole <", value, "heightscole");
            return (Criteria) this;
        }

        public Criteria andHeightscoleLessThanOrEqualTo(Double value) {
            addCriterion("heightscole <=", value, "heightscole");
            return (Criteria) this;
        }

        public Criteria andHeightscoleIn(List<Double> values) {
            addCriterion("heightscole in", values, "heightscole");
            return (Criteria) this;
        }

        public Criteria andHeightscoleNotIn(List<Double> values) {
            addCriterion("heightscole not in", values, "heightscole");
            return (Criteria) this;
        }

        public Criteria andHeightscoleBetween(Double value1, Double value2) {
            addCriterion("heightscole between", value1, value2, "heightscole");
            return (Criteria) this;
        }

        public Criteria andHeightscoleNotBetween(Double value1, Double value2) {
            addCriterion("heightscole not between", value1, value2, "heightscole");
            return (Criteria) this;
        }

        public Criteria andDirectionscoleIsNull() {
            addCriterion("directionscole is null");
            return (Criteria) this;
        }

        public Criteria andDirectionscoleIsNotNull() {
            addCriterion("directionscole is not null");
            return (Criteria) this;
        }

        public Criteria andDirectionscoleEqualTo(Double value) {
            addCriterion("directionscole =", value, "directionscole");
            return (Criteria) this;
        }

        public Criteria andDirectionscoleNotEqualTo(Double value) {
            addCriterion("directionscole <>", value, "directionscole");
            return (Criteria) this;
        }

        public Criteria andDirectionscoleGreaterThan(Double value) {
            addCriterion("directionscole >", value, "directionscole");
            return (Criteria) this;
        }

        public Criteria andDirectionscoleGreaterThanOrEqualTo(Double value) {
            addCriterion("directionscole >=", value, "directionscole");
            return (Criteria) this;
        }

        public Criteria andDirectionscoleLessThan(Double value) {
            addCriterion("directionscole <", value, "directionscole");
            return (Criteria) this;
        }

        public Criteria andDirectionscoleLessThanOrEqualTo(Double value) {
            addCriterion("directionscole <=", value, "directionscole");
            return (Criteria) this;
        }

        public Criteria andDirectionscoleIn(List<Double> values) {
            addCriterion("directionscole in", values, "directionscole");
            return (Criteria) this;
        }

        public Criteria andDirectionscoleNotIn(List<Double> values) {
            addCriterion("directionscole not in", values, "directionscole");
            return (Criteria) this;
        }

        public Criteria andDirectionscoleBetween(Double value1, Double value2) {
            addCriterion("directionscole between", value1, value2, "directionscole");
            return (Criteria) this;
        }

        public Criteria andDirectionscoleNotBetween(Double value1, Double value2) {
            addCriterion("directionscole not between", value1, value2, "directionscole");
            return (Criteria) this;
        }

        public Criteria andHousescoleIsNull() {
            addCriterion("housescole is null");
            return (Criteria) this;
        }

        public Criteria andHousescoleIsNotNull() {
            addCriterion("housescole is not null");
            return (Criteria) this;
        }

        public Criteria andHousescoleEqualTo(Double value) {
            addCriterion("housescole =", value, "housescole");
            return (Criteria) this;
        }

        public Criteria andHousescoleNotEqualTo(Double value) {
            addCriterion("housescole <>", value, "housescole");
            return (Criteria) this;
        }

        public Criteria andHousescoleGreaterThan(Double value) {
            addCriterion("housescole >", value, "housescole");
            return (Criteria) this;
        }

        public Criteria andHousescoleGreaterThanOrEqualTo(Double value) {
            addCriterion("housescole >=", value, "housescole");
            return (Criteria) this;
        }

        public Criteria andHousescoleLessThan(Double value) {
            addCriterion("housescole <", value, "housescole");
            return (Criteria) this;
        }

        public Criteria andHousescoleLessThanOrEqualTo(Double value) {
            addCriterion("housescole <=", value, "housescole");
            return (Criteria) this;
        }

        public Criteria andHousescoleIn(List<Double> values) {
            addCriterion("housescole in", values, "housescole");
            return (Criteria) this;
        }

        public Criteria andHousescoleNotIn(List<Double> values) {
            addCriterion("housescole not in", values, "housescole");
            return (Criteria) this;
        }

        public Criteria andHousescoleBetween(Double value1, Double value2) {
            addCriterion("housescole between", value1, value2, "housescole");
            return (Criteria) this;
        }

        public Criteria andHousescoleNotBetween(Double value1, Double value2) {
            addCriterion("housescole not between", value1, value2, "housescole");
            return (Criteria) this;
        }

        public Criteria andTransportscoleIsNull() {
            addCriterion("transportscole is null");
            return (Criteria) this;
        }

        public Criteria andTransportscoleIsNotNull() {
            addCriterion("transportscole is not null");
            return (Criteria) this;
        }

        public Criteria andTransportscoleEqualTo(Double value) {
            addCriterion("transportscole =", value, "transportscole");
            return (Criteria) this;
        }

        public Criteria andTransportscoleNotEqualTo(Double value) {
            addCriterion("transportscole <>", value, "transportscole");
            return (Criteria) this;
        }

        public Criteria andTransportscoleGreaterThan(Double value) {
            addCriterion("transportscole >", value, "transportscole");
            return (Criteria) this;
        }

        public Criteria andTransportscoleGreaterThanOrEqualTo(Double value) {
            addCriterion("transportscole >=", value, "transportscole");
            return (Criteria) this;
        }

        public Criteria andTransportscoleLessThan(Double value) {
            addCriterion("transportscole <", value, "transportscole");
            return (Criteria) this;
        }

        public Criteria andTransportscoleLessThanOrEqualTo(Double value) {
            addCriterion("transportscole <=", value, "transportscole");
            return (Criteria) this;
        }

        public Criteria andTransportscoleIn(List<Double> values) {
            addCriterion("transportscole in", values, "transportscole");
            return (Criteria) this;
        }

        public Criteria andTransportscoleNotIn(List<Double> values) {
            addCriterion("transportscole not in", values, "transportscole");
            return (Criteria) this;
        }

        public Criteria andTransportscoleBetween(Double value1, Double value2) {
            addCriterion("transportscole between", value1, value2, "transportscole");
            return (Criteria) this;
        }

        public Criteria andTransportscoleNotBetween(Double value1, Double value2) {
            addCriterion("transportscole not between", value1, value2, "transportscole");
            return (Criteria) this;
        }

        public Criteria andEducationscoleIsNull() {
            addCriterion("educationscole is null");
            return (Criteria) this;
        }

        public Criteria andEducationscoleIsNotNull() {
            addCriterion("educationscole is not null");
            return (Criteria) this;
        }

        public Criteria andEducationscoleEqualTo(Double value) {
            addCriterion("educationscole =", value, "educationscole");
            return (Criteria) this;
        }

        public Criteria andEducationscoleNotEqualTo(Double value) {
            addCriterion("educationscole <>", value, "educationscole");
            return (Criteria) this;
        }

        public Criteria andEducationscoleGreaterThan(Double value) {
            addCriterion("educationscole >", value, "educationscole");
            return (Criteria) this;
        }

        public Criteria andEducationscoleGreaterThanOrEqualTo(Double value) {
            addCriterion("educationscole >=", value, "educationscole");
            return (Criteria) this;
        }

        public Criteria andEducationscoleLessThan(Double value) {
            addCriterion("educationscole <", value, "educationscole");
            return (Criteria) this;
        }

        public Criteria andEducationscoleLessThanOrEqualTo(Double value) {
            addCriterion("educationscole <=", value, "educationscole");
            return (Criteria) this;
        }

        public Criteria andEducationscoleIn(List<Double> values) {
            addCriterion("educationscole in", values, "educationscole");
            return (Criteria) this;
        }

        public Criteria andEducationscoleNotIn(List<Double> values) {
            addCriterion("educationscole not in", values, "educationscole");
            return (Criteria) this;
        }

        public Criteria andEducationscoleBetween(Double value1, Double value2) {
            addCriterion("educationscole between", value1, value2, "educationscole");
            return (Criteria) this;
        }

        public Criteria andEducationscoleNotBetween(Double value1, Double value2) {
            addCriterion("educationscole not between", value1, value2, "educationscole");
            return (Criteria) this;
        }

        public Criteria andTreatmentscoleIsNull() {
            addCriterion("treatmentscole is null");
            return (Criteria) this;
        }

        public Criteria andTreatmentscoleIsNotNull() {
            addCriterion("treatmentscole is not null");
            return (Criteria) this;
        }

        public Criteria andTreatmentscoleEqualTo(Double value) {
            addCriterion("treatmentscole =", value, "treatmentscole");
            return (Criteria) this;
        }

        public Criteria andTreatmentscoleNotEqualTo(Double value) {
            addCriterion("treatmentscole <>", value, "treatmentscole");
            return (Criteria) this;
        }

        public Criteria andTreatmentscoleGreaterThan(Double value) {
            addCriterion("treatmentscole >", value, "treatmentscole");
            return (Criteria) this;
        }

        public Criteria andTreatmentscoleGreaterThanOrEqualTo(Double value) {
            addCriterion("treatmentscole >=", value, "treatmentscole");
            return (Criteria) this;
        }

        public Criteria andTreatmentscoleLessThan(Double value) {
            addCriterion("treatmentscole <", value, "treatmentscole");
            return (Criteria) this;
        }

        public Criteria andTreatmentscoleLessThanOrEqualTo(Double value) {
            addCriterion("treatmentscole <=", value, "treatmentscole");
            return (Criteria) this;
        }

        public Criteria andTreatmentscoleIn(List<Double> values) {
            addCriterion("treatmentscole in", values, "treatmentscole");
            return (Criteria) this;
        }

        public Criteria andTreatmentscoleNotIn(List<Double> values) {
            addCriterion("treatmentscole not in", values, "treatmentscole");
            return (Criteria) this;
        }

        public Criteria andTreatmentscoleBetween(Double value1, Double value2) {
            addCriterion("treatmentscole between", value1, value2, "treatmentscole");
            return (Criteria) this;
        }

        public Criteria andTreatmentscoleNotBetween(Double value1, Double value2) {
            addCriterion("treatmentscole not between", value1, value2, "treatmentscole");
            return (Criteria) this;
        }

        public Criteria andShopscoleIsNull() {
            addCriterion("shopscole is null");
            return (Criteria) this;
        }

        public Criteria andShopscoleIsNotNull() {
            addCriterion("shopscole is not null");
            return (Criteria) this;
        }

        public Criteria andShopscoleEqualTo(Double value) {
            addCriterion("shopscole =", value, "shopscole");
            return (Criteria) this;
        }

        public Criteria andShopscoleNotEqualTo(Double value) {
            addCriterion("shopscole <>", value, "shopscole");
            return (Criteria) this;
        }

        public Criteria andShopscoleGreaterThan(Double value) {
            addCriterion("shopscole >", value, "shopscole");
            return (Criteria) this;
        }

        public Criteria andShopscoleGreaterThanOrEqualTo(Double value) {
            addCriterion("shopscole >=", value, "shopscole");
            return (Criteria) this;
        }

        public Criteria andShopscoleLessThan(Double value) {
            addCriterion("shopscole <", value, "shopscole");
            return (Criteria) this;
        }

        public Criteria andShopscoleLessThanOrEqualTo(Double value) {
            addCriterion("shopscole <=", value, "shopscole");
            return (Criteria) this;
        }

        public Criteria andShopscoleIn(List<Double> values) {
            addCriterion("shopscole in", values, "shopscole");
            return (Criteria) this;
        }

        public Criteria andShopscoleNotIn(List<Double> values) {
            addCriterion("shopscole not in", values, "shopscole");
            return (Criteria) this;
        }

        public Criteria andShopscoleBetween(Double value1, Double value2) {
            addCriterion("shopscole between", value1, value2, "shopscole");
            return (Criteria) this;
        }

        public Criteria andShopscoleNotBetween(Double value1, Double value2) {
            addCriterion("shopscole not between", value1, value2, "shopscole");
            return (Criteria) this;
        }

        public Criteria andLifescoleIsNull() {
            addCriterion("lifescole is null");
            return (Criteria) this;
        }

        public Criteria andLifescoleIsNotNull() {
            addCriterion("lifescole is not null");
            return (Criteria) this;
        }

        public Criteria andLifescoleEqualTo(Double value) {
            addCriterion("lifescole =", value, "lifescole");
            return (Criteria) this;
        }

        public Criteria andLifescoleNotEqualTo(Double value) {
            addCriterion("lifescole <>", value, "lifescole");
            return (Criteria) this;
        }

        public Criteria andLifescoleGreaterThan(Double value) {
            addCriterion("lifescole >", value, "lifescole");
            return (Criteria) this;
        }

        public Criteria andLifescoleGreaterThanOrEqualTo(Double value) {
            addCriterion("lifescole >=", value, "lifescole");
            return (Criteria) this;
        }

        public Criteria andLifescoleLessThan(Double value) {
            addCriterion("lifescole <", value, "lifescole");
            return (Criteria) this;
        }

        public Criteria andLifescoleLessThanOrEqualTo(Double value) {
            addCriterion("lifescole <=", value, "lifescole");
            return (Criteria) this;
        }

        public Criteria andLifescoleIn(List<Double> values) {
            addCriterion("lifescole in", values, "lifescole");
            return (Criteria) this;
        }

        public Criteria andLifescoleNotIn(List<Double> values) {
            addCriterion("lifescole not in", values, "lifescole");
            return (Criteria) this;
        }

        public Criteria andLifescoleBetween(Double value1, Double value2) {
            addCriterion("lifescole between", value1, value2, "lifescole");
            return (Criteria) this;
        }

        public Criteria andLifescoleNotBetween(Double value1, Double value2) {
            addCriterion("lifescole not between", value1, value2, "lifescole");
            return (Criteria) this;
        }

        public Criteria andEntertainmentscoleIsNull() {
            addCriterion("entertainmentscole is null");
            return (Criteria) this;
        }

        public Criteria andEntertainmentscoleIsNotNull() {
            addCriterion("entertainmentscole is not null");
            return (Criteria) this;
        }

        public Criteria andEntertainmentscoleEqualTo(Double value) {
            addCriterion("entertainmentscole =", value, "entertainmentscole");
            return (Criteria) this;
        }

        public Criteria andEntertainmentscoleNotEqualTo(Double value) {
            addCriterion("entertainmentscole <>", value, "entertainmentscole");
            return (Criteria) this;
        }

        public Criteria andEntertainmentscoleGreaterThan(Double value) {
            addCriterion("entertainmentscole >", value, "entertainmentscole");
            return (Criteria) this;
        }

        public Criteria andEntertainmentscoleGreaterThanOrEqualTo(Double value) {
            addCriterion("entertainmentscole >=", value, "entertainmentscole");
            return (Criteria) this;
        }

        public Criteria andEntertainmentscoleLessThan(Double value) {
            addCriterion("entertainmentscole <", value, "entertainmentscole");
            return (Criteria) this;
        }

        public Criteria andEntertainmentscoleLessThanOrEqualTo(Double value) {
            addCriterion("entertainmentscole <=", value, "entertainmentscole");
            return (Criteria) this;
        }

        public Criteria andEntertainmentscoleIn(List<Double> values) {
            addCriterion("entertainmentscole in", values, "entertainmentscole");
            return (Criteria) this;
        }

        public Criteria andEntertainmentscoleNotIn(List<Double> values) {
            addCriterion("entertainmentscole not in", values, "entertainmentscole");
            return (Criteria) this;
        }

        public Criteria andEntertainmentscoleBetween(Double value1, Double value2) {
            addCriterion("entertainmentscole between", value1, value2, "entertainmentscole");
            return (Criteria) this;
        }

        public Criteria andEntertainmentscoleNotBetween(Double value1, Double value2) {
            addCriterion("entertainmentscole not between", value1, value2, "entertainmentscole");
            return (Criteria) this;
        }

        public Criteria andFinancescoleIsNull() {
            addCriterion("financescole is null");
            return (Criteria) this;
        }

        public Criteria andFinancescoleIsNotNull() {
            addCriterion("financescole is not null");
            return (Criteria) this;
        }

        public Criteria andFinancescoleEqualTo(Double value) {
            addCriterion("financescole =", value, "financescole");
            return (Criteria) this;
        }

        public Criteria andFinancescoleNotEqualTo(Double value) {
            addCriterion("financescole <>", value, "financescole");
            return (Criteria) this;
        }

        public Criteria andFinancescoleGreaterThan(Double value) {
            addCriterion("financescole >", value, "financescole");
            return (Criteria) this;
        }

        public Criteria andFinancescoleGreaterThanOrEqualTo(Double value) {
            addCriterion("financescole >=", value, "financescole");
            return (Criteria) this;
        }

        public Criteria andFinancescoleLessThan(Double value) {
            addCriterion("financescole <", value, "financescole");
            return (Criteria) this;
        }

        public Criteria andFinancescoleLessThanOrEqualTo(Double value) {
            addCriterion("financescole <=", value, "financescole");
            return (Criteria) this;
        }

        public Criteria andFinancescoleIn(List<Double> values) {
            addCriterion("financescole in", values, "financescole");
            return (Criteria) this;
        }

        public Criteria andFinancescoleNotIn(List<Double> values) {
            addCriterion("financescole not in", values, "financescole");
            return (Criteria) this;
        }

        public Criteria andFinancescoleBetween(Double value1, Double value2) {
            addCriterion("financescole between", value1, value2, "financescole");
            return (Criteria) this;
        }

        public Criteria andFinancescoleNotBetween(Double value1, Double value2) {
            addCriterion("financescole not between", value1, value2, "financescole");
            return (Criteria) this;
        }

        public Criteria andServicescoleIsNull() {
            addCriterion("servicescole is null");
            return (Criteria) this;
        }

        public Criteria andServicescoleIsNotNull() {
            addCriterion("servicescole is not null");
            return (Criteria) this;
        }

        public Criteria andServicescoleEqualTo(Double value) {
            addCriterion("servicescole =", value, "servicescole");
            return (Criteria) this;
        }

        public Criteria andServicescoleNotEqualTo(Double value) {
            addCriterion("servicescole <>", value, "servicescole");
            return (Criteria) this;
        }

        public Criteria andServicescoleGreaterThan(Double value) {
            addCriterion("servicescole >", value, "servicescole");
            return (Criteria) this;
        }

        public Criteria andServicescoleGreaterThanOrEqualTo(Double value) {
            addCriterion("servicescole >=", value, "servicescole");
            return (Criteria) this;
        }

        public Criteria andServicescoleLessThan(Double value) {
            addCriterion("servicescole <", value, "servicescole");
            return (Criteria) this;
        }

        public Criteria andServicescoleLessThanOrEqualTo(Double value) {
            addCriterion("servicescole <=", value, "servicescole");
            return (Criteria) this;
        }

        public Criteria andServicescoleIn(List<Double> values) {
            addCriterion("servicescole in", values, "servicescole");
            return (Criteria) this;
        }

        public Criteria andServicescoleNotIn(List<Double> values) {
            addCriterion("servicescole not in", values, "servicescole");
            return (Criteria) this;
        }

        public Criteria andServicescoleBetween(Double value1, Double value2) {
            addCriterion("servicescole between", value1, value2, "servicescole");
            return (Criteria) this;
        }

        public Criteria andServicescoleNotBetween(Double value1, Double value2) {
            addCriterion("servicescole not between", value1, value2, "servicescole");
            return (Criteria) this;
        }

        public Criteria andEnvironmentscoleIsNull() {
            addCriterion("environmentscole is null");
            return (Criteria) this;
        }

        public Criteria andEnvironmentscoleIsNotNull() {
            addCriterion("environmentscole is not null");
            return (Criteria) this;
        }

        public Criteria andEnvironmentscoleEqualTo(Double value) {
            addCriterion("environmentscole =", value, "environmentscole");
            return (Criteria) this;
        }

        public Criteria andEnvironmentscoleNotEqualTo(Double value) {
            addCriterion("environmentscole <>", value, "environmentscole");
            return (Criteria) this;
        }

        public Criteria andEnvironmentscoleGreaterThan(Double value) {
            addCriterion("environmentscole >", value, "environmentscole");
            return (Criteria) this;
        }

        public Criteria andEnvironmentscoleGreaterThanOrEqualTo(Double value) {
            addCriterion("environmentscole >=", value, "environmentscole");
            return (Criteria) this;
        }

        public Criteria andEnvironmentscoleLessThan(Double value) {
            addCriterion("environmentscole <", value, "environmentscole");
            return (Criteria) this;
        }

        public Criteria andEnvironmentscoleLessThanOrEqualTo(Double value) {
            addCriterion("environmentscole <=", value, "environmentscole");
            return (Criteria) this;
        }

        public Criteria andEnvironmentscoleIn(List<Double> values) {
            addCriterion("environmentscole in", values, "environmentscole");
            return (Criteria) this;
        }

        public Criteria andEnvironmentscoleNotIn(List<Double> values) {
            addCriterion("environmentscole not in", values, "environmentscole");
            return (Criteria) this;
        }

        public Criteria andEnvironmentscoleBetween(Double value1, Double value2) {
            addCriterion("environmentscole between", value1, value2, "environmentscole");
            return (Criteria) this;
        }

        public Criteria andEnvironmentscoleNotBetween(Double value1, Double value2) {
            addCriterion("environmentscole not between", value1, value2, "environmentscole");
            return (Criteria) this;
        }

        public Criteria andLocationscoleIsNull() {
            addCriterion("locationscole is null");
            return (Criteria) this;
        }

        public Criteria andLocationscoleIsNotNull() {
            addCriterion("locationscole is not null");
            return (Criteria) this;
        }

        public Criteria andLocationscoleEqualTo(Double value) {
            addCriterion("locationscole =", value, "locationscole");
            return (Criteria) this;
        }

        public Criteria andLocationscoleNotEqualTo(Double value) {
            addCriterion("locationscole <>", value, "locationscole");
            return (Criteria) this;
        }

        public Criteria andLocationscoleGreaterThan(Double value) {
            addCriterion("locationscole >", value, "locationscole");
            return (Criteria) this;
        }

        public Criteria andLocationscoleGreaterThanOrEqualTo(Double value) {
            addCriterion("locationscole >=", value, "locationscole");
            return (Criteria) this;
        }

        public Criteria andLocationscoleLessThan(Double value) {
            addCriterion("locationscole <", value, "locationscole");
            return (Criteria) this;
        }

        public Criteria andLocationscoleLessThanOrEqualTo(Double value) {
            addCriterion("locationscole <=", value, "locationscole");
            return (Criteria) this;
        }

        public Criteria andLocationscoleIn(List<Double> values) {
            addCriterion("locationscole in", values, "locationscole");
            return (Criteria) this;
        }

        public Criteria andLocationscoleNotIn(List<Double> values) {
            addCriterion("locationscole not in", values, "locationscole");
            return (Criteria) this;
        }

        public Criteria andLocationscoleBetween(Double value1, Double value2) {
            addCriterion("locationscole between", value1, value2, "locationscole");
            return (Criteria) this;
        }

        public Criteria andLocationscoleNotBetween(Double value1, Double value2) {
            addCriterion("locationscole not between", value1, value2, "locationscole");
            return (Criteria) this;
        }

        public Criteria andTotalscoleIsNull() {
            addCriterion("totalscole is null");
            return (Criteria) this;
        }

        public Criteria andTotalscoleIsNotNull() {
            addCriterion("totalscole is not null");
            return (Criteria) this;
        }

        public Criteria andTotalscoleEqualTo(Double value) {
            addCriterion("totalscole =", value, "totalscole");
            return (Criteria) this;
        }

        public Criteria andTotalscoleNotEqualTo(Double value) {
            addCriterion("totalscole <>", value, "totalscole");
            return (Criteria) this;
        }

        public Criteria andTotalscoleGreaterThan(Double value) {
            addCriterion("totalscole >", value, "totalscole");
            return (Criteria) this;
        }

        public Criteria andTotalscoleGreaterThanOrEqualTo(Double value) {
            addCriterion("totalscole >=", value, "totalscole");
            return (Criteria) this;
        }

        public Criteria andTotalscoleLessThan(Double value) {
            addCriterion("totalscole <", value, "totalscole");
            return (Criteria) this;
        }

        public Criteria andTotalscoleLessThanOrEqualTo(Double value) {
            addCriterion("totalscole <=", value, "totalscole");
            return (Criteria) this;
        }

        public Criteria andTotalscoleIn(List<Double> values) {
            addCriterion("totalscole in", values, "totalscole");
            return (Criteria) this;
        }

        public Criteria andTotalscoleNotIn(List<Double> values) {
            addCriterion("totalscole not in", values, "totalscole");
            return (Criteria) this;
        }

        public Criteria andTotalscoleBetween(Double value1, Double value2) {
            addCriterion("totalscole between", value1, value2, "totalscole");
            return (Criteria) this;
        }

        public Criteria andTotalscoleNotBetween(Double value1, Double value2) {
            addCriterion("totalscole not between", value1, value2, "totalscole");
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