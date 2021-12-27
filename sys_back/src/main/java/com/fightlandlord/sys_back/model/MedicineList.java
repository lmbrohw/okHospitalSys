package com.fightlandlord.sys_back.model;

public class MedicineList {
    private String medicineListId;

    private String medicineName;

    private Integer medicineNum;

    private Float medicinePrice;

    private String medicineDescription;

    public String getMedicineListId() {
        return medicineListId;
    }

    public void setMedicineListId(String medicineListId) {
        this.medicineListId = medicineListId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public Integer getMedicineNum() {
        return medicineNum;
    }

    public void setMedicineNum(Integer medicineNum) {
        this.medicineNum = medicineNum;
    }

    public Float getMedicinePrice() {
        return medicinePrice;
    }

    public void setMedicinePrice(Float medicinePrice) {
        this.medicinePrice = medicinePrice;
    }

    public String getMedicineDescription() {
        return medicineDescription;
    }

    public void setMedicineDescription(String medicineDescription) {
        this.medicineDescription = medicineDescription;
    }
}