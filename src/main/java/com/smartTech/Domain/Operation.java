package com.smartTech.Domain;

public class Operation {


    private Integer operationId;
    private Integer categoryId;
    private Integer userId;
    private Double price;
    private String rate;

    private Long operationDate;

    public Operation(Integer operationId, Integer categoryId, Integer userId, Double price, String rate, Long operationDate) {
        this.operationId = operationId;
        this.categoryId = categoryId;
        this.userId = userId;
        this.price = price;
        this.rate = rate;
        this.operationDate = operationDate;
    }

    public Integer getOperationId() {
        return operationId;
    }

    public void setOperationId(Integer operationId) {
        this.operationId = operationId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public Long getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Long operationDate) {
        this.operationDate = operationDate;
    }
}
