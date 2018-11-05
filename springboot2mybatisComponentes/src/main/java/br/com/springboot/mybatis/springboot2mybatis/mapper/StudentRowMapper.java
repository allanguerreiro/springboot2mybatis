package br.com.springboot.mybatis.springboot2mybatis.mapper;

import br.com.springboot.mybatis.springboot2mybatis.bean.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setId(rs.getLong("id"));
        student.setName(rs.getString("name"));
        student.setPassport(rs.getString("passport"));
        return student;
    }
}
