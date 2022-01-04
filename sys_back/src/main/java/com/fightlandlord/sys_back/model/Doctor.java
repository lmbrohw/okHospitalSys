package com.fightlandlord.sys_back.model;

public class Doctor {
    private String doctorId;

    private String departmentId;

    private Integer gender;

    private Integer age;

    private Integer isExpert;

    private String name;

    private String password;

    public Doctor() {}

    public Doctor(String doctorId, int gender, int age, String name, String password) {
        this.doctorId = doctorId;
        this.gender = gender;
        this.age = age;
        this.name = name;
        this.password = password;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
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

    public Integer getIsExpert() {
        return isExpert;
    }

    public void setIsExpert(Integer isExpert) {
        this.isExpert = isExpert;
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