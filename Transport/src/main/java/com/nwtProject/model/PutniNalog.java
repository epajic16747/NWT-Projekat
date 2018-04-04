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
@Table(name="PutniNalog")
public class PutniNalog {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column (name = "idPutniNalog")
    private int idPutniNalog;
    @NotNull
    @Column (name = "informacije")
    
    @NotNull
    @Size(min=5, max=45)
    private String Informacije;
    
    @NotNull
    @Column (name = "idTransporta")
    private int idTransporta;
    
    @NotNull
    @Size(min=5, max=500)
    @Column (name = "dokument")
    private byte[] dokument;
    
    
    
    
    
	public PutniNalog() {
	}
	public PutniNalog(int idPutniNalog, String informacije, int idTransporta, byte[] dokument) {
		super();
		this.idPutniNalog = idPutniNalog;
		Informacije = informacije;
		this.idTransporta = idTransporta;
		this.dokument = dokument;
	}
	public int getIdPutniNalog() {
		return idPutniNalog;
	}
	public void setIdPutniNalog(int idPutniNalog) {
		this.idPutniNalog = idPutniNalog;
	}
	public String getInformacije() {
		return Informacije;
	}
	public void setInformacije(String informacije) {
		Informacije = informacije;
	}
	public int getIdTransporta() {
		return idTransporta;
	}
	public void setIdTransporta(int idTransporta) {
		this.idTransporta = idTransporta;
	}
	public byte[] getDokument() {
		return dokument;
	}
	public void setDokument(byte[] dokument) {
		this.dokument = dokument;
	}
    
    
    
 
    
}
