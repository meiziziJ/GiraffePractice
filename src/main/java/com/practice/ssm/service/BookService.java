package com.practice.ssm.service;

import com.practice.ssm.model.Book;
import com.practice.ssm.util.PageBean;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {
    int deleteByPrimaryKey(Integer bookId);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer bookId);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    /**
     * 该service层的方法，要想使得切入到切面，则必须遵循切面类的规则
     * @param book
     * @return
     */
    List<Book> queryBooksPager(Book book, PageBean pageBean);

    //List<Book> querySingleBook(Integer bookId);
}