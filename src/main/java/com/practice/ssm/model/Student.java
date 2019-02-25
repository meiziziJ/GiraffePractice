package com.practice.ssm.model;

public class Student {
    private Integer sid;

    private String sname;

    private String simage;

    public Student(Integer sid, String sname, String simage) {
        this.sid = sid;
        this.sname = sname;
        this.simage = simage;
    }

    public Student() {
        super();
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSimage() {
        return simage;
    }

    public void setSimage(String simage) {
        this.simage = simage;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", simage='" + simage + '\'' +
                '}';
    }
}