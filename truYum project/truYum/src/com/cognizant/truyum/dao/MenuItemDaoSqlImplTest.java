package com.cognizant.truyum.dao;

/**
 * @author Sai Kiran
 *
 */

import java.util.*;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoSqlImplTest {
	
	public static void testGetMenuItemListAdmin(){
				
		try {
			MenuItemDaoSqlImpl m = new  MenuItemDaoSqlImpl();
			ArrayList<MenuItem> menuitems = m.getMenuItemListAdmin();
			for(int i = 0; i < menuitems.size(); i++) 
				System.out.println(menuitems.get(i));
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void testGetMenuItemListCustomer() {
		
		try {
			MenuItemDaoSqlImpl m = new  MenuItemDaoSqlImpl();
			ArrayList<MenuItem> menuitems = m.getMenuItemListCustomer();
			for(int i = 0; i < menuitems.size(); i++) 
				System.out.println(menuitems.get(i));
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void testmodifyMenuItem(){
		
		try {
			MenuItemDaoSqlImpl menuitemsdao = new  MenuItemDaoSqlImpl();
			ArrayList<MenuItem> menuitems = menuitemsdao.getMenuItemListCustomer();
			for(int i = 0; i < menuitems.size(); i++) 
				System.out.println(menuitems.get(i));
			System.out.println("Changes applied");
		} 		
		
		catch (Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) throws CartEmptyException{
		
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
        testmodifyMenuItem();
        
	}
	

}
