package sl314.myservlets;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.*;
import javax.naming.*;
import javax.sql.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Servlet implementation class MyStudentsJNDIServlet
 */
@WebServlet("/MyStudentsJNDIServlet")
public class MyStudentsJNDIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyStudentsJNDIServlet() {
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
		
		Connection con=null;
		
		try
		{
		InitialContext ic=new InitialContext();
		DataSource ds=(DataSource)ic.lookup("java:/comp/env/jdbc/studentsDB");
		con=ds.getConnection();
		
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select students_details.first_name,students_details.last_name,students_details.Phone_no,marks.physics,marks.chemistry,marks.maths from students_details INNER JOIN marks ON students_details.id=marks.id");
		
		PreparedStatement ps = con.prepareStatement("insert into students_details(first_name,last_name,Phone_no)VALUES(?,?,?)insert into marks(physics,chemistry,maths)VALUES(?,?,?)");
		ps.setString(1, "Venkatesa ram s");
		ps.setString(2, "New row creating");
		ps.setString(3, "8056107589");
		ps.setInt(1, 100);
		ps.setInt(2, 98);
		ps.setInt(3, 99);
		
		
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<head><style>"
				+ "table{width:80%;border-collapse:collapse;}"
				+ "th,td{width:16%;border:2px solid black;text-align:center;}"
				+"th{background-color:#f2f2f2}"
				+ "</style>"
				+ "</head>");
		
		out.println("<H1> Below are the student details:</H1>");
		
		out.println("<table><tr><th>FirstName</th><th>LastName</th><th>Phone No</th><th>Physics</th><th>Chemistry</th><th>Maths</th><tr>");
		
		
		while(rs.next())
		{
			out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getInt(4)+"</td><td>"+rs.getInt(5)+"</td><td>"+rs.getInt(6)+"</td><tr>");
		}
		
		out.println("</table>");
			
		}
		catch(NamingException ne)
		{
			ne.printStackTrace();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		finally
		{
			try
			{
				con.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
		}
	}

}
