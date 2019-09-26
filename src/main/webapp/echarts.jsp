<%--
  Created by IntelliJ IDEA.
  User: fan
  Date: 2019/9/24 0024
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>echarts</title>
    <style>
        #echart {
            width: 700px;
            height: 500px;
            border: 1px solid red;
        }
    </style>
    <script src="js/jquery3.2.1.js"></script>
    <script src="js/echarts.js" type="text/javascript"></script>
    <script>

        $(document).ready(function () {
            let myChart = echarts.init(document.getElementById("echart"));

            let option = {
                xAxis: {
                    type: 'category',
                    data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
                },
                yAxis: {
                    type: 'value'
                },
                series: [{
                    data: [120, 200, 150, 80, 70, 110, 130],
                    type: 'bar'
                }]
            };
            myChart.setOption(option);
        })


    </script>

</head>
<body>
<div id="echart">

</div>

</body>
</html>
