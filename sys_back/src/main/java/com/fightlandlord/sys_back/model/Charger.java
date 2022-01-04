package com.fightlandlord.sys_back.model;

public class Charger {
    private String chargerId;

    private Integer gender;

    private Integer age;

    private String name;

    private String password;

    public Charger() {}

    public Charger(String chargerId, int gender, int age, String name, String password) {
        this.chargerId = chargerId;
        this.gender = gender;
        this.age = age;
        this.name = name;
        this.password = password;
    }

    public String getChargerId() {
        return chargerId;
    }

    public void setChargerId(String chargerId) {
        this.chargerId = chargerId;
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