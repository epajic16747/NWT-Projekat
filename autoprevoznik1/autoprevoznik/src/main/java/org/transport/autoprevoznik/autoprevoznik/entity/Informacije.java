package org.transport.autoprevoznik.autoprevoznik.entity;

import javax.persistence.*;
import java.io.Serializable;

public class Informacije implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="informacijeId", nullable = false)
    private int informacijeId;

    @ManyToOne
    @JoinColumn(name="autoprevoznikId", nullable = false)
    private Autoprevoznik autoprevoznikId;

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Column(name="opis", nullable = false)
    private String opis;



}
