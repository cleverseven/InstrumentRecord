package com.tianhe.ctrl;

import com.tianhe.entity.Charts;
import com.tianhe.entity.ClockVoltageAvg;
import com.tianhe.entity.table;
import com.tianhe.service.GasService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.util.ArrayList;

import java.util.List;


@RequestMapping("/gas")
@Controller
public class GasController {
    @Resource
    GasService gasService;
    @RequestMapping("/chart")
    public ModelAndView userInfo(String clockNum,String test1,String test2,Integer time){
        DecimalFormat df = new DecimalFormat("#.000");
        ModelAndView mav=new ModelAndView("charts");
        if (clockNum==""){
            List<Charts> charts = gasService.queryAll(test1, test2);
            List<Integer> integers = gasService.clockSum();
            List<String> day =new ArrayList<>();
            List<Integer> num =new ArrayList<>();
            List<Double>  successRate = new ArrayList<>();
            for (Charts chart:charts) {
                day.add(chart.getDay());
                num.add(chart.getNum());
            }
            mav.addObject("chart",charts);
            mav.addObject("day",day);
            mav.addObject("num",num);
            double frequency =1440/time;
            mav.addObject("frequency",frequency*integers.size());
            for (int num1:num) {
                String format = df.format(num1/(frequency*1.0*integers.size()));
                successRate.add(new Double(format)) ;
            }
            mav.addObject("successRate",successRate);
            List<table> table =new ArrayList<>();
            for (int i=0;i<successRate.size();i++){
                table.add(new table(charts.get(i),successRate.get(i)));
            }
            mav.addObject("table",table);
            return  mav;
        }else{
            List<ClockVoltageAvg> clockVoltageAvgs = gasService.queryAvg(test1, test2, clockNum);
            List<Charts> charts = gasService.queryNum(test1, test2, clockNum);
            List<String> day =new ArrayList<>();
            List<Integer> num =new ArrayList<>();
            List<Double> avg =new ArrayList<>();
            List<Double>  successRate = new ArrayList<>();
            for (Charts chart:charts) {
                day.add(chart.getDay());
                num.add(chart.getNum());
            }
            for (ClockVoltageAvg clockVoltageAvg:clockVoltageAvgs) {
                String format = df.format(clockVoltageAvg.getAvg());
                avg.add(new Double(format));
            }
            mav.addObject("avg",avg);
            mav.addObject("chart",charts);
            mav.addObject("day",day);
            mav.addObject("num",num);
            mav.addObject("clockNum",clockNum);
            double frequency =1440/time;
            mav.addObject("frequency",frequency);
            for (int num1:num) {
                String format = df.format(num1 / frequency * 1.0);
                successRate.add(new Double(format)) ;
            }
            mav.addObject("successRate",successRate);
            List<table> table =new ArrayList<>();
            for (int i=0;i<successRate.size();i++){
                table.add(new table(charts.get(i),successRate.get(i),avg.get(i)));
            }
            mav.addObject("table",table);
            return  mav;
        }
    }
    @RequestMapping("/goToChart")
    public ModelAndView goToChart(){
        ModelAndView mav=new ModelAndView("charts");
        return mav;
    }


}
