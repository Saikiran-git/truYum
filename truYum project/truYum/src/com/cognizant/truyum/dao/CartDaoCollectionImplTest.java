package com.cognizant.truyum.dao;


/**
 * @author Sai Kiran
 *
 */

import com.cognizant.truyum.model.MenuItem;

import java.util.ArrayList;

public class CartDaoCollectionImplTest {

	/**
	 * @param args
	 */
		
	static void testAddCartItem() throws CartEmptyException{
		
		try {
			CartDaoCollectionImpl cartDao = new CartDaoCollectionImpl();
			cartDao.addCartItem(1, 2);
			ArrayList<MenuItem> menuItemList = cartDao.getAllCartItems(1);
			for(MenuItem item : menuItemList)
				System.out.println(item);
		}
		
		catch(Exception e) {
			System.out.print("Can't add items to cart");
		}
		
	}
	
	static void testGetAllCartItems() throws CartEmptyException{
		
		try{
			CartDaoCollectionImpl cartDao = new CartDaoCollectionImpl();
			ArrayList<MenuItem> menuItemList = cartDao.getAllCartItems(1);
			for(MenuItem item : menuItemList)
				System.out.println(item);
			System.out.println("Retrieved all items");
		}
		
		catch(Exception e) {
			System.out.println("Can't retrieve cart items or cart is empty");
		}
		
	}
	//8886431095
	static void testRemoveCartItem() throws CartEmptyException{
		
		try {
			CartDaoCollectionImpl cartDao = new CartDaoCollectionImpl();
			cartDao.removeCartItem(1, 2);
			ArrayList<MenuItem> menuItemList = cartDao.getAllCartItems(1);
			for(MenuItem item : menuItemList)
				System.out.println(item);
			System.out.println("Item removed");
		}
		
		catch(Exception e) {
			System.out.println("Can't remove item from cart");
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			CartDaoCollectionImplTest.testAddCartItem();
			CartDaoCollectionImplTest.testGetAllCartItems();
			CartDaoCollectionImplTest.testRemoveCartItem();
		}
		
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
