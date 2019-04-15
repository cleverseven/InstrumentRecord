package com.tianhe.service;

import com.tianhe.entity.Charts;
import com.tianhe.entity.ClockVoltageAvg;

import java.util.List;

public interface GasService {
    public List<Integer> clockSum();
    public List<Charts> queryAll( String startTime,String overTime);
    public List<Charts> queryNum(String startTime, String overTime, String clockNum);
    public List<ClockVoltageAvg> queryAvg(String startTime,String overTime,String clockNum);
}
