package com.utk.entity;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Letter implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private String title;

	private String sender;

	private LocalDate sentOn;

	@Enumerated(EnumType.STRING)
	private com.utk.util.Category category = com.utk.util.Category.MISC;

	@NotEmpty
	private String content;

}
