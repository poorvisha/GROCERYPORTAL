/**International Technological University, SanJose
 * 
 */
package com.groceryportal.valueobjects;
/**
 * @author PoorvishaMuthusamy
 *
 */
public class ItemsVO{
	public int item_id;	
	public String item_name;
	public String item_image_url;
	public double item_price;
	public String item_avail;
	public String item_category;
	
	
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getItem_image_url() {
		return item_image_url;
	}
	public void setItem_image_url(String item_image_url) {
		this.item_image_url = item_image_url;
	}
	public double getItem_price() {
		return item_price;
	}
	public void setItem_price(double item_price) {
		this.item_price = item_price;
	}
	public String getItem_avail() {
		return item_avail;
	}
	public void setItem_avail(String item_avail) {
		this.item_avail = item_avail;
	}
	public String getItem_category() {
		return item_category;
	}
	public void setItem_category(String item_category) {
		this.item_category = item_category;
	}
}
