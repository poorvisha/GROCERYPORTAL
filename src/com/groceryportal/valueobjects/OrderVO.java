/**International Technological University, SanJose
 * 
 */
package com.groceryportal.valueobjects;
/**
 * @author PoorvishaMuthusamy
 *
 */
public class OrderVO {
	
	private int user_id;
	private int order_id;
	private double order_total_price;
	private String order_status;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public double getOrder_total_price() {
		return order_total_price;
	}
	public void setOrder_total_price(double order_total_price) {
		this.order_total_price = order_total_price;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	

}
