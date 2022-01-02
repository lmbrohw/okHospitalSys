package com.fightlandlord.sys_back.model;

import com.fightlandlord.sys_back.util.UUIDGenerator;

import java.util.Date;

public class Subscribe {
    private String subscribeId;

    private String patientId;

    private String subscribeChoice;

    private Date subscribeTime;

    private Integer subscribeState;


    public  Subscribe() {}

    public Subscribe(String patientId, String subscribeChoice, Date subscribeTime) {
        this.subscribeId = UUIDGenerator.makeUUID("sb");
        this.patientId = patientId;
        this.subscribeChoice = subscribeChoice;
        this.subscribeTime = subscribeTime;
        this.subscribeState = 0;
    }

    public String getSubscribeId() {
        return subscribeId;
    }

    public void setSubscribeId(String subscribeId) {
        this.subscribeId = subscribeId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getSubscribeChoice() {
        return subscribeChoice;
    }

    public void setSubscribeChoice(String subscribeChoice) {
        this.subscribeChoice = subscribeChoice;
    }

    public Date getSubscribeTime() {
        return subscribeTime;
    }

    public void setSubscribeTime(Date subscribeTime) {
        this.subscribeTime = subscribeTime;
    }

    public Integer getSubscribeState() {
        return subscribeState;
    }

    public void setSubscribeState(Integer subscribeState) {
        this.subscribeState = subscribeState;
    }
}