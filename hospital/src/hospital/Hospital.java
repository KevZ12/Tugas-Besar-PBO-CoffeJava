/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hospital;
import controller.DoctorController;
import controller.PatientController;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;





/**
 *
 * @author kevin
 */
public class Hospital {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NoSuchAlgorithmException {
        PatientController patientController = new PatientController();
        DoctorController doctorController = new DoctorController();
        
        //LoginPatientView loginPatientView = new LoginPatientView(patientController);
        //loginPatientView.setVisible(true);
        
        //LoginDoctorView loginDoctorView =  new LoginDoctorView();
        //loginDoctorView.setVisible(true);
        //String password = "y8YKzJJBkmmm4H3ctRkwGRnIxgI4znjVAe/C6y/7MaW+WwXu9IFhtn40LvHQmiZqp2/Hnm7cvturmxtfS/7reA==";
        //String salt = "IqBt6cBEpPV0WMG3BI5nvg==";
        //String hashPassword = PasswordUtil.hashPassword(password, salt);
        
        //System.out.println(salt);
        //System.out.println(hashPassword);
        
        //System.out.println(PasswordUtil.comparePassword(password, hashPassword, salt));
    }
}
