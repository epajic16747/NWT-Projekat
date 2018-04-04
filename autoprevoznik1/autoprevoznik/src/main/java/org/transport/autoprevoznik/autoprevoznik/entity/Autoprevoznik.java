package org.transport.autoprevoznik.autoprevoznik.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "autoprevoznik")
public class Autoprevoznik implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="autoprevoznikId", nullable = false)
    private int autoprevoznikId;

    @Column(name="naziv", nullable = false)
    private String naziv;

    @Column(name="opis", nullable = false)
    private String opis;

    @Column(name="adresa", nullable = false)
    private String adresa;

    @Column(name="telefon", nullable = false)
    private String telefon;

    @Column(name="email", nullable = false)
    private String email;

    Autoprevoznik() {}

    public Autoprevoznik(String naziv, String opis, String adresa, String telefon, String email)
    {
        this.naziv = naziv;
        this.opis = opis;
        this.adresa = adresa;
        this.telefon = telefon;
        this.email = email;
    }
}
