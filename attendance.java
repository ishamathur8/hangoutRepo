

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Calendar;
import java.util.Locale;
import java.text.DateFormatSymbols;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class attendance
 */
@WebServlet("/attendance")
public class attendance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public attendance() {
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
		String attendance = request.getParameter("attendance");
		HttpSession session = request.getSession(true);
		String user=(String)session.getAttribute("ussn");
		
		
		
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/hangout", "postgres", "isha@123");
			PreparedStatement ps=con.prepareStatement("insert into public.attendance(assn,adate,aday,attendance) values(?,?,?,?)");
			ps.setString(1,user);
			Locale usersLocale = Locale.getDefault();
			java.sql.Date adate = new java.sql.Date(new java.util.Date().getTime());
			ps.setDate(2,adate);
			DateFormatSymbols dfs = new DateFormatSymbols(usersLocale);
			String weekdays[] = dfs.getWeekdays();
			Calendar calendar = Calendar.getInstance();
			int day = calendar.get(Calendar.DAY_OF_WEEK);
			String aday = weekdays[day]; 
			ps.setString(3,aday);
			ps.setString(4,attendance);
		    ps.executeUpdate();
		    
			

			
			int i = ps.executeUpdate();
			
			String msg=" ";
			if(i!=0) {
				
				msg="record has been inserted";
				out.println("<font size='6' color=blue>" + msg + "</font>");
			}else {
				msg="failed to insert data";
				out.println("<font size='6' color=blue>" + msg + "</font>");
			}ps.close();
			
			


			
			}catch(Exception e){
			e.printStackTrace();
		}


	
		








	}

}
