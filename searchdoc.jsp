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

<form action="updatedoc.jsp">
<input type="submit" value="update">
<table border="1">
<tr>
     <th>dssn</th>
     <th>dname</th>
     <th>floc</th>
    
</tr>
     
<%
  String id=request.getParameter("id");
try {
	Class.forName("org.postgresql.Driver");
	Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/hangout", "postgres", "isha@123");
	PreparedStatement ps=con.prepareStatement("select * from public.documents where dssn=?");
	ps.setString(1, id);
	ResultSet rs = ps.executeQuery();

	while(rs.next()) {
	%>
	<tr><td><input type="number" name="dssn" value="<%=rs.getString("dssn")%>" ></td>
	<td><input type="text" name="dname" value="<%=rs.getString("dname")%>" ></td>
	<td><input type="text" name="floc" value="<%=rs.getString("floc")%>" ></td></tr>
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