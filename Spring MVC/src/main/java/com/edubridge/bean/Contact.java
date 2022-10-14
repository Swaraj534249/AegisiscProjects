package com.edubridge.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "conatact")
public class Contact {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int visiterid;


	@Column
	private String visitername;

	/** The tenantemail. */
	@Column
	private String visiteremail;


	/** The dateformat. */
	@Column
	private String visitermessage;
	
	@Column
	private Date date;
	
	@Column
	private double totalprice;
	
	

	public double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

	public Contact() {
	}

	public Contact(int visiterid, String visitername, String visiteremail, String visitermessage, Date date) {
		super();
		this.visiterid = visiterid;
		this.visitername = visitername;
		this.visiteremail = visiteremail;
		this.visitermessage = visitermessage;
		this.date = date;
	}

	public int getVisiterid() {
		return visiterid;
	}

	public void setVisiterid(int visiterid) {
		this.visiterid = visiterid;
	}

	public String getVisitername() {
		return visitername;
	}

	public void setVisitername(String visitername) {
		this.visitername = visitername;
	}

	public String getVisiteremail() {
		return visiteremail;
	}

	public void setVisiteremail(String visiteremail) {
		this.visiteremail = visiteremail;
	}

	public String getVisitermessage() {
		return visitermessage;
	}

	public void setVisitermessage(String visitermessage) {
		this.visitermessage = visitermessage;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}