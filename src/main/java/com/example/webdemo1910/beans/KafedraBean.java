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

    @Getter @Setter
    private Kafedra selectedKafedra;

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

    public String showTeachers(int kafedraId) {
        selectedKafedra = kafedraDao.find(kafedraId);
        return "kafedra";
    }

    public String edit(int id) {
        kafedra = kafedraDao.find(id);
        return "edit_kafedra";
    }

    public String update() {
        kafedraDao.update(kafedra);
        kafedra = new Kafedra();
        return "index";
    }
}
