package com.utk.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class SingerForm {

	@NotEmpty(message = "{NotEmpty.singer.firstName}")
	@Size(min = 2, max = 30, message = "{Size.singer.firstName}")
	private String firstName;

	@NotEmpty(message = "{NotEmpty.singer.lastName}")
	@Size(min = 2, max = 30, message = "{Size.singer.lastName}")
	private String lastName;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthDate;

	MultipartFile multipartFile;

	public SingerForm() {
	}

	public SingerForm(String firstName, String lastName, LocalDate birthDate, MultipartFile multipartFile) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.multipartFile = multipartFile;
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

	public MultipartFile getMultipartFile() {
		return multipartFile;
	}

	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}

}
