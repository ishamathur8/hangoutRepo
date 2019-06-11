<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="http://localhost:8082/LoginDemo/addNewdoc.jsp">add new document</a>
<form action="searchdoc" method="post">
<table>
    <tr>
        <td>enter the id</td>
        <td><input type="number" name="id"></td>
    </tr>
    <tr>
    <td><input type="submit" value="search"></td>
    </tr>  
</table>
</form>

</body>
</html>