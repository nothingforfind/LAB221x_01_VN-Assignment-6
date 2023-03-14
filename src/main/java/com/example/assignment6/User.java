package com.example.assignment6;

public class User {

    private int id;
    private String userId;
    private String password;
    private String question1;
    private String answer1;
    private String question2;
    private String answer2;
    private int time;

    public User() {}

    public User(int id, String userId, String password, String question1, String answer1, String question2, String answer2, int time) {
        this.id = id;
        this.userId = userId;
        this.password = password;
        this.question1 = question1;
        this.answer1 = answer1;
        this.question2 = question2;
        this.answer2 = answer2;
        this.time = time;
    }

    public User(String userId, String password, String question1, String answer1, String question2, String answer2, boolean locked, int time) {
        this.userId = userId;
        this.password = password;
        this.question1 = question1;
        this.answer1 = answer1;
        this.question2 = question2;
        this.answer2 = answer2;
        this.time = time;
    }

    public User(String userId, String password, String question1, String answer1, String question2, String answer2) {
        this.userId = userId;
        this.password = password;
        this.question1 = question1;
        this.answer1 = answer1;
        this.question2 = question2;
        this.answer2 = answer2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getQuestion1() {
        return question1;
    }

    public void setQuestion1(String question1) {
        this.question1 = question1;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getQuestion2() {
        return question2;
    }

    public void setQuestion2(String question2) {
        this.question2 = question2;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
