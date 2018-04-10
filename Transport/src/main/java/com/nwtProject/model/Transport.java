package com.nwtProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Transport")
public class Transport {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column (name = "idTransporta")
    private int idTransporta;

    @Column(name = "cijenaMax")
    private Double cijenaMax;

    @Column(name = "datum")
    private String datum;
	
    @Column(name = "idAutoprevoznika")
    private int idAutoprevoznika;
	
    @Column(name = "status")
    private String status;
	
    @Column(name = "idKompanije")
    private int idKompanije;
	
    @Column(name = "naziv")
    private String naziv;

    protected Transport() {}

    public Transport(int idTransporta, Double cijenaMax, String datum,  int idAutoprevoznika, String status,
    		int idKompanije, String naziv ) {
        super();
        this.idTransporta = idTransporta;
        this.cijenaMax = cijenaMax;
        this.datum = datum;
        this.idAutoprevoznika = idAutoprevoznika;
        this.status = status;
        this.idKompanije = idKompanije;
        this.naziv = naziv; 
    }

    @Override
    public String toString() {
        return String.format(
                "Transport[idTransporta=%d, cijenaMax='%d', datum='%d' , idAutoprevoznika = '%d', status='%s', idKompanije = '%d', naziv = '%s']",
                idTransporta, cijenaMax, datum, idAutoprevoznika, status, idKompanije, naziv);
    }

	public int getIdTransporta() {
		return idTransporta;
	}

	public void setIdTransporta(int idTransporta) {
		this.idTransporta = idTransporta;
	}

	public Double getCijenaMax() {
		return cijenaMax;
	}

	public void setCijenaMax(Double cijenaMax) {
		this.cijenaMax = cijenaMax;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public int getIdAutoprevoznika() {
		return idAutoprevoznika;
	}

	public void setIdAutoprevoznika(int idAutoprevoznika) {
		this.idAutoprevoznika = idAutoprevoznika;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getIdKompanije() {
		return idKompanije;
	}

	public void setIdKompanije(int idKompanije) {
		this.idKompanije = idKompanije;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

}