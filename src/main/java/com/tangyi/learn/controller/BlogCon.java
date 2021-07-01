package com.tangyi.learn.controller;

import com.alibaba.fastjson.JSON;
import com.tangyi.learn.bean.Blog;
import com.tangyi.learn.dao.BlogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class BlogCon {
    @Autowired
    BlogDao blogDao;

    @CrossOrigin
    @RequestMapping("/blog/list")
    public String getAllBlog(){
        List<Blog> allBlog=blogDao.findAllBlog();
        String blog_json= JSON.toJSONString(allBlog);
        System.out.println(blog_json);
        return blog_json;
    }
    @RequestMapping("/blog/detail")
    public String getContent(@RequestBody String id){
        Blog blogContent;
        System.out.println(id);
        int blogId=Integer.parseInt(id);
        blogContent=blogDao.findContentById(blogId);
        System.out.println(blogContent);
        String blog_content=JSON.toJSONString(blogContent);
        return blog_content;
    }
    @RequestMapping("/blog/add")
    public String addBlog(@RequestBody Map<String,String> map){
        String title= map.get("title").toString();
        String introduction=map.get("introduction").toString();
        String content=map.get("content").toString();
        System.out.println(title);
        System.out.println(introduction);
        System.out.println(content);
        Date date = new Date();
        int user_id=1827405135;
        String img="https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2548892998,499717296&fm=26&gp=0.jpg";
        Blog blog=new Blog(user_id,title,img,introduction,content,date);
        System.out.println(blog);
        blogDao.addBlog(blog);

        return "ok";
    }


}
