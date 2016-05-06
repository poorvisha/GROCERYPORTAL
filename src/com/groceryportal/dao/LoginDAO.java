/**International Technological University, SanJose
 * 
 */

package com.groceryportal.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import com.groceryportal.valueobjects.UserVO;



public class LoginDAO { 
    
    public static UserVO validate(String eMail, String loginPassword) {          
       
        Connection conn = null;  
        PreparedStatement pst = null;
        PreparedStatement pst1 = null;
        PreparedStatement pst2 = null; 
        ResultSet rs = null;
        ResultSet rs1 = null;
        
        final String DB_URL="jdbc:mysql://127.0.0.1:3306/GROCERY_SHOP"; 
        String driver = "com.mysql.jdbc.Driver";  
        String userName = "root";  
        String password = "root";
        UserVO userVo = null;
        try {  
            Class.forName(driver).newInstance();  
            conn = DriverManager  
                    .getConnection(DB_URL, userName, password);  
  
            pst = conn  
                    .prepareStatement("select * from user_details where email_id=?  and password=? ");  
            pst.setString(1, eMail);  
            pst.setString(2, loginPassword);  
  
            rs = pst.executeQuery();
         
            if(rs != null && rs.next()){
            	userVo = new UserVO(); 
            	int user_id = rs.getInt("user_id");
            	userVo.setUser_id(user_id);
        		userVo.setFirst_name(rs.getString("first_name"));
        		userVo.setLast_name(rs.getString("last_name"));
        		userVo.setEmail(rs.getString("email_id"));
        		userVo.setPassword(rs.getString("password"));
        		userVo.setAddress_line1(rs.getString("address_line1"));
        		userVo.setAddress_line2(rs.getString("address_line2"));
        		userVo.setCity(rs.getString("city"));
        		userVo.setState(rs.getString("state"));
        		userVo.setCountry(rs.getString("country"));
        		userVo.setZipcode(rs.getString("zipcode"));	 
        		userVo.setPhone(rs.getString("phone"));		 
        		
        		pst1 = conn  
                        .prepareStatement("select * from user_orders where user_id=?  and order_status=?"); 
        		pst1.setInt(1, user_id);
        		pst1.setString(2, "INCOMPLETE");
        		rs1 = pst1.executeQuery();
        		if(rs1 != null && rs1.next()){
        			userVo.setCurrent_order_id(rs1.getInt("order_id"));
        		}else{
        			Random rand = new Random();

        			int  n = rand.nextInt(50) + 1;
        			pst2 = conn  
                            .prepareStatement("insert into user_orders(user_id,order_id,order_total_price,order_status) values (?,?,?,?)");
            		pst2.setInt(1, user_id);
            		pst2.setInt(2, n);
            		pst2.setDouble(3, 0.0);
            		pst2.setString(4, "INCOMPLETE");
            		pst2.executeUpdate();
            		userVo.setCurrent_order_id(n);
        		}
            	return userVo;
             
            }
  
        } catch (Exception e) {  
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
        return userVo;  
    }
    
    
}
