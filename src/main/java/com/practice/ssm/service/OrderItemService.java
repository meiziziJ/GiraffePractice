package com.practice.ssm.service;

import com.practice.ssm.model.Order;
import com.practice.ssm.model.OrderItem;

import java.util.List;

public interface OrderItemService {
    int deleteByPrimaryKey(Integer orderItemId);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    OrderItem selectByPrimaryKey(Integer orderItemId);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);

    List<OrderItem> querySingleOrderItem(Integer orderItemId);
}