<%--
  Created by IntelliJ IDEA.
  User: young
  Date: 2019/4/9
  Time: 8:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>天和仪表数据记录</title>
    <script src="<%=basePath%>/static/layui/layui.js"></script>
    <link rel="stylesheet" href="<%=basePath%>/static/layui/css/layui.css">
    <script type="text/javascript" src="<%=basePath%>/static/js/echarts.min(1).js"></script>
    <script type="text/javascript" src="<%=basePath%>/static/js/jquery-3.2.1.min.js"></script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">仪表记录</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    ${user.username}
                </a>
            </li>
            <li class="layui-nav-item"><a href="<%=request.getContextPath()%>/login.jsp">退出</a></li>
        </ul>
    </div>
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div class="found" style="padding:30px; margin-left: 60px; width: 1000px;height: 10px; ">
            请输入表号查询: <input type="text" id="clockNum" placeholder="请输入表号查询" style="width: 100px"/>
            请输入起始时间: <input type="text" id="test1" placeholder="YYYY-MM-DD" style="width: 100px">
            请输入截止时间: <input type="text" id="test2" placeholder="YYYY-MM-DD" style="width: 100px">
            请输入上传间隔时间: <input type="text" id="time" placeholder="上传间隔" style="width: 100px">
            <button id="sousuo" class="layui-btn layui-btn-sm layui-btn-normal">搜索</button>
        </div>
        <div id="main" style="width: 950px;height:400px;margin-left: 50px; margin-top: 60px;"></div>
        <div id="main1" style="width: 950px;height:400px; margin-top: 60px;margin-left: 50px;"></div>
        <script type="text/javascript">
            $(function(){
                // 基于准备好的dom，初始化echarts实例
            var myChart = echarts.init(document.getElementById('main'));
            // 指定图表的配置项和数据
            var option = {
                title: {
                    text: '成功率电压关系图',
                    subtext: '数据来自天和智能仪表有限责任公司',
                    x: 'center',
                    align: 'right'
                },
                tooltip : {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'cross',
                        animation: false,
                    }
                },
                legend: {
                    data:['成功率','电压'],
                    x: 'left'
                },
                xAxis: {
                    data: <c:if test="${!empty chart}">
                            ${chart}
                          </c:if>
                          <c:if test="${empty chart}">
                            []
                          </c:if>
                },
                dataZoom: [{
                    type: 'slider',
                    show: true,
                    xAxisIndex: [0],
                    left: '9%',
                    bottom: -5,
                    start: 10,
                    end: 90 //初始化滚动条
                }],
                yAxis: [
                    {
                        name: '成功率',
                        type: 'value',
                    },
                    {
                        name: '电压',
                        nameLocation: 'start',
                        max: 7,
                        type: 'value',
                    }
                ],
                series: [{
                    name: '成功率',
                    type: 'line',
                    data: <c:if test="${!empty successRate}">
                             ${successRate}
                          </c:if>
                          <c:if test="${empty successRate}">
                            []
                          </c:if>
                },{
                    name: '电压',
                    type: 'line',
                    yAxisIndex:1,
                    data: <c:if test="${!empty avg}">
                        ${avg}
                        </c:if>
                        <c:if test="${empty avg}">
                        []
                    </c:if>
                }]
            };
            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
            });
            $(function(){
                // 基于准备好的dom，初始化echarts实例
                var myChart = echarts.init(document.getElementById('main1'));
                // 指定图表的配置项和数据
                var option = {
                    title: {
                        text: '次数/时间'
                    },
                    tooltip: {},
                    legend: {
                        data:['次数']
                    },
                    xAxis: {
                        data: <c:if test="${!empty chart}">
                              ${chart}
                              </c:if>
                              <c:if test="${empty chart}">
                              []
                              </c:if>
                    },
                    dataZoom: [{
                        type: 'slider',
                        show: true,
                        xAxisIndex: [0],
                        left: '9%',
                        bottom: -5,
                        start: 10,
                        end: 10 //初始化滚动条
                    }],
                    yAxis: {
                    },
                    series: [{
                        name: '次数',
                        type: 'bar',
                        data: <c:if test="${!empty num}">
                                 ${num}
                              </c:if>
                              <c:if test="${empty num}">
                            []
                              </c:if>
                    }]
                };
                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);
            });
            $(function(){
                layui.use('laydate', function(){
                    var laydate = layui.laydate;
                    //执行一个laydate实例
                    laydate.render({
                        elem: '#test1' //指定元素
                    });
                    laydate.render({
                        elem: '#test2' //指定元素
                    });
                });
            });
            $("#sousuo").click(function () {
                var a= $("#clockNum").val();
                var b= $("#test1").val();
                var c= $("#test2").val();
                var d= $("#time").val();
                alert(a+b+c+d);
                location.href="<%=request.getContextPath()%>/gas/chart?clockNum="+a+"&&test1="+b+"&&test2="+c+"&&time="+d;
            });
        </script>
        <div id="table" style="margin-left: 50px;width: 950px" >
        <table class="layui-table">

            <thead>
            <tr>
                <th>表号</th>
                <th>统计时间</th>
                <th>实传次数</th>
                <th>应传次数</th>
                <th>成功率</th>
                <th>电压</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="chart1" items="${table}">
            <tr>
                <td>${clockNum}</td>
                <td>${chart1.charts.day}</td>
                <td>${chart1.charts.num}</td>
                <td>${frequency}</td>
                <td>${chart1.successRate}</td>
                <td>${chart1.avg}</td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->

    </div>
</div>
</body>
</html>
