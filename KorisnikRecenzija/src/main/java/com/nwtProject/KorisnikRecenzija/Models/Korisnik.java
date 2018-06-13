package com.nwtProject.KorisnikRecenzija.Models;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;


import com.nwtProject.KorisnikRecenzija.Models.Role;

import java.util.Optional;

import javax.persistence.Column;


@Entity
@Table(name="Korisnik")
public class Korisnik {
	
	@Id
	@Column(name="idKorisnika")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idKorisnika;
	
    @NotNull
    @Size(min=5, max=45)
	@Column(name="username")
	private String username;
	
    
    @NotNull
    @Size(min=10, max=45)
	@Column(name="password")
	private String password;
	
    
    @NotNull
    @Size(min=10, max=100)
	@Column(name="email",unique=true)
	private String email;
	
	@Column(name="idKompanije")
	private int idKompanije;
	
	@Column(name="idAutoprevoznika")
	private int idAutoprevoznika;


	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
    
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
	
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
	
    @Override
    public String toString() {
        return String.format(
                "Korisnik[id=%d, username='%s', email='%s']",
                idKorisnika, password, email);
    }




	

}