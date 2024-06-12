/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import controller.AppointmentController;
import controller.AdminController;
import DashBoard.AdminDashBoard;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.util.stream.Collectors;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.event.ListSelectionEvent;
import model.Admin;
import model.Appointment;
import model.Doctor;
import model.Room;

/**
 *
 * @author adibf
 */
public class AppointmentFrame extends javax.swing.JFrame {

    Admin admin;
    AdminController adminController;
    AppointmentController control;
    List<Appointment> listAppointments;
    List<Doctor> doctors;
    List<Room> rooms;
    ListSelectionEvent event;
    
    /**
     * Creates new form AppointmentFrame
     */
    public AppointmentFrame(Admin admin) {
        initComponents();
        
        this.event = null;
        this.control = new AppointmentController(this);
        this.adminController = new AdminController();
        
        SpinnerDate.setModel(new javax.swing.SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(SpinnerDate, "yyyy-MM-dd");
        SpinnerDate.setEditor(dateEditor);
        
        DefaultTableModel TableAppointmentModel = (DefaultTableModel) TableSchedule.getModel();
        DefaultTableModel TableDoctorModel = (DefaultTableModel) TableDoctor.getModel();
        DefaultTableModel TableRoomModel = (DefaultTableModel) TableRoom.getModel();
        
        try {
            listAppointments = this.control.getAllAppointment();
            loadTableAppointment(listAppointments);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        try {
            doctors = this.adminController.getAllDoctors();
            loadTableDoctor(doctors);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        try {
            rooms = this.control.getAllRooms();
            loadTableRoom(rooms);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableSchedule = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        TextFieldDoctorId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        SpinnerDate = new javax.swing.JSpinner();
        labelStart = new javax.swing.JLabel();
        TextFieldStart = new javax.swing.JTextField();
        TextFieldEnd = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        SpinnerCapacity = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        TextFieldRoomId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableDoctor = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableRoom = new javax.swing.JTable();
        ButtonAdd = new javax.swing.JButton();
        ButtonRemove = new javax.swing.JButton();
        ButtonClear = new javax.swing.JButton();
        ButtonBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Appointment Management");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addContainerGap())
        );

        TableSchedule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Appointment ID", "Doctor's ID", "Date", "Start", "End", "Room", "Capacity", "Status"
            }
        ));
        jScrollPane1.setViewportView(TableSchedule);

        jLabel6.setText("Enter Doctor's ID");

        jLabel5.setText("Date");

        labelStart.setText("Enter start working hour");

        jLabel2.setText("Enter end working hour");

        jLabel4.setText("Capacity");

        jLabel3.setText("Enter the room's ID");

        TableDoctor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Doctor's ID", "Doctor's Name"
            }
        ));
        jScrollPane2.setViewportView(TableDoctor);

        TableRoom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Room Id", "Name", "Location"
            }
        ));
        jScrollPane3.setViewportView(TableRoom);

        ButtonAdd.setBackground(new java.awt.Color(139, 207, 255));
        ButtonAdd.setText("    Add    ");
        ButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAddActionPerformed(evt);
            }
        });

        ButtonRemove.setBackground(new java.awt.Color(139, 207, 255));
        ButtonRemove.setText("  Remove  ");
        ButtonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRemoveActionPerformed(evt);
            }
        });

        ButtonClear.setBackground(new java.awt.Color(139, 207, 255));
        ButtonClear.setText("     Clear    ");
        ButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonClearActionPerformed(evt);
            }
        });

        ButtonBack.setBackground(new java.awt.Color(139, 207, 255));
        ButtonBack.setText("Back");
        ButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(labelStart, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TextFieldStart, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SpinnerDate)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TextFieldDoctorId, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TextFieldEnd)
                            .addComponent(TextFieldRoomId)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SpinnerCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ButtonAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                            .addComponent(ButtonRemove, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ButtonBack, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ButtonClear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextFieldRoomId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextFieldDoctorId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SpinnerCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SpinnerDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelStart)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextFieldStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextFieldEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ButtonAdd)
                        .addGap(30, 30, 30)
                        .addComponent(ButtonRemove)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ButtonClear)
                        .addGap(35, 35, 35)
                        .addComponent(ButtonBack))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1134, 582));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAddActionPerformed
        if(!TextFieldStart.getText().isEmpty() &&
                !TextFieldEnd.getText().isEmpty() &&
                !TextFieldDoctorId.getText().isEmpty() &&
                !TextFieldRoomId.getText().isEmpty() &&
                (int)SpinnerCapacity.getValue() != 0){
            
            try{
            LocalTime start = LocalTime.parse(TextFieldStart.getText().trim());
            LocalTime end = LocalTime.parse(TextFieldEnd.getText().trim());
            int status = 0; 
            int isDone = 0;
            int capacity = (int) SpinnerCapacity.getValue();
            int room = Integer.parseInt(TextFieldRoomId.getText().trim());
            int docId = Integer.parseInt(TextFieldDoctorId.getText().trim());
            LocalDate date = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(SpinnerDate.getValue()));
             
            if (capacity <= 0) {
                throw new NumberFormatException("Capacity must be greater than zero.");
            }
            
            try {
                control.add(start, end, status, isDone, capacity, room, docId, date);
                listAppointments = control.getAllAppointment(); 
                loadTableAppointment(listAppointments);
            } catch (SQLException ex) {
                Logger.getLogger(AppointmentFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            } catch (DateTimeParseException dtpe) {
            JOptionPane.showMessageDialog(null, "Please enter a valid time format (HH:mm:ss).");
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Please enter valid numbers for Doctor ID, Room ID, and Capacity.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        } else {
            JOptionPane.showMessageDialog(null, "Please input data completely and correct");
        }
        loadTableAppointment(listAppointments);
        clearinput();
    }//GEN-LAST:event_ButtonAddActionPerformed

    private void ButtonRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRemoveActionPerformed
        try {
            control.delete();
            listAppointments = control.getAllAppointment(); 
            loadTableAppointment(listAppointments);
        } catch (SQLException ex) {
            Logger.getLogger(AppointmentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonRemoveActionPerformed

    private void ButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonClearActionPerformed
        clearinput();
    }//GEN-LAST:event_ButtonClearActionPerformed

    private void ButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBackActionPerformed
        AdminDashBoard adminDashBoard = new AdminDashBoard(admin);
        adminDashBoard.setLocationRelativeTo(null);
        adminDashBoard.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ButtonBackActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AppointmentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppointmentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppointmentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppointmentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppointmentFrame(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAdd;
    private javax.swing.JButton ButtonBack;
    private javax.swing.JButton ButtonClear;
    private javax.swing.JButton ButtonRemove;
    private javax.swing.JSpinner SpinnerCapacity;
    private javax.swing.JSpinner SpinnerDate;
    private javax.swing.JTable TableDoctor;
    private javax.swing.JTable TableRoom;
    private javax.swing.JTable TableSchedule;
    private javax.swing.JTextField TextFieldDoctorId;
    private javax.swing.JTextField TextFieldEnd;
    private javax.swing.JTextField TextFieldRoomId;
    private javax.swing.JTextField TextFieldStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelStart;
    // End of variables declaration//GEN-END:variables

    
    private void loadTableAppointment(List<Appointment> appointments){
        String visibleStatus;
        DefaultTableModel model = (DefaultTableModel) TableSchedule.getModel();
        model.setRowCount(0);
        for (Appointment appointment : appointments){
            if (appointment.getStatus() == 0){
                visibleStatus = "AVAILABLE";
            } else {
                visibleStatus = "FULL";
            }
            
            Object[] rowData = {appointment.getAppointmentId(), appointment.getDoctorId(), appointment.getDate(), appointment.getStart(), appointment.getEnd(), appointment.getRoomId(), appointment.getCapacity(), visibleStatus};
            model.addRow(rowData);
        }
    }
    
    private void loadTableDoctor(List<Doctor> doctors) {
        DefaultTableModel model = (DefaultTableModel) TableDoctor.getModel();
        model.setRowCount(0);
        for (Doctor doctor : doctors) {
            String fullName = doctor.getFirstName() + " " + doctor.getLastName();
        Object[] rowData = {doctor.getDoctorId(), fullName};
            model.addRow(rowData);
        }
    }
    
    private void loadTableRoom(List<Room> rooms){
        DefaultTableModel model = (DefaultTableModel) TableRoom.getModel();
        model.setRowCount(0);
        for (Room room : rooms) {
            String location = "Floor " + room.getRoomFloor() + " Number " + room.getRoomNumber();
        Object[] rowData = {room.getRoomId(), room.getRoomName(), location};
            model.addRow(rowData);
        }
    }
    
    private void clearinput(){
        getTextFieldDoctorId().setText("");
        getTextFieldStart().setText("");
        getTextFieldEnd().setText("");
        getTextFieldRoomId().setText("");
        getSpinnerCapacity().setValue(0);
        getSpinnerDate().setValue(new java.util.Date());
    }

    public javax.swing.JButton getButtonAdd() {
        return ButtonAdd;
    }

    public void setButtonAdd(javax.swing.JButton buttonAdd) {
        ButtonAdd = buttonAdd;
    }

    public javax.swing.JButton getButtonClear() {
        return ButtonClear;
    }

    public void setButtonClear(javax.swing.JButton buttonClear) {
        ButtonClear = buttonClear;
    }

    public javax.swing.JButton getButtonRemove() {
        return ButtonRemove;
    }

    public void setButtonRemove(javax.swing.JButton buttonRemove) {
        ButtonRemove = buttonRemove;
    }

    public javax.swing.JSpinner getSpinnerCapacity() {
        return SpinnerCapacity;
    }

    public void setSpinnerCapacity(javax.swing.JSpinner spinnerCapacity) {
        SpinnerCapacity = spinnerCapacity;
    }

    public javax.swing.JSpinner getSpinnerDate() {
        return SpinnerDate;
    }

    public void setSpinnerDate(javax.swing.JSpinner spinnerDate) {
        SpinnerDate = spinnerDate;
    }

    public javax.swing.JTable getTableDoctor() {
        return TableDoctor;
    }

    public void setTableDoctor(javax.swing.JTable tableDoctor) {
        TableDoctor = tableDoctor;
    }

    public javax.swing.JTable getTableRoom() {
        return TableRoom;
    }

    public void setTableRoom(javax.swing.JTable tableRoom) {
        TableRoom = tableRoom;
    }

    public javax.swing.JTable getTableSchedule() {
        return TableSchedule;
    }

    public void setTableSchedule(javax.swing.JTable tableSchedule) {
        TableSchedule = tableSchedule;
    }

    public javax.swing.JTextField getTextFieldDoctorId() {
        return TextFieldDoctorId;
    }

    public void setTextFieldDoctorId(javax.swing.JTextField textFieldDoctorId) {
        TextFieldDoctorId = textFieldDoctorId;
    }

    public javax.swing.JTextField getTextFieldEnd() {
        return TextFieldEnd;
    }

    public void setTextFieldEnd(javax.swing.JTextField textFieldEnd) {
        TextFieldEnd = textFieldEnd;
    }

    public javax.swing.JTextField getTextFieldRoomId() {
        return TextFieldRoomId;
    }
    
    public void setTextFieldRoomId(javax.swing.JTextField textFieldRoomId) {
        TextFieldRoomId = textFieldRoomId;
    }

    public javax.swing.JTextField getTextFieldStart() {
        return TextFieldStart;
    }

    public void setTextFieldStart(javax.swing.JTextField textFieldStart) {
        TextFieldStart = textFieldStart;
    }

    public javax.swing.JPanel getJPanel2() {
        return jPanel2;
    }

    public void setJPanel2(javax.swing.JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    public javax.swing.JScrollPane getJScrollPane1() {
        return jScrollPane1;
    }

    public void setJScrollPane1(javax.swing.JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public javax.swing.JScrollPane getJScrollPane2() {
        return jScrollPane2;
    }

    public void setJScrollPane2(javax.swing.JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public javax.swing.JScrollPane getJScrollPane3() {
        return jScrollPane3;
    }

    public void setJScrollPane3(javax.swing.JScrollPane jScrollPane3) {
        this.jScrollPane3 = jScrollPane3;
    }
}
