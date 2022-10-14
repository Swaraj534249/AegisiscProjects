package com.edubridge.service;

import java.util.List;

import com.edubridge.bean.Category;
import com.edubridge.bean.Item;

public interface ItemService {

	void add(Item item);

	void edit(Item item);

	void delete(Item item);

	Item getItemByItemId(int itemid);
	
	List<Item> getAllItems(Item item);
	
	// category part
	
void addCat(Category category);
	
	void editCat(Category category);
	
	void deleteCat(Category category);
	
	Category getCategoryByCategoryId(int categoryId);
	
	List<Category> getAllCategories(Category category);

}
