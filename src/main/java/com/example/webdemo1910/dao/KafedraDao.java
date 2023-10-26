package com.example.webdemo1910.dao;

import com.example.webdemo1910.data.Kafedra;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class KafedraDao {
    @PersistenceContext
    EntityManager em;

    public List<Kafedra> findAll() {
        return em.createNamedQuery("Kafedra.findAll", Kafedra.class).getResultList();
    }

    public void add(Kafedra kafedra) {
        em.persist(kafedra);
    }

    public void delete(int id) {
        Kafedra kafedra = em.find(Kafedra.class, id);
        em.remove(kafedra);
    }

    public Kafedra find(int kafedraId) {
        return em.find(Kafedra.class, kafedraId);
    }

    public void update(Kafedra kafedra) {
        em.merge(kafedra);
    }
}
