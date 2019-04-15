package com.tianhe.serviceImpl;

import com.tianhe.dao.GasDao;
import com.tianhe.entity.Charts;
import com.tianhe.entity.ClockVoltageAvg;
import com.tianhe.service.GasService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service("GasService")
public class GasServiceImpl implements GasService {
    @Resource
    GasDao gasDao;

    @Override
    public List<Integer> clockSum() {
        List<Integer> integers = gasDao.clockSum();
        return integers;
    }

    @Override
    public List<Charts> queryAll(String startTime, String overTime) {
        List<Charts> charts = gasDao.queryAll(startTime, overTime);
        return charts;
    }

    @Override
    public List<Charts> queryNum(String startTime, String overTime, String clockNum) {
        List<Charts> charts = gasDao.queryNum(startTime, overTime, clockNum);
        return charts;
    }

    @Override
    public List<ClockVoltageAvg> queryAvg(String startTime, String overTime, String clockNum) {
        List<ClockVoltageAvg> clockVoltageAvgs = gasDao.queryAvg(startTime, overTime, clockNum);
        return clockVoltageAvgs;
    }
}
