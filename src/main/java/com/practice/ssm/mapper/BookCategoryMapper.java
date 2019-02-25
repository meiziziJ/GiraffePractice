package com.practice.ssm.mapper;

import com.practice.ssm.model.BookCategory;

public interface BookCategoryMapper {
    int deleteByPrimaryKey(Integer bcid);

    int insert(BookCategory record);

    int insertSelective(BookCategory record);

    BookCategory selectByPrimaryKey(Integer bcid);

    int updateByPrimaryKeySelective(BookCategory record);

    int updateByPrimaryKey(BookCategory record);
}