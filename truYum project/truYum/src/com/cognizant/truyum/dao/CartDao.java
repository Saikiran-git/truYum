package com.cognizant.truyum.dao;

/**
 * @author Sai Kiran
 *
 */

import java.util.ArrayList;

import com.cognizant.truyum.model.MenuItem;

public interface CartDao {

	public void addCartItem(long userId,long menuItemId);
	public ArrayList<MenuItem> getAllCartItems(long userId) throws CartEmptyException;
	public void removeCartItem(long userId,long menuItemId);
	
}