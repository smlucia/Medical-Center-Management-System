/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagmentsystem;

import com.toedter.calendar.JMonthChooser;
import java.awt.Image;
import java.awt.print.PrinterException;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author Hp
 */
public class DocAppointmentReport extends javax.swing.JFrame {
    
    Boolean result;
    Connection con1;
    PreparedStatement insert;

    /**
     * Creates new form docReport
     */
    public DocAppointmentReport() {
        initComponents();
      
    }
    
     
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        backBtn = new javax.swing.JButton();
        reportTitle = new javax.swing.JLabel();
        specializationL = new javax.swing.JLabel();
        txtDoctorSpecility = new javax.swing.JComboBox<>();
        searchBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        reportTable = new javax.swing.JTable();
        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        monthlabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        area = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        totAppL = new javax.swing.JLabel();
        totAppT = new javax.swing.JTextField();
        generateR = new javax.swing.JButton();
        backg = new javax.swing.JLabel();
        viewBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backBtn.setBackground(new java.awt.Color(53, 92, 125));
        backBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backBtn.setForeground(new java.awt.Color(255, 255, 255));
        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        reportTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        reportTitle.setText("Total Doctor Appointments");

        specializationL.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        specializationL.setText("Select Specialization:");

        txtDoctorSpecility.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Neurologist", "Cardiologist", "Physician", "Psychiatrist", "Radiology", "Urology", "Dermatology", " " }));
        txtDoctorSpecility.setBorder(null);

