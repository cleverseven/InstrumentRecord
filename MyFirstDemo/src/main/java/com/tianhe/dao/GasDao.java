package com.tianhe.dao;

import com.tianhe.entity.Charts;
import com.tianhe.entity.ClockVoltageAvg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GasDao {
    public List<Charts> queryNum(@Param("startTime") String startTime,@Param("overTime") String overTime,@Param("clockNum") String clockNum);
    public List<Charts> queryAll(@Param("startTime") String startTime,@Param("overTime") String overTime);
    public List<Integer> clockSum();
    public List<ClockVoltageAvg> queryAvg(@Param("startTime") String startTime, @Param("overTime") String overTime, @Param("clockNum") String clockNum);
}
