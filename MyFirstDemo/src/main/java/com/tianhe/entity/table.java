package com.tianhe.entity;

public class table {
    private Charts charts;
    private Double successRate;
    private Double avg;
    public table(){}

    public table(Charts charts, Double successRate, Double avg) {
        this.charts = charts;
        this.successRate = successRate;
        this.avg = avg;
    }

    public table(Charts charts, Double successRate) {
        this.charts = charts;
        this.successRate = successRate;

    }
    public Double getAvg() {
        return avg;
    }

    public void setAvg(Double avg) {
        this.avg = avg;
    }

    public Charts getCharts() {
        return charts;
    }

    public void setCharts(Charts charts) {
        this.charts = charts;
    }

    public Double getSuccessRate() {
        return successRate;
    }

    public void setSuccessRate(Double successRate) {
        this.successRate = successRate;
    }

    @Override
    public String toString() {
        return "table{" +
                "charts=" + charts +
                ", successRate=" + successRate +
                '}';
    }
}
