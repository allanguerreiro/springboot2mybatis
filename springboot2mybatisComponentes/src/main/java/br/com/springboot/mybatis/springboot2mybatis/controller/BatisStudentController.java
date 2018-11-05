package br.com.springboot.mybatis.springboot2mybatis.controller;

import br.com.springboot.mybatis.springboot2mybatis.bean.Student;
import br.com.springboot.mybatis.springboot2mybatis.dao.IStudentBatisDao;
import br.com.springboot.mybatis.springboot2mybatis.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component("batisStudentController")
public class BatisStudentController implements IBatisStudentController {

    @Autowired
    IStudentBatisDao iStudentBatisDao;

    @Override
    public String findAll() {
        String estudantes = "";
        try {
            List<Student> students = iStudentBatisDao.findAll();
            estudantes = Util.objectFromJSon(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return estudantes;
    }

    @Override
    public String findById(long id) {
        String estudante = "";
        try {
            Student student = iStudentBatisDao.findById(id);
            estudante = Util.objectFromJSon(student);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return estudante;
    }

    @Override
    public void deleteById(long id) {
        try {
            int retorno = iStudentBatisDao.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert() {
        try {
            Student student = new Student(1L, "Allan", "A1234567");
            int retorno = iStudentBatisDao.insert(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        try {
            Student student = new Student(1L, "Allan Guerreiro Carneiro", "D1234567");
            int retorno = iStudentBatisDao.update(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
