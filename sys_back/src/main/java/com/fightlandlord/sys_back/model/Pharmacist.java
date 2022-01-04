package com.fightlandlord.sys_back.model;

public class Pharmacist {
    private String pharmacistId;

    private Integer gender;

    private Integer age;

    private String name;

    private String password;

    public Pharmacist() {}

    public Pharmacist(String pharmacistId, int gender, int age, String name, String password) {
        this.pharmacistId = pharmacistId;
        this.gender = gender;
        this.age = age;
        this.name = name;
        this.password = password;
    }

    public String getPharmacistId() {
        return pharmacistId;
    }

    public void setPharmacistId(String pharmacistId) {
        this.pharmacistId = pharmacistId;
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