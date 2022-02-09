package com.cognizant.truyum.dao;

/**
 * @author Sai Kiran
 *
 */

import java.lang.Exception;

@SuppressWarnings("serial")
public class CartEmptyException extends Exception {
	
	public CartEmptyException(String s) {
		super(s);
	}
	
}
