package com.cognizant.truyum.dao;

/**
 * @author Sai Kiran
 *
 */

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CartDaoSqlImpl implements CartDao {

	@Override
	public void addCartItem(long userId, long menuItemId) {
		// TODO Auto-generated method stub
		
		try {
			Connection con = ConnectionHandler.getConnection();
			String query = "INSERT INTO cart values(?, ?);";
			PreparedStatement prep = con.prepareStatement(query);
			prep.setInt(1, (int)userId);
			prep.setInt(2, (int)menuItemId);
			prep.execute();
			
		} 
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public ArrayList<MenuItem> getAllCartItems(long userId) throws CartEmptyException {
		// TODO Auto-generated method stub
		
		ArrayList<MenuItem> menuitems = new ArrayList<>();
		
		try {
			
			Connection con = ConnectionHandler.getConnection();
			Cart c = new Cart(menuitems, 0);
			
			String query = "SELECT m.id, m.name, m.price, m.active, m.dateOfLaunch, m.category, m.freeDelivery FROM menu_item AS m " + 
					"INNER JOIN cart AS c " + 
					"ON m.id = c.menuItemId " + 
					"WHERE c.userId = ?;";
			
			PreparedStatement prep = con.prepareStatement(query);
			prep.setInt(1, (int)userId);
			ResultSet rs = prep.executeQuery();
			
			while(rs.next()) {
				long id = (long)rs.getInt(1);
				String name = rs.getString(2);
				float price = rs.getFloat(3);
				String act = rs.getString(4);
				boolean active = act.equalsIgnoreCase("yes") ? true : false;
				String dateOfLaunch = rs.getString(5);
				String category = rs.getString(6);
				String fd = rs.getString(7);
				boolean freeDelivery = fd.equalsIgnoreCase("y") ? true : false;
				MenuItem item = new MenuItem(id, name, price, active, DateUtil.convertToDateYY(dateOfLaunch), category, freeDelivery);
				menuitems.add(item);
			}

			String query1 = "SELECT SUM(m.price) FROM menu_item AS m " + 
					"INNER JOIN cart AS c " + 
					"ON m.id = c.menuItemId " + 
					"WHERE c.userId = ?;";
			PreparedStatement prep1 = con.prepareStatement(query1);
			prep.setInt(1, (int)userId);
			ResultSet rs1 = prep1.executeQuery();
			rs1.next();
			float totalPrice = rs1.getFloat(1);
			c.setMenuItemList(menuitems);
			c.setTotal((double)totalPrice);
			
		}
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return menuitems;
		
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) {
		// TODO Auto-generated method stub
		
		try {
			Connection con = ConnectionHandler.getConnection();
			String query = "DELETE FROM cart WHERE userId = ? AND menuItemId = ?;";
			PreparedStatement prep = con.prepareStatement(query);
			prep.setInt(1, (int)userId);
			prep.setInt(2, (int)menuItemId);
			prep.execute();
			
		} 
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
