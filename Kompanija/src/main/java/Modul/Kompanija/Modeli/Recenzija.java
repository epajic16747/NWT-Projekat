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
@Table(name="Recenzija")
public class Recenzija {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="ocjena")
	private String ocjena;
	



	@Column(name="komentar")
	private String komentar;


	
	@ManyToOne(targetEntity=Kompanija.class)
    @JoinColumn(name="idKompanije")
	private int idKompanije;
	
	

	public Recenzija() {
		
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getOcjena() {
		return ocjena;
	}



	public void setOcjena(String ocjena) {
		this.ocjena = ocjena;
	}



	public String getKomentar() {
		return komentar;
	}



	public void setKomentar(String komentar) {
		this.komentar = komentar;
	}



	public int getIdKompanije() {
		return idKompanije;
	}



	public void setIdKompanije(int idKompanije) {
		this.idKompanije = idKompanije;
	}

}
