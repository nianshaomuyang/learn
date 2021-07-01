package com.tangyi.learn.bean;

public class Answer {
    private  int id;
    private  int index;
    private  int val;
    private String state;
    private  int examid;
    private  String studentid;
    private  String grade;



    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", index=" + index +
                ", val=" + val +
                ", state='" + state + '\'' +
                ", examid=" + examid +
                ", studentid='" + studentid + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }



    public Answer(int index, int val, int examid, String studentid,String state) {
        this.index = index;
        this.val = val;
        this.examid = examid;
        this.studentid = studentid;
        this.state=state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public int getExamid() {
        return examid;
    }

    public void setExamid(int examid) {
        this.examid = examid;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }
}
