/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;
import java.sql.*;
import database.DataBaseConnection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.*;
/**
 *
 * @author Admin
 */
public class MedicalCheckupDao {
     public void createMcu(String date, String note, String result, int doctor_id, int patient_id, int appoimentId) {
        String query = "INSERT INTO medicalcheckups (date, NoteMedicalChekup, Result, DoctorId, PatientId, AppoimentId) VALUES (?, ?, ?, ?, ?,?)";
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, date);
            statement.setString(2, note);
            statement.setString(3, result);
            statement.setInt(4, doctor_id);
            statement.setInt(5, patient_id);
            statement.setInt(6, appoimentId);

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
     public List<MedicalCheckUp> readMcu(int id) {
         List<MedicalCheckUp> list = new ArrayList<>();
        String query = "SELECT * FROM medicalcheckups WHERE PatientId = ?";
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);            
            ResultSet rs = statement.executeQuery();
            System.out.println(rs);
            while(rs.next()) {
                int medic_id = rs.getInt("MedicalChekUpId");
                LocalDate date = rs.getDate("date").toLocalDate();
                String note = rs.getString("NoteMedicalChekup");
                MedicalCheckUp medical = new MedicalCheckUp(medic_id, date, note, null);
                list.add(medical);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
     }
     
         public void deleteMcu(int doctorId, int patient_id, int appoimentId) {
        String query = "DELETE FROM medicalcheckups WHERE DoctorId = ? AND PatientId = ? AND AppoimentId = ?";
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, doctorId);
            statement.setInt(2, patient_id);
            statement.setInt(3, appoimentId);

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateMcu(String date, String note, String result, int doctorId, int patient_id, int appoimentId) {
        String query = "UPDATE medicalcheckups SET date = ?, NoteMedicalChekup = ?, Result = ? WHERE DoctorId = ? AND PatientId = ? AND AppoimentId = ?";
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, date);
            statement.setString(2, note);
            statement.setString(3, result);
            statement.setInt(4, doctorId);
            statement.setInt(5, patient_id);
            statement.setInt(6, appoimentId);

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
     public boolean isExist(int patientId, int AppoimentId) {
        
        String query = "SELECT * FROM medicalcheckups WHERE PatientId = ? AND AppoimentId = ?";
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, patientId);
            statement.setInt(2, AppoimentId);
            ResultSet rs = statement.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    
     }
}
