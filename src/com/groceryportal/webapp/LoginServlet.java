/**International Technological University, SanJose
 * 
 */
package com.groceryportal.webapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.groceryportal.dao.LoginDAO;
import com.groceryportal.valueobjects.UserVO;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   response.setContentType("text/html"); 
		   PrintWriter out = response.getWriter();    
		 
	        String eMail=request.getParameter("email");    
	        String password=request.getParameter("password"); 
	        
	        RequestDispatcher rd = null;
	      
	        
	        HttpSession session = request.getSession(false); 
	        if(session!=null)  {
	        	  
	        	UserVO userVo = LoginDAO.validate(eMail, password);
         	   
	        	if(null != userVo)
	        	{
	        		session.setAttribute("userVo", userVo); 
	        		rd = request.getRequestDispatcher("HomePage.jsp");
					rd.forward(request, response);
	        	}else
	        	{
	        		rd = request.getRequestDispatcher("Login.jsp");
					rd.forward(request, response);
	        	}
	        }
	   out.close();
	}

}
