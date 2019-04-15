package com.tianhe.entity;

public class Charts {
    private Integer num;
    private String day;
    public Charts() {}
    public Charts(Integer num, String day) {
        this.num = num;
        this.day = day;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "'" + day +
                "'";
    }
}
