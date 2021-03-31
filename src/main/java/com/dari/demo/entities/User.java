package com.dari.demo.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.dari.demo.classes.Gender;
import com.dari.demo.classes.Profession;

@Entity
/*@Table(name = "t_user")*/
public class User {

	@Id
	@GeneratedValue
	private Long Id;
	private String name;
	private int age ;
	private @Enumerated(EnumType.STRING) Gender gender;

	@OneToMany(mappedBy = "users")
	private Set<Ad> ads;

	private @Enumerated(EnumType.STRING) Profession profession;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Abn_id", referencedColumnName = "id")
	private Abn abn ;
	
	
	
	
	public Abn getAbn() {
		return abn;
	}
	public void setAbn(Abn abn) {
		this.abn = abn;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Set<Ad> getAds() {
		return ads;
	}
	public void setAds(Set<Ad> ads) {
		this.ads = ads;
	}
	public Profession getProfession() {
		return profession;
	}
	public void setProfession(Profession profession) {
		this.profession = profession;
	}
	
	
	public User(Long id, String name, int age, Gender gender, Set<Ad> ads, Profession profession ) {
		super();
		Id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.ads = ads;
		this.profession = profession;
	
	}
	
	
	public User() {
		super();
		
	}
	
	
	
}

