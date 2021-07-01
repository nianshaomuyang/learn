package com.tangyi.learn.dao;

import com.tangyi.learn.bean.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {
    public Student getUserByMessage(@Param("username")String username,@Param("password")String password);
    public Student getUserByName(@Param("id")int id);
    public Student getId(@Param("username")String username);
    public List<Student> getAllUser(@Param("username") String username, @Param("pageStart") int pageStart, @Param("pageSize") int pageSize);
    public int getUserCounts(@Param("username") String username);
    public int addUser(Student student);
    public int deleteUser(int id);
}
