package com.tangyi.learn.bean;

public class Exam {
    private int id;
    private String testname;
    private int time;
    private String myclass;
    private int score;
    private String date;
    private  int state;

    public int getState() {
        return state;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", testname='" + testname + '\'' +
                ", time=" + time +
                ", myclass='" + myclass + '\'' +
                ", score=" + score +
                ", date='" + date + '\'' +
                ", state=" + state +
                '}';
    }

    public void setState(int state) {
        this.state = state;
    }

    public Exam() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTestname() {
        return testname;
    }

    public void setTestname(String testname) {
        this.testname = testname;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getMyclass() {
        return myclass;
    }

    public void setMyclass(String myclass) {
        this.myclass = myclass;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
