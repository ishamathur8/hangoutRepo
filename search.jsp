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
<jsp:include page="admin_menu.jsp"/>

<form action="update.jsp">
<input type="submit" value="update">
<table border="1">
<tr>
     <th>ssn</th>
     <th>ename</th>
     <th>address</th>
     <th>mob</th>
     <th>email</th>
     <th>bdate</th>
</tr>
     
<%
  String id=request.getParameter("id");
try {
	Class.forName("org.postgresql.Driver");
	Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/hangout", "postgres", "isha@123");
	PreparedStatement ps=con.prepareStatement("select * from public.employee where ssn=?");
	ps.setString(1, id);
	ResultSet rs = ps.executeQuery();

	while(rs.next()) {
	%>
	<tr><td><input type="number" name="ssn" value="<%=rs.getString("ssn")%>" ></td>
	<td><input type="text" name="ename" value="<%=rs.getString("ename")%>" ></td>
	<td><input type="text" name="address" value="<%=rs.getString("address")%>" ></td>
	<td><input type="text" name="mob" value="<%=rs.getString("mob")%>"></td>
	<td><input type="text" name="email" value="<%=rs.getString("email")%>"></td>
	<td><input type="text" name="bdate" value="<%=rs.getString("bdate")%>"></td></tr>
	<%
	
	}
		
    %>
    </table>
    <%
      rs.close();
      con.close();
}catch(Exception e){
	e.printStackTrace();
}


%>
</form>

</body>
</html>