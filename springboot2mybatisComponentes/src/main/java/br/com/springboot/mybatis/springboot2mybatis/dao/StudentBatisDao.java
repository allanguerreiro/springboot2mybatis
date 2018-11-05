package br.com.springboot.mybatis.springboot2mybatis.dao;

import br.com.springboot.mybatis.springboot2mybatis.bean.Student;
import br.com.springboot.mybatis.springboot2mybatis.mapper.StudentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("studentBatisDao")
public class StudentBatisDao implements IStudentBatisDao {

    @Autowired
    JdbcTemplate jdbcTemplateH2;

    @Override
    public List<Student> findAll() {
        return jdbcTemplateH2.query("select * from student", new StudentRowMapper());
    }

    @Override
    public int deleteById(long id) {
        return jdbcTemplateH2.update("delete from student where id=?", new Object[]{id});
    }

    @Override
    public int insert(Student student) {
        return jdbcTemplateH2.update("insert into student (id, name, passport) " + "values(?,  ?, ?)",
                new Object[]{student.getId(), student.getName(), student.getPassport()});
    }

    @Override
    public int update(Student student) {
        return jdbcTemplateH2.update("update student " + " set name = ?, passport_number = ? " + " where id = ?",
                new Object[]{student.getName(), student.getPassport(), student.getId()});
    }

    @Override
    public Student findById(long id) {
        return jdbcTemplateH2.queryForObject("select * from student where id=?", new Object[]{id}, new BeanPropertyRowMapper<Student>(Student.class));
    }
}
