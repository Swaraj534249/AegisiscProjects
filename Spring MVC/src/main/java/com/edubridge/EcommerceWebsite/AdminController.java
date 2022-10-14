package com.edubridge.EcommerceWebsite;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.edubridge.bean.Item;
import com.edubridge.bean.Role;
import com.edubridge.bean.User;
import com.edubridge.exception.GenericException;
import com.edubridge.service.ItemService;
import com.edubridge.service.UserService;

// TODO: Auto-generated Javadoc
/**
 * The Class TenantController takes the request from the browser and give a
 * proper response as per the request related to tenant.
 */
@Controller
public class AdminController {

	/** The logger. */
	private static Logger logger = Logger.getLogger(AdminController.class);

	/** The session factory. */
//	@Autowired
//	private SessionFactory sessionFactory;
	
	@Autowired
	private UserService userService;
	
//	@Autowired
//	private ItemService itemService;
	
	/** The Constant USER. */
	private static final String USERLIST = "userlist";

	/** The Constant TENANT. */
	private static final String USER = "user";
	
	private static final String ERROR = "ERROR!";

	/**
	 * Show form.
	 * 
	 * @return the tenantregistration jsp
	 */
	@RequestMapping(value = "/showUser.html", method = RequestMethod.GET)
	public String showForm() {
		logger.info("return a registration form of the tenant");

		return "headerAdmin";
	}

	/**
	 * Show excel.
	 * 
	 * @return the excel jsp
	 */




//	@RequestMapping(value = "/adminuserregistrationsuccess.html", method = RequestMethod.POST)
//	public String addUser(@ModelAttribute(User) User user, HttpSession session, Model model) {
//
//		try {
//			session.setAttribute(User, user);
//			Role role = new Role();
//			role.setRoleid(1);
//			role.setRolename("Admin");
//			user.setRole(role);
//			userService.add(user);
//			model.addAttribute(User, user);
//			logger.info("successfull registration of admin");
//			return "login";
//		} catch (Exception e) {
//			return "signin";
//		}
//
//	}
//	
	
	
	@RequestMapping(value = "/userlist.html", method = RequestMethod.GET)
	public String userlist(HttpSession session, ModelMap model) {
		try {
			System.out.println("user list");
			User user = (User) session.getAttribute(USER);
			List<User> userlist = userService.getAllUsers(user);
			model.addAttribute(USERLIST, userlist);
			logger.info("showing item list as per the tenant");
//			System.out.println(user.getUsername()+ " " + user.getUseremail());
			System.out.println("All ok");
			return "showuser";
		} catch (Exception e) {
			System.out.println("Error" + e);
			return "error";

		}
	}

	@RequestMapping(value = "/deleteuser.html", method = RequestMethod.GET)
	public String deleteitem(@RequestParam("userid") int userid,
			HttpSession session, Model model) {

		try {
			
			
			User user = userService.getUserByUserId(userid);		
			
			
//			Item item = new Item();
			user.setUserid(userid);
			userService.delete(user);
			
			User user1 = (User) session.getAttribute(USER);

			List<User> userlist = userService.getAllUsers(user1);
			model.addAttribute(USERLIST, userlist);
			
			logger.info("deleting a item and return a itemlist page");

			return "showuser";
		} catch (Exception e) {
			throw new GenericException(ERROR);

		}

	}

	@RequestMapping(value = "/edituser.html", method = RequestMethod.GET)
	public String edituser(@RequestParam("userid") int userid, HttpSession session, Model model) {

		try {

			User user2 = userService.getUserByUserId(userid);

			logger.info("update a item info");
			System.out.println(user2.getUsername()+ " " + user2.getUseremail());
			
			model.addAttribute("user", user2);
//			ModelAndView andView = new ModelAndView();
//			andView.addObject("username",user2.getUsername() );
//			andView.addObject("useremail",user2.getUseremail());
//			andView.setViewName("edituser");
//			return andView;
			return "edituser";
		} catch (Exception e) {
			throw new GenericException(ERROR);

		}

	}


	@RequestMapping(value = "/editcurrentuser.html", method = RequestMethod.POST)
	public String editcurrentitem(@ModelAttribute("User") User user, HttpSession session, Model model) {

		try {

			userService.edit(user);

			User user1 = (User) session.getAttribute(USER);

			List<User> userlist = userService.getAllUsers(user1);

			model.addAttribute(USERLIST, userlist);

			logger.info("edit the current item a sper the tanant");
			return "showuser";
		} catch (Exception e) {
			throw new GenericException(ERROR);

		}

	}

}
