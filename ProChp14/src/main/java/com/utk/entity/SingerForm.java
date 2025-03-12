package com.utk.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class SingerForm {

	@NotNull
	@Size(min = 2, max = 30)
	private String firstName;

	@NotNull
	@Size(min = 2, max = 30)
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
