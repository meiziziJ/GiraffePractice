package com.practice.ssm.service.impl;

import com.practice.ssm.mapper.BookMapper;
import com.practice.ssm.model.Book;
import com.practice.ssm.service.BookService;
import com.practice.ssm.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Giraffe Wld
 * @site www.grf.com
 * @company grf公司
 * @create  2019-01-15 11:53
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public int deleteByPrimaryKey(Integer bookId) {
        return this.bookMapper.deleteByPrimaryKey(bookId);
    }

    @Override
    public int insert(Book record) {
        return this.bookMapper.insert(record);
    }

    @Override
    public int insertSelective(Book record) {
        return this.bookMapper.insertSelective(record);
    }

    @Override
    public Book selectByPrimaryKey(Integer bookId) {
        return this.bookMapper.selectByPrimaryKey(bookId);
    }

    @Override
    public int updateByPrimaryKeySelective(Book record) {
        return this.bookMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Book record) {
        return this.bookMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Book> queryBooksPager(Book book, PageBean pageBean) {
        return this.bookMapper.queryBooks(book);
    }

    /*@Override
    public List<Book> querySingleBook(Integer bookId) {
        return this.bookMapper.querySingleBook(bookId);
    }*/
}
