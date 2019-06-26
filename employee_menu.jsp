<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%String name=(String)session.getAttribute("name"); %>
<body>
<%--Welcome :: <%=name%> --%>
Welcome :: ${name}
<a href="http://localhost:8082/LoginDemo/myprofile.jsp">My Profile</a>
<a href="http://localhost:8082/LoginDemo/leave.jsp">Leave</a>
<a href="http://localhost:8082/LoginDemo/attendance.jsp">Attendance</a>

</body>
</html>