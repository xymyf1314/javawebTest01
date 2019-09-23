<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <style type="text/css">
        * {
            margin: 0;
            padding: 0;
            border: none;
            font-family: "微软雅黑";
        }

        /* 整个盒子 */
        #register {
            position: relative;
            background-color: rgb(255, 238, 221);
            box-sizing: border-box;
            margin: auto;
            width: 957px;
            height: 742px;
        }

        /* 会员注册标题 */
        #title {
            /* background-color: red; */
            box-sizing: border-box;
            width: 957px;
            height: 89px;
        }

        h1 {
            text-align: center;
            font-size: 60px;
        }

        /* 个人简介 */
        .texta {
            margin-top: 8px;
            width: 299px;
            height: 208px;
        }

        /* 提交按钮 */
        #foot {
            position: absolute;
            bottom: 0;
            /* background-color: blue; */
            box-sizing: border-box;
            width: 957px;
            height: 57px;
        }

        li {
            list-style-type: none;
            margin-bottom: 7px;
        }

        /*  表的输入框 */
        .input1 {
            width: 274px;
            height: 33px;
            font-size: 22px;
            border: 1px solid white;
        }

        .inputsuccess {
            width: 274px;
            height: 33px;
            font-size: 22px;
            border: 1px solid white;
            border-color: greenyellow;
        }

        .inputerror {
            width: 274px;
            height: 33px;
            font-size: 22px;
            border: 1px solid red;
            border-color: #d00212;
        }

        span {
            font-size: 22px;
        }

        /* 两个字的span */
        .span2 {
            margin-left: 44px;
        }

        /* 三个字的span */
        .span3 {
            margin-left: 22px;
        }

        ul {
            margin-left: 60px;
        }

        /* 详细地址 */
        .address {
            font-size: 22px;
        }

        /* 上传头像 */
        .photo {
            height: 36px;
            font-family: "微软雅黑";
            font-size: 22px;
        }

        /* 个人简介 */
        .texta {
            margin-top: 8px;
            width: 302px;
            height: 200px;
            margin-bottom: 0;
            font-family: "微软雅黑";
            font-size: 22px;
        }

        /* 注册按钮的样式*/
        .button1:active {
            top: 2px;
            /**向下偏移2px **/
        }

        .button1 {
            position: relative;
            /** 相对布局 **/
            margin-top: 18px;
            margin-left: 175px;
            width: 64px;
            height: 36px;
            font-family: "微软雅黑";
            font-size: 22px;
            background-color: rgb(237, 237, 237);
        }

        /* 重置按钮的样式*/
        .button2:active {
            top: 2px;
            /**向下偏移2px **/
        }

        .button2 {
            position: relative;
            /** 相对布局 **/
            margin-top: 18px;
            width: 64px;
            height: 36px;
            font-family: "微软雅黑";
            font-size: 22px;
            background-color: rgb(237, 237, 237);
        }

        .zs {
            margin-left: 33px;
        }
    </style>

    <script>

        function uname() {
            var regexphone = /^1[345678]\d{9}$/;
            var username = document.getElementById("username").value;

            // 用户名
            if (username.length > 4) {
                document.getElementById("username").className = "inputsuccess";
                document.getElementById("usernamespan").innerHTML = "nice，兄弟！";
                document.getElementById("usernamespan").style.color = "greenyellow";
            } else {
                document.getElementById("username").className = "inputerror"
                document.getElementById("usernamespan").innerText = "low爆了！"
                document.getElementById("usernamespan").style.color = "red";
            }
        }

        function apwd() {

            var pwd = document.getElementById("pwd").value;
            // 密码
            if (pwd.length > 10 && pwd.length < 13) {
                document.getElementById("pwd").className = "inputsuccess";
                document.getElementById("pwdspan").innerHTML = "贼安全，兄弟！";
                document.getElementById("pwdspan").style.color = "greenyellow";
            } else {
                document.getElementById("pwd").className = "inputerror"
                document.getElementById("pwdspan").innerText = "low爆了！"
                document.getElementById("pwdspan").style.color = "red";
            }
        }

        function rrpwd() {
            var pwd = document.getElementById("pwd").value;
            var rpwd = document.getElementById("rpwd").value;
            if (pwd === rpwd) {
                document.getElementById("rpwd").className = "inputsuccess";
                document.getElementById("rpwdspan").innerHTML = "贼强，兄弟！";
                document.getElementById("rpwdspan").style.color = "greenyellow";
            } else {
                document.getElementById("rpwd").className = "inputerror"
                document.getElementById("rpwdspan").innerText = "这不一样啊兄弟！"
                document.getElementById("rpwdspan").style.color = "red";
            }
        }
    </script>


    <script src="/servletTest03_war/js/jquery3.2.1.js"></script>
    <%--    三级下拉菜单--%>
    <script>
        $(document).ready(function () {
            // 第一级
            $.ajax({
                url: "/servletTest03_war/register",
                type: "GET",
                dataType: "json",
                async: true,
                success: function (strProvinces) {
                    for (var i = 0; i < strProvinces.length; i++) {
                        var p = strProvinces;
                        var html = "<option id='province' value='" + p[i].code + "'><span>" + p[i].name + "</span></option>"
                        $("#provinces").append(html);
                    }
                }
            });
            // 第二级
            $("#provinces").change(function () {
                $.ajax({
                    url: "/servletTest03_war/register",
                    type: "GET",
                    dataType: "json",
                    data: {
                        code: $("#provinces").val(),
                        method: "2"
                    },
                    success: function (res) {
                        $("#city").html("");
                        $("#county").html("");
                        for (var i = 0; i < res.length; i++) {
                            var html = "<option value='" + res[i].code + "'><span>" + res[i].name + "</span></option>";
                            $("#city").append(html);
                        }
                    }
                });
            });
            // 第三级
            $("#city").change(function () {
                $.ajax({
                    url: "/servletTest03_war/register",
                    type: "GET",
                    dataType: "json",
                    data:{
                        code: $("#city").val(),
                        method: "2"
                    },
                    success: function (res) {
                        $("#county").html("");
                        for (let i = 0; i < res.length; i++) {
                            let html = "<option value='" + res[i].code + "'><span>" + res[i].name + "</span></option>";
                            $("#county").append(html);
                        }
                    }
                });
            });
        });

    </script>

