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
<% String user=(String)session.getAttribute("ussn");%>

<form>
<table border="1">

<tr> 
     <th>lssn</th>
     <th>sdate</th>
     <th>edate</th>
     <th>leavestatus</th>
     <th>reason</th>
     
     
</tr>
<%


try {
	Class.forName("org.postgresql.Driver");
	Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/hangout", "postgres", "isha@123");
	PreparedStatement ps=con.prepareStatement("select * from public.application where lssn=?");
	ps.setString(1, user);
	ResultSet rs = ps.executeQuery();
	
    
	
	
	while(rs.next()) {
	%>

	<tr><td><%out.println(rs.getString("lssn")); %></td>
	<td><%out.println(rs.getString("sdate")); %></td>
	<td><%out.println(rs.getString("edate")); %></td>
	<td><%out.println(rs.getString("leavestatus")); %></td>
	<td><%out.println(rs.getString("reason")); %></td>
	

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