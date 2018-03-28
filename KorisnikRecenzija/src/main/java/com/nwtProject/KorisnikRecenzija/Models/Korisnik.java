package com.nwtProject.KorisnikRecenzija.Models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;


@Entity
@Table(name="Korisnik")
public class Korisnik {
	
	@Id
	@Column(name="IdKorisnika")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idKorisnika;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String email;
	
	@Column(name="idKompanije")
	private int idKompanije;
	
	@Column(name="idAutoprevoznika")
	private int idAutoprevoznika;

	
	protected Korisnik() {
		
	}
	
	public Korisnik(Long idKorisnika, String username, String password, String email, int idKompanije,
			int idAutoprevoznika) {
		//super();
		this.idKorisnika = idKorisnika;
		this.username = username;
		this.password = password;
		this.email = email;
		this.idKompanije = idKompanije;
		this.idAutoprevoznika = idAutoprevoznika;
	}

	public Long getIdKorisnika() {
		return idKorisnika;
	}

	public void setIdKorisnika(Long idKorisnika) {
		this.idKorisnika = idKorisnika;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdKompanije() {
		return idKompanije;
	}

	public void setIdKompanije(int idKompanije) {
		this.idKompanije = idKompanije;
	}

	public int getIdAutoprevoznika() {
		return idAutoprevoznika;
	}

	public void setIdAutoprevoznika(int idAutoprevoznika) {
		this.idAutoprevoznika = idAutoprevoznika;
	}
	
    @Override
    public String toString() {
        return String.format(
                "Korisnik[id=%d, username='%s', email='%s']",
                idKorisnika, password, email);
    }

}