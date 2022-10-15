package com.edubridge.EcommerceWebsite;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edubridge.bean.Item;
import com.edubridge.bean.User;
import com.edubridge.exception.GenericException;
import com.edubridge.service.ItemService;
import com.edubridge.service.UserService;

@Controller
public class LoginController {

	
	/** The logger. */
	private static Logger logger = Logger.getLogger(UserController.class);

	/** The session factory. */
//	@Autowired
//	private SessionFactory sessionFactory;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ItemService itemService;
	
	private static final String ITEMLIST = "itemlist";
	
	private static final String ITEM = "item";
	
	private static final String User = "user";
	
	
	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public String showForm() {
		logger.info("return a registration form of the tenant");

		return "login";
	}
	
	@RequestMapping(value = "/userlogin.html", method = RequestMethod.POST)
	public String simple(@ModelAttribute(User) User user, HttpSession session, ModelMap model) {

		try {

			String useremail = user.getUseremail();
			String pass = user.getPassword();
			
			System.out.println(useremail + " " + pass);
			User user1 = userService.authenticateUser(useremail, pass);
			
			System.out.println(useremail + " " + pass);
			
			
			
			if (user1 == null) {
				return "index";
			}
			
			else {

				session.setAttribute("user", user1);
				if (user1.getRole().getRoleid() == 2) {
					Item item = (Item) session.getAttribute(ITEM);
					List<Item> itemlist = itemService.getAllItems(item);						
					model.addAttribute(ITEMLIST, itemlist);
					return "homeIn";
				} else if (user1.getRole().getRoleid() == 1) {
					Item item = (Item) session.getAttribute(ITEM);
					List<Item> itemlist = itemService.getAllItems(item);						
					model.addAttribute(ITEMLIST, itemlist);
					return "homeAdmin";

				} else {
					return "login";
				}

			}
			
		} catch (Exception e) {
			System.out.println("Error"+e);
			throw new GenericException("ERROR!");
//			return "login";
		}
	}
	
	@RequestMapping(value = "/sellerlogin.html", method = RequestMethod.POST)
	public String sellerlogin(@ModelAttribute(User) User user, HttpSession session, ModelMap model) {

		try {

			String useremail = "Seller@gmail.com";
			String pass = "seller";
			
			System.out.println(useremail + " " + pass);
			User user1 = userService.authenticateUser(useremail, pass);
			
			System.out.println(useremail + " " + pass);
						
				session.setAttribute("user", user1);
				if (user1.getRole().getRoleid() == 1) {
					Item item = (Item) session.getAttribute(ITEM);
					List<Item> itemlist = itemService.getAllItems(item);						
					model.addAttribute(ITEMLIST, itemlist);
					return "homeAdmin";
				} else {
					return "login";
				}
			
		} catch (Exception e) {
			System.out.println("Error"+e);
			throw new GenericException("ERROR!");
//			return "login";
		}
	}
	
	@RequestMapping(value = "/logout.html", method = RequestMethod.GET)
	public String logoutForm(HttpSession session) {

		try {

			session.invalidate();
			logger.info("invalidate the current session");

			return "index";
		} catch (Exception e) {
			System.out.println("Error" + e);
			return "error";
//			throw new GenericException(ERROR);

		}
	}
}
