package com.cognizant.truyum.model;

/**
 * @author Sai Kiran
 *
 */

import java.util.ArrayList;

public class Cart {
	
	private ArrayList<MenuItem> menuItemList;
	private double total;
	
	public Cart() {
		
	}
	
	public Cart(ArrayList<MenuItem> menuItemList, double total) {
		super();
		this.menuItemList = menuItemList;
		this.total = total;
	}

	/**
	 * @return the menuList
	 */
	public ArrayList<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	/**
	 * @param menuList the menuList to set
	 */
	public void setMenuItemList(ArrayList<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

	/**
	 * @return the total
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Cart [menuItemList=" + menuItemList + ", total=" + total + "]";
	}
	
	
}
