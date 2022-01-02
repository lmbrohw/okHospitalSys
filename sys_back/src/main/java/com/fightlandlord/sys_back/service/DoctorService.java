package com.fightlandlord.sys_back.service;

import com.fightlandlord.sys_back.model.*;

import java.util.List;

public interface DoctorService {
    Doctor queryById(String departmentID);
    Register getAPatient(String doctorId);
    List<CheckList> getCheckList();
    List<MedicineList> getMedicineList();
    int sendDossierTable(DossierTable dossierTable);
    List<DossierTable> getPatientRecord(String patientID);
    Float getCheckItemPriceById(String checkListId);
    int sendCheckTable(CheckTable checkTable);
    Float getMedicinePriceById(String medicineListId);
    int sendMedicineTable(MedicineTable medicineTable);
    int addCheckTableArray(CheckTableArray checkTableArray);
    int addMedicineTableArray(MedicineTableArray medicineTableArray);
}
