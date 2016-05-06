/**International Technological University, SanJose
 * 
 */

package com.groceryportal.webapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.groceryportal.dao.RegisterDAO;

/**
 * Servlet implementation class RegisterServlet
 */

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		HttpSession session = request.getSession(false); 
		
		String firstName,lastName,email,password,addrLine1,addrLine2,city,state,country,zipCode,phone = null;
		boolean status = false;
		
		firstName = request.getParameter("first_name");
		lastName = request.getParameter("last_name");
		email = request.getParameter("email");
		password = request.getParameter("password");
		addrLine1 = request.getParameter("addressline1");
		addrLine2 = request.getParameter("addressline2");
		city = request.getParameter("city");
		state = request.getParameter("state");
		country = request.getParameter("country");
		zipCode = request.getParameter("zipcode");
		phone = request.getParameter("phone");
		
		try {
			status = RegisterDAO.enterUserCredentials(firstName, 
			 lastName, email, password, addrLine1, addrLine2, city, 
			 state, country, zipCode, phone);
			} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		if (status == true)
		{
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.jsp");
		    requestDispatcher.forward(request, response);
		}else
		{
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Register.jsp");
		    requestDispatcher.forward(request, response);
		}
		out.close();
	}

}
