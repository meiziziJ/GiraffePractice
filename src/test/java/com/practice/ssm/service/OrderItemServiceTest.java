package com.practice.ssm.service;

import com.practice.base.SpringJunitTest;
import com.practice.ssm.model.OrderItem;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Giraffe Wld
 * @site www.grf.com
 * @company grf公司
 * @create  2019-01-19 19:35
 */
public class OrderItemServiceTest extends SpringJunitTest {

    @Autowired
    private OrderItemService orderItemService;

    @Test
    public void querySingleOrderItem() {
        List<OrderItem> orderItems = this.orderItemService.querySingleOrderItem(1);
        System.out.println(orderItems);
    }
}