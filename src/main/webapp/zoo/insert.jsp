<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/2/1
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="../js/jquery-3.6.0.min.js"></script>
    <script>
        $(function (){

            $.ajax({
                url: "<%=request.getContextPath()%>/animal?m=getType",
                dataType: "json",
                type: "post",
                success:function (resp){
                    let select = $("#tid");
                    for (const r of resp){
                        select.append("<option value='"+r.tid+"'>"+r.name+"</option>");
                    }
                }
            })


            $("#btn").click(function (){
                $.ajax({
                    url:"../animal?m=insert",
                    data:$("#f").serialize(),
                    dataType:"json",
                    type:"post",
                    success:function (resp){
                        if (resp){
                            location = "../animal?m=query";
                        }
                    }
                })
            })
        })
    </script>
</head>
<body>
    <form id="f">
        <table>
            <tr>
                <td>用户名</td>
                <td>
                    <input type="text" name="name">
                </td>
            </tr>
            <tr>
                <td>年龄</td>
                <td>
                    <input type="text" name="age">
                </td>
            </tr>
            <tr>
                <td>性别</td>
                <td>
                    <input type="radio" name="sex" value="雄">雄
                    <input type="radio" name="sex" value="雌">雌
                </td>
            </tr>
            <tr>
                <td>类别</td>
                <td>
                    <label for="tid"></label><select name="tid" id="tid">
                        <option>请选择</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="button" value="添加" id="btn">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
