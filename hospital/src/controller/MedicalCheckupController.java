/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Dao.MedicalCheckupDao;

/**
 *
 * @author Admin
 */
public class MedicalCheckupController {
    private MedicalCheckupDao medicalDao;
    public MedicalCheckupController() {
        medicalDao = new MedicalCheckupDao();
    }
    public void createMcu(String date, String note, String result, int doctor_id, int patient_id, int appoimentId) {
        this.medicalDao.createMcu(date, note, result, doctor_id, patient_id, appoimentId);
    }

     public void deleteMcu(int doctorId, int patient_id, int appoimentId) {
        this.medicalDao.deleteMcu(doctorId, patient_id, appoimentId);
    }

    public void updateMcu(String date, String note, String result, int doctorId, int patient_id, int appoimentId) {
        this.medicalDao.updateMcu(date, note, result, doctorId, patient_id, appoimentId);
    }
    
    public boolean isExist(int patientId, int AppoimentId){
       return this.medicalDao.isExist(patientId, AppoimentId);
    }
}
