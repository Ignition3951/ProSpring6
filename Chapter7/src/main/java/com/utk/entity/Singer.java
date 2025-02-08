package com.utk.entity;

import java.io.Serial;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "SINGER")
public class Singer extends AbstractEntity {

	/**
	 * 
	 */
	@Serial
	private static final long serialVersionUID = 2L;

	private String fistName;
	private String lastName;
	private LocalDate birthDate;
	private Set<Album> albums = new HashSet<>();
	private Set<Instrument> instruments = new HashSet<>();

	@ManyToMany
	@JoinTable(name = "SINGER_INSTRUMENT", joinColumns = @JoinColumn(name = "SINGER_ID"), inverseJoinColumns = @JoinColumn(name = "INSTRUMENT_ID"))
	public Set<Instrument> getInstruments() {
		return instruments;
	}

	public void setInstruments(Set<Instrument> instruments) {
		this.instruments = instruments;
	}

	@OneToMany(mappedBy = "singer", cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(Set<Album> album) {
		this.albums = album;
	}

	public boolean addAlbum(Album album) {
		album.setSinger(this);
		return getAlbums().add(album);
	}

	public void removeALbum(Album album) {
		getAlbums().remove(album);
	}

	@Column(name = "FIRST_NAME")
	public String getFistName() {
		return fistName;
	}

	public void setFistName(String fistName) {
		this.fistName = fistName;
	}

	@Column(name = "LAST_NAME")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "BIRTH_DATE")
	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Singer [fistName=" + fistName + ", lastName=" + lastName + ", birthDate=" + birthDate + "]";
	}

}
