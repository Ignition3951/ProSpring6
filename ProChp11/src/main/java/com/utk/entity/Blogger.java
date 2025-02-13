package com.utk.entity;

import java.net.URL;
import java.time.LocalDate;

public class Blogger {

	private String firstName;
	private String lastName;
	private LocalDate birthDate;
	private java.net.URL personalSite;

	public Blogger(String firstName, String lastName, LocalDate birthDate, URL personalSite) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.personalSite = personalSite;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public java.net.URL getPersonalSite() {
		return personalSite;
	}

	public void setPersonalSite(java.net.URL personalSite) {
		this.personalSite = personalSite;
	}

}
