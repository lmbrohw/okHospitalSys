package com.fightlandlord.sys_back.model;

public class MedicineTable {
    private String medicineTableId;

    private String patientId;

    private String doctorId;

    private String pharmacistId;

    private String dispenserId;

    private Float totalPrice;

    private Integer medicineTableState;

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

    public String getPharmacistId() {
        return pharmacistId;
    }

    public void setPharmacistId(String pharmacistId) {
        this.pharmacistId = pharmacistId;
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

    public Integer getMedicineTableState() {
        return medicineTableState;
    }

    public void setMedicineTableState(Integer medicineTableState) {
        this.medicineTableState = medicineTableState;
    }
}