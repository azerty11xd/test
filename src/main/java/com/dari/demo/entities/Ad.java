package com.dari.demo.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.dari.demo.classes.Stat;


@Entity
public class Ad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id ;
	private @Enumerated(EnumType.STRING) Stat statue;
	private String Adress,Description;
	private float Price ;
	private int Rooms,Baths;
	private boolean furnished,sold;
	private @ManyToOne
	User users;
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public Stat getStatue() {
		return statue;
	}
	public void setStatue(Stat statue) {
		this.statue = statue;
	}
	public String getAdress() {
		return Adress;
	}
	public void setAdress(String adress) {
		Adress = adress;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public float getPrice() {
		return Price;
	}
	public void setPrice(float price) {
		Price = price;
	}
	public int getRooms() {
		return Rooms;
	}
	public void setRooms(int rooms) {
		Rooms = rooms;
	}
	public int getBaths() {
		return Baths;
	}
	public void setBaths(int baths) {
		Baths = baths;
	}
	public boolean isFurnished() {
		return furnished;
	}
	public void setFurnished(boolean furnished) {
		this.furnished = furnished;
	}
	public boolean isSold() {
		return sold;
	}
	public void setSold(boolean sold) {
		this.sold = sold;
	}
	public User getUsers() {
		return users;
	}
	public void setUsers(User users) {
		this.users = users;
	}
	public Ad(long id, Stat statue, String adress, String description, float price, int rooms, int baths,
			boolean furnished, boolean sold, User users) {
		super();
		Id = id;
		this.statue = statue;
		Adress = adress;
		Description = description;
		Price = price;
		Rooms = rooms;
		Baths = baths;
		this.furnished = furnished;
		this.sold = sold;
		this.users = users;
	}
	
	public Ad() {
		super();
	
	}
	
}
