

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
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
		String ssn=request.getParameter("id");
		int id=Integer.valueOf(ssn);
		out.println("<html><body><table border='1'><tr><th>ssn</th><th>ename</th><th>address</th><th>mob</th><th>email</th><th>bdate</th></tr>");
		
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/hangout", "postgres", "isha@123");
			PreparedStatement ps=con.prepareStatement("select * from public.employee where ssn=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				out.print("<tr><td>");
				out.println(rs.getInt("ssn"));
				out.print("</td><td>");
				out.println(rs.getString("ename"));
				out.print("</td><td>");
				out.println(rs.getString("address"));
				out.print("</td><td>");
				out.println(rs.getString("mob"));
				out.print("</td><td>");
				out.println(rs.getString("email"));
				out.print("</td><td>");
				out.println(rs.getString("bdate"));
				out.print("</td></tr>");
			}
			out.println("</table></body></html>");

			
		
		
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	}


