package com.tangyi.learn.controller;

import com.alibaba.fastjson.JSON;
import com.tangyi.learn.bean.Question;
import com.tangyi.learn.bean.Student;
import com.tangyi.learn.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class QuestionCon {
    @Autowired
    QuestionDao questionDao;

    @CrossOrigin
    @RequestMapping("/exam")
    public String getAllQuestion(@RequestBody Map<String,Object> map){
        int code=Integer.parseInt(map.get("examCode").toString());
        System.out.println(code);
        List<Question> questions=questionDao.findQuestionById(code);
        System.out.println(questions);
        String questions_json = JSON.toJSONString(questions);
        return questions_json;
    }
    @RequestMapping("/allquestions")
    public String getQustions(){
        List<Question> all=questionDao.findAllQuestion();
        String all_json = JSON.toJSONString(all);
        return all_json;

    }
    @RequestMapping("/addQuestion")
    public String addUser(@RequestBody Question question){


        System.out.println(question);
        int i = questionDao.addQuestion(question);
        String str = i >0?"success":"error";
        return str;
    }
    @RequestMapping("/deleteQuestion")
    public String deleteUser(int id){
        System.out.println(id);
        int i = questionDao.deleteQuestion(id);
        String str = i >0?"success":"error";
        return str;
    }
}
