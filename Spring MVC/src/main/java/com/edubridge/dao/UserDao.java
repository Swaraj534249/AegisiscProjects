package com.edubridge.dao;

import java.util.List;

import com.edubridge.bean.Contact;
import com.edubridge.bean.User;

// TODO: Auto-generated Javadoc
/**
 * The Interface TenantDao consist the methods related to tenant.
 */
public interface UserDao {

	void add(User user);

	void edit(User user);

	void delete(User user);

	User getUserByUserId(int userid);

	User authenticateUser(String useremail, String pass);

	List<User> getAllUser(User user);
	
	User getUserByUserName(String username);

	void addVisiter(Contact contact);


}
