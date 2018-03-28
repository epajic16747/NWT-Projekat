package com.nwtProject.KorisnikRecenzija.Models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Column;

@Entity
@Table(name="Recenzija")
public class Recenzija {
	
	
	@Id
	@Column(name="IdRecenzije")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idRecenzije;
	
    @NotNull
    @Size(min=100, max=1500)
	@Column(name="komentar")
	private String komentar;
	
    @NotNull
    @Size(min=1, max=10)
	@Column(name="ocjena")
	private int ocjena;
	
	@Column(name="idAutoprevoznika")
	private int idAutoprevoznika;
	
	@Column(name="idKompanije")
	private int idKompanije;
	
	public Recenzija() {}
	public Recenzija(Long idRecenzije, String komentar, int ocjena, int idAutoprevoznika, int idKompanije) {
		super();
		this.idRecenzije = idRecenzije;
		this.komentar = komentar;
		this.ocjena = ocjena;
		this.idAutoprevoznika = idAutoprevoznika;
		this.idKompanije = idKompanije;
	}
	public Long getIdRecenzije() {
		return idRecenzije;
	}
	public void setIdRecenzije(Long idRecenzije) {
		this.idRecenzije = idRecenzije;
	}
	public String getKomentar() {
		return komentar;
	}
	public void setKomentar(String komentar) {
		this.komentar = komentar;
	}
	public int getOcjena() {
		return ocjena;
	}
	public void setOcjena(int ocjena) {
		this.ocjena = ocjena;
	}
	public int getIdAutoprevoznika() {
		return idAutoprevoznika;
	}
	public void setIdAutoprevoznika(int idAutoprevoznika) {
		this.idAutoprevoznika = idAutoprevoznika;
	}
	public int getIdKompanije() {
		return idKompanije;
	}
	public void setIdKompanije(int idKompanije) {
		this.idKompanije = idKompanije;
	}
	
    @Override
    public String toString() {
        return String.format(
                "Recenzija[id=%d, komentar='%s', ocjena='%d']",
                idRecenzije, komentar, ocjena);
    }

}
