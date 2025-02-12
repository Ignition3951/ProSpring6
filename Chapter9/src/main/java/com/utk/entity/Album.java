package com.utk.entity;

import java.io.Serial;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ALBUM")
public class Album extends AbstractEntity {

	/**
	 * 
	 */
	@Serial
	private static final long serialVersionUID = 3L;

	private String title;
	private LocalDate releaseDate;
	private Singer singer;

	@ManyToOne
	@JoinColumn(name = "SINGER_ID")
	public Singer getSinger() {
		return singer;
	}

	public void setSinger(Singer singer) {
		this.singer = singer;
	}

	@Column(name = "TITLE")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "RELEASE_DATE")
	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Override
	public String toString() {
		return "Album [title=" + title + ", releaseDate=" + releaseDate + "]";
	}


}
