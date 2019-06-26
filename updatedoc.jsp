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
<form action="Updatedoc" method="post">
<h1>Update Project</h1>
dssn: <input type="text" name="dssn" ><br>
dname: <input type="text" name="dname"><br>
floc: <input type="text" name="floc"><br>
      <input type="submit" value="update">

</form>

</body>
</html>