

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter out = response.getWriter();
		String ssn = request.getParameter("ssn");
		String ename = request.getParameter("ename");
		String address = request.getParameter("address");
		String mob = request.getParameter("mob");
		String email = request.getParameter("email");
		Date bdate = Date.valueOf(request.getParameter("bdate"));
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/hangout", "postgres", "isha@123");
			PreparedStatement ps=con.prepareStatement("update employee set ssn=?, ename=?, address=?, mob=?, email=?, bdate=? where ssn ='"+ssn+"' ");
			ps.setString(1, ssn);
			ps.setString(2, ename);
			ps.setString(3, address);
			ps.setString(4, mob);
			ps.setString(5, email);
			ps.setDate(6, bdate);
			
			int i = ps.executeUpdate();
			

			String msg=" ";
			if(i!=0) {
				msg="record has been inserted";
				out.println("<font size='6' color=blue>" + msg + "</font>");
			}else {
				msg="failed to insert data";
				out.println("<font size='6' color=blue>" + msg + "</font>");
			}ps.close();
			
		
		
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
	


	}


