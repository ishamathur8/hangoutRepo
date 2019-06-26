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

<form action="leaveapp" method="get">

<table border="1">

<tr> 
     <th>lssn</th>
     <th>sdate</th>
     <th>edate</th>
     <th>reason</th>
     <th>leavestatus</th>
     <th>action</th>
                    
</tr>


<% 
try {
	Class.forName("org.postgresql.Driver");
	Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/hangout", "postgres", "isha@123");
	PreparedStatement ps=con.prepareStatement("select * from public.application");
	ResultSet rs = ps.executeQuery();

	while(rs.next()) {
	%>
	<tr><td><input type="number" name="lssn" value="<%=rs.getString("lssn")%>" ></td>
	<td><input type="date" name="sdate" value="<%=rs.getString("sdate")%>" ></td>
	<td><input type="date" name="edate" value="<%=rs.getString("edate")%>" ></td>
	<td><input type="text" name="reason" value="<%=rs.getString("reason")%>" ></td>
	<td><input type="text" name="leavestatus" value="<%=rs.getString("leavestatus")%>" ></td>
	<td><a href='leaveapp?id=<%=rs.getInt("uniqueid")%>&type=1'>Accept</a></td>
	<td><a href='leaveapp?id=<%=rs.getInt("uniqueid")%>&type=2'>Reject</a></td></tr>
	
	
	
	
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