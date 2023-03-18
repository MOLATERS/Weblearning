package com.lab2.lab2.Entity;

import java.util.Date;

public class Student {
    private String sid;
    private String sname;
    private String gender;
    private int age;
    private Date birthday;
    private String mid;

    public Student() {
    }

    public Student(String sid, String sname, String gender, int age, Date birthday, String mid) {
        this.sid = sid;
        this.sname = sname;
        this.gender = gender;
        this.age = age;
        this.birthday = birthday;
        this.mid = mid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }
}
