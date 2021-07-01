package com.tangyi.learn.controller;

import com.alibaba.fastjson.JSON;
import com.tangyi.learn.bean.Exam;
import com.tangyi.learn.bean.Question;
import com.tangyi.learn.dao.ExamDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ExamCon {
    @Autowired
    ExamDao examDao;

    @CrossOrigin
    @RequestMapping("/allpaper")
    public String getexam(){
        List<Exam> all=examDao.findAllExam();
        String all_json = JSON.toJSONString(all);
        return all_json;

    }
    @RequestMapping({"/myexam","/test"})

    public String getAllExam(@RequestBody Map<String,Object> map, HttpSession session){
        int size =Integer.parseInt(map.get("size").toString());
        int page =Integer.parseInt(map.get("current").toString());
        if (page>=0 && size >0) {
            page = (page-1)*size;
        }
        HashMap<String, Object> res = new HashMap<>();
        SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd" );

        String str = sdf.format(new Date());
        int numbers=examDao.getCount(str);
        List<Exam> exams=examDao.getExamByMessage(str,page,size);
        res.put("numbers",numbers);
        res.put("data",exams);
        System.out.println("总条数："+numbers);
        String exams_json = JSON.toJSONString(res);
        System.out.println(exams);
        return exams_json;
    }
    @RequestMapping("/getstate")
    public String getState(@RequestBody Map<String,Object> map){
        String username=map.get("username").toString();
        int examid =Integer.parseInt(map.get("examid").toString());
        String state=examDao.getExamState(examid,username);
        System.out.println(state);
        return state;
    }
}
