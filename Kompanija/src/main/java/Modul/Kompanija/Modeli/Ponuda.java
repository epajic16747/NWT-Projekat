package Modul.Kompanija.Modeli;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="Ponuda")
public class Ponuda {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	



	
	@ManyToOne(targetEntity=Kompanija.class)
    @JoinColumn(name="idKompanije")
	private int idKompanije;
	
	

	public Ponuda() {
		
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}


	public int getIdKompanije() {
		return idKompanije;
	}



	public void setIdKompanije(int idKompanije) {
		this.idKompanije = idKompanije;
	}

}

