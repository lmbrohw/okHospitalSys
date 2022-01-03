package com.fightlandlord.sys_back.model;

import com.fightlandlord.sys_back.util.UUIDGenerator;

import java.security.PublicKey;

public class WithdrawMedicineTableArray {
    private String withdrawMedicineTableArrayId;

    private String withdrawMedicineTableId;

    private String withdrawMedicineListId;

    private Integer withdrawMedicineNum;

    public String getWithdrawMedicineTableArrayId() {
        return withdrawMedicineTableArrayId;
    }


    public WithdrawMedicineTableArray() {}

    public WithdrawMedicineTableArray(String withdrawMedicineTableId, String withdrawMedicineListId, int withdrawMedicineNum) {
        this.withdrawMedicineTableArrayId = UUIDGenerator.makeUUID("wma");
        this.withdrawMedicineTableId = withdrawMedicineTableId;
        this.withdrawMedicineListId = withdrawMedicineListId;
        this.withdrawMedicineNum = withdrawMedicineNum;
    }

    public void setWithdrawMedicineTableArrayId(String withdrawMedicineTableArrayId) {
        this.withdrawMedicineTableArrayId = withdrawMedicineTableArrayId;
    }

    public String getWithdrawMedicineTableId() {
        return withdrawMedicineTableId;
    }

    public void setWithdrawMedicineTableId(String withdrawMedicineTableId) {
        this.withdrawMedicineTableId = withdrawMedicineTableId;
    }

    public String getWithdrawMedicineListId() {
        return withdrawMedicineListId;
    }

    public void setWithdrawMedicineListId(String withdrawMedicineListId) {
        this.withdrawMedicineListId = withdrawMedicineListId;
    }

    public Integer getWithdrawMedicineNum() {
        return withdrawMedicineNum;
    }

    public void setWithdrawMedicineNum(Integer withdrawMedicineNum) {
        this.withdrawMedicineNum = withdrawMedicineNum;
    }
}