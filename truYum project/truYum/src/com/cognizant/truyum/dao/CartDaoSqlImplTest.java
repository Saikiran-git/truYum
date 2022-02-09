package com.cognizant.truyum.dao;

/**
 * @author Sai Kiran
 *
 */

import java.util.ArrayList;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImplTest {
	
	public static void testAddCartItem() {
		
		try {
			CartDaoSqlImpl c = new CartDaoSqlImpl();
			c.addCartItem(1, 5);
			c.addCartItem(1, 1);
			System.out.println("Items added to cart.");
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void testGetAllCartItems() {
		
		try {
			System.out.println("All cart items");
			CartDaoSqlImpl cartDao = new CartDaoSqlImpl();
			ArrayList<MenuItem> menuitem = cartDao.getAllCartItems(1);
			for(int i = 0; i < menuitem.size(); i++) 
				System.out.println(menuitem.get(i));
		}
		
		catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void testRemoveCartItem() {
		
		try {
			CartDaoSqlImpl c = new CartDaoSqlImpl();
			c.removeCartItem(1, 5);
			System.out.println("Item removed");
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