</head>
<body>
<!-- 一个大的盒子 -->
<div id="register">
    <!-- 标题会员注册的盒子 -->
    <div id="title">
        <h1>会员注册</h1>
    </div>
    <!-- 表的信息 -->
    <form action="#" method="post">
        <div id="tb">
            <ul>
                <li><span><span class="span3">用户名：</span></span><input class="input1" type="text" required="required"
                                                                       name="username"
                                                                       id="username" value="" autofocus="autofocus"
                                                                       onblur="uname()"/><span id="usernamespan"
                                                                                               class="zs">只能以$_或字母开头6-16位字母或者数字组合</span>
                </li>
                <li><span class="span2">密码：</span><input onblur="apwd()" id="pwd" name="pwd" class="input1"
                                                         type="password" name="pwd"
                                                         required="required"/><span id="pwdspan" class="zs">必需以大写字母开头6-16位字母或者数字组合</span>
                </li>
                <li><span>确认密码：</span><input id="rpwd" onblur="rrpwd()" class="input1" type="password" name="repwd"
                                             required="required"/><span id="rpwdspan" class="zs">请再次确认密码</span></li>
                <li><span class="span2">姓名：</span><input class="input1" type="text" name="name"/></li>
                <li><span class="span2">年龄：</span><input class="input1" type="number" name="age"/></li>
                <li><span class="span2">性别：</span><input type="radio" name="sex" checked="checked"/><span>男</span>&nbsp;<input
                        type="radio" name="sex"/><span>女</span></li>
                <li><span>身份证号：</span><input class="input1" type="text" name="IDcard"/><span class="zs">请输入正确的身份证号，以便核实您的信息</span>
                </li>
                <li><span>出生年月：</span><input class="input1" type="date" name="birthday"/></li>
                <li><span>居住地址：</span>
                    <select style="width: 150px;height: 30px; font-size: 22px;" id="provinces">
                        <option id="province" value=""><span>---省/直辖市---</span></option>
                    </select>
                    <select style="width: 150px;height: 30px; font-size: 22px;" id="city">
                        <option value="area"><span>---区/市---</span></option>
                    </select>
                    <select style="width: 150px;height: 30px; font-size: 22px;" id="county">
                        <option value="area"><span>---区县---</span></option>
                    </select>
                    <input class="address" type="text" name="" placeholder="请填写具体地址"/></td>
                    </tr>
                </li>
                <li><span>上传头像：</span><input class="photo" type="file" name="photo" value=""/></li>
            </ul>
            <div id="introduce">
                <span style="margin-top: 98px;margin-left: 60px;position: absolute;	">个人简介：</span><textarea
                    style="position: absolute;margin-left: 175px;"
                    class="texta" cols=""></textarea>
            </div>
        </div>
        <!-- 尾部的注册按钮 -->
        <div id="foot">
            <input class="button1" type="submit" value="注册"/>
            <input class="button2" type="reset" value="重置"/>
        </div>
    </form>
</div>
</body>
</html>
