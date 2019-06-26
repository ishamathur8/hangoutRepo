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
<%
String user="";
if(session!=null){
	if(session.getAttribute("ussn")!=null){
		user=(String) session.getAttribute("ussn");
	}else{
		response.sendRedirect("login.jsp");
	}
}


%>
<form>
<table border="1">

<tr> 
     
     <th>ssn</th>
     <th>ename</th>
     <th>address</th>
     <th>mob</th>
     <th>email</th>
     <th>bdate</th>
     <th>pssn</th>
     <th>pname</th>
     <th>dssn</th>
     <th>dname</th>
     <th>floc</th>
     
</tr>
<%


try {
	Class.forName("org.postgresql.Driver");
	Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/hangout", "postgres", "isha@123");
	PreparedStatement ps=con.prepareStatement("select * from public.login, public.employee, public.project, public.documents where public.login.ussn=? and public.employee.ssn=? and public.project.pssn=? and public.documents.dssn=?");
	ps.setString(1,user);
	ps.setString(2,user);
	ps.setString(3,user);
	ps.setString(4,user);
	ResultSet rs = ps.executeQuery();
    
	

	
	while(rs.next()) {
	%>

	
	<tr><td><%out.println(rs.getString("ssn")); %></td>
	<td><%out.println(rs.getString("ename")); %></td>
	<td><%out.println(rs.getString("address")); %></td>
	<td><%out.println(rs.getString("mob")); %></td>
	<td><%out.println(rs.getString("email")); %></td>
	<td><%out.println(rs.getString("bdate")); %></td>
	<td><%out.println(rs.getString("pssn")); %></td>
	<td><%out.println(rs.getString("pname")); %></td>
	<td><%out.println(rs.getString("dssn")); %></td>
	<td><%out.println(rs.getString("dname")); %></td>
	<td><%out.println(rs.getString("floc")); %></td></tr>

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