        searchBtn.setBackground(new java.awt.Color(153, 204, 255));
        searchBtn.setText("search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        reportTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Doc Name", "No of Appointments"
            }
        ));
        jScrollPane1.setViewportView(reportTable);

        monthlabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        monthlabel.setText("Select Month:");

        area.setColumns(20);
        area.setRows(5);
        jScrollPane2.setViewportView(area);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        totAppL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        totAppL.setText("Total Appointments:");

        totAppT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        totAppT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totAppTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(totAppL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(totAppT, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totAppL)
                    .addComponent(totAppT, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        generateR.setBackground(new java.awt.Color(53, 92, 125));
        generateR.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        generateR.setForeground(new java.awt.Color(255, 255, 255));
        generateR.setText("Generate Report");
        generateR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateRActionPerformed(evt);
            }
        });

        viewBtn.setBackground(new java.awt.Color(53, 92, 125));
        viewBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        viewBtn.setForeground(new java.awt.Color(255, 255, 255));
        viewBtn.setText("View");
        viewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(specializationL)
                            .addComponent(monthlabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDoctorSpecility, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jMonthChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(186, 186, 186))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(generateR)
                            .addGap(46, 46, 46)
                            .addComponent(viewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addComponent(backg)
                .addGap(179, 179, 179)
                .addComponent(reportTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reportTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backg))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(specializationL)
                            .addComponent(txtDoctorSpecility, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jMonthChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(monthlabel))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(generateR, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(viewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(47, 47, 47))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
       MainLoginUI back1 = new MainLoginUI();
        back1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
       
       int appdate = jMonthChooser1.getMonth() + 1;
  
       try {
            Class.forName("com.mysql.jdbc.Driver");
            con1=DriverManager.getConnection("jdbc:mysql://localhost:3308/channelingcenter","root","");
            insert=con1.prepareStatement("select count(app.docId) as 'total' , doc.docName from doctor doc, docappointment app where doc.docId = app.docId and doc.specialization = ? and month(app.appDate) = ? group by doc.docName");
            insert.setString(1, txtDoctorSpecility.getSelectedItem().toString());
            insert.setInt(2, appdate);

            ResultSet rs=insert.executeQuery();

            ResultSetMetaData res =rs.getMetaData();

            int c= res.getColumnCount();

            DefaultTableModel df = (DefaultTableModel) reportTable.getModel();
            df.setRowCount(0);
           
            while(rs.next()){
                Vector v2 = new Vector ();
                for (int a=1;a<=c;a++){
                    v2.add(rs.getString("doc.docname"));
                    v2.add(rs.getString("total"));
                 
                }
                df.addRow(v2);
            }
            
          String spl = txtDoctorSpecility.getSelectedItem().toString();
          String sql2 = "select count(app.appoId) as 'c' from doctor doc, docappointment app where doc.docId = app.docId and doc.specialization = '"+spl+"' and month(app.appDate) = '"+appdate+"'";
          insert = (com.mysql.jdbc.PreparedStatement) con1.prepareStatement(sql2);
          ResultSet r1 = insert.executeQuery(sql2);
          r1.next();
          String totCount = r1.getString("c");
          
          totAppT.setText(totCount);
        
                  
        } catch (SQLException ex) {
            Logger.getLogger(DocAppointmentReport.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DocAppointmentReport.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_searchBtnActionPerformed

    private void totAppTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totAppTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totAppTActionPerformed

    private void generateRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateRActionPerformed
        try {
            // TODO add your handling code here:
            
//        int check = reportTable.getRowCount();
//
//        if(check == 0)
//        JOptionPane.showMessageDialog(this, "No results available!");
//
//        else{
//            int dialogresult = JOptionPane.showConfirmDialog(null, "This will print labtests report for the month. Click ok to continue", "Info", JOptionPane.YES_NO_OPTION);
//
//            if(dialogresult == JOptionPane.YES_OPTION){
//                MessageFormat header = new MessageFormat("Lab Test for HMS");
//                MessageFormat footer = new MessageFormat("page 1");
//                try {
//
//                    reportTable.print(JTable.PrintMode.FIT_WIDTH,header,footer);
//                } catch (PrinterException ex) {
//
//                    //Logger.getLogger(HLabApp.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//
//        }
            area.print();
        } catch (PrinterException ex) {
            Logger.getLogger(DocAppointmentReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_generateRActionPerformed

    private void viewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewBtnActionPerformed
        // TODO add your handling code here:
        int appdate = jMonthChooser1.getMonth() + 1;
        String mymonth;
        SimpleDateFormat sdf1 = new SimpleDateFormat("MM");
        
        mymonth = sdf1.format(appdate);
        System.out.println(mymonth);
    
        System.out.println("Error2");
        area.setText(area.getText()+"\t"+" "+"UNION CHANNELING CENTER\n\n");
        area.setText(area.getText()+"-----------------------Doctor Appointment Summary Report-------------------------------\n");
        area.setText(area.getText()+"Doctor Specialization\t\t: "+txtDoctorSpecility.getSelectedItem().toString()+"\n");
        System.out.println("Error1");
        area.setText(area.getText()+"Month\t\t\t: "+mymonth+"\n");
        System.out.println("Error3");
        area.setText(area.getText()+"Total Appointments\t\t: "+totAppT.getText()+"\n");
        area.setText(area.getText()+"-----------------------------------------------------------------------------------------------\n\n");
        area.setText(area.getText()+"Doctor Name"+"\t\t\t"+"No Of Appointments"+"\n");
        area.setText(area.getText()+"------------------------------------------------------------------------------------------------\n\n");
        for (int count = 0; count < reportTable.getRowCount(); count++){
        area.setText(area.getText()+reportTable.getValueAt(count, 0).toString()+"\t\t\t");
        area.setText(area.getText()+reportTable.getValueAt(count, 1).toString()+"\n");
}


    }//GEN-LAST:event_viewBtnActionPerformed

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
            java.util.logging.Logger.getLogger(DocAppointmentReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DocAppointmentReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DocAppointmentReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DocAppointmentReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DocAppointmentReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea area;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel backg;
    private javax.swing.JButton generateR;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel monthlabel;
    private javax.swing.JTable reportTable;
    private javax.swing.JLabel reportTitle;
    private javax.swing.JButton searchBtn;
    private javax.swing.JLabel specializationL;
    private javax.swing.JLabel totAppL;
    private javax.swing.JTextField totAppT;
    private javax.swing.JComboBox<String> txtDoctorSpecility;
    private javax.swing.JButton viewBtn;
    // End of variables declaration//GEN-END:variables
}