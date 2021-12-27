package com.fightlandlord.sys_back.model;

public class CheckTable {
    private String checkTableId;

    private String patientId;

    private String doctorId;

    private Float totalPrice;

    private Integer checkTableState;

    public String getCheckTableId() {
        return checkTableId;
    }

    public void setCheckTableId(String checkTableId) {
        this.checkTableId = checkTableId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getCheckTableState() {
        return checkTableState;
    }

    public void setCheckTableState(Integer checkTableState) {
        this.checkTableState = checkTableState;
    }
}