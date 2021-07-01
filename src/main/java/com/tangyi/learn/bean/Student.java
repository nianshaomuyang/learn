package com.tangyi.learn.bean;

public class Student {
    private int id;
    private String username;
    private String password;
    private String myclass;
    private String role;
    private boolean state;

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMyclass() {
        return myclass;
    }

    public void setMyclass(String myclass) {
        this.myclass = myclass;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", myclass='" + myclass + '\'' +
                ", role='" + role + '\'' +
                ", state=" + state +
                '}';
    }
}
