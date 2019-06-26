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
<form action="UpdateProj" method="post">
<h1>Update Project</h1>
ssn: <input type="text" name="pssn" ><br>
ename: <input type="text" name="pname"><br>
      <input type="submit" value="update">

</form>

</body>
</html>