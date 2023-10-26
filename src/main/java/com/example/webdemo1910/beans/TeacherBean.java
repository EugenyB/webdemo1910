package com.example.webdemo1910.beans;

import com.example.webdemo1910.dao.TeacherDao;
import com.example.webdemo1910.data.Teacher;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Named
@SessionScoped
public class TeacherBean implements Serializable {

    @Getter @Setter
    private Teacher currentTeacher;

    @EJB
    TeacherDao teacherDao;

    public String showSubjects(int teacherId) {
        currentTeacher = teacherDao.find(teacherId);
        return "teacher";
    }
}
