package com.nwt.autoprevoznik.POJO;

public class Recenzija {

	private Long idRecenzije;
	private String komentar;
	private int ocjena;
	private int idAutoprevoznika;
	

	private int idKompanije;
	
	public Recenzija() {}
	public Recenzija(Long idRecenzije, String komentar, int ocjena, int idAutoprevoznika, int idKompanije) {
		super();
		this.idRecenzije = idRecenzije;
		this.komentar = komentar;
		this.ocjena = ocjena;
		this.idAutoprevoznika = idAutoprevoznika;
		this.idKompanije = idKompanije;
	}
	public Long getIdRecenzije() {
		return idRecenzije;
	}
	public void setIdRecenzije(Long idRecenzije) {
		this.idRecenzije = idRecenzije;
	}
	public String getKomentar() {
		return komentar;
	}
	public void setKomentar(String komentar) {
		this.komentar = komentar;
	}
	public int getOcjena() {
		return ocjena;
	}
	public void setOcjena(int ocjena) {
		this.ocjena = ocjena;
	}
	public int getIdAutoprevoznika() {
		return idAutoprevoznika;
	}
	public void setIdAutoprevoznika(int idAutoprevoznika) {
		this.idAutoprevoznika = idAutoprevoznika;
	}
	public int getIdKompanije() {
		return idKompanije;
	}
	public void setIdKompanije(int idKompanije) {
		this.idKompanije = idKompanije;
	}
	
    @Override
    public String toString() {
        return String.format(
                "Recenzija[id=%d, komentar='%s', ocjena='%d']",
                idRecenzije, komentar, ocjena);
    }

}
