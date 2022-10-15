package com.edubridge.EcommerceWebsite;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.edubridge.bean.Contact;
import com.edubridge.bean.Item;
import com.edubridge.bean.Role;
import com.edubridge.bean.User;
import com.edubridge.service.ItemService;
import com.edubridge.service.UserService;

// TODO: Auto-generated Javadoc
/**
 * The Class TenantController takes the request from the browser and give a
 * proper response as per the request related to tenant.
 */
@Controller
public class UserController {

	/** The logger. */
	private static Logger logger = Logger.getLogger(UserController.class);

	/** The session factory. */
//	@Autowired
//	private SessionFactory sessionFactory;

	@Autowired
	private UserService userService;

	@Autowired
	private ItemService itemService;

	private static final String ITEM = "item";

	private static final String ITEMLIST = "itemlist";

	/** The Constant TENANT. */
	private static final String User = "user";

	private static final String CONTACT = "contact";

	/**
	 * Show form.
	 * 
	 * @return the tenantregistration jsp
	 */
	@RequestMapping(value = "/newUser.html", method = RequestMethod.GET)
	public String showForm() {
		logger.info("return a registration form of the tenant");

		return "signin";
	}

	@RequestMapping(value = "/contact.html", method = RequestMethod.GET)
	public String contact() {
		logger.info("return a registration form of the tenant");

		return "contact";
	}

	/**
	 * Show excel.
	 * 
	 * @return the excel jsp
	 */
	@RequestMapping(value = "/excel.html", method = RequestMethod.GET)
	public String showExcel() {
		logger.info("link to download excel format of invoices");

		return "excel";
	}

	/**
	 * Show index.
	 * 
	 * @return the index jsp
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showIndex(HttpSession session, ModelMap model) {

		try {
			System.out.println("item list");
			Item item = (Item) session.getAttribute(ITEM);
			List<Item> itemlist = itemService.getAllItems(item);
			model.addAttribute(ITEMLIST, itemlist);
			logger.info("showing home page");
			System.out.println("All ok");
			return "homeOut";
		} catch (Exception e) {
			System.out.println("Error" + e);
			return "error";

		}
//		return "homeOut";
	}

	@RequestMapping(value = "/homeAdmin.html", method = RequestMethod.GET)
	public String showHomeAdmin(HttpSession session, ModelMap model) {
		try {
			Item item = (Item) session.getAttribute(ITEM);
			List<Item> itemlist = itemService.getAllItems(item);
			model.addAttribute(ITEMLIST, itemlist);
			logger.info("showing home page");
			return "homeAdmin";
		} catch (Exception e) {
			System.out.println("Error" + e);
			return "error";

		}
	}

	@RequestMapping(value = "/homeIn.html", method = RequestMethod.GET)
	public String showHomeIn(HttpSession session, ModelMap model) {
		try {
			Item item = (Item) session.getAttribute(ITEM);
			List<Item> itemlist = itemService.getAllItems(item);
			model.addAttribute(ITEMLIST, itemlist);
			logger.info("showing home page");
			return "homeIn";
		} catch (Exception e) {
			System.out.println("Error" + e);
			return "error";

		}
	}

	@RequestMapping(value = "/userregistrationsuccess.html", method = RequestMethod.POST)
	public String addUser(@ModelAttribute(User) User user, HttpSession session, Model model) {

		try {
			session.setAttribute(User, user);
			user.setDate(new Date());
			Role role = new Role();

			role.setRoleid(3);
			role.setRolename("User");
			user.setRole(role);
			userService.add(user);
			model.addAttribute(User, user);
			logger.info("successfull registration of tenant");
			return "homeIn";
		} catch (Exception e) {
			return "signin";
		}

	}

	@RequestMapping(value = "/customerregistrationsuccess.html", method = RequestMethod.GET)
	public String customerregister( HttpSession session, Model model) {
		try {
			User customer = new User();			
			User user1 = userService.authenticateUser("Customer@gmail.com", "Customer");					
			if(user1 == null) {				
				customer.setUsername("Customer");
				customer.setUserlastname("Customer");
				customer.setUseremail("Customer@gmail.com");
				customer.setPassword("Customer");
				customer.setUseraddress("India");
				customer.setDob("00/00/0000");
				customer.setUsercontactno(000000000L);
				customer.setBalance(10000.00);
				customer.setDate(new Date());
				session.setAttribute(User, customer);
				Role role = new Role();
				role.setRoleid(2);
				role.setRolename("Customer");
				customer.setRole(role);
				userService.add(customer);
				model.addAttribute(User, customer);
				logger.info("successfull registration of tenant");
				Item item = (Item) session.getAttribute(ITEM);
				List<Item> itemlist = itemService.getAllItems(item);						
				model.addAttribute(ITEMLIST, itemlist);
				return "homeIn";
			}
			else {
				session.setAttribute("user", user1);
				Item item = (Item) session.getAttribute(ITEM);
				List<Item> itemlist = itemService.getAllItems(item);						
				model.addAttribute(ITEMLIST, itemlist);
				return "homeIn";
			}		
		} catch (Exception e) {
			System.out.println(e);
			return "signin";
		}
	}
	@RequestMapping(value = "/sellerregistrationsuccess.html", method = RequestMethod.GET)
	public String sellerregister( HttpSession session, Model model) {
		try {
			User seller = new User();			
			User user1 = userService.authenticateUser("Seller@gmail.com", "Seller");					
			if(user1 == null) {				
				seller.setUsername("Seller");
				seller.setUserlastname("Seller");
				seller.setUseremail("Seller@gmail.com");
				seller.setPassword("Seller");
				seller.setUseraddress("India");
				seller.setDob("00/00/0000");
				seller.setUsercontactno(000000000L);
				seller.setBalance(10000.00);
				seller.setDate(new Date());
				session.setAttribute(User, seller);
				Role role = new Role();
				role.setRoleid(1);
				role.setRolename("Customer");
				seller.setRole(role);
				userService.add(seller);
				model.addAttribute(User, seller);
				logger.info("successfull registration of tenant");
				Item item = (Item) session.getAttribute(ITEM);
				List<Item> itemlist = itemService.getAllItems(item);						
				model.addAttribute(ITEMLIST, itemlist);
				return "homeAdmin";
			}
			else {
				session.setAttribute("user", user1);
				Item item = (Item) session.getAttribute(ITEM);
				List<Item> itemlist = itemService.getAllItems(item);						
				model.addAttribute(ITEMLIST, itemlist);
				return "homeAdmin";
			}		
		} catch (Exception e) {
			System.out.println(e);
			return "signin";
		}
	}
	

	@RequestMapping(value = "/visitercontact.html", method = RequestMethod.POST)
	public String conatctvister(@ModelAttribute(CONTACT) Contact contact, HttpSession session, Model model) {

		try {
			session.setAttribute(User, contact);
			contact.setDate(new Date());
			userService.addVisiter(contact);
			model.addAttribute(CONTACT, contact);
			logger.info("successfull registration of tenant");
			return "index";
		} catch (Exception e) {
			return "signin";
		}

	}

//	ModelAndView andView = new ModelAndView();
//	
//	User user2 = userService.getUserByUserId(userid);
//
//	logger.info("update a item info");
//	System.out.println(user2.getUsername()+ " " + user2.getUseremail());
//	andView.addObject("username",user2.getUsername() );
//	andView.addObject("useremail",user2.getUseremail());
//	andView.setViewName("edituser");
//	return andView;

}
