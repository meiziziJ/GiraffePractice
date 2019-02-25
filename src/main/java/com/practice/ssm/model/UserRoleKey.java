package com.practice.ssm.model;

public class UserRoleKey {
    private Integer userid;

    private Integer roleid;

    public UserRoleKey(Integer userid, Integer roleid) {
        this.userid = userid;
        this.roleid = roleid;
    }

    public UserRoleKey() {
        super();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }
}