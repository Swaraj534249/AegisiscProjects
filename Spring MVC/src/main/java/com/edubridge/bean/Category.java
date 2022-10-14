package com.edubridge.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "category")
public class Category {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int categoryId;
	
	@Column
	private String categoryname;
	
	@Column
	private String categorydesc;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")
	private Set<Item> item = new HashSet<Item>(0);

	public Category() {
		
	}

	public Category(int categoryId, String categoryname, String categorydesc, Set<Item> item) {
		super();
		this.categoryId = categoryId;
		this.categoryname = categoryname;
		this.categorydesc = categorydesc;
		this.item = item;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryname;
	}

	public void setCategoryName(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getCategoryDesc() {
		return categorydesc;
	}

	public void setCategoryDesc(String categorydesc) {
		this.categorydesc = categorydesc;
	}

	public Set<Item> getItem() {
		return item;
	}

	public void setItem(Set<Item> item) {
		this.item = item;
	}
	
	
	
}
