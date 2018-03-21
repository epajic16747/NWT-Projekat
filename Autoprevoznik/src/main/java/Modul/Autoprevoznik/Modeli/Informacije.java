package Modul.Autoprevoznik.Modeli;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Informacije")
public class Informacije {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	
	@ManyToOne(targetEntity=Autoprevoznik.class)
    @JoinColumn(name="idAutoprevoznika")
	private int idAutoprevoznika;
	



	@Column(name="tekst")
	private String tekst;




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public int getIdAutoprevoznika() {
		return idAutoprevoznika;
	}




	public void setIdAutoprevoznika(int idAutoprevoznika) {
		this.idAutoprevoznika = idAutoprevoznika;
	}




	public String getTekst() {
		return tekst;
	}




	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	

}
