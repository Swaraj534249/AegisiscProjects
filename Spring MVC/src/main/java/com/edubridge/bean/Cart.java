package com.edubridge.bean;

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
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartid;
	
	@Column
	private int quantity;
	
	@Column
	private double amount;
	
	public double getAmount() {
		return this.item.getItemprice() * this.quantity;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "userid")
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "itemid")
	private Item item;
	
	
	public Cart() {
		super();
	}


	public Cart(int cartid, int quantity) {
		super();
		this.cartid = cartid;
		this.quantity = quantity;
	}

//	 public double getAmount() {
//	        return this.item.getItemprice() * this.quantity;
//	    }

	public int getCartid() {
		return cartid;
	}


	public void setCartid(int cartid) {
		this.cartid = cartid;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Item getItem() {
		return item;
	}


	public void setItem(Item item) {
		this.item = item;
	}


}
