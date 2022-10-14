/**
 * 
 */
package com.edubridge.service;

import java.util.List;

import com.edubridge.bean.Contact;
import com.edubridge.bean.Item;
import com.edubridge.bean.User;

// TODO: Auto-generated Javadoc
/**
 * The Interface TenantService consist the methods related to tenant.
 * 
 * @author Ashish
 */
public interface UserService {

	/**
	 * Adds the.
	 * 
	 * @param tenant
	 *            the tenant
	 */
	void add(User user);

	/**
	 * Edits the.
	 * 
	 * @param tenant
	 *            the tenant
	 */
	void edit(User user);

	/**
	 * Delete.
	 * 
	 * @param tenant
	 *            the tenant
	 */
	void delete(User user);

	/**
	 * Gets the tenant by tenant id.
	 * 
	 * @param tenantid
	 *            the tenantid
	 * @return the tenant by tenant id
	 */
	User getUserByUserId(int userid);
	
	User authenticateUser(String useremail, String pass);
	
	List<User> getAllUsers(User user);
	
	User getUserByUserName(String username);
	
	void addVisiter(Contact contact);

}
