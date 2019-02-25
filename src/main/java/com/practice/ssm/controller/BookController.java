package com.practice.ssm.controller;

import com.practice.ssm.model.Book;
import com.practice.ssm.service.BookService;
import com.practice.ssm.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Giraffe Wld
 * @site www.grf.com
 * @company grf公司
 * @create  2019-01-23 21:17
 */
@Controller
@RequestMapping("/book")/* 此requestMapping的设置为给该controller添加一个命名空间 */
public class BookController {
    @Autowired
    private BookService bookService;

    /**
     *  关于结果码的配置情况:
     *    一，
     *      1.转发到WEN-INF/**.jsp页面    直接编写返回的视图名 xx
     *      2.转发到后台的某一requestMapping请求上     forward:/book/list
     *      3.转发到webapp下的页面     forward:/xx.jsp
     *    二，
     *      1.重定向到后台的某一requestMapping请求上    redirect:/book/list
     *      2.重定向到webapp下的页面    redirect:/xx.jsp
     */

    @RequestMapping("/list")
    public String bookList(HttpServletRequest req, Book book){
        System.out.println("进方法了");
        PageBean pageBean = new PageBean();


        //前台模糊查，可在后台进行sql语句攻击实现查询


        pageBean.setRequest(req);
        List<Book> books = this.bookService.queryBooksPager(book, pageBean);
        req.setAttribute("bookList",books);
        req.setAttribute("pageBean",pageBean);
        return "bookList";
    }

    @RequestMapping("/pageUrl")
    public String toPage(String pageUrl, Integer bid, HttpServletRequest req){
        if(bid != null || !bid.equals("")){
            Book book = this.queryOne(pageUrl, bid);
            System.out.println(book);
            req.setAttribute("book",book);
        }
        return pageUrl;
    }

    @RequestMapping("/add")
    public String add(Book book){
        this.bookService.insert(book);
        return "redirect:/book/list";
    }

    private Book queryOne(String pageUrl, Integer bid){
        if(pageUrl.contains("Edit")) {
            Book book = this.bookService.selectByPrimaryKey(bid);
            return book;
        }else return null;
    }

    @RequestMapping("/edit")
    public String edit(Book book){
        this.bookService.updateByPrimaryKey(book);
        return "redirect:/book/list";
    }

    @RequestMapping("/validate")
    public String validate(@Validated Book book, BindingResult result){
        //如果请求绑定的结果存在错误，则进判断
        if(result.hasErrors()){
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                //将多个属性验证的错误信息输入到控制台
                System.out.println(fieldError.getField() + " : " + fieldError.getDefaultMessage());
            }
        }
        return null;
    }

    /**
     * 使用restful风格传值
     *  书本删除
     * @return
     */
    @RequestMapping("/del/{bid}")
    public String del(@PathVariable(value = "bid") Integer book_id){
        this.bookService.deleteByPrimaryKey(book_id);
        return "redirect:/book/list";
    }

    /**
     * 将所返回的数据转成json格式
     * @param req
     * @param book
     * @return
     */
   /* @ResponseBody
    @RequestMapping("/listAjax")
    public List<Book> bookListAjax(HttpServletRequest req, Book book){
        PageBean pageBean = new PageBean();

        *//*
        前台模糊查，可在后台进行sql语句攻击实现查询
         *//*

        pageBean.setRequest(req);
        List<Book> books = this.bookService.queryBooksPager(book, pageBean);
        return books;
    }*/
}
