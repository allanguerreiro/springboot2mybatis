package br.com.springboot.mybatis.springboot2mybatis.repository;

import br.com.springboot.mybatis.springboot2mybatis.bean.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentBatisRepository {

    @Select("select * from student")
    List<Student> findAll();

    @Select("SELECT * FROM student WHERE id = #{id}")
    Student findById(long id);

    @Delete("DELETE FROM student WHERE id = #{id}")
    int deleteById(long id);

    @Insert("INSERT INTO student(id, name, passport) VALUES (#{id}, #{name}, #{passport})")
    int insert(Student student);

    @Update("Update student set name=#{name}, passport=#{passport} where id=#{id}")
    int update(Student student);
}
