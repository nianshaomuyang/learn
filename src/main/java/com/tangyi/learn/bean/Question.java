package com.tangyi.learn.bean;

public class Question {
    private int id;
    private String subject;
    private String problem;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String rightAnswer;
    private String analysis;
    private int score;
    private String points;
    private  String level;
    private  int examCode;

    public Question() {
    }

//    public Question(String subject, String problem, String answerA, String answerB, String answerC, String answerD,
//                    String rightAnswer, String analysis, int score, String points, String level) {
//        this.subject = subject;
//        this.problem = problem;
//        this.answerA = answerA;
//        this.answerB = answerB;
//        this.answerC = answerC;
//        this.answerD = answerD;
//        this.rightAnswer = rightAnswer;
//        this.analysis = analysis;
//        this.score = score;
//        this.points = points;
//        this.level = level;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getExamCode() {
        return examCode;
    }

    public void setExamCode(int examCode) {
        this.examCode = examCode;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", problem='" + problem + '\'' +
                ", answerA='" + answerA + '\'' +
                ", answerB='" + answerB + '\'' +
                ", answerC='" + answerC + '\'' +
                ", answerD='" + answerD + '\'' +
                ", rightAnswer='" + rightAnswer + '\'' +
                ", analysis='" + analysis + '\'' +
                ", score=" + score +
                ", points='" + points + '\'' +
                ", level='" + level + '\'' +
                ", examCode=" + examCode +
                '}';
    }
}
