package com.tangyi.learn.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.tangyi.learn.bean.Answer;
import com.tangyi.learn.bean.Question;
import com.tangyi.learn.dao.AnswerDao;
import com.tangyi.learn.dao.ExamDao;
import com.tangyi.learn.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AnswerCon {
    @Autowired
    AnswerDao answerDao;


    @CrossOrigin
    @RequestMapping("/addanswer")
    public String addAnswer(@RequestBody Map<String,String> map){
//        int code=Integer.parseInt(map.get("examCode").toString());
        ;
        String list=map.get("list");
        int examid=Integer.parseInt(map.get("examid"));
        String stunumber=map.get("stunumber");

        List<Integer> lst = JSON.parseObject(list, List.class);
        int length=lst.size();
        String state="1";
        for(int i=0;i<length;i++){
            Answer answer=new Answer(i,lst.get(i),examid,stunumber,state);
            answerDao.addAnswer(answer);
        }
        System.out.println(lst);
        System.out.println(examid);
        System.out.println(stunumber);
//        int state=1;
//        answerDao.updateState(examid,state);
        return "123";

    }
    @RequestMapping("/checkexam")
    public String getAnswer(@RequestBody Map<String,Object> map){
        int examid =Integer.parseInt(map.get("examCode").toString());
        String username =map.get("username").toString();
        List<Question> questions=answerDao.findQuById(examid);
        List<Map<String,Object>> answers=answerDao.findAnswer(examid,username);
        HashMap<String, Object> res = new HashMap<>();
        res.put("question",questions);

        res.put("answer",answers);
        System.out.println(answers);
        for(int i=0;i<answers.size();i++){
            int value=Integer.parseInt(answers.get(i).get("val").toString());
            if(value==1) answers.get(i).put("val","A");
            if(value==2) answers.get(i).put("val","B");
            if(value==3) answers.get(i).put("val","C");
            if(value==4) answers.get(i).put("val","D");

        }
        System.out.println(answers);
        String users_json = JSON.toJSONString(res);
        return users_json;
    }
    @RequestMapping("/selectstudent")
    public String selectStudent(@RequestBody String couseid){
        int examid=Integer.parseInt(couseid);
        List<String>students=answerDao.findStudentByCourse(examid);
        System.out.println(students);
        String stu_json=JSON.toJSONString(students);
        return stu_json;


    }

}
