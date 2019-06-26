<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="admin_menu.jsp"/>
<form action="Update" method="post">
<h1>Update Employee</h1>
ssn: <input type="text" name="ssn" ><br>
ename: <input type="text" name="ename"><br>
address: <input type="text" name="address"><br>
mob: <input type="text" name="mob" ><br>
email: <input type="text" name="email"><br>
bdate: <input type="text" name="bdate"><br>
      <input type="submit" value="update">

</form>

</body>
</html>