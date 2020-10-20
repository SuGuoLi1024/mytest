package com.itheima.entity;

import java.util.Date;

public class QueryVo {
    private User user;
    private Date Start;
    private Date end;

    public QueryVo() {
    }

    public QueryVo(User user, Date start, Date end) {
        this.user = user;
        Start = start;
        this.end = end;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getStart() {
        return Start;
    }

    public void setStart(Date start) {
        Start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "QueryVo{" +
                "user=" + user +
                ", Start=" + Start +
                ", end=" + end +
                '}';
    }
}
