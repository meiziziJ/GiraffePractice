package com.practice.ssm.service.impl;

import com.practice.ssm.mapper.OrderItemMapper;
import com.practice.ssm.model.OrderItem;
import com.practice.ssm.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Giraffe Wld
 * @site www.grf.com
 * @company grf公司
 * @create  2019-01-19 19:34
 */
@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Override
    public int deleteByPrimaryKey(Integer orderItemId) {
        return 0;
    }

    @Override
    public int insert(OrderItem record) {
        return 0;
    }

    @Override
    public int insertSelective(OrderItem record) {
        return 0;
    }

    @Override
    public OrderItem selectByPrimaryKey(Integer orderItemId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(OrderItem record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(OrderItem record) {
        return 0;
    }

    @Override
    public List<OrderItem> querySingleOrderItem(Integer orderItemId) {
        return this.orderItemMapper.querySingleOrderItem(orderItemId);
    }
}
