/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagmentsystem;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lushiya
 */
public class appointmentInsert extends javax.swing.JFrame {
    
    Connection con1;
    PreparedStatement insert;
    String channelingDay;
    String doctorId;
    String channelingTime;
    String patientCount;
    int patientChannelingCount;
    String doctorfee;
    /**
     * Creates new form appointmentInsert
     */
    public appointmentInsert() {
        initComponents();
        patientChannelingCount = 0;
        updateCombo();
//        setimg();
//        jPanel3.setBackground(new Color(255,255,255,120));
    }
//    
//    public void setimg(){
//        ImageIcon imageicon = new ImageIcon("C:\\Users\\singer\\Downloads\\user_roles\\user_roles\\icon14.png");
//        Image img = imageicon.getImage();
//        Image imgScale = img.getScaledInstance(backg.getWidth(),backg.getHeight(),Image.SCALE_FAST);
//        ImageIcon scaledIcon = new ImageIcon(imgScale);
//        backg.setIcon(scaledIcon);
//        
//    };
//    
     private void updateCombo() {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3308/channelingcenter", "root", "");

            Speciality1.removeAllItems();

            insert = con1.prepareStatement("select specialization from doctor ");

            ResultSet result = insert.executeQuery();

            while (result.next()) {
                Speciality1.addItem(result.getString("specialization"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(updateAppointment.class.getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(updateAppointment.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private void getDoctor(){
        
    int c;    
    try 
    {
        Class.forName("com.mysql.jdbc.Driver");

        con1 = DriverManager.getConnection("jdbc:mysql://localhost:3308/channelingcenter", "root", "");

        insert = con1.prepareStatement("SELECT docId,docName,specialization,docCount,weekday,weekdayTime,weekend,weekendTime FROM doctor where Speciality = ?");

        insert.setString(1, chnDay.getSelectedItem().toString()); 

        ResultSet rs = insert.executeQuery();
        ResultSetMetaData res = rs.getMetaData();

        c = res.getColumnCount();

        DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
        df.setRowCount(0);

        while (rs.next()) {

                Vector v2 = new Vector();

                for (int a = 1; a <= c; a++){

                        v2.add(rs.getString("docId"));
                        v2.add(rs.getString("docName"));
                        v2.add(rs.getString("specialization"));
                        v2.add(rs.getDate("docCount"));
                        v2.add(rs.getTime("weekday"));
                        v2.add(rs.getString("weekdayTime"));
                        v2.add(rs.getString("weekend"));
                        v2.add(rs.getString("weekendTime"));
                }
                df.addRow(v2);
        }


        if(jTable1.getRowCount()==0)
                JOptionPane.showMessageDialog(this, "No Channelings for the search");

    } 
    catch (SQLException ex) {
        //Logger.getLogger(HIpd.class.getName()).log(Level.SEVERE, null, ex);
    } 

    catch (ClassNotFoundException ex) {
        //Logger.getLogger(HIpd.class.getName()).log(Level.SEVERE, null, ex);
    }
} 
            
    private void specialityList(){

        int c;
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");

            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3308/channelingcenter", "root", "");

            insert = con1.prepareStatement("SELECT docId,docName,specialization,docCount,weekday,weekdayTime,weekend,weekendTime FROM doctor where Speciality = ? AND docAvailability = 'Yes'");
            insert.setString(1, chnDay.getSelectedItem().toString());
            ResultSet rs = insert.executeQuery();
            ResultSetMetaData res = rs.getMetaData();

            c = res.getColumnCount();

            DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
            df.setRowCount(0);

            while (rs.next()) {

                    Vector v2 = new Vector();

                    for (int a = 1; a <= c; a++) {

                            v2.add(rs.getString("docId"));
                            v2.add(rs.getString("docName"));
                            v2.add(rs.getString("specialization"));
                            v2.add(rs.getDate("docCount"));
                            v2.add(rs.getTime("weekday"));
                            v2.add(rs.getString("weekdayTime"));
                            v2.add(rs.getString("weekend"));
                            v2.add(rs.getString("weekendTime"));

                    }

                    df.addRow(v2);
            }
            if(jTable1.getRowCount()==0)
                    JOptionPane.showMessageDialog(this, "No Channelings for the search");

        } 
        catch (SQLException ex) {
                    //Logger.getLogger(HIpd.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (ClassNotFoundException ex) {
                    //Logger.getLogger(HIpd.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        consName = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        consName1 = new javax.swing.JLabel();
        consultantName = new javax.swing.JLabel();
        specializationText = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Speciality1 = new javax.swing.JComboBox<>();
        chnDay = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(214, 234, 245));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        consName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        consName.setText("Consultant Name:");

        jButton5.setBackground(new java.awt.Color(53, 93, 125));
        jButton5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Add Appointment");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        consName1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        consName1.setText("Specialization:");

        consultantName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        specializationText.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(consName)
                            .addComponent(consName1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(specializationText, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(consultantName, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jButton5)))
                .addGap(0, 74, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(consName)
                    .addComponent(consultantName, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(consName1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(specializationText, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(75, 75, 75)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Doctor Id", "Doctor Name", "Specialization", "No of Patients", "Channeling day", "Channeling Time", "Doctor Fee"
            }
        ));
        jTable1.setRowHeight(25);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Add Appointment");

        jButton1.setBackground(new java.awt.Color(53, 92, 125));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel1.setText("Select Doctor Specialization:");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setText("Channeling Day");

        Speciality1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        Speciality1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Neurologist", "Cardiologist", "Physician", "Psychiatrist" }));
        Speciality1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Speciality1ActionPerformed(evt);
            }
        });

        chnDay.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        chnDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Weekday", "Weekend" }));
        chnDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chnDayActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(53, 92, 125));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 888, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(chnDay, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Speciality1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(549, 549, 549)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel4)
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Speciality1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chnDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 37, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chnDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chnDayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chnDayActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        consultantName.setText("");
        specializationText.setText("");
        
        if (chnDay.getSelectedItem().equals("Weekday"))
{
	
	int c;
	try{

		Class.forName("com.mysql.jdbc.Driver");
		con1=DriverManager.getConnection("jdbc:mysql://localhost:3308/channelingcenter","root","");
		insert=con1.prepareStatement("select docID , docName , specialization , docCount , weekday , weekdayTime , docFee from doctor where specialization = ? AND docAvailability = 'Yes'");
		insert.setString(1,Speciality1.getSelectedItem().toString());

		//selectAddresult.setString(1, Specialty.getSelectedItem().toString());
		ResultSet rs=insert.executeQuery();

		ResultSetMetaData res =rs.getMetaData();

		c = res.getColumnCount();

		DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
		df.setRowCount(0);


		while(rs.next()){
			Vector v2 = new Vector ();
			for (int a=1;a<=c;a++){
				v2.add(rs.getString("docId"));
				v2.add(rs.getString("docName"));
				v2.add(rs.getString("specialization"));
				v2.add(rs.getString("docCount"));
				v2.add(rs.getString("weekday"));
				v2.add(rs.getString("weekdayTime"));
				v2.add(rs.getString("docFee"));		

			}
			df.addRow(v2);
		}



	} 
	catch (SQLException ex) {
		//Logger.getLogger(ShReports.class.getName()).log(Level.SEVERE, null, ex);
	} 
	catch (ClassNotFoundException ex) {
		//Logger.getLogger(ShReports.class.getName()).log(Level.SEVERE, null, ex);
	}
}

	else if (chnDay.getSelectedItem().equals("Weekend")){ 
	
	
		int c;
		try{

			Class.forName("com.mysql.jdbc.Driver");
			con1=DriverManager.getConnection("jdbc:mysql://localhost:3308/channelingcenter","root","");
			insert=con1.prepareStatement("select docID , docName , specialization , docCount , weekend , weekendTime , docFee from doctor where specialization = ? AND docAvailability = 'Yes'");
			insert.setString(1,Speciality1.getSelectedItem().toString());

			//selectAddresult.setString(1, Specialty.getSelectedItem().toString());
			ResultSet rs=insert.executeQuery();

			ResultSetMetaData res =rs.getMetaData();

			c = res.getColumnCount();

			DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
			df.setRowCount(0);


			while(rs.next()){
				Vector v2 = new Vector ();
				for (int a=1;a<=c;a++){
					v2.add(rs.getString("docId"));
					v2.add(rs.getString("docName"));
					v2.add(rs.getString("specialization"));
					v2.add(rs.getString("docCount"));
					v2.add(rs.getString("weekend"));
					v2.add(rs.getString("weekendTime"));
					v2.add(rs.getString("docFee"));		

				}
				df.addRow(v2);
			}


		} 
		catch (SQLException ex) {
			//Logger.getLogger(ShReports.class.getName()).log(Level.SEVERE, null, ex);
		} 
		catch (ClassNotFoundException ex) {
			//Logger.getLogger(ShReports.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	else{
		JOptionPane.showMessageDialog(this,"Error Message");
	}
	
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
        int selectedIndex = jTable1.getSelectedRow();

        doctorId = df.getValueAt(selectedIndex, 0).toString();
        consultantName.setText(df.getValueAt(selectedIndex, 1).toString());
        specializationText.setText(df.getValueAt(selectedIndex, 2).toString());
        patientCount = df.getValueAt(selectedIndex, 3).toString();
        channelingDay = df.getValueAt(selectedIndex, 4).toString();
        channelingTime = df.getValueAt(selectedIndex, 5).toString();
        doctorfee = df.getValueAt(selectedIndex, 6).toString();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:

        if(consultantName.getText().equals("") && specializationText.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select a consultant");
        }	
        else
        {
            try 
            {
                Class.forName("com.mysql.jdbc.Driver");

                con1 = DriverManager.getConnection("jdbc:mysql://localhost:3308/channelingcenter", "root", "");

                insert = con1.prepareStatement("select count(patientId) as count\n" +
                                                "from docappointment,doctor\n" + "where docappointment.docId = doctor.docId "
                                                + "and doctor.docId = ?");

                insert.setString(1,doctorId);

                ResultSet rs = insert.executeQuery();

                while(rs.next()){

                   patientChannelingCount = (rs.getInt("count"));
                }


                if(Integer.parseInt(patientCount) == patientChannelingCount)
                {
                    JOptionPane.showMessageDialog(this, "No more appointments available. Channneling is full");
                }

                else
                {
                        insert = con1.prepareStatement("select docappointment.appStatus\n" +
                                                        "from docappointment,doctor\n" + "where docappointment.docId = doctor.docId "
                                                        + "and doctor.docId = ?");
                        insert.setString(1,doctorId);
                        String status = "Active";

                        ResultSet rs2 = insert.executeQuery();

                        while(rs2.next()){				  
                            status = (rs2.getString("docappointment.appStatus"));
                        }

                        if(status.equals("Cancelled"))
                           JOptionPane.showMessageDialog(this, "Cannot add appointment. This channeling is cancelled");

                        else
                        { 
                            patientChannelingCount+=1;
                            String patientChannelingCounts ="";
                            patientChannelingCounts+=patientChannelingCount;
                            System.out.println(patientChannelingCounts);

                            addAppointment happ = new addAppointment(consultantName.getText(),doctorId,channelingDay,channelingTime,patientChannelingCounts,doctorfee);
                            happ.setVisible(true); 
                        }

                }

            } 
            catch (SQLException ex) {
               // Logger.getLogger(HIpd.class.getName()).log(Level.SEVERE, null, ex);
            } 
            catch (ClassNotFoundException ex) {
                //Logger.getLogger(HIpd.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void Speciality1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Speciality1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Speciality1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
//         receptionistMain recepback = new receptionistMain();
//        recepback.setVisible(true);
//        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(appointmentInsert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(appointmentInsert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(appointmentInsert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(appointmentInsert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new appointmentInsert().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Speciality1;
    private javax.swing.JComboBox<String> chnDay;
    private javax.swing.JLabel consName;
    private javax.swing.JLabel consName1;
    private javax.swing.JLabel consultantName;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel specializationText;
    // End of variables declaration//GEN-END:variables
}
