package com.nwt.autoprevoznik.Models;

import java.util.Map;

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
@Table(name="Informacije")
public class Informacije {
	
	 @Id
	    @GeneratedValue(strategy= GenerationType.AUTO)
	    @Column(name="informacijeId", nullable = false)
	    private int informacijeId;

	    @ManyToOne
	    @JoinColumn(name="autoprevoznikId", nullable = false)
	    private Autoprevoznik autoprevoznikId;

	    
	    @NotNull
	    @Size(min=5, max=100)
	    @Column(name="opis", nullable = false)
	    private String opis;



		public int getInformacijeId() {
			return informacijeId;
		}



		public void setInformacijeId(int informacijeId) {
			this.informacijeId = informacijeId;
		}



		public String getOpis() {
			return opis;
		}



		public void setOpis(String opis) {
			this.opis = opis;
		}



		

}
