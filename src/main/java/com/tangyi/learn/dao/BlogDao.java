package com.tangyi.learn.dao;

import com.tangyi.learn.bean.Blog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogDao {
    public List<Blog> findAllBlog();
    public Blog findContentById(int id);
    public void addBlog(Blog blog);
}
