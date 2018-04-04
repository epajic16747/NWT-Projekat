package org.transport.autoprevoznik.autoprevoznik.dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.transport.autoprevoznik.autoprevoznik.entity.Autoprevoznik;


@Transactional
@Repository
public class AutoprevoznikDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void unosAutoprevoznika(){

        Autoprevoznik a = new Autoprevoznik("Centrotrans", "Neki opis", "Muje Mujica",
                "061225883", "mail@email.com");
        entityManager.persist(a);

    }
}


