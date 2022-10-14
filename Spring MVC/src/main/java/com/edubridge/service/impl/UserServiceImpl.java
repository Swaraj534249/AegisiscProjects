package com.edubridge.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edubridge.bean.Contact;
import com.edubridge.bean.Item;
import com.edubridge.bean.User;
import com.edubridge.dao.UserDao;
import com.edubridge.exception.GenericException;
import com.edubridge.service.UserService;


// TODO: Auto-generated Javadoc

/**
 * The Class TenantServiceImpl implements the interface TenantService and
 * interacts with TenantDao.
 */
@Service
public class UserServiceImpl implements UserService  {

	/** The tenantdao. */
	@Autowired
	private UserDao userdao;
	private static final String ERROR = "ERROR!";
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.service.TenantService#add(com.impetus.invc_mgmt
	 * .model.Tenant)
	 */
	@Transactional
	public void add(User user) {
		try {
			userdao.add(user);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}
	
	@Transactional
	public void addVisiter(Contact contact) {
		try {
			userdao.addVisiter(contact);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.service.TenantService#edit(com.impetus.invc_mgmt
	 * .model.Tenant)
	 */
	@Transactional
	public void edit(User user) {
		// TODO Auto-generated method stub
		try {
			userdao.edit(user);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.service.TenantService#delete(com.impetus.invc_mgmt
	 * .model.Tenant)
	 */
	@Transactional
	public void delete(User user) {
		// TODO Auto-generated method stub
		try {
			userdao.delete(user);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.impetus.invc_mgmt.service.TenantService#getTenantByTenantId(int)
	 */
	@Transactional
	public User getUserByUserId(int userid) {
		// TODO Auto-generated method stub
		try {
			return userdao.getUserByUserId(userid);
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}
	
	@Transactional
	public User authenticateUser(String useremail, String pass) {
		try {
			return userdao.authenticateUser(useremail, pass);
		}  catch (Exception e) {
			System.out.println("Error service"+e);
			throw new GenericException(ERROR);
		}
	}
	
	@Transactional
	public List<User> getAllUsers(User user) {
		try {
			return userdao.getAllUser(user);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	@Transactional
	public User getUserByUserName(String username) {
		try {
			return userdao.getUserByUserName(username);
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}


}
