package com.passportUniDi.entity;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import org.hibernate.action.internal.OrphanRemovalAction;

@Entity
public class Person {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private Date dateOfBirth;
	private String birthPlace;
	
	
	@OneToOne(cascade=CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="pafk")
	private Passport passport;
	
	public Person() {
		
	}

	public Person( String name, Date dateOfBirth, String birthPlace,Passport passport) {
//		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.birthPlace = birthPlace;
		this.passport=passport;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}
    
	
	
}
