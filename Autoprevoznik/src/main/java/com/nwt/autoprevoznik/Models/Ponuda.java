package com.nwt.autoprevoznik.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Ponuda")
public class Ponuda {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ponudaId", nullable = false)
    private int ponudaId;
	@NotNull
    @Column(name="cijena", nullable = false)
    private double cijena;
	
	@NotNull
    @Column(name="tipVozila", nullable = false)
    private String tipVozila;
	
	@NotNull
    @Column(name="status", nullable = false)
    private Boolean status;

    @ManyToOne
    @JoinColumn(name="autoprevoznikId", nullable = false)
    private Autoprevoznik autoprevonikId;

    public int getPonudaId() {
		return ponudaId;
	}

	public void setPonudaId(int ponudaId) {
		this.ponudaId = ponudaId;
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

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Autoprevoznik getAutoprevonikId() {
		return autoprevonikId;
	}

	public void setAutoprevonikId(Autoprevoznik autoprevonikId) {
		this.autoprevonikId = autoprevonikId;
	}

	Ponuda() {}

}
