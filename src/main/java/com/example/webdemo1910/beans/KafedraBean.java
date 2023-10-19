package com.example.webdemo1910.beans;

import com.example.webdemo1910.dao.KafedraDao;
import com.example.webdemo1910.data.Kafedra;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class KafedraBean implements Serializable {
    @EJB
    KafedraDao kafedraDao;

    @Getter @Setter
    private Kafedra kafedra = new Kafedra();

    public List<Kafedra> getKafedraList() {
        return kafedraDao.findAll();
    }

    public void add() {
        kafedraDao.add(kafedra);
        kafedra = new Kafedra();
    }

    public void delete(int id) {
        kafedraDao.delete(id);
    }
}
