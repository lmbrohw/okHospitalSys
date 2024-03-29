package com.fightlandlord.sys_back.model;

import com.fightlandlord.sys_back.util.UUIDGenerator;

public class WithdrawMedicineTable {
    private String withdrawMedicineTableId;

    private String medicineTableId;

    private String patientId;

    private String doctorId;

    private String dispenserId;

    private Float totalPrice;

    public String getWithdrawMedicineTableId() {
        return withdrawMedicineTableId;
    }

    public void setWithdrawMedicineTableId(String withdrawMedicineTableId) {
        this.withdrawMedicineTableId = withdrawMedicineTableId;
    }

    public WithdrawMedicineTable(){}

    public WithdrawMedicineTable(String medicineTableId, String patientId, String doctorId, String dispenserId, float totalPrice) {
        this.withdrawMedicineTableId = UUIDGenerator.makeUUID("wm");
        this.medicineTableId = medicineTableId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.dispenserId = dispenserId;
        this.totalPrice = totalPrice;
    }

    public String getMedicineTableId() {
        return medicineTableId;
    }

    public void setMedicineTableId(String medicineTableId) {
        this.medicineTableId = medicineTableId;
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

    public String getDispenserId() {
        return dispenserId;
    }

    public void setDispenserId(String dispenserId) {
        this.dispenserId = dispenserId;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }
}