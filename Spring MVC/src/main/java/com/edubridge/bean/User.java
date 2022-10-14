/**
 * 
 */
package com.edubridge.bean;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;




@Entity
@Table(name = "user")
public class User {



	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;


	@Column
	private String username;
	
	@Column
	private String userlastname;

	/** The tenantaddress. */
	@Column
	private String useraddress;

	/** The tenantemail. */
	@Column
	private String useremail;
	
	@Column
	private String dob;

	/** The tenantcontactno. */
	@Column
	private Long usercontactno;
	
	@Column
	private Double balance;

	/** The dateformat. */
	@Column
	private String password;
	
	@Column
	private Date date;

	/** The role. */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "roleid")
	private Role role;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade=CascadeType.ALL)
	private Set<Cart> cart;
	

	/**
	 * Instantiates a new tenant.
	 */
	public User() {
	}

	public User(int userid, String username, String useraddress,
			String useremail, Long usercontactno, String password) {
		super();
		this.userid = userid;
		this.username = username;
		this.useraddress = useraddress;
		this.useremail = useremail;
		this.usercontactno = usercontactno;
		this.password = password;

	}

	// getter setter
	/**
	 * Gets the tenantid.
	 * 
	 * @return the tenantid
	 */
	public int getUserid() {
		return userid;
	}

	/**
	 * Sets the tenantid.
	 * 
	 * @param tenantid
	 *            the new tenantid
	 */
	public void setUserid(int userid) {
		this.userid = userid;
	}

	/**
	 * Gets the tenantname.
	 * 
	 * @return the tenantname
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the tenantname.
	 * 
	 * @param tenantname
	 *            the new tenantname
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the tenantaddress.
	 * 
	 * @return the tenantaddress
	 */
	public String getUseraddress() {
		return useraddress;
	}

	/**
	 * Sets the tenantaddress.
	 * 
	 * @param tenantaddress
	 *            the new tenantaddress
	 */
	public void setUseraddress(String useraddress) {
		this.useraddress = useraddress;
	}

	/**
	 * Gets the tenantemail.
	 * 
	 * @return the tenantemail
	 */
	public String getUseremail() {
		return useremail;
	}

	/**
	 * Sets the tenantemail.
	 * 
	 * @param tenantemail
	 *            the new tenantemail
	 */
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	/**
	 * Gets the tenantcontactno.
	 * 
	 * @return the tenantcontactno
	 */
	public Long getUsercontactno() {
		return usercontactno;
	}

	/**
	 * Sets the tenantcontactno.
	 * 
	 * @param tenantcontactno
	 *            the new tenantcontactno
	 */
	public void setUsercontactno(Long usercontactno) {
		this.usercontactno = usercontactno;
	}

	/**
	 * Gets the dateformat.
	 * 
	 * @return the dateformat
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the dateformat.
	 * 
	 * @param dateformat
	 *            the new dateformat
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Gets the role.
	 * 
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * Sets the role.
	 * 
	 * @param role
	 *            the new role
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	public Set<Cart> getCart() {
		return cart;
	}

	public void setCart(Set<Cart> cart) {
		this.cart = cart;
	}

	public String getUserlastname() {
		return userlastname;
	}

	public void setUserlastname(String userlastname) {
		this.userlastname = userlastname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	
	
}
