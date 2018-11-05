package br.com.springboot.mybatis.springboot2mybatis.controller;

public interface IBatisStudentController {
    String findAll();

    String findById(long id);

    void deleteById(long id);

    void insert();

    void update();
}
