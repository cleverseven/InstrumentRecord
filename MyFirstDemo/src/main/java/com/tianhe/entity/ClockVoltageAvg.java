package com.tianhe.entity;

public class ClockVoltageAvg {
    private double avg;
    private String day;
    private int device_addr;
    public ClockVoltageAvg() {}
    public ClockVoltageAvg(double avg, String day, int device_addr) {
        this.avg = avg;
        this.day = day;
        this.device_addr = device_addr;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getDevice_addr() {
        return device_addr;
    }

    public void setDevice_addr(int device_addr) {
        this.device_addr = device_addr;
    }

    @Override
    public String toString() {
        return "ClockVoltageAvg{" +
                "avg=" + avg +
                ", day='" + day + '\'' +
                ", device_addr=" + device_addr +
                '}';
    }
}
