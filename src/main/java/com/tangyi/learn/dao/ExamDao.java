package com.tangyi.learn.dao;

import com.tangyi.learn.bean.Exam;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamDao {
    public List<Exam> getExamByMessage(@Param("date")String date, @Param("page")int page, @Param("size")int size);
    public List<Exam> findAllExam();

    public int  getCount(@Param("date")String date);
//    public void updateState(@Param("id") int id,@Param("state")int state);
    public  String getExamState(@Param("examid") int examid,@Param("studentid") String studentid);
}
