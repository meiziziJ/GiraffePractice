package com.practice.ssm.service;

import com.practice.ssm.model.Book;
import com.practice.ssm.model.Order;
import com.practice.ssm.util.PageBean;

import java.util.List;

public interface OrderService {
    int deleteByPrimaryKey(Integer orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> querySingleOrder(Integer orderId);
}