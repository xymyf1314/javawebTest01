<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%--
  Created by IntelliJ IDEA.
  User: fan
  Date: 2019/9/23 0023
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>Title</title>
</head>
<script src="js/jquery3.2.1.js"></script>
<script>
    // window.onload=function () {
    //     document.getElementById("uid").setAttribute("onblur", "ajax()");
    // }
    // function ajax(){
    //     var xhr = new XMLHttpRequest();
    //     xhr.open("GET", "/servletTest03_war/ajaxtest", true);
    //     xhr.onreadystatechange = function () {
    //         if (xhr.readyState == 4 && xhr.status == 200) {
    //             document.getElementById("span").innerHTML = xhr.responseText;
    //         }
    //     }
    //     xhr.send();
    // }
    // 使用jQuery监听方式完成函数调用
    $(document).ready(function () {
        // 监听是否有blur事件发生
        $("#uid").blur(function () {
            // 发送异步请求
            $.ajax({
                url: "/servletTest03_war/ajaxtest?username=" + $("#uid").val(),
                type: "GET",
                async: "true",
                // 回调函数
                success:function (data) {
                    $("#span").html(data);
                }
            });
        });
    });


</script>
<body>

<input type="text" name="user" id="uid"/>
<span id="span"></span>

</body>
</html>
