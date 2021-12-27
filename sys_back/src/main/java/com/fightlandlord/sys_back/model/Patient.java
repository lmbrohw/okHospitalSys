package com.fightlandlord.sys_back.model;

public class Patient {
    private String patientId;

    private Integer gender;

    private Integer age;

    private Integer subscribeCancelNumsInOneMonth;

    private String name;

    private String password;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
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

    public Integer getSubscribeCancelNumsInOneMonth() {
        return subscribeCancelNumsInOneMonth;
    }

    public void setSubscribeCancelNumsInOneMonth(Integer subscribeCancelNumsInOneMonth) {
        this.subscribeCancelNumsInOneMonth = subscribeCancelNumsInOneMonth;
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