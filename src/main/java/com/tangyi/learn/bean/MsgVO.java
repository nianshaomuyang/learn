package com.tangyi.learn.bean;

public class MsgVO {
    public int id;

    private int userid;

    private String username;

    private String avatar;

    private String msg;

    private int count;

    public MsgVO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "MsgVO{" +
                "id=" + id +
                ", userid=" + userid +
                ", username='" + username + '\'' +
                ", avatar='" + avatar + '\'' +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                '}';
    }
}
