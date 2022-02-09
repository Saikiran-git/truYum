package com.cognizant.truyum.dao;

/**
 * @author Sai Kiran
 *
 */

import com.cognizant.truyum.model.MenuItem;
//import com.cognizant.truyum.util.DateUtil;
import com.cognizant.truyum.util.DateUtil;

import java.util.ArrayList;

public class MenuItemDaoCollectionImpl implements MenuItemDao{
	
	private static ArrayList<MenuItem> menuItemList;
	
	public MenuItemDaoCollectionImpl(){
		
		// push all the menu items into menuItemList arrayList in this method
		ArrayList<MenuItem> newItem = new ArrayList<MenuItem>();
		try{
			MenuItem e1 = new MenuItem(1, "Sandwich", (float) 99.00, true, DateUtil.convertToDateYY("15-03-2017"), "Main Course", true);
			newItem.add(e1);
			MenuItem e2 = new MenuItem(2, "Burger", (float) 129.00, true, DateUtil.convertToDateYY("23-12-2017"), "Main Course", false);
			newItem.add(e2);
			MenuItem e3 = new MenuItem(3, "Pizza", (float) 149.00, true, DateUtil.convertToDateYY("21-08-2017"), "Main Course", false);
			newItem.add(e3);
			MenuItem e4 = new MenuItem(4, "French Fries", (float) 57.00, false, DateUtil.convertToDateYY("02-07-2017"), "Starters", true);
			newItem.add(e4);
			MenuItem e5 = new MenuItem(5, "Chocolate Brownie", (float) 32.00, true, DateUtil.convertToDateYY("15-03-2017"), "Desserts", true);
			newItem.add(e5);
			menuItemList = newItem;
		}
		
		catch(Exception nullPointerException){
			System.out.println("Can't add items");
		}
		
		
	}
	
	public ArrayList<MenuItem> getMenuItemListCustomer()  {
		
		ArrayList<MenuItem> menu = new ArrayList<MenuItem>();	
		for(MenuItem item : menuItemList)
			if((item.isActive() == true))
				menu.add(item);
		return menu;
		
	}
	
	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
		
		for(MenuItem item : menuItemList){
			if(item.getId() == menuItem.getId()){
				item.setId(menuItem.getId());
				item.setName(menuItem.getName());
				item.setCategory(menuItem.getCategory());
				item.setPrice(menuItem.getPrice());
				item.setActive(menuItem.isActive());
				item.setDateOfLaunch(menuItem.getDateOfLaunch());
			}
		}
		
	}
	
	@Override
	public MenuItem getMenuItem(long menuItemId) {
		// TODO Auto-generated method stub
		
		MenuItem menu = null;
		for(MenuItem item : menuItemList){
			if(item.getId() == menuItemId){
				menu = item;
				break;
			}
		}
		return menu;
		
	}
	
	public ArrayList<MenuItem> getMenuItemListAdmin() {
		
		return menuItemList;
	
	}

	
}
