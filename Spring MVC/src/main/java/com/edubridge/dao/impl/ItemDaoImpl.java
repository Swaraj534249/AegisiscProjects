package com.edubridge.dao.impl;

import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edubridge.bean.Category;
import com.edubridge.bean.Item;
import com.edubridge.dao.ItemDao;
import com.edubridge.exception.GenericException;

@Repository
public class ItemDaoImpl implements ItemDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private static final String ERROR = "ERROR!";

	@Override
	public void add(Item item) {
		try {
			sessionFactory.getCurrentSession().save(item);
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	@Override
	public void edit(Item item) {
		try {
			sessionFactory.getCurrentSession().update(item);
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	@Override
	public void delete(Item item) {
		try {
			sessionFactory.getCurrentSession().delete(item);
		}catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

	@Override
	public Item getItemByItemId(int itemid) {
		try {
			Item item = (Item) sessionFactory.getCurrentSession().get(Item.class,
					itemid);

			return item;
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Item> getAllItems(Item item) {
		try {
			return sessionFactory
					.getCurrentSession()
					.createQuery(
							"from Item")
					.list();
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}
	
	// Category part
	
	@Override
	public void addCat(Category category) {
		try {
			sessionFactory.getCurrentSession().save(category);
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}
		
	}

	@Override
	public void editCat(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}
		
	}

	@Override
	public void deleteCat(Category category) {
		try {
			sessionFactory.getCurrentSession().delete(category);
		}catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

	@Override
	public Category getCategoryByCategoryId(int categoryId) {
		try {
			Category category = (Category) sessionFactory.getCurrentSession().get(Category.class,
					categoryId);

			return category;
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getAllCategories(Category category) {
		try {
			return sessionFactory
					.getCurrentSession()
					.createQuery(
							"from Category ")
					.list();
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

}
