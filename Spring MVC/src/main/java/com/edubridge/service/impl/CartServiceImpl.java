package com.edubridge.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edubridge.bean.Cart;
import com.edubridge.dao.CartDao;
import com.edubridge.exception.GenericException;
import com.edubridge.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDao cartdao;

	
	private static final String ERROR = "ERROR!";
	@Transactional
	public void add(Cart cart) {
		try {
			cartdao.add(cart);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	@Transactional
	public void edit(Cart cart) {
		try {
			cartdao.edit(cart);
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}
	
	@Transactional
	public void increase(int cartid) {
		try {
			cartdao.increase(cartid);
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}
	
	@Transactional
	public void decrease(int cartid) {
		try {
			cartdao.decrease(cartid);
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	@Transactional
	public void delete(Cart cart) {
		try {
			cartdao.delete(cart);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}
	
	@Transactional
	public void pricesum(Cart cart) {
		try {
			cartdao.pricesum(cart);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

	@Transactional
	public Cart getCartByCartId(int cartid) {
		try {
			return cartdao.getCartByCartId(cartid);
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

	@Transactional
	public List<Cart> getAllCartItems(Cart cart) {
		try {
			return cartdao.getAllCartItems(cart);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}
}
