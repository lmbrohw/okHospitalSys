package com.fightlandlord.sys_back.model;

public class Dispenser {
    private String dispenserId;

    private Integer gender;

    private Integer age;

    private String name;

    private String password;

    public Dispenser() {}

    public Dispenser(String dispenserId, int gender, int age, String name, String password) {
        this.dispenserId = dispenserId;
        this.gender = gender;
        this.age = age;
        this.name = name;
        this.password = password;
    }

    public String getDispenserId() {
        return dispenserId;
    }

    public void setDispenserId(String dispenserId) {
        this.dispenserId = dispenserId;
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