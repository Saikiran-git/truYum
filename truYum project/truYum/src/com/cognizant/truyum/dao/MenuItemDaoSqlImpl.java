package com.cognizant.truyum.dao;

/**
 * @author Sai Kiran
 *
 */

import java.sql.*;
import java.util.*;

/**
 * @author Sai Kiran
 *
 */


import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImpl implements MenuItemDao {
	
	public ArrayList<MenuItem> getMenuItemListAdmin() {
		
	    ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();
		try { 
			
			String query = "SELECT * FROM menu_item;";
			Connection con = ConnectionHandler.getConnection();
			PreparedStatement prep = con.prepareStatement(query);
			ResultSet rs = prep.executeQuery();
			
			while(rs.next()){
				long id = (long)rs.getLong("id");
				String name  = rs.getString("name");
				float price = rs.getFloat("price");
				String act = rs.getString("active");
				boolean active = (act.equalsIgnoreCase("yes")) ? true : false;
				String dateOfLaunch = rs.getString("dateoflaunch");
				String category = rs.getString("category");
				String fd = rs.getString("freeDelivery");
				boolean freeDelivery = (fd.equalsIgnoreCase("yes")) ? true : false;
				MenuItem m1 = new MenuItem(id, name, price, active, DateUtil.convertToDateDD(dateOfLaunch), category, freeDelivery);
				menuItemList.add(m1);
			}
			
		} 
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return menuItemList ;
		
	}
	
	@Override
	public ArrayList<MenuItem> getMenuItemListCustomer(){
		
		ArrayList<MenuItem> menuItemListCust = new ArrayList<MenuItem>();
		
		try {
			Connection con = ConnectionHandler.getConnection();
			String query = "SELECT * FROM menu_item WHERE active = 'yes' AND dateoflaunch < CURDATE();";
			PreparedStatement prep = con.prepareStatement(query);
			ResultSet rs = prep.executeQuery();
			while(rs.next()){
				
				long id = rs.getLong("id");
				String name  = rs.getString("name");
				float price = rs.getFloat("price");
				String act = rs.getString("active");
				boolean active = (act.equalsIgnoreCase("yes")) ? true : false;
				String dateOfLaunch = rs.getString("dateOfLaunch");
				String category = rs.getString("category");
				String fd = rs.getString("freeDelivery");
				boolean freeDelivery = (fd.equalsIgnoreCase("yes")) ? true : false;
				
				
				MenuItem m1 = new MenuItem(id, name, price, active, DateUtil.convertToDateDD(dateOfLaunch), category, freeDelivery);
				menuItemListCust.add(m1);
			}
			
		} 
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return menuItemListCust;
		
	}
	
	@Override
	public MenuItem getMenuItem(long menuItemId){
				
		try {
			
			Connection con = ConnectionHandler.getConnection();
			String query = "SELECT * FROM menu_item WHERE id = "+menuItemId+";";
			PreparedStatement prep = con.prepareStatement(query);
			ResultSet rs = prep.executeQuery();
			while(rs.next()) {
				
				long id = (long)rs.getInt("id");
				String name = rs.getString("name");
				float price = rs.getFloat("price");
				String act = rs.getString("active");
				boolean active = act.equalsIgnoreCase("yes") ? true : false;
				String dateOfLaunch = rs.getString("dateOfLaunch");
				String category = rs.getString("category");
				String fd = rs.getString("freeDelivery");
				boolean freeDelivery = (fd.equalsIgnoreCase("y")) ? true : false;
				MenuItem m = new MenuItem(id, name, price, active, DateUtil.convertToDateDD(dateOfLaunch), category, freeDelivery);
				return m;
				
			}
			
		} 
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;

	}
	
	
	public void editMenuItem(MenuItem menuItem) {
		
		try {
			
			Connection con = ConnectionHandler.getConnection();
			System.out.println(menuItem);
			
			String query = "UPDATE menu_item SET name = ?, price = ?, active = ?, dateOfLaunch = ?, category = ?, freeDelivery = ? WHERE id=?;";
			PreparedStatement prep = con.prepareStatement(query);
			prep.setString(1, menuItem.getName());
			prep.setFloat(2, menuItem.getPrice());
			boolean act = menuItem.isActive();
			String active = act ? "yes" : "no";
			prep.setString(3,active);
			java.util.Date dt =  menuItem.getDateOfLaunch();
			java.sql.Date ndt = new java.sql.Date(dt.getTime());
			prep.setDate(4, ndt);
			prep.setString(5, menuItem.getCategory());
			boolean fd = menuItem.isFreeDelivery();
			String freeDelivery = fd ? "yes" : "no";
			prep.setString(6, freeDelivery);
			prep.setInt(7, (int)menuItem.getId());
			prep.execute();
		}
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
		


	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
		
	}
	
}

