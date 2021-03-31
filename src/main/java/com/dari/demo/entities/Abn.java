package com.dari.demo.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.dari.demo.classes.sub;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Abn {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	private @Temporal(TemporalType.DATE) Date inscriptionstart,isncriptionend;
	private int inscriptionlength ;
	private float price;
	private @Enumerated(EnumType.STRING) sub Atype ;
	private @OneToOne(mappedBy = "abn")@JsonIgnore
	User user;
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public Date getInscriptionstart() {
		return inscriptionstart;
	}
	public void setInscriptionstart(Date inscriptionstart) {
		this.inscriptionstart = inscriptionstart;
	}
	public Date getIsncriptionend() {
		return isncriptionend;
	}
	public void setIsncriptionend(Date isncriptionend) {
		this.isncriptionend = isncriptionend;
	}
	public int getInscriptionlength() {
		return inscriptionlength;
	}
	public void setInscriptionlength(int inscriptionlength) {
		this.inscriptionlength = inscriptionlength;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public sub getAtype() {
		return Atype;
	}
	public void setAtype(sub atype) {
		Atype = atype;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Abn(long id, Date inscriptionstart, Date isncriptionend, int inscriptionlength, float price, sub atype
			) {
		super();
		Id = id;
		this.inscriptionstart = inscriptionstart;
		this.isncriptionend = isncriptionend;
		this.inscriptionlength = inscriptionlength;
		this.price = price;
		Atype = atype;
		
	}
	
	public Abn() {
		super();
	
	}
	
	

}
