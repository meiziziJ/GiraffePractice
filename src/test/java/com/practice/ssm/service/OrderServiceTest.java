package com.practice.ssm.service;

import com.practice.base.SpringJunitTest;
import com.practice.ssm.model.Order;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Giraffe Wld
 * @site www.grf.com
 * @company grf公司
 * @create  2019-01-19 19:11
 */
public class OrderServiceTest extends SpringJunitTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void querySingleOrder() {
        List<Order> orders =this.orderService.querySingleOrder(257);
        System.out.println(orders);
    }
}