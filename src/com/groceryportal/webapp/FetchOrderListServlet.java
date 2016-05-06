/**International Technological University, SanJose
 * 
 */
package com.groceryportal.webapp;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class FetchOrderListServlet
 * @author PoorvishaMuthusamy
 */
@WebServlet("/FetchOrderListServlet")
public class FetchOrderListServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public FetchOrderListServlet() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub 
        
        HttpSession session = request.getSession(false); 
        if(session!=null)  {
        	CartOperationsDAO cartOp = new CartOperationsDAO(); 
        	UserVO userVo = (UserVO)session.getAttribute("userVo");
        	List<String> orderIdList= cartOp.fetchOrderIds(userVo);
        	request.setAttribute("orderIds", orderIdList);
        	RequestDispatcher requestDispatcher = request.getRequestDispatcher("OrderList.jsp");
			requestDispatcher.forward(request, response);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
