package com.tangyi.learn.dao;

import com.tangyi.learn.bean.Question;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao {
    public List<Question> findQuestionById(@Param("id")int id);
    public List<Question> findAllQuestion();
    public int addQuestion(Question question);
    public int deleteQuestion(int id);
}
