package com.edubridge.service;

import java.util.List;

import com.edubridge.bean.Cart;

public interface CartService {

	void add(Cart cart);
	
	void edit(Cart cart);

	void delete(Cart cart);
	
	Cart getCartByCartId(int cartid);
	
	List<Cart> getAllCartItems(Cart cart);
	
	void increase(int cartid);
	
	void decrease(int cartid);
	
	void pricesum(Cart cartid);
}
