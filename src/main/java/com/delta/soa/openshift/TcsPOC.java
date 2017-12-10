package com.delta.soa.openshift;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TcsPOC
 */
public class TcsPOC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TcsPOC() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String result = "";
		Connection con;
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection("jdbc:mysql://mysql:3306/pocdb","root","root");  
			//here sonoo is database name, root is username and password  
			Statement stmt=con.createStatement();  
			
			ResultSet rs=stmt.executeQuery("select * from pocusertb"); 
			while(rs.next())  
			{
				result += rs.getString(1)+" -- "+rs.getString(2)+"  --  "+rs.getString(3) + "\n";
			}
			
			con.close();
		}catch(Exception e){ System.out.println(e);} finally {
		}
			
	response.getWriter().append(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		doGet(request, response);
		
	}

}

	

	