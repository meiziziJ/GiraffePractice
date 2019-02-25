package com.practice.ssm.mapper;

import com.practice.ssm.model.Book;
import com.practice.ssm.util.PageBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookMapper {
    int deleteByPrimaryKey(Integer bookId);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer bookId);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    List<Book> queryBooks(Book book);

    //List<Book> querySingleBook(Integer bookId);
}