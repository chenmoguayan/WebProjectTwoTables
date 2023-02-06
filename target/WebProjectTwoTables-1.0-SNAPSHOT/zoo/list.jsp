<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/2/1
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
    <script>
        $(function (){
            $(".update").click(function (){
                let id = $(this).next().val();
                location = "zoo/update.jsp?id="+id;
            })
            $(".delete").click(function (){
                let id = $(this).prev().val();//id
                $.ajax({
                    url:"<%=request.getContextPath()%>/animal?id="+id,
                    data:{m:"delete"},
                    type:"post",
                    dataType:"json",
                    success:function (resp){
                        if (resp){
                            // location.reload();
                            location = "<%=request.getContextPath()%>/animal?m=query";
                        }
                    }
                })
            })

        //  三级联动
            let str = $("#address");
            let sheng = "";
            let shi = "";
            let qu = "";
            getByPid(0,"#sheng")
            $("#sheng").change(function (){
                let id = $("#sheng").val();
                getByPid(id,"#shi");
                sheng = $("#sheng option:checked").text();
                str.val(sheng);
                $("#shi").empty();
                $("#qu").empty();
            })
            $("#shi").change(function (){
                let id = $("#shi").val();
                getByPid(id,"#qu");
                shi = $("#shi option:checked").text();
                str.val(sheng + shi);
                $("#qu").empty();
            })
            $("#qu").change(function (){
                qu = $("#qu option:checked").text();
                str.val(sheng + shi + qu);
            })


            function getByPid(id,adderss){
                $.ajax({
                    url: "<%=request.getContextPath()%>/animal",
                    data:{id:id,m:"getCity"},
                    type: "post",
                    dataType: "json",
                    success:function (resp){
                        $(adderss).append("<option>请选择</option>");
                        for (let x of resp) {
                            $(adderss).append("<option value=" +x.id+ ">"+x.name+"</option>");
                        }
                    }

                })
            }

        })
    </script>
</head>
<body>
    <table>
        <tr>
            <td></td>
            <td>名称</td>
            <td>年龄</td>
            <td>性别</td>
            <td>类别</td>
            <td>操作 | <input type="button" value="添加" id="insert"></td>
        </tr>
        <c:forEach items="${list}" var="a">
            <tr>
                <td></td>
                <td>${a.name}</td>
                <td>${a.age}</td>
                <td>${a.sex}</td>
                <td>${a.type.name}</td>
                <td>
                    <input type="button" class="update" value="修改">
                    <input type="hidden" value="${a.id}">
                    <input type="button" class="delete" value="删除">
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="6">
                <input type="text" id="address"><br>
                <select id="sheng">
                </select>省
                <select id="shi"></select>市
                <select id="qu"></select>区
            </td>
        </tr>
    </table>
    <script>
        let insert = document.getElementById("insert");
        insert.onclick = function (){
            location = "zoo/insert.jsp";
        }
    </script>
</body>
</html>
