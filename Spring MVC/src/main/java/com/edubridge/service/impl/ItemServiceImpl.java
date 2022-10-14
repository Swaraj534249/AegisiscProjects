package com.edubridge.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edubridge.bean.Category;
import com.edubridge.bean.Item;
import com.edubridge.dao.ItemDao;
import com.edubridge.exception.GenericException;
import com.edubridge.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	/** The itemdao. */
	@Autowired
	private ItemDao itemdao;

	
	private static final String ERROR = "ERROR!";
	@Transactional
	public void add(Item item) {
		try {
			itemdao.add(item);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	@Transactional
	public void edit(Item item) {
		try {
			itemdao.edit(item);
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	@Transactional
	public void delete(Item item) {
		try {
			itemdao.delete(item);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

	@Transactional
	public Item getItemByItemId(int itemid) {
		try {
			return itemdao.getItemByItemId(itemid);
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

	@Transactional
	public List<Item> getAllItems(Item item) {
		try {
			return itemdao.getAllItems(item);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}
	
	// category part
	
	@Transactional
	public void addCat(Category category) {
		try {
			itemdao.addCat(category);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}
		
	}

	@Transactional
	public void editCat(Category category) {
		try {
			itemdao.editCat(category);
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}
		
	}

	@Transactional
	public void deleteCat(Category category) {
		try {
			itemdao.deleteCat(category);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}
		
	}

	@Transactional
	public Category getCategoryByCategoryId(int categoryId) {
		try {
			return itemdao.getCategoryByCategoryId(categoryId);
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

	@Transactional
	public List<Category> getAllCategories(Category category) {
		try {
			return itemdao.getAllCategories(category);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

}
