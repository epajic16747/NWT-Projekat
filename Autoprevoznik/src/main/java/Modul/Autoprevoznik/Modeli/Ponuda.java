package Modul.Autoprevoznik.Modeli;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Ponuda")
public class Ponuda {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	
	@OneToOne(targetEntity=Autoprevoznik.class)
    @JoinColumn(name="idAutoprevoznika")
	private int idAutoprevoznika;
	



	@Column(name="tekstPonude")
	private String tekstPonude;


	@Column(name="cijena")
	private double cijena;

   

	@Column(name="idKompanije")
	private int idKompanije;
	
	@Column(name="Polaziste")
	private String polaziste;
	
	@Column(name="Odrediste")
	private String odrediste;
	
	@Column(name="TipVozila")
	private String tipVozila;
	
	@Column(name="Status")
	private Boolean status;

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

	public String getTekstPonude() {
		return tekstPonude;
	}

	public void setTekstPonude(String tekstPonude) {
		this.tekstPonude = tekstPonude;
	}

	public double getCijena() {
		return cijena;
	}

	public void setCijena(double cijena) {
		this.cijena = cijena;
	}

	public int getIdKompanije() {
		return idKompanije;
	}

	public void setIdKompanije(int idKompanije) {
		this.idKompanije = idKompanije;
	}

	public String getPolaziste() {
		return polaziste;
	}

	public void setPolaziste(String polaziste) {
		this.polaziste = polaziste;
	}

	public String getOdrediste() {
		return odrediste;
	}

	public void setOdrediste(String odrediste) {
		this.odrediste = odrediste;
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
	
	

	

}
