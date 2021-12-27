package com.fightlandlord.sys_back.model;

public class CheckList {
    private String checkListId;

    private String checkName;

    private Float checkPrice;

    private String checkDescription;

    public String getCheckListId() {
        return checkListId;
    }

    public void setCheckListId(String checkListId) {
        this.checkListId = checkListId;
    }

    public String getCheckName() {
        return checkName;
    }

    public void setCheckName(String checkName) {
        this.checkName = checkName;
    }

    public Float getCheckPrice() {
        return checkPrice;
    }

    public void setCheckPrice(Float checkPrice) {
        this.checkPrice = checkPrice;
    }

    public String getCheckDescription() {
        return checkDescription;
    }

    public void setCheckDescription(String checkDescription) {
        this.checkDescription = checkDescription;
    }
}