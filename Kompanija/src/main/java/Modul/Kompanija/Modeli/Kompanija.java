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
@Table(name="Kompanija")
public class Kompanija {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="naziv")
	private String naziv;
	



	@Column(name="opis")
	private String opis;


	@Column(name="stavka1")
	private String stavka1;

	@Column(name="stavka2")
	private String stavka2;
	
	

	public Kompanija() {
		
	}
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNaziv() {
		return naziv;
	}


	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}


	public String getOpis() {
		return opis;
	}


	public void setOpis(String opis) {
		this.opis = opis;
	}	
	
	public String getStavka1() {
		return stavka1;
	}
	
	public void setStavka1(String stavka1) {
		this.stavka1 = stavka1;
	}
	
	public String getStavka2() {
		return stavka2;
	}
	
	public void setStavka2(String stavka2) {
		this.stavka2 = stavka2;
	}
}
