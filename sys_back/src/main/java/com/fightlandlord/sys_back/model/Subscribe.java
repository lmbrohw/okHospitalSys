package com.fightlandlord.sys_back.model;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Subscribe {
    private String subscribeId;

    private String patientId;

    private String subscribeChoice;

    private Date subscribeTime;

    private Integer subscribeState;

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