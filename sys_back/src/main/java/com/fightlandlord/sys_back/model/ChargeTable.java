package com.fightlandlord.sys_back.model;

import java.util.Date;

public class ChargeTable {
    private String chargeTableId;

    private String patientId;

    private String chargerId;

    private Date chargeCreateTime;

    private Integer chargeState;

    private float chargePrice;

    public ChargeTable() {}

    public ChargeTable(String chargeItemId, String patientId, String chargerId, Date chargeCreateTime, float chargePrice) {
        this.chargeTableId = chargeItemId;
        this.patientId = patientId;
        this.chargerId = chargerId;
        this.chargeCreateTime = chargeCreateTime;
        this.chargePrice = chargePrice;
        this.chargeState = 0;
    }

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

    public float getChargePrice() {
        return chargePrice;
    }

    public void setChargePrice(float chargePrice) {
        this.chargePrice = chargePrice;
    }
}