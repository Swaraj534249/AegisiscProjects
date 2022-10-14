package com.edubridge.EcommerceWebsite;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.edubridge.bean.Category;
import com.edubridge.bean.Item;
import com.edubridge.bean.User;
import com.edubridge.exception.GenericException;

import com.edubridge.service.ItemService;
import com.edubridge.util.FileUploadUtil;

@Controller
public class ItemController {

	private static Logger logger = Logger.getLogger(ItemController.class);

	@Autowired
	private ItemService itemService;
	
//	@Autowired(required = true)
//	private CategoryService categoryService;

	private static final String ITEMLIST = "itemlist";

	private static final String ITEM = "item";
	
private static final String CATEGORYLIST = "categorylist";
	
	private static final String CATEGORY = "category";

	private static final String ERROR = "ERROR!";

//	@RequestMapping(value = "/item.html", method = RequestMethod.GET)
//	public String item(HttpSession session, Model model) {
//
//		try {
//			User user = (User) session.getAttribute(USER);
//			
//			List<Item> itemlist = itemService.getAllItems(tenantid);
//
//			model.addAttribute(ITEMLIST, itemlist);
//			logger.info("showing item list");
//			return "showitem";
//		} catch (Exception e) {
//			return "home";
//
//		}
//	}

	@RequestMapping(value = "/additem.html", method = RequestMethod.GET)
	public String additem(@ModelAttribute("Item") Item item, HttpSession session, ModelMap model) {

		model.addAttribute("Item", item);
		logger.info("adding a new item");
		return "additem";
	}

	@RequestMapping(value = "/itemlist.html", method = RequestMethod.GET)
	public String itemlist(HttpSession session, ModelMap model) {
		try {
			System.out.println("item list");
			Item item = (Item) session.getAttribute(ITEM);
			List<Item> itemlist = itemService.getAllItems(item);
			model.addAttribute(ITEMLIST, itemlist);
			
			logger.info("showing item list as per the tenant");
			System.out.println("All ok");
			return "showitem";
		} catch (Exception e) {
			System.out.println("Error" + e);
			return "error";

		}
	}

//	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
//	public String showHomeout(HttpSession session, ModelMap model) {
//		try {
//			System.out.println("item list");
//			Item item = (Item) session.getAttribute(ITEM);
//			List<Item> itemlist = itemService.getAllItems(item);
//			model.addAttribute(ITEMLIST, itemlist);
//			logger.info("showing item list as per the tenant");
//			System.out.println("All ok");
//			return "homeOut";
//		} catch (Exception e) {
//			System.out.println("Error" + e);
//			return "error";
//
//		}
//	}
	
	@RequestMapping(value = "/insertitem.html", method = RequestMethod.POST)
	public String additem(@ModelAttribute(ITEM) Item item, HttpSession session, Model model) {
		try {
			session.setAttribute(ITEM, item);
			item.setDate(new Date());
			
			model.addAttribute(ITEM, item);
//			String fileName = StringUtils.cleanPath(image.getOriginalFilename());
//			item.setImage(fileName);
			itemService.add(item);			
			List<Item> itemlist = itemService.getAllItems(item);
//			List<MultipartFile> files = item.getFiles();
//			List<String> fileNames = new ArrayList<String>();
//			for (MultipartFile multipartFile : files) {
//
//				String fileName = multipartFile.getOriginalFilename();
//				fileNames.add(fileName);
//
//			}
//			model.addAttribute("files", fileNames);
			
//			String uploadDir = "user-photos/" + fileName;
//			System.out.println("file name saved");		 
//	        FileUploadUtil.saveFile(uploadDir, fileName, image);

			
			
			model.addAttribute(ITEMLIST, itemlist);
			logger.info("new item inserted");
			System.out.println("All OK");
			return "showitem";
		} catch (Exception e) {
			System.out.println("Error " + e);

			return "error";

		}

	}

	@RequestMapping(value = "/deleteitem.html", method = RequestMethod.GET)
	public String deleteitem(@RequestParam("itemId") int itemid,
			HttpSession session, Model model) {

		try {
			
			
			Item item = itemService.getItemByItemId(itemid);		
			item.setItemid(itemid);
			itemService.delete(item);
			
			Item item1 = (Item) session.getAttribute(ITEM);

			List<Item> itemlist = itemService.getAllItems(item1);
			model.addAttribute(ITEMLIST, itemlist);
			
			logger.info("deleting a item and return a itemlist page");

			return "showitem";
		} catch (Exception e) {
			throw new GenericException(ERROR);

		}

	}

	@RequestMapping(value = "/edititem.html", method = RequestMethod.GET)
	public String edititem(@RequestParam("itemId") int itemid, HttpSession session, Model model) {

		try {

			Item item = itemService.getItemByItemId(itemid);

			model.addAttribute("item", item);
			logger.info("update a item info");

			return "edititem";
		} catch (Exception e) {
			throw new GenericException(ERROR);

		}

	}
	
