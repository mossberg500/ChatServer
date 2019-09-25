<%--
  Created by IntelliJ IDEA.
  User: LazovoyOV
  Date: 11.09.2019
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.chatserver.userdata.User"%>
<%@page import="java.util.List"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.chatserver.userdata.Users" %>
<%@ page import="java.io.PrintWriter" %>


<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Active users</title>
</head>
<body>

<h2>This user is active now</h2>

<%Users users = Users.getInstance();%>
<%List<String> userList = users.getlist();%>
<%for (String str : userList){%>
<p><%out.println(str);%></p>
<%}%>

</body>
</html>