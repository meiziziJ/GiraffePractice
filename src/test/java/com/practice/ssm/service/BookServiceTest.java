package com.practice.ssm.service;

import com.practice.base.SpringJunitTest;
import com.practice.ssm.model.Book;
import com.practice.ssm.util.PageBean;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Giraffe Wld
 * @site www.grf.com
 * @company grf公司
 * @create  2019-01-15 14:39
 */
public class BookServiceTest extends SpringJunitTest {
    @Autowired
    private BookService bookService;
    @Test
    public void deleteByPrimaryKey() {
        bookService.deleteByPrimaryKey(10);
    }

    @Test
    public void insert() {
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByPrimaryKey() {
        Book book = bookService.selectByPrimaryKey(1);
        System.out.println(book);
        Book book2 = bookService.selectByPrimaryKey(1);
        System.out.println(book2);
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }

    /*@Test
    public void queryBooksPager() {
        Book book = new Book();
        book.setBook_name("%%");
        PageBean pageBean = new PageBean();
        pageBean.setRows(3);

        List<Book> books = this.bookService.queryBooksPager(book, pageBean);
        for (Book book1 : books) {
            System.out.println(book1);
        }
        System.out.println(books);
        List<Book> books2 = this.bookService.queryBooksPager(book, pageBean);
        for (Book book2 : books2) {
            System.out.println(book2);
        }
        System.out.println(books2);
    }*/

    /*@Test
    public void querySingleBook() {
        List<Book> books = this.bookService.querySingleBook(1);
        System.out.println(books);
    }*/
}