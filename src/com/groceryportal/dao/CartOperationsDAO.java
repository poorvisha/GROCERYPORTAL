/**International Technological University, SanJose
 * 
 */
package com.groceryportal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.groceryportal.valueobjects.UserVO;

/**
 * @author PoorvishaMuthusamy
 *
 */
public class CartOperationsDAO {
	
	
	/**Method to add items to cart
	 * @param item_id
	 * @param quantity
	 * @param userVo
	 * @return
	 */
	public boolean addItemToCart(int item_id,int quantity,UserVO userVo){
		boolean status = false;
		Connection conn = null;  
        PreparedStatement pst = null;  
        ResultSet resultSet = null;
        PreparedStatement pst1 = null;  
        ResultSet resultSet1 = null;
        PreparedStatement pst2 = null;  
        final String DB_URL="jdbc:mysql://127.0.0.1:3306/GROCERY_SHOP"; 
        String driver = "com.mysql.jdbc.Driver";  
        String userName = "root";  
        String password = "root"; 
        double item_price = 0.0;
        double order_item_price = 0.0;
        int current_order_id = userVo.getCurrent_order_id();
        try {
        	
            Class.forName(driver).newInstance();  
            conn = DriverManager  
                    .getConnection(DB_URL, userName, password);  
            pst = conn.prepareStatement("select * from items where item_id=?");
            pst.setInt(1, item_id);
            resultSet = pst.executeQuery();
            if(resultSet != null && resultSet.next()){
            	item_price = resultSet.getDouble("item_price");
            	order_item_price = item_price * quantity;
            }
            pst1 = conn.prepareStatement("select * from order_items where order_id=? and item_id=?");
            pst1.setInt(1, current_order_id);
            pst1.setInt(2,item_id);
            resultSet1 = pst1.executeQuery();
            if(resultSet1 != null && resultSet1.next()){
            	pst2 = conn.prepareStatement("update order_items set quantity_ordered=?,total_price=? where order_id=? and item_id=?");
            	pst2.setInt(1, quantity);
                pst2.setDouble(2, order_item_price);
            	pst2.setInt(3, current_order_id);
                pst2.setInt(4, item_id);
                pst2.executeUpdate();
            }else{
            pst2=conn.prepareStatement(  
            		"insert into order_items(order_id,item_id,quantity_ordered,total_price) values(?,?,?,?)");  
            		
            pst2.setInt(1, current_order_id);
            pst2.setInt(2, item_id);
            pst2.setInt(3, quantity);
            pst2.setDouble(4, order_item_price);		
            pst2.executeUpdate(); 
                 	
            }
  
}
        catch (Exception e) {  
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
            if (resultSet != null) {  
                try {  
                	resultSet.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
        return status;
	}
	
	/**Method to remove items from cart
	 * @param item_id
	 * @param userVo
	 * @return
	 */
	public boolean removeItemFromCart(int item_id,UserVO userVo){
		boolean status = false;
		Connection conn = null;  
        PreparedStatement pst = null;  
     
        final String DB_URL="jdbc:mysql://127.0.0.1:3306/GROCERY_SHOP"; 
        String driver = "com.mysql.jdbc.Driver";  
        String userName = "root";  
        String password = "root"; 
        int current_order_id = userVo.getCurrent_order_id();
        try {
        	
            Class.forName(driver).newInstance();  
            conn = DriverManager  
                    .getConnection(DB_URL, userName, password);  
            
            pst = conn.prepareStatement("delete from order_items where order_id=? and item_id=?");
            pst.setInt(1, current_order_id);
            pst.setInt(2,item_id);
            pst.executeUpdate();	        
	
}
        catch (Exception e) {  
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
        }  
        return status;
	}
	
	
	/**Method to submit order
	 * @param order_id
	 * @return
	 */
	public boolean submitOrder(int order_id){
		boolean status = false;
		Connection conn = null;  
        PreparedStatement pst = null;  
     
        final String DB_URL="jdbc:mysql://127.0.0.1:3306/GROCERY_SHOP"; 
        String driver = "com.mysql.jdbc.Driver";  
        String userName = "root";  
        String password = "root";
        try {
        	
            Class.forName(driver).newInstance();  
            conn = DriverManager  
                    .getConnection(DB_URL, userName, password);  
            
            pst = conn.prepareStatement("update user_orders set order_status=? where order_id=?");
            pst.setString(1, "SUBMITTED");
            pst.setInt(2, order_id);
            pst.executeUpdate();
            status = true;
	
}
        catch (Exception e) {  
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
        }  
        return status;
	}
	
	/**Method to Fetch OrderIds
	 * @param userVO
	 * @return
	 */
	public List<String> fetchOrderIds(UserVO userVO){
		List<String> orderIdList = new ArrayList<String>();

		Connection conn = null;  
        PreparedStatement pst = null;  
        ResultSet rs = null;
     
        final String DB_URL="jdbc:mysql://127.0.0.1:3306/GROCERY_SHOP"; 
        String driver = "com.mysql.jdbc.Driver";  
        String userName = "root";  
        String password = "root";
        try {
        	int user_id = userVO.getUser_id();
            Class.forName(driver).newInstance();  
            conn = DriverManager  
                    .getConnection(DB_URL, userName, password);  
            
            pst = conn.prepareStatement("select * from user_orders where user_id=? and order_status !=?");
            pst.setInt(1, user_id);
            pst.setString(2, "INCOMPLETE");
            rs = pst.executeQuery();
            while(rs.next()){
            	orderIdList.add(rs.getString("order_id"));
            }
	
        }
        catch (Exception e) {  
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
        }
		return orderIdList;
		
	}
	
	/**Method to create new order
	 * @param userVO
	 * @return
	 */
	public UserVO createNewOrder(UserVO userVO){
		
		Connection conn = null;  
        PreparedStatement pst = null;  
     
        final String DB_URL="jdbc:mysql://127.0.0.1:3306/GROCERY_SHOP"; 
        String driver = "com.mysql.jdbc.Driver";  
        String userName = "root";  
        String password = "root";
        try {
        	int user_id = userVO.getUser_id();
            Class.forName(driver).newInstance();  
            conn = DriverManager  
                    .getConnection(DB_URL, userName, password);  
            

			Random rand = new Random();

			int  n = rand.nextInt(50) + 1;
			pst = conn  
                    .prepareStatement("insert into user_orders(user_id,order_id,order_total_price,order_status) values (?,?,?,?)");
			pst.setInt(1, user_id);
			pst.setInt(2, n);
			pst.setDouble(3, 0.0);
			pst.setString(4, "INCOMPLETE");
			pst.executeUpdate();
			userVO.setCurrent_order_id(n);
		
	
        }
        catch (Exception e) {  
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
        }
		return userVO;
		
	}

}
