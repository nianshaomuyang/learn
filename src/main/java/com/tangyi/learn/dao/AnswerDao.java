package com.tangyi.learn.dao;

import com.tangyi.learn.bean.Answer;
import com.tangyi.learn.bean.Question;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface AnswerDao {
    public void addAnswer(Answer answer);
    public List<Question> findQuById(@Param("id")int id);
    public List<Map<String,Object>> findAnswer(@Param("examid")int examid, @Param("studentid")String studentid);
    public List<String> findStudentByCourse(int examid);

}
