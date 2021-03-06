/**International Technological University, SanJose
 * 
 */

package com.groceryportal.webapp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.groceryportal.dao.CartOperationsDAO;
import com.groceryportal.valueobjects.UserVO;

/**
 * Servlet implementation class AddItemServlet
 * @author PoorvishaMuthusamy
 */
@WebServlet("/AddItemServlet")
public class AddItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddItemServlet() {
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
		
		int item_id=Integer.parseInt(request.getParameter("item_id"));    
        int quantity=Integer.parseInt(request.getParameter("quantity")); 
        
        HttpSession session = request.getSession(false); 
        if(session!=null)  {
        	CartOperationsDAO cartOp = new CartOperationsDAO(); 
        	UserVO userVo = (UserVO)session.getAttribute("userVo");
        	cartOp.addItemToCart(item_id,quantity,userVo);
        	
        }
	}

}
