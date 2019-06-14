

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class leaveApply
 */
@WebServlet("/leaveApply")
public class leaveApply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public leaveApply() {
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
		String lssn = request.getParameter("lssn");
		Date sdate = Date.valueOf(request.getParameter("sdate"));
		Date edate = Date.valueOf(request.getParameter("edate"));
		String reason = request.getParameter("reason");
		
		
		
			
		
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/hangout", "postgres", "isha@123");
			PreparedStatement ps = con.prepareStatement("insert into public.application(lssn,sdate,edate,reason) values(?,?,?,?)");
			
			ps.setString(1, lssn);
			ps.setDate(2, sdate);
			ps.setDate(3, edate);
			ps.setString(4, reason);
			HttpSession session = request.getSession(true);
			
			
			int i = ps.executeUpdate();
			
			String msg=" ";
			if(i!=0) {
				session.setAttribute("lssn",lssn);
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
		}
		}
	



	}