	@RequestMapping(value = "/viewitem.html", method = RequestMethod.GET)
	public String viewitem(@RequestParam("itemId") int itemid, HttpSession session, Model model) {

		try {

			Item item = itemService.getItemByItemId(itemid);

			model.addAttribute("item", item);
			logger.info("update a item info");

			return "viewItem";
		} catch (Exception e) {
			throw new GenericException(ERROR);

		}

	}


	@RequestMapping(value = "/editcurrentitem.html", method = RequestMethod.POST)
	public String editcurrentitem(@ModelAttribute("Item") Item item, HttpSession session, Model model) {

		try {

			itemService.edit(item);

			Item item1 = (Item) session.getAttribute(ITEM);
			item.setDate(new Date());
			List<Item> itemlist = itemService.getAllItems(item1);
			
//			item1.setDate(new Date());
			model.addAttribute(ITEMLIST, itemlist);

			logger.info("edit the current item a sper the tanant");
			return "showitem";
		} catch (Exception e) {
			System.out.println(e);
			return "edititem";
//			throw new GenericException(ERROR);

		}

	}

	
	@RequestMapping(value = "/shoplist.html", method = RequestMethod.GET)
	public String shoplist(HttpSession session, ModelMap model) {
		try {
			System.out.println("shop list");
			Item item = (Item) session.getAttribute(ITEM);
			List<Item> itemlist = itemService.getAllItems(item);
			model.addAttribute(ITEMLIST, itemlist);
			logger.info("showing item list as per the tenant");
			System.out.println("All ok");
			return "shoplistIn";
		} catch (Exception e) {
			System.out.println("Error" + e);
			return "error";

		}
	}
	
	
	// Categories part
	
	@RequestMapping(value = "/addcategory.html", method = RequestMethod.GET)
	public String addcategory(@ModelAttribute("Category") Category category, HttpSession session, ModelMap model) {

		model.addAttribute("Category", category);
		logger.info("adding a new item");
		return "addcategory";
	}
	
	@RequestMapping(value = "/categorylist.html", method = RequestMethod.GET)
	public String categorylist(HttpSession session, ModelMap model) {
		try {
			System.out.println("category list");
			Category category = (Category) session.getAttribute(CATEGORY);
			List<Category> categorylist = itemService.getAllCategories(category);
			model.addAttribute(CATEGORYLIST, categorylist);
			logger.info("showing item list as per the tenant");
			System.out.println("All ok");
			return "showcategory";
		} catch (Exception e) {
			System.out.println("Error" + e);
			return "error";

		}
	}
	
	@RequestMapping(value = "/insertcategory.html", method = RequestMethod.POST)
	public String addcategory(@ModelAttribute(CATEGORY) Category category, HttpSession session, Model model) {
		try {
			session.setAttribute(CATEGORY, category);
			
			model.addAttribute(CATEGORY, category);
			itemService.addCat(category);			
			List<Category> categorylist = itemService.getAllCategories(category);						
			model.addAttribute(CATEGORYLIST, categorylist);
			logger.info("new item inserted");
			System.out.println("All OK");
			return "showcategory";
		} catch (Exception e) {
			System.out.println("Error " + e);

			return "error";

		}

	}
	
//	@RequestMapping(value = "/deletecategory.html", method = RequestMethod.GET)
//	public String deletecategory(@RequestParam("categoryId") int categoryId,
//			HttpSession session, Model model) {
//
//		try {
//					
//			Category category = categoryService.getCategoryByCategoryId(categoryId);		
//						
////			Item item = new Item();
//			category.setCategoryId(categoryId);
//			categoryService.delete(category);
//			
//			Category category1 = (Category) session.getAttribute(CATEGORY);
//
//			List<Category> categorylist = categoryService.getAllCategories(category1);
//			model.addAttribute(CATEGORYLIST, categorylist);
//			
//			logger.info("deleting a item and return a itemlist page");
//
//			return "showitem";
//		} catch (Exception e) {
//			throw new GenericException(ERROR);
//
//		}
//
//	}
	
//	@RequestMapping(value = "/editcategory.html", method = RequestMethod.GET)
//	public String edititem(@RequestParam("categoryId") int categoryId, HttpSession session, Model model) {
//
//		try {
//
//			Category category = categoryService.getCategoryByCategoryId(categoryId);	
//
//			model.addAttribute("category", category);
//			logger.info("update a item info");
//
//			return "editcategory";
//		} catch (Exception e) {
//			throw new GenericException(ERROR);
//
//		}
//
//	}


//	@RequestMapping(value = "/editcurrentcategory.html", method = RequestMethod.POST)
//	public String editcurrentitem(@ModelAttribute("Category") Category category, HttpSession session, Model model) {
//
//		try {
//
//			categoryService.edit(category);
//
//			Category category1 = (Category) session.getAttribute(CATEGORY);
//
//			List<Category> categorylist = categoryService.getAllCategories(category1);
////			item.setDate(new Date());
//			model.addAttribute(CATEGORYLIST, categorylist);
//
//			logger.info("edit the current item a sper the tanant");
//			return "showcategory";
//		} catch (Exception e) {
//			throw new GenericException(ERROR);
//
//		}
//
//	}
}
