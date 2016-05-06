/**International Technological University, SanJose
 * 
 */
package com.groceryportal.webapp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.groceryportal.dao.CartOperationsDAO;
import com.groceryportal.valueobjects.UserVO;

/**
 * Servlet implementation class SubmitOrderServlet
 * @author PoorvishaMuthusamy
 */
@WebServlet("/SubmitOrderServlet")
public class SubmitOrderServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public SubmitOrderServlet() {
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
		
		int order_id=Integer.parseInt(request.getParameter("order_id"));
        
        HttpSession session = request.getSession(false); 
        if(session!=null)  {
        	 CartOperationsDAO cartOp = new CartOperationsDAO();
        	 if(cartOp.submitOrder(order_id)){
	        	 UserVO updatedUserVO = cartOp.createNewOrder((UserVO)session.getAttribute("userVo"));
	        	 session.setAttribute("userVo", updatedUserVO);
	        	 
        	 }else{
        		 
        	 }
			   
        }
	}

}
