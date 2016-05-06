/**International Technological University, SanJose
 * 
 */
package com.groceryportal.valueobjects;

/**
 * @author PoorvishaMuthusamy
 *
 */
public class OrderItemVO {
	
	private int order_id;
	private int item_id;
	private int quantity_ordered ;
	private double total_price;
	private ItemsVO itemVo;

	public ItemsVO getItemVo() {
		return itemVo;
	}
	public void setItemVo(ItemsVO itemVo) {
		this.itemVo = itemVo;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public int getQuantity_ordered() {
		return quantity_ordered;
	}
	public void setQuantity_ordered(int quantity_ordered) {
		this.quantity_ordered = quantity_ordered;
	}
	public double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}

}
