package com.cognizant.truyum.dao;

/**
 * @author Sai Kiran
 *
 */

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

import java.util.*;

public class CartDaoCollectionImpl implements CartDao{

	private static HashMap<Long, Cart> userCarts;
	ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();

	public CartDaoCollectionImpl(){
        if(userCarts == null)
	        userCarts = new HashMap<Long, Cart>();
    }
	
	public static HashMap<Long, Cart> getuserCarts() {
		return userCarts;
	}
	
	public static void setuserCarts(HashMap<Long, Cart> userCarts) {
		CartDaoCollectionImpl.userCarts = userCarts;
	}
	
	@Override
	public void addCartItem(long userId, long menuItemId) {
		// TODO Auto-generated method stub
		
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);
		
		if(userCarts.containsKey(userId)){
			menuItemList = (ArrayList<MenuItem>) 
					userCarts.get(userId).getMenuItemList();
			menuItemList.add(menuItem);
		}
		
		else{
			ArrayList<MenuItem>menuItemList = new ArrayList<MenuItem>();
			menuItemList.add(menuItem);
			Cart c = new Cart(menuItemList, 0);
			c.setMenuItemList(menuItemList);
			userCarts.put(userId, c);
		}
		
	}

	@Override
	public ArrayList<MenuItem> getAllCartItems(long userId) throws CartEmptyException {
		// TODO Auto-generated method stub
		
		ArrayList<MenuItem>menuItemList = new ArrayList<MenuItem>();
		double total = 0.0;
		
		menuItemList = (ArrayList<MenuItem>)userCarts.get(userId).getMenuItemList();
		
		if(menuItemList.isEmpty()){
			throw new CartEmptyException("Cart is empty");
		}
		
		for(MenuItem item : menuItemList)
			total += item.getPrice();
		
		userCarts.get(userId).setTotal(total);
		return menuItemList;
		
	}
	
	public double getTotal(long userId) {
		return userCarts.get(userId).getTotal();
	}
	
	@Override
	public void removeCartItem(long userId, long menuItem) {
		// TODO Auto-generated method stub
		
		ArrayList<MenuItem>menuItemList = (ArrayList<MenuItem>) userCarts.get(userId).getMenuItemList();
		double total = userCarts.get(userId).getTotal();
		for(MenuItem item : menuItemList){
			if(item.getId() == menuItem){
		        menuItemList.remove(menuItemList.indexOf(item));
		        total -= item.getPrice();
		        break;
			}
			userCarts.get(userId).setMenuItemList(menuItemList);
			userCarts.get(userId).setTotal(total);
		}
		
	}
	
}
