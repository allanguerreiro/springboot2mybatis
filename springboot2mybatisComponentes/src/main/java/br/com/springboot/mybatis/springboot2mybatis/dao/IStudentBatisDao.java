package br.com.springboot.mybatis.springboot2mybatis.dao;

import br.com.springboot.mybatis.springboot2mybatis.bean.Student;

import java.util.List;

public interface IStudentBatisDao {
    List<Student> findAll();

    int deleteById(long id);

    int insert(Student student);

    int update(Student student);

    Student findById(long id);
}
