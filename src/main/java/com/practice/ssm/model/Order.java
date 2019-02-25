package com.practice.ssm.model;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@ToString
public class Order {
    private Integer orderId;

    private String orderNo;

    private List<OrderItem> orderItems = new ArrayList<>();

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Order(Integer orderId, String orderNo) {
        this.orderId = orderId;
        this.orderNo = orderNo;
    }

    public Order() {
        super();
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}