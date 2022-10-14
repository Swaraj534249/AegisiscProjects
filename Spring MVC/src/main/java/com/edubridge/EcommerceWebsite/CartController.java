package com.edubridge.EcommerceWebsite;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.edubridge.bean.Cart;
import com.edubridge.bean.Contact;
import com.edubridge.bean.Item;
import com.edubridge.bean.User;
import com.edubridge.exception.GenericException;
import com.edubridge.service.CartService;
import com.edubridge.service.ItemService;
import com.edubridge.service.UserService;


@Controller
public class CartController {

	private static Logger logger = Logger.getLogger(ItemController.class);

	@Autowired
	private CartService cartService;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private UserService userService;
	
	private static final String CARTLIST = "cartlist";

	private static final String CART = "cart";
	
	private static final String ITEMLIST = "itemlist";

	private static final String ITEM = "item";
	
	private static final String ERROR = "ERROR!";
	
	private static final String CONTACT = "contact";
	
	private static final String User = "user";
	
	@RequestMapping(value = "/cartlist.html", method = RequestMethod.GET)
	public String itemlist(HttpSession session, ModelMap model) {
		try {
			System.out.println("item list");
			Cart cart = (Cart) session.getAttribute(CART);
			List<Cart> cartlist = cartService.getAllCartItems(cart);
			model.addAttribute(CARTLIST, cartlist);	
			
			logger.info("showing item list as per the tenant");
			System.out.println("All ok");
			return "showcart";
		} catch (Exception e) {
			System.out.println("Error" + e);
			return "error";

		}
	}
	
	@RequestMapping(value = "/insertcart.html", method = RequestMethod.GET)
	public String additem(@ModelAttribute(CART) Cart cart,@RequestParam("itemId") String itemid, @RequestParam("username") String username,  HttpSession session, Model model) {
		try {
			
			int itemId = Integer.parseInt(itemid);
			Item item = itemService.getItemByItemId( itemId);
			System.out.println(username);			

			User  user1 = userService.getUserByUserName(username);
			System.out.println(user1.getUserid());
			cart.setQuantity(1);
				int cartUserid= user1.getUserid();
			cart.setUser(user1);
			cart.setItem(item);
			model.addAttribute(CART, item);
			cartService.add(cart);			
			List<Cart> cartlist = cartService.getAllCartItems(cart);
			
			model.addAttribute(CARTLIST, cartlist);
			List<Item> itemlist = itemService.getAllItems(item);						
			model.addAttribute(ITEMLIST, itemlist);
			logger.info("new item inserted");
			System.out.println("All OK");
			return "homeIn";
		} catch (Exception e) {
			System.out.println("Error " + e);

			return "error";

		}

	}
	
	@RequestMapping(value = "/insertcartshop.html", method = RequestMethod.GET)
	public String additemshop(@ModelAttribute(CART) Cart cart,@RequestParam("itemId") String itemid, @RequestParam("username") String username,  HttpSession session, Model model) {
		try {
			
			int itemId = Integer.parseInt(itemid);
			Item item = itemService.getItemByItemId( itemId);
			System.out.println(username);			

			User  user1 = userService.getUserByUserName(username);
			System.out.println(user1.getUserid());
			cart.setQuantity(1);
				int cartUserid= user1.getUserid();
			cart.setUser(user1);
			cart.setItem(item);
			model.addAttribute(CART, item);
			cartService.add(cart);			
			List<Cart> cartlist = cartService.getAllCartItems(cart);
			
			model.addAttribute(CARTLIST, cartlist);
			List<Item> itemlist = itemService.getAllItems(item);						
			model.addAttribute(ITEMLIST, itemlist);
			logger.info("new item inserted");
			System.out.println("All OK");
			return "shoplistIn";
		} catch (Exception e) {
			System.out.println("Error " + e);

			return "error";

		}

	}
	
	@RequestMapping(value = "/deletecart.html", method = RequestMethod.GET)
	public String deleteitem(@RequestParam("cartId") int cartid,
			HttpSession session, Model model) {

		try {		
			Cart cart = cartService.getCartByCartId(cartid);		
					
//			Item item = new Item();
			cart.setCartid(cartid);
			cartService.delete(cart);
			
			Cart cart1 = (Cart) session.getAttribute(CART);

			List<Cart> cartlist = cartService.getAllCartItems(cart1);
			model.addAttribute(CARTLIST, cartlist);
			
			logger.info("deleting a item and return a itemlist page");

			return "showcart";
		} catch (Exception e) {
			throw new GenericException(ERROR);

		}

	}
	
	@RequestMapping(value = "/increase.html", method = RequestMethod.GET)
	public String increase(@RequestParam("cartId") int cartid,
			HttpSession session, Model model) {
		try {		
			Cart cart = cartService.getCartByCartId(cartid);		
			cart.setCartid(cartid);
			cartService.increase(cartid);			
			Cart cart1 = (Cart) session.getAttribute(CART);
			List<Cart> cartlist = cartService.getAllCartItems(cart1);
			model.addAttribute(CARTLIST, cartlist);
			logger.info("deleting a item and return a itemlist page");
			return "showcart";
		} catch (Exception e) {
			System.out.println(e);
			throw new GenericException(ERROR);
		}
	}
	
	@RequestMapping(value = "/decrease.html", method = RequestMethod.GET)
	public String decrease(@RequestParam("cartId") int cartid,
			HttpSession session, Model model) {
		try {		
			Cart cart = cartService.getCartByCartId(cartid);		
			cart.setCartid(cartid);
			cartService.decrease(cartid);			
			Cart cart1 = (Cart) session.getAttribute(CART);
			List<Cart> cartlist = cartService.getAllCartItems(cart1);
			model.addAttribute(CARTLIST, cartlist);
			logger.info("deleting a item and return a itemlist page");
			return "showcart";
		} catch (Exception e) {
			System.out.println(e);
			throw new GenericException(ERROR);
		}
	}
	
	@RequestMapping(value = "/buy.html", method = RequestMethod.GET)
	public String edititem( HttpSession session, Model model) {

		try {

			
			logger.info("update a item info");

			return "buy";
		} catch (Exception e) {
			throw new GenericException(ERROR);

		}

	}
	
	@RequestMapping(value = "/contactbuy.html", method = RequestMethod.POST)
	public String conatctbuy(@ModelAttribute(CONTACT) Contact contact, HttpSession session, Model model) {

		try {
			session.setAttribute(CONTACT, contact);
			contact.setDate(new Date());
			userService.addVisiter(contact);
			model.addAttribute(CONTACT, contact);
			logger.info("successfull registration of tenant");
			return "homeIn";
		} catch (Exception e) {
			return "signin";
		}

	}
}
