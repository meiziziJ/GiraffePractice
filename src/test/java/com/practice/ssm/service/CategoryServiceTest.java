package com.practice.ssm.service;

import com.practice.base.SpringJunitTest;
import com.practice.ssm.model.Category;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Giraffe Wld
 * @site www.grf.com
 * @company grf公司
 * @create  2019-01-19 19:59
 */
public class CategoryServiceTest extends SpringJunitTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void querySingleCategory() {
        List<Category> categories = this.categoryService.querySingleCategory(1);
        System.out.println(categories);

    }
}