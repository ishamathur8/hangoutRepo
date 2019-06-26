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

<form action="updateProj.jsp">
<input type="submit" value="update">
<table border="1">
<tr>
     <th>pssn</th>
     <th>pname</th>
     
</tr>
     
<%
  String id=request.getParameter("id");
try {
	Class.forName("org.postgresql.Driver");
	Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/hangout", "postgres", "isha@123");
	PreparedStatement ps=con.prepareStatement("select * from public.project where pssn=?");
	ps.setString(1, id);
	ResultSet rs = ps.executeQuery();

	while(rs.next()) {
	%>
	<tr><td><input type="number" name="pssn" value="<%=rs.getString("pssn")%>" ></td>
	<td><input type="text" name="pname" value="<%=rs.getString("pname")%>" ></td></tr>
	
	
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