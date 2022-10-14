package com.edubridge.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edubridge.bean.Cart;
import com.edubridge.dao.CartDao;
import com.edubridge.exception.GenericException;
import com.edubridge.service.UserService;

@Repository
public class CartDaoImpl implements CartDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private static final String ERROR = "ERROR!";

	@Override
	public void add(Cart cart) {
		try {
			sessionFactory.getCurrentSession().save(cart);
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	@Override
	public void edit(Cart cart) {
		try {
			sessionFactory.getCurrentSession().update(cart);
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}
	
	@Override
	public void increase(int cartid) {
		try {
			Query query= sessionFactory.getCurrentSession().createQuery(
					"UPDATE Cart SET quantity = quantity + 1 WHERE cartid =: cartid");
			query.setParameter("cartid", cartid);
			int rowno = query.executeUpdate();
			System.out.println("rows updated are " +rowno);
		} catch (Exception e) {
			System.out.println(e);
			throw new GenericException(ERROR);
		}

	}
	
	@Override
	public void decrease(int cartid) {
		try {
			Query query= sessionFactory.getCurrentSession().createQuery(
					"UPDATE Cart SET quantity = quantity - 1 WHERE cartid =: cartid");
			query.setParameter("cartid", cartid);
			int rowno = query.executeUpdate();
			System.out.println("rows updated are " +rowno);
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}
	
	@Override
	public void pricesum(Cart cartid) {
		try {
			Query query= sessionFactory.getCurrentSession().createQuery(
					"SELECT sum(item.itemprice) FROM item INNER JOIN cart ON item.itemid=cart.itemid;");
			query.setParameter("cartid", cartid);
			int rowno = query.executeUpdate();
			System.out.println("rows updated are " +rowno);
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	@Override
	public void delete(Cart cart) {
		try {
			sessionFactory.getCurrentSession().delete(cart);
		}catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

	@Override
	public Cart getCartByCartId(int cartid) {
		try {
			Cart cart = (Cart) sessionFactory.getCurrentSession().get(Cart.class,
					cartid);

			return cart;
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cart> getAllCartItems(Cart cart) {
		try {
			
			return sessionFactory
					.getCurrentSession()
					.createQuery(
							"from Cart ")
					.list();
		} catch (Exception e) {
			System.out.println(e);
			throw new GenericException(ERROR);
		}

	}
}
