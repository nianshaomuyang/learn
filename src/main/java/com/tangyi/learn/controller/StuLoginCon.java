package com.tangyi.learn.controller;

import com.alibaba.fastjson.JSON;
import com.tangyi.learn.bean.QueryInfo;
import com.tangyi.learn.bean.Student;
import com.tangyi.learn.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@RestController
public class StuLoginCon {

    private StudentDao studentDao;

    @Autowired
    public void setUserDao (StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @CrossOrigin
    @RequestMapping("/login")
    public String Login(@RequestBody Student user,HttpSession session){
        System.out.println("user"+user);
        String flag="error";
        Student us=studentDao.getUserByMessage(user.getUsername(),user.getPassword());
        System.out.println("user"+us);
        HashMap<String,Object> hmap=new HashMap<>();
        if(us!=null) {

            session.setAttribute("myclass",us.getMyclass());
            session.setMaxInactiveInterval(60*60);//设置session过期时间 为60分钟
            if(us.getRole().equals("root")){
                flag="ok";
            }else if(us.getRole().equals("teacher")){
                flag="teacherok";
            }else if(us.getRole().equals("student")){
                flag="studentok";
            }
        }
        System.out.println("flag"+flag);
        hmap.put("flag",flag);
        hmap.put("user",user);
        String res= JSON.toJSONString(hmap);

        return res;
    }

    @RequestMapping("/allUser")
    public String getUserList(QueryInfo queryInfo){
        System.out.println(queryInfo);
        int numbers = studentDao.getUserCounts("%"+queryInfo.getQuery()+"%");// 获取数据总数
        int pageStart = (queryInfo.getPageNum()-1)*queryInfo.getPageSize();
        List<Student> users = studentDao.getAllUser("%"+queryInfo.getQuery()+"%",pageStart,queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("data",users);
        System.out.println("总条数："+numbers);
        String users_json = JSON.toJSONString(res);
        return users_json;
    }

    @RequestMapping("/addUser")
    public String addUser(@RequestBody Student user){

        user.setState(true);
        System.out.println(user);
        int i = studentDao.addUser(user);
        String str = i >0?"success":"error";
        return str;
    }
    @RequestMapping("/deleteUser")
    public String deleteUser(int id){
        System.out.println(id);
        int i = studentDao.deleteUser(id);
        String str = i >0?"success":"error";
        return str;
    }
    @RequestMapping("/getid")
    public String getId(@RequestBody String username){
        System.out.println(username);
        Student i = studentDao.getId(username);

        return JSON.toJSONString(i.getId());
    }

}
