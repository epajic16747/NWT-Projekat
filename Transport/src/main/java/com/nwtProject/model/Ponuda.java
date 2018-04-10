package com.nwtProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="Ponuda")
public class Ponuda {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column (name = "idPonuda")
    private Long idPonuda;
    
    @NotNull
    @Size(min=1, max=10)
    @Column (name = "cijena")
    private double cijena;
    
    @NotNull
    @Size(min=5, max=45)
    @Column (name = "tipVozila")
    private String tipVozila;
    
    @NotNull
    @Column (name = "idTransporta")
    private int idTransporta;
    @NotNull
    @Column (name = "idAutoprevoznika")
    private int idAutoprevoznika;
	
    protected Ponuda() {}

    
    public Ponuda(Long idPonuda, double cijena, String tipVozila, int idTransporta, int idAutoprevoznika) {
		super();
		this.idPonuda = idPonuda;
		this.cijena = cijena;
		this.tipVozila = tipVozila;
		this.idTransporta = idTransporta;
		this.idAutoprevoznika = idAutoprevoznika;
	}

	public Long getIdPonuda() {
		return idPonuda;
	}

	public void setIdPonuda(Long idPonuda) {
		this.idPonuda = idPonuda;
	}

	public double getCijena() {
		return cijena;
	}

	public void setCijena(double cijena) {
		this.cijena = cijena;
	}

	public String getTipVozila() {
		return tipVozila;
	}

	public void setTipVozila(String tipVozila) {
		this.tipVozila = tipVozila;
	}

	public int getIdTransporta() {
		return idTransporta;
	}

	public void setIdTransporta(int idTransporta) {
		this.idTransporta = idTransporta;
	}

	public int getIdAutoprevoznika() {
		return idAutoprevoznika;
	}

	public void setIdAutoprevoznika(int idAutoprevoznika) {
		this.idAutoprevoznika = idAutoprevoznika;
	}
    
}
