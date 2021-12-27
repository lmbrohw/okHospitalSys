package com.fightlandlord.sys_back.model;

public class DossierTable {
    private String dossierTableId;

    private String patientId;

    private String doctorId;

    private String description;

    public String getDossierTableId() {
        return dossierTableId;
    }

    public void setDossierTableId(String dossierTableId) {
        this.dossierTableId = dossierTableId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}