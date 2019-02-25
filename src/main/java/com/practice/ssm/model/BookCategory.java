package com.practice.ssm.model;

public class BookCategory {
    private Integer bcid;

    private Integer bid;

    private Integer cid;

    public BookCategory(Integer bcid, Integer bid, Integer cid) {
        this.bcid = bcid;
        this.bid = bid;
        this.cid = cid;
    }

    public BookCategory() {
        super();
    }

    public Integer getBcid() {
        return bcid;
    }

    public void setBcid(Integer bcid) {
        this.bcid = bcid;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
}