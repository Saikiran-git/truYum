package com.cognizant.truyum.dao;

/**
 * @author Sai Kiran
 *
 */

import com.cognizant.truyum.model.*;
import com.cognizant.truyum.util.DateUtil;

import java.util.List;
import java.util.Scanner;

public class MenuItemDaoCollectionImplTest {

	static List<MenuItem> menuitems;
	static MenuItemDaoCollectionImpl menudata = new MenuItemDaoCollectionImpl();
	
	/**
	 * @param args
	 */
	
	static void testGetMenuItemListAdmin(){
		
		try {
			menuitems = menudata.getMenuItemListAdmin();
			for(MenuItem items : menuitems) 
				System.out.println(items);
		}
		
		catch(Exception e) {
			System.out.println("Can't retrieve Admin menu");
		}
		
	}
	
	static void testGetMenuItemListCustomer(){
		
		try {
			menuitems = menudata.getMenuItemListCustomer();
			for(MenuItem items : menuitems) 
				System.out.println(items);
		}
		catch(Exception e) {
			System.out.println("Can't retrieve Customer Menu");
		}
		
	}
	
	static void testModifyMenuItem(){
		
		try {
			MenuItem x = new MenuItem((long)1005, "Chocolate Brownie", 20.00f, true, DateUtil.convertToDateDD("01-06-2022"), "Dessert", true);
			menudata.modifyMenuItem(x);
			System.out.println("Modified");
		}
		
		catch(Exception e) {
			System.out.println("Not Modified");
		}
		
	}
	
	static void testGetMenuItem() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Menu Item id to retrieve items else enter '-1'");
		int id = sc.nextInt();
		sc.close();
		if(id == -1) 
			System.exit(0);
		MenuItem item = menudata.getMenuItem(id);
		System.out.println(item);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			System.out.println("Before Modification");
			MenuItemDaoCollectionImplTest.testGetMenuItemListAdmin();
			MenuItemDaoCollectionImplTest.testModifyMenuItem();
			System.out.println("Modified");
			MenuItemDaoCollectionImplTest.testGetMenuItemListAdmin();
		}
		
		catch (Exception e) {
			System.out.println("Item not modified nor listed");
		}
		
	}

}
