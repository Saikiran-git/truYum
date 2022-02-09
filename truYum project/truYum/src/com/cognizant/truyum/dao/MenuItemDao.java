package com.cognizant.truyum.dao;

/**
 * @author Sai Kiran
 *
 */


import com.cognizant.truyum.model.*;
import java.util.ArrayList;

public interface MenuItemDao {
	public ArrayList<MenuItem> getMenuItemListCustomer();
	public ArrayList<MenuItem> getMenuItemListAdmin();
	public void modifyMenuItem(MenuItem menuItem);
	MenuItem getMenuItem(long menuItemId);
}
