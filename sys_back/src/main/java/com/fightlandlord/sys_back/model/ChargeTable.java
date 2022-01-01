package com.fightlandlord.sys_back.model;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ChargeTable {
    private String chargeTableId;

    private String patientId;

    private String chargerId;

    private String chargeItemId;

    private Date chargeCreateTime;

    private Integer chargeState;

    private Integer chargePrice;

    public String getChargeTableId() {
        return chargeTableId;
    }

    public void setChargeTableId(String chargeTableId) {
        this.chargeTableId = chargeTableId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getChargerId() {
        return chargerId;
    }

    public void setChargerId(String chargerId) {
        this.chargerId = chargerId;
    }

    public String getChargeItemId() {
        return chargeItemId;
    }

    public void setChargeItemId(String chargeItemId) {
        this.chargeItemId = chargeItemId;
    }

    public Date getChargeCreateTime() {
        return chargeCreateTime;
    }

    public void setChargeCreateTime(Date chargeCreateTime) {
        this.chargeCreateTime = chargeCreateTime;
    }

    public Integer getChargeState() {
        return chargeState;
    }

    public void setChargeState(Integer chargeState) {
        this.chargeState = chargeState;
    }

    public Integer getChargePrice() {
        return chargePrice;
    }

    public void setChargePrice(Integer chargePrice) {
        this.chargePrice = chargePrice;
    }
}