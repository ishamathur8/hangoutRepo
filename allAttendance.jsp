<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form>
<table border="1">
<tr> 
     <th>assn</th>
     <th>adate</th>
     <th>aday</th>
     <th>attendance</th>
                    
</tr>


<%
  String id=request.getParameter("id");
try {
	Class.forName("org.postgresql.Driver");
	Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/hangout", "postgres", "isha@123");
	PreparedStatement ps=con.prepareStatement("select * from public.attendance where assn=?");
	ps.setString(1, id);
	ResultSet rs = ps.executeQuery();


	 while(rs.next()) {
	%>
	   <tr><td><input type="number" name="assn" value="<%=rs.getString("assn")%>" ></td>
	   <td><input type="date" name="adate" value="<%=rs.getString("adate")%>" ></td>
	   <td><input type="text" name="aday" value="<%=rs.getString("aday")%>" ></td>
	   <td><input type="text" name="attendance" value="<%=rs.getString("attendance")%>"></td></tr>
	
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