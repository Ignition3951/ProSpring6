package com.utk.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "SINGER")
public class Singer extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	private String fistName;
	private String lastName;
	private LocalDate birthDate;
	private Set<Album> albums = new HashSet<>();
	private Set<Instrument> instruments = new HashSet<>();
	private byte[] photo;

	public Singer() {
	}

	Singer(Builder builder) {
		this.fistName = builder.fistName;
		this.lastName = builder.lastName;
		this.birthDate = builder.birthDate;
	}

	@Basic(fetch = FetchType.LAZY)
	@Lob
	@Column(name = "PHOTO")
	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

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

	@NotNull
	@Size(min = 2, max = 30)
	@Column(name = "FIRST_NAME")
	public String getFistName() {
		return fistName;
	}

	public void setFistName(String fistName) {
		this.fistName = fistName;
	}

	@NotNull
	@Size(min = 2, max = 30)
	@Column(name = "LAST_NAME")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "BIRTH_DATE")
	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Singer [fistName=" + fistName + ", lastName=" + lastName + ", birthDate=" + birthDate + ", albums="
				+ albums + ", instruments=" + instruments + "]";
	}

//	@Override
//	public String toString() {
//		return "Singer [fistName=" + fistName + ", lastName=" + lastName + ", birthDate=" + birthDate + "]";
//	}

	public static class Builder {

		private String fistName;
		private String lastName;
		private LocalDate birthDate;

		public Builder fistName(String firstName) {
			this.fistName = firstName;
			return this;
		}

		public Builder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder birthDate(LocalDate birthDate) {
			this.birthDate = birthDate;
			return this;
		}

		public Singer build() {
			return new Singer(this);
		}
	}

}
