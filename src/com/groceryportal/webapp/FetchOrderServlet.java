/**International Technological University, SanJose
 * 
 */

package com.groceryportal.webapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.groceryportal.valueobjects.ItemsVO;
import com.groceryportal.valueobjects.OrderItemVO;
import com.groceryportal.valueobjects.UserVO;

/**
 * Servlet implementation class FetchOrderServlet
 * @author PoorvishaMuthusamy
 */
@WebServlet("/FetchOrderServlet")
public class FetchOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    final String DB_URL = "jdbc:mysql://127.0.0.1:3306/GROCERY_SHOP";
	  String driver = "com.mysql.jdbc.Driver";
	  String userName = "root";
	  String password = "root";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 
		  response.setContentType("text/html");
		  Connection conn = null;
		  PreparedStatement pst = null;
		  ResultSet rs = null;
		  PreparedStatement pst1 = null;
		 
		  List<OrderItemVO> itemsListVO = new ArrayList<OrderItemVO>();
		  
		  UserVO userVo = null;
		  double order_total = 0.0;
		  try {
			  String order_id = request.getParameter("orderid");
			  HttpSession session = request.getSession(false); 
		        if(session!=null)  {
		        	userVo = (UserVO)session.getAttribute("userVo");
		        }
			   int current_order_id;
			   if(null != order_id){
				   current_order_id = Integer.parseInt(order_id) ;
			   }else{
				   current_order_id = userVo.getCurrent_order_id();
			   }			   
			   Class.forName(driver).newInstance();
			   conn = DriverManager
			    .getConnection(DB_URL, userName, password);
			   pst = conn
			    .prepareStatement("select * from order_items where order_id=?");
			   pst.setInt(1, current_order_id);
			
			   rs = pst.executeQuery();
			   int itemId = 0;
			   while(rs.next()) {
				   OrderItemVO itemsVO = new OrderItemVO();
				   double item_total_price = rs.getDouble("total_price");
				   itemId = rs.getInt("item_id");
				   itemsVO.setItem_id(itemId);
				   itemsVO.setQuantity_ordered(rs.getInt("quantity_ordered"));
				   itemsVO.setTotal_price(item_total_price);
				   itemsVO.setItemVo(getItemForId(itemId));
				   itemsListVO.add(itemsVO);
				   order_total += item_total_price;
			   }
			   pst1 = conn
					    .prepareStatement("update user_orders set order_total_price =? where order_id=?");
					   pst1.setDouble(1, order_total);
					   pst1.setInt(2, current_order_id);
					   pst1.executeUpdate();
			   request.setAttribute("orderItemsList", itemsListVO);
			   request.setAttribute("orderTotal",order_total);
			   request.setAttribute("orderid",current_order_id);
			   request.setAttribute("orderStatus",getOrderStatus(current_order_id));
			   RequestDispatcher requestDispatcher = request.getRequestDispatcher("ViewCart.jsp");
			   requestDispatcher.forward(request, response);
			   
		  }catch (Exception e) {
			  System.out.println(e);
		  } finally {
			   if (conn != null) {
				    try {
				    	conn.close();
				    } catch (SQLException e) {
				    	e.printStackTrace();
				    }
			   }
			   if (pst != null) {
				    try {
				    	pst.close();
				    } catch (SQLException e) {
				    	e.printStackTrace();
				    }
			   }
			   if (rs != null) {
				    try {
				    	rs.close();
				    } catch (SQLException e) {
				    	e.printStackTrace();
				    }
			   }
		  }	
		}
	
	private ItemsVO getItemForId(int itemId){
		Connection conn = null;
		  PreparedStatement pst = null;
		  ResultSet rs = null;
		  
		  ItemsVO itemsVO = new ItemsVO();
		  try{
		  Class.forName(driver).newInstance();
		   conn = DriverManager
		    .getConnection(DB_URL, userName, password);
		pst = conn
			    .prepareStatement("select * from items where item_id=?");
			   pst.setInt(1, itemId);
			
			   rs = pst.executeQuery();
			   
			   while(rs.next()) {
				   itemsVO.setItem_id(rs.getInt("item_id"));
				   itemsVO.setItem_name(rs.getString("item_name"));
				   itemsVO.setItem_price(rs.getDouble("item_price"));
				   itemsVO.setItem_image_url(rs.getString("item_image_url"));
			   }
		  }catch (Exception e) {
			  System.out.println(e);
		  } finally {
			   if (conn != null) {
				    try {
				    	conn.close();
				    } catch (SQLException e) {
				    	e.printStackTrace();
				    }
			   }
			   if (pst != null) {
				    try {
				    	pst.close();
				    } catch (SQLException e) {
				    	e.printStackTrace();
				    }
			   }
			   if (rs != null) {
				    try {
				    	rs.close();
				    } catch (SQLException e) {
				    	e.printStackTrace();
				    }
			   }
		  }
			  return itemsVO;
	}
	
	private String getOrderStatus(int order_id){
		Connection conn = null;
		  PreparedStatement pst = null;
		  ResultSet rs = null;
		 
		  String orderStatus = "INVALID_ORDER";
		  try{
		  Class.forName(driver).newInstance();
		   conn = DriverManager
		    .getConnection(DB_URL, userName, password);
		pst = conn
			    .prepareStatement("select * from user_orders where order_id=?");
			   pst.setInt(1, order_id);
			
			   rs = pst.executeQuery();
			   if(rs.next()){
				   orderStatus = rs.getString("order_status");
			   }
		  }catch (Exception e) {
			  System.out.println(e);
		  } finally {
			   if (conn != null) {
				    try {
				    	conn.close();
				    } catch (SQLException e) {
				    	e.printStackTrace();
				    }
			   }
			   if (pst != null) {
				    try {
				    	pst.close();
				    } catch (SQLException e) {
				    	e.printStackTrace();
				    }
			   }
			   if (rs != null) {
				    try {
				    	rs.close();
				    } catch (SQLException e) {
				    	e.printStackTrace();
				    }
			   }
		  }
			  return orderStatus;
	}
	
	private String getOrderTotalPrice(int order_id){
		Connection conn = null;
		  PreparedStatement pst = null;
		  ResultSet rs = null;
		  
		  String orderTotalPrice = "INVALID_ORDER";
		  try{
		  Class.forName(driver).newInstance();
		   conn = DriverManager
		    .getConnection(DB_URL, userName, password);
		pst = conn
			    .prepareStatement("select * from user_orders where order_id=?");
			   pst.setInt(1, order_id);
			
			   rs = pst.executeQuery();
			   if(rs.next()){
				   orderTotalPrice = rs.getString("order_total_price");
			   }
		  }catch (Exception e) {
			  System.out.println(e);
		  } finally {
			   if (conn != null) {
				    try {
				    	conn.close();
				    } catch (SQLException e) {
				    	e.printStackTrace();
				    }
			   }
			   if (pst != null) {
				    try {
				    	pst.close();
				    } catch (SQLException e) {
				    	e.printStackTrace();
				    }
			   }
			   if (rs != null) {
				    try {
				    	rs.close();
				    } catch (SQLException e) {
				    	e.printStackTrace();
				    }
			   }
		  }
			  return orderTotalPrice;
	}
		
	}



