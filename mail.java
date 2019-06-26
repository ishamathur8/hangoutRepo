

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;  
import javax.mail.*;  
import javax.mail.internet.*; 



/**
 * Servlet implementation class mail
 */
@WebServlet("/mail")
public class mail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mail() {
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
		String id=request.getParameter("id");
		   
		   int month=Integer.parseInt(request.getParameter("month"));
		   int year=Integer.parseInt(request.getParameter("year"));
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/hangout", "postgres", "isha@123");
			PreparedStatement ps=con.prepareStatement("select * from public.attendance where assn=? and EXTRACT(month FROM adate)=? and EXTRACT(year FROM adate)=? ");
			ps.setString(1, id);
			
			ps.setInt(2, month);
			
			ps.setInt(3, year);
			
			ResultSet rs = ps.executeQuery();
			String x="";
			String y="";
			String z="";
			
			while(rs.next()) {
				 x = rs.getString("adate");
			     y = rs.getString("attendance");
			     z += (x + " " + ":" + " " + y + "\n");
			}
			PreparedStatement pst=con.prepareStatement("select email from public.employee,public.attendance where ssn=assn ");
			ResultSet rst = pst.executeQuery();
			String email="";
			while(rst.next()) {
				email = rst.getString("email");
			}
			String host="smtp.googlemail.com";  
			final String user="ishamathur456@gmail.com";//change accordingly  
			final String password="jagrati@123";//change accordingly  
				    
			String to=(email);//change accordingly  
				  
				   //Get the session object  
			Properties props = new Properties();  
			props.put("mail.smtp.host",host); 
			props.put("mail.smtp.socketFactory.port", "465");    
	          props.put("mail.smtp.socketFactory.class",    
	                    "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true"); 
			props.put("mail.smtp.port", "465");
				     
			Session session = Session.getDefaultInstance(props,  
			new javax.mail.Authenticator() {  
			protected PasswordAuthentication getPasswordAuthentication() {  
				    return new PasswordAuthentication(user,password);  
				      }  
				    });  
				  
				   //Compose the message  
				    try {  
				     MimeMessage message = new MimeMessage(session);  
				     message.setFrom(new InternetAddress(user));  
				     message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
				     message.setSubject("");  
				     message.setText(z);  
				       
				    //send the message  
				     Transport.send(message);  
				  
				     System.out.println("message sent successfully...");  
				   
				     } catch (MessagingException e) {e.printStackTrace();}  
				       catch(Exception e) {
				    	   e.printStackTrace();
				       }
			 

			
			
			
			rs.close();
		      con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
			    
			
			
	}

}
 