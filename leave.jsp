<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="employee_menu.jsp"/>
<a href="http://localhost:8082/LoginDemo/leave_apply.jsp">leave apply</a>
<a href="http://localhost:8082/LoginDemo/myapp.jsp">my application</a>

</body>
</html>