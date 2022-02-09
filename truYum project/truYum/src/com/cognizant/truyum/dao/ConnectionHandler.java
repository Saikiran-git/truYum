package com.cognizant.truyum.dao;

/**
 * @author Sai Kiran
 *
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.FileInputStream;
import java.util.Properties;

public class ConnectionHandler {
	private static Connection con = null;
	private static Properties props = new Properties();
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
	    try{
			FileInputStream fis = null;
			fis = new FileInputStream("C:\\Users\\Sai Kiran\\eclipse-workspace\\truYum\\src\\connection.properties");
			props.load(fis);
            con = DriverManager.getConnection(props.getProperty("connection-url"),props.getProperty("user"),props.getProperty("password"));
            System.out.print("Connection Established");
	    }
	    catch(Exception e){
	        e.printStackTrace();
	    }
		return con;	
	}
}
 
