package com.example.webdemo1910.dao;

import com.example.webdemo1910.data.Teacher;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class TeacherDao {
    @PersistenceContext
    EntityManager em;

    public Teacher find(int id){
        return em.find(Teacher.class, id);
    }
}
