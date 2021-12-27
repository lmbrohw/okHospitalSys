package com.fightlandlord.sys_back.model;

public class Dispenser {
    private String disperserId;

    private Integer gender;

    private Integer age;

    private String name;

    private String password;

    public String getDisperserId() {
        return disperserId;
    }

    public void setDisperserId(String disperserId) {
        this.disperserId = disperserId;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}