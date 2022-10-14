package com.edubridge.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edubridge.bean.Contact;
import com.edubridge.bean.Item;
import com.edubridge.bean.User;
import com.edubridge.dao.UserDao;
import com.edubridge.exception.GenericException;


// TODO: Auto-generated Javadoc
/**
 * The Class TenantDaoImplm implements the interface TenantDao and interacts
 * with DB.
 */
@Repository
public class UserDaoImpl implements UserDao {

	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;
	
	private static final String ERROR = "ERROR!";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.dao.TenantDao#add(com.impetus.invc_mgmt.model.Tenant
	 * )
	 */
	@Override
	public void add(User user) {
		try {
			sessionFactory.getCurrentSession().save(user);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}
	
	@Override
	public void addVisiter(Contact contact) {
		try {
			sessionFactory.getCurrentSession().save(contact);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.dao.TenantDao#edit(com.impetus.invc_mgmt.model.
	 * Tenant)
	 */
	@Override
	public void edit(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.dao.TenantDao#delete(com.impetus.invc_mgmt.model
	 * .Tenant)
	 */
	@Override
	public void delete(User user) {
		try {
			sessionFactory.getCurrentSession().delete(user);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.impetus.invc_mgmt.dao.TenantDao#getTenantByTenantId(int)
	 */
	@Override
	public User getUserByUserId(int userid) {
		// TODO Auto-generated method stub
		try {
			User user = (User) sessionFactory.getCurrentSession().get(
					User.class, userid);

			return user;
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}
	
	@Override
	public User getUserByUserName(String username) {
		// TODO Auto-generated method stub
		try {
			@SuppressWarnings({ "deprecation", "unchecked" })
			List<User> list = sessionFactory.getCurrentSession().createQuery(
					"from User u  where u.username=:logid")
			.setString("logid", username).list();

			return list.get(0);
		}  catch (Exception e) {
			System.out.println(e);
			throw new GenericException(ERROR);
		}
	}

	@Override
	public User authenticateUser(String useremail, String pass) {
		// TODO Auto-generated method stub
		try {
			@SuppressWarnings("unchecked")
			List<User> list = sessionFactory
					.getCurrentSession()
					.createQuery(
							"from User u  where u.useremail=:logid and u.password=:pass")
					.setString("logid", useremail).setString("pass", pass).list();

			if (list.size() > 0) {

				return list.get(0);
			} else {
				return null;
			}
		}catch (Exception e) {
			System.out.println("Error dao"+e);
			throw new GenericException(ERROR);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUser(User user) {
		try {
			return sessionFactory
					.getCurrentSession()
					.createQuery(
							"from User")
					.list();
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}
}
