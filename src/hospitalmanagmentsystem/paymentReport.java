/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagmentsystem;

import java.awt.HeadlessException;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rashmi
 */
public class paymentReport extends javax.swing.JFrame {
    
    Connection con = null;//create connection
    PreparedStatement update, insert, delete = null;//create preparedStatement
    final String password = "";//databse password
    final String userName = "root";//database username
    final String URL = "jdbc:mysql://localhost:3308/channelingcenter";//database url

    /**
     * Creates new form paymentReport
     */
    public paymentReport() {
        initComponents();
        
        try {
            //set connection
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, userName, password);//create database connection

        } catch (HeadlessException | ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Final bill already registered!");

        }
    }
    
    public void showDate() {
        java.util.Date d = new java.util.Date();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        reportDate.setText(sd.format(d));

    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    public void table_update_forDate()
    {
        int c;
        
        try{
          
            //get dates from SAimpleDateFormat
             SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
             String e1=sd.format(Dateto.getDate());
             String e2=sd.format(DateFrom.getDate());
             
            //select the record according to the given dates
            insert=con.prepareStatement("select finalBillId ,patientId ,currentDate, amount from payment where currentDate <= ? and currentDate >= ? ");
            insert.setString(1, e1);
            insert.setString(2, e2);
            
            //retrieve all the matching recpords to the result set
            ResultSet rs=insert.executeQuery();
            ResultSetMetaData res=rs.getMetaData();
            c=res.getColumnCount();
            DefaultTableModel df=(DefaultTableModel) jTable1.getModel();
            df.setRowCount(0);
            
            while(rs.next())
            {
                Vector v2=new Vector();
                for(int a=1;a<=c;a++)
                {
                    //add all data to the jTable
                    v2.add(rs.getString("finalBillId"));
                    v2.add(rs.getString("patientId")); 
                    v2.add(rs.getString("currentDate"));
                    v2.add(rs.getString("amount"));
                   
                }
                
                df.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(paymentReport.class.getName()).log(Level.SEVERE, null, ex);
           
        }
    }
    
    public void table_update_forMonth(){
        
        int c;
        int date1 = jMonthChooser1.getMonth()+ 1;
        
        try{
          
             
            //select the record according to the given dates
            insert=con.prepareStatement("select finalBillId ,patientId ,currentDate, amount from payment where month(currentDate) = ? ");
            insert.setInt(1, date1);
            
            
            //retrieve all the matching recpords to the result set
            ResultSet rs=insert.executeQuery();
            ResultSetMetaData res=rs.getMetaData();
            c=res.getColumnCount();
            DefaultTableModel df=(DefaultTableModel) jTable1.getModel();
            df.setRowCount(0);
            
            while(rs.next())
            {
                Vector v2=new Vector();
                for(int a=1;a<=c;a++)
                {
                    //add all data to the jTable
                    v2.add(rs.getString("finalBillId"));
                    v2.add(rs.getString("patientId")); 
                    v2.add(rs.getString("currentDate"));
                    v2.add(rs.getString("amount"));
                   
                }
                
                df.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(paymentReport.class.getName()).log(Level.SEVERE, null, ex);
           
        }

        
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Dateto = new com.toedter.calendar.JDateChooser();
        DateFrom = new com.toedter.calendar.JDateChooser();
        findDate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        findMonth = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        totAmount = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        area = new javax.swing.JTextArea();
        okBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        reportDate = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(214, 234, 245));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Date");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("To");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("From");

        Dateto.setBorder(new javax.swing.border.MatteBorder(null));
        Dateto.setDateFormatString("yyyy-MM-dd");

        DateFrom.setBorder(new javax.swing.border.MatteBorder(null));
        DateFrom.setDateFormatString("yyyy-MM-dd");

        findDate.setBackground(new java.awt.Color(53, 92, 125));
        findDate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        findDate.setForeground(new java.awt.Color(255, 255, 255));
        findDate.setText("Find");
        findDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findDateActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Bill No", "Patiient Id", "Current Date", "Amount"
            }
        ));
        jTable1.setRowHeight(22);
        jScrollPane1.setViewportView(jTable1);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Month");

        jMonthChooser1.setBorder(new javax.swing.border.MatteBorder(null));

        findMonth.setBackground(new java.awt.Color(53, 92, 125));
        findMonth.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        findMonth.setForeground(new java.awt.Color(255, 255, 255));
        findMonth.setText("Find");
        findMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findMonthActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Total Amount");

        totAmount.setEditable(false);
        totAmount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        area.setColumns(20);
        area.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        area.setRows(5);
        area.setTabSize(6);
        area.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        area.setSelectedTextColor(new java.awt.Color(204, 204, 204));
        jScrollPane2.setViewportView(area);

        okBtn.setBackground(new java.awt.Color(53, 92, 125));
        okBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        okBtn.setForeground(new java.awt.Color(255, 255, 255));
        okBtn.setText("Weekly Report");
        okBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okBtnActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(53, 92, 125));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(53, 92, 125));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Monthly Report");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(53, 92, 125));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(53, 92, 125));
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Logout");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel5)
                .addGap(43, 43, 43)
                .addComponent(totAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(okBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(729, 729, 729)
                        .addComponent(reportDate, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(41, 41, 41)
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(DateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(28, 28, 28)
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(Dateto, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(findDate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGap(3, 3, 3)
                                    .addComponent(jLabel4)
                                    .addGap(34, 34, 34)
                                    .addComponent(jMonthChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(381, 381, 381)
                                    .addComponent(findMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(57, 57, 57))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(reportDate, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2)
                                        .addComponent(Dateto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(findDate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(findMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jMonthChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(totAmount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(okBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void findDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findDateActionPerformed
        
        //check whether the dates are null or not
        if(Dateto.getDate() == null|| DateFrom.getDate() == null)
        {
            //if one of the date is null, display error message
            JOptionPane.showMessageDialog(this, "Please enter all details");
        }
        
        
        else
        {
            //if both of the dates are not null
            SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
            String e1=sd.format(Dateto.getDate());//get to date as a string
            String e2=sd.format(DateFrom.getDate());//get from date as a string 
            //check whether both dates are correct, to date should be a after date of from date
             if(e1.compareTo(e2)<0)
             {
                 //if from date is not correct, display error message
                JOptionPane.showMessageDialog(this, "Invalid date"); 
             }
             else
             {
                  try{
          
           
                    //select the record according to the given dates
                    insert=con.prepareStatement("select sum(amount) as tot1 from payment where currentDate <= ? and currentDate >= ? ");
                    insert.setString(1, e1);
                    insert.setString(2, e2);
                    //retrieve all the matching recpords to the result set
                    ResultSet rs=insert.executeQuery();
                    rs.next();
                  
                    totAmount.setText(rs.getString("tot1"));

                } catch (SQLException ex) {
                    Logger.getLogger(paymentReport.class.getName()).log(Level.SEVERE, null, ex);

                }
                 
                 //if both dates are correctly given, update the table 
                 table_update_forDate();
             }

        }
    }//GEN-LAST:event_findDateActionPerformed

    private void findMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findMonthActionPerformed
        
       int date1 = jMonthChooser1.getMonth()+ 1;
        
        try{
          
             
            //select the record according to the given dates
            insert=con.prepareStatement("select sum(amount) as tot2 from payment where month(currentDate) = ? ");
            insert.setInt(1, date1);
            
            //retrieve all the matching recpords to the result set
            ResultSet rs=insert.executeQuery();
            rs.next();
                  
            totAmount.setText(rs.getString("tot2"));
 
        } catch (SQLException ex) {
            Logger.getLogger(paymentReport.class.getName()).log(Level.SEVERE, null, ex);
           
        }        
       table_update_forMonth();
    }//GEN-LAST:event_findMonthActionPerformed

    private void okBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okBtnActionPerformed
        // TODO add your handling code here:
        
        showDate();
        area.setText(area.getText()+"\t"+"     "+"UNION CHANNELING CENTER\n");
        area.setText(area.getText()+"\t         Weekly Payment Report\n\n");
        
        area.setText(area.getText()+"\t"+"                                      "+reportDate.getText()+"\n\n");
        
        //get dates from SAimpleDateFormat
        SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
        String e1=sd.format(Dateto.getDate());
        String e2=sd.format(DateFrom.getDate());
        
        area.setText(area.getText()+"From Date\t: "+e1+"\n");
        area.setText(area.getText()+"To Date\t: "+e2+"\n");
        
        area.setText(area.getText() + "\n");
        
        try{
             
             
             area.setText(area.getText() + "Bill No\tPatient Id\tCurrent Date\tAmount\n");
             
            //select the record according to the given dates
            insert=con.prepareStatement("select finalBillId ,patientId ,currentDate, amount from payment where currentDate <= ? and currentDate >= ? ");
            insert.setString(1, e1);
            insert.setString(2, e2);
            
            
                try{

                //retrieve all the matching recpords to the result set
                ResultSet rs=insert.executeQuery();

                 while (rs.next()) {
                   
                    area.setText(area.getText() + Integer.parseInt(rs.getString("finalBillId")) + "\t" + Integer.parseInt(rs.getString("patientId")) + "\t" + rs.getString("currentDate") + "\t" + Integer.parseInt(rs.getString("amount")) + "\n");
                }

                }catch(NumberFormatException ex){

                }
                
            area.setText(area.getText() + "\n");
            area.setText(area.getText() + "Total Amount: Rs." + totAmount.getText());
            area.setText(area.getText() + "\n");

            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Record Not Found");
            
        }
        

    }//GEN-LAST:event_okBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            area.print();
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        showDate();
        area.setText(area.getText()+"\t"+"     "+"UNION CHANNELING CENTER\n");
        area.setText(area.getText()+"\t        Monthly Payment Report\n\n");
        
        area.setText(area.getText()+"\t"+"                                      "+reportDate.getText()+"\n\n");
        
        
        int date1 = jMonthChooser1.getMonth()+ 1;
        
        area.setText(area.getText()+"Month\t: "+date1+"\n"); 
        
        area.setText(area.getText() + "\n");
        
        try{
             
             
            area.setText(area.getText() + "Bill No\tPatient Id\tCurrent Date\tAmount\n");
           
             
            //select the record according to the given dates
            insert=con.prepareStatement("select finalBillId ,patientId ,currentDate, amount from payment where month(currentDate) = ? ");
            insert.setInt(1, date1);
            
                try{

                //retrieve all the matching recpords to the result set
                ResultSet rs=insert.executeQuery();

                 while (rs.next()) {
                   
                    area.setText(area.getText() + Integer.parseInt(rs.getString("finalBillId")) + "\t" + Integer.parseInt(rs.getString("patientId")) + "\t" + rs.getString("currentDate") + "\t" + Integer.parseInt(rs.getString("amount")) + "\n");
                }

                }catch(NumberFormatException ex){

                }
                
            area.setText(area.getText() + "\n");
            area.setText(area.getText() + "Total Amount: Rs." + totAmount.getText());
            area.setText(area.getText() + "\n");

            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Record Not Found");
            
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        new cashierMain().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        cashierLogin Log = new cashierLogin();
        Log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(paymentReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(paymentReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(paymentReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(paymentReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new paymentReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateFrom;
    private com.toedter.calendar.JDateChooser Dateto;
    private javax.swing.JTextArea area;
    private javax.swing.JButton findDate;
    private javax.swing.JButton findMonth;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton okBtn;
    private javax.swing.JLabel reportDate;
    private javax.swing.JTextField totAmount;
    // End of variables declaration//GEN-END:variables

    
}
