package org.transport.autoprevoznik.autoprevoznik.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Ponuda")
public class Ponuda  implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ponudaId", nullable = false)
    private int autoprevoznikId;

    @Column(name="cijena", nullable = false)
    private double cijena;

    @Column(name="tipVozila", nullable = false)
    private String tipVozila;

    @Column(name="status", nullable = false)
    private Boolean status;

    @ManyToOne
    @JoinColumn(name="autoprevonikId", nullable = false)
    private Autoprevoznik autoprevonikId;

    Ponuda() {}

}
