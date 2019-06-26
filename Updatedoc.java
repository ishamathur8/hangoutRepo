

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Updatedoc
 */
@WebServlet("/Updatedoc")
public class Updatedoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updatedoc() {
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
		String dssn = request.getParameter("dssn");
		String dname = request.getParameter("dname");
		String floc = request.getParameter("floc");
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/hangout", "postgres", "isha@123");
			PreparedStatement ps=con.prepareStatement("update documents set dssn=?, dname=?, floc=? where dssn ='"+dssn+"' ");
			ps.setString(1, dssn);
			ps.setString(2, dname);
			ps.setString(3, floc);
			
			
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


