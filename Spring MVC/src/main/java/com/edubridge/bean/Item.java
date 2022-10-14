/**
 * 
 */
package com.edubridge.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;



import javax.persistence.Entity;

// TODO: Auto-generated Javadoc

@Entity
@Table(name = "item")
public class Item {

	/** The itemid. */
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int itemid;

	/** The itemname. */
	@Column
	private String itemname;
	
	@Column
	private String itemdesc;
	
	@Column
	private double costprice;
	
	@Column
	private Integer stockunit;

	/** The itemprice. */
	@Column
	private double itemprice;
	
	@Column
	private Date date;
	
//    @Lob
//    @Column(name = "Image", nullable = true)
//	private String image;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
	private Set<Cart> cart;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable (name = "item_category", catalog = "spring",
	joinColumns = {
			@JoinColumn(name = "itemid", nullable = false, updatable = false)
	},
	inverseJoinColumns = {
			@JoinColumn (name = "categoryId", nullable = false, updatable = false)
	})
	private Set<Category> categories = new HashSet<Category>(0);

//	@Column
//	private List<MultipartFile> files;
//	@Column
//	/** The file to upload. */
//	private MultipartFile fileToUpload;
	
	public Item() {
	}

	public Item(int itemid, String itemname, double itemprice, Date date, Set<Category> categories) {
		super();
		this.itemid = itemid;
		this.itemname = itemname;
		this.itemprice = itemprice;
		this.date=date;
		this.categories = categories;

	}

	public int getItemid() {
		return itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public double getItemprice() {
		return itemprice;
	}

	public void setItemprice(double itemprice) {
		this.itemprice = itemprice;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
			
//	public String getImage() {
//		return image;
//	}
//
//	public void setImage(String fileName) {
//		this.image = fileName;
//	}

	public Set<Cart> getCart() {
		return cart;
	}

	public void setCart(Set<Cart> cart) {
		this.cart = cart;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public String getItemdesc() {
		return itemdesc;
	}

	public void setItemdesc(String itemdesc) {
		this.itemdesc = itemdesc;
	}

	public double getCostprice() {
		return costprice;
	}

	public void setCostprice(double costprice) {
		this.costprice = costprice;
	}

	public Integer getStockunit() {
		return stockunit;
	}

	public void setStockunit(Integer stockunit) {
		this.stockunit = stockunit;
	}
	
	
//	public MultipartFile getFileToUpload() {
//		return fileToUpload;
//	}
//
//	public void setFileToUpload(MultipartFile fileToUpload) {
//		this.fileToUpload = fileToUpload;
//	}
//	public List<MultipartFile> getFiles() {
//		return files;
//	}
//
//	public void setFiles(List<MultipartFile> files) {
//		this.files = files;
//	}
}
