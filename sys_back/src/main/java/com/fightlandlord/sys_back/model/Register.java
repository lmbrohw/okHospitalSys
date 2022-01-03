package com.fightlandlord.sys_back.model;

import com.fightlandlord.sys_back.util.UUIDGenerator;

import java.util.Date;

public class Register {
    private String registerId;

    private String patientId;

    private String registerChoice;

    private Date registerTime;

    private Integer isSubscribe;

    private String dossierTableId;

    private String checkTableId;

    private String medicineTableId;

    private String withdrawMedicineTableId;

    private Integer registerState;

    public Register() {}

    public Register(String patientId, String registerChoice, Date registerTime, int isSubscribe) {
        this.registerId = UUIDGenerator.makeUUID("rg");
        this.patientId = patientId;
        this.registerChoice = registerChoice;
        this.registerTime = registerTime;
        this.isSubscribe = isSubscribe;
        this.registerState = 0;
    }

    public String getRegisterId() {
        return registerId;
    }

    public void setRegisterId(String registerId) {
        this.registerId = registerId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getRegisterChoice() {
        return registerChoice;
    }

    public void setRegisterChoice(String registerChoice) {
        this.registerChoice = registerChoice;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Integer getIsSubscribe() {
        return isSubscribe;
    }

    public void setIsSubscribe(Integer isSubscribe) {
        this.isSubscribe = isSubscribe;
    }

    public String getDossierTableId() {
        return dossierTableId;
    }

    public void setDossierTableId(String dossierTableId) {
        this.dossierTableId = dossierTableId;
    }

    public String getCheckTableId() {
        return checkTableId;
    }

    public void setCheckTableId(String checkTableId) {
        this.checkTableId = checkTableId;
    }

    public String getMedicineTableId() {
        return medicineTableId;
    }

    public void setMedicineTableId(String medicineTableId) {
        this.medicineTableId = medicineTableId;
    }

    public String getWithdrawMedicineTableId() {
        return withdrawMedicineTableId;
    }

    public void setWithdrawMedicineTableId(String withdrawMedicineTableId) {
        this.withdrawMedicineTableId = withdrawMedicineTableId;
    }

    public Integer getRegisterState() {
        return registerState;
    }

    public void setRegisterState(Integer registerState) {
        this.registerState = registerState;
    }
}