package com.tangyi.learn.bean;

import java.util.Date;

public class Blog {
    private int id;
    private int user_id;
    private  String title;
    private  String img;
    private  String introduction;
    private  String content;
    private Date create_time;

    public Blog() {
    }

    public Blog(int user_id, String title, String img, String introduction, String content, Date create_time) {
        this.user_id = user_id;
        this.title = title;
        this.img = img;
        this.introduction = introduction;
        this.content = content;
        this.create_time = create_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUssr_id() {
        return user_id;
    }

    public void setUssr_id(int ussr_id) {
        this.user_id = ussr_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "blog{" +
                "id=" + id +
                ", ussr_id=" + user_id +
                ", title='" + title + '\'' +
                ", img='" + img + '\'' +
                ", introduction='" + introduction + '\'' +
                ", content='" + content + '\'' +
                ", create_time=" + create_time +
                '}';
    }
}
