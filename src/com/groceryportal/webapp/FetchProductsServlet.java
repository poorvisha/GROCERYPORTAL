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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.groceryportal.valueobjects.ItemsVO;

/**
 * Servlet implementation class FetchProductsServlet
 * @author PoorvishaMuthusamy
 */

public class FetchProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchProductsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 
		  response.setContentType("text/html");
		  Connection conn = null;
		  PreparedStatement pst = null;
		  ResultSet rs = null;
		  List<ItemsVO> itemsListVO = new ArrayList<ItemsVO>();
		  final String DB_URL = "jdbc:mysql://127.0.0.1:3306/GROCERY_SHOP";
		  String driver = "com.mysql.jdbc.Driver";
		  String userName = "root";
		  String password = "root";
		  try {
			   String itemCategory = request.getParameter("cat");
			   Class.forName(driver).newInstance();
			   conn = DriverManager
			    .getConnection(DB_URL, userName, password);
			   pst = conn
			    .prepareStatement("select * from items where item_category=?");
			   pst.setString(1, itemCategory);
			
			   rs = pst.executeQuery();
			   
			   while(rs.next()) {
				   ItemsVO itemsVO = new ItemsVO();
				   itemsVO.setItem_id(rs.getInt("item_id"));
				   itemsVO.setItem_name(rs.getString("item_name"));
				   itemsVO.setItem_price(rs.getDouble("item_price"));
				   if(rs.getInt("item_avail") == 1)
				   {
				   itemsVO.setItem_avail("Available");
				   }				   
				   else
				   {
				   itemsVO.setItem_avail("Not Available"); 
				   }
				   itemsVO.setItem_image_url(rs.getString("item_image_url"));
				   itemsVO.setItem_category(rs.getString("item_category"));
				   itemsListVO.add(itemsVO);
			   }
			   request.setAttribute("itemsList", itemsListVO);
			   
			   RequestDispatcher rd = request.getRequestDispatcher("Products.jsp");
               rd.forward(request, response);
			   
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
		
	}



