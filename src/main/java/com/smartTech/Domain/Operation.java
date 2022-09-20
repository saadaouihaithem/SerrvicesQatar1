package com.smartTech.Domain;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Operation implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="operationId")
    private Long operationId;

    private Long categoryId;
    private Long userId;

    @NotNull
    @Column(name="price", nullable = false)
    private Double price;

    @NotNull
    @Column(name="rate", nullable = false)
    private String rate;

    private Long operationDate;



    public Operation(Long operationId, Long categoryId, Long userId, Double price, String rate, Long operationDate) {
        this.operationId = operationId;
        this.categoryId = categoryId;
        this.userId = userId;
        this.price = price;
        this.rate = rate;
        this.operationDate = operationDate;
    }

    public Operation() {

    }

    public Long getOperationId() {
        return operationId;
    }

    public void setOperationId(Long operationId) {
        this.operationId = operationId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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

    @Override
    public String toString() {
        return "Operation{" +
                "operationId=" + operationId +
                ", categoryId=" + categoryId +
                ", userId=" + userId +
                ", price=" + price +
                ", rate='" + rate + '\'' +
                ", operationDate=" + operationDate +
                '}';
    }
}
