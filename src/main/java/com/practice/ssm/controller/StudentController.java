package com.practice.ssm.controller;

import com.practice.ssm.model.Book;
import com.practice.ssm.model.Student;
import com.practice.ssm.service.StudentService;
import com.practice.ssm.util.PageBean;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Giraffe Wld
 * @site www.grf.com
 * @company grf公司
 * @create  2019-02-15 9:08
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    String serverPath = "/ssm/upload";

    @RequestMapping("/studentList")
    public String list(HttpServletRequest req, Student student){
        PageBean pageBean = new PageBean();
        pageBean.setRequest(req);
        System.out.println("分页:"+pageBean);

        student.setSname(this.queryAppend(student.getSname()));
        List<Student> studentList = this.studentService.queryListPager(student, pageBean);

        req.setAttribute("studentList", studentList);
        req.setAttribute("pageBean", pageBean);

        return "studentList";
    }

    private String queryAppend(Object value){
        if (value == null || value.equals("null")) {
            value = "";
        }
        return "%"+value+"%";
    }

    @RequestMapping("/pageUrl")
    public String toPage(HttpServletRequest req, String pageUrl, Integer sid){
        if(sid != null || !sid.equals("")){
            Student student = this.queryOne(pageUrl, sid);
            System.out.println(student);
            req.setAttribute("student",student);
            return pageUrl;
        }else return pageUrl;
    }

    private Student queryOne(String pageUrl, int sid){
        if(pageUrl.contains("Edit")) {
            Student student = this.studentService.selectByPrimaryKey(sid);
            return student;
        }else return null;
    }

    @RequestMapping("/studentAdd")
    public String add(Student student, MultipartFile file, HttpServletRequest req){
        try {
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File("E://IdeaProjects//GiraffePractice//ssm//src//main//webapp//images//"+file.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String realpath = "images/"+file.getOriginalFilename();
        student.setSimage(realpath);
        this.studentService.insert(student);

        return "redirect:/student/studentList";
    }

    @RequestMapping("/studentDel/{sid}")
    public String del(@PathVariable(value = "sid") int sid){
        this.studentService.deleteByPrimaryKey(sid);
        return "redirect:/student/studentList";
    }

    @RequestMapping("/studentEdit")
    public String update(Student student, MultipartFile file, HttpServletRequest req){
        try {
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File("E://IdeaProjects//GiraffePractice//ssm//src//main//webapp//images//"+file.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String realpath = "images/"+file.getOriginalFilename();
        student.setSimage(realpath);

        this.studentService.updateByPrimaryKey(student);
        return "redirect:/student/studentList";
    }

}
