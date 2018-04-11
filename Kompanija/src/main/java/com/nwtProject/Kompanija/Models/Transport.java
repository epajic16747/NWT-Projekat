package com.nwtProject.Kompanija.Models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Column;

@Entity
@Table(name="Transport")
public class Transport {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column (name = "idTransporta")
    private Long idTransporta;
    
    @NotNull
    @Column(name = "datum")
    private String datum;
    @NotNull
    @Column(name = "idAutoprevoznika")
    private int idAutoprevoznika;
    
    @NotNull
    @Size(min=3, max=45)
    @Column(name = "status")
    private String status;

	@NotNull
	@ManyToOne
//    @JoinColumn(name="idKompanije")
    private Kompanija idKompanije;

    @NotNull
    @Size(min=3, max=450)
    @Column(name = "naziv")
    private String naziv;

    public Transport() {}

//    public Transport(Long idTransporta, Double cijenaMax, String datum,  int idAutoprevoznika, String status,
//    		int idKompanije, String naziv ) {
//        super();
//        this.idTransporta = idTransporta;
//        this.cijenaMax = cijenaMax;
//        this.datum = datum;
//        this.idAutoprevoznika = idAutoprevoznika;
//        this.status = status;
//        this.idKompanije = idKompanije;
//        this.naziv = naziv;
//    }
//
//    @Override
//    public String toString() {
//        return String.format(
//                "Transport[idTransporta=%d, cijenaMax='%d', datum='%d' , idAutoprevoznika = '%d', status='%s', idKompanije = '%d', naziv = '%s']",
//                idTransporta, cijenaMax, datum, idAutoprevoznika, status, idKompanije, naziv);
//    }

	public Long getIdTransporta() {
		return idTransporta;
	}

	public void setIdTransporta(Long idTransporta) {
		this.idTransporta = idTransporta;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Kompanija getIdKompanije() {
		return idKompanije;
	}

	public void setIdKompanije(Kompanija idKompanije) {
		this.idKompanije = idKompanije;
	}
}
