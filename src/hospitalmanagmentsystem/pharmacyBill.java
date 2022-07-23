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
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author singer
 */
public class pharmacyBill extends javax.swing.JFrame {
    
    Boolean result;
    Connection con1;
    PreparedStatement insert, delete;
    
    /**
     * Creates new form pharmacyBill
     */
    public pharmacyBill() {
        initComponents();
        table_update();
//        setimg();
//        jPanel1.setBackground(new Color(255,255,255,120));
         //jPanel2.setBackground(new Color(255,255,255,120));
    }
    
//    public void setimg(){
//        ImageIcon imageicon = new ImageIcon("C:\\Users\\singer\\Downloads\\user_roles\\user_roles\\icon14.png");
//        Image img = imageicon.getImage();
//        Image imgScale = img.getScaledInstance(backg.getWidth(),backg.getHeight(),Image.SCALE_FAST);
//        ImageIcon scaledIcon = new ImageIcon(imgScale);
//        backg.setIcon(scaledIcon);
//        
//    };
    
        public void table_update(){
        
        try{
            int c;
            Class.forName("com.mysql.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3308/channelingcenter","root","");
            
            insert = con1.prepareStatement("select PharmacyBillId from pharmacybill group by PharmacyBillId order by PharmacyBillId desc limit 1");

            ResultSet rs = insert.executeQuery();

            while(rs.next()){

                bno.setText(rs.getString("PharmacyBillId"));
            }
            
            String billNo = bno.getText();
            
            insert = con1.prepareStatement("select drug.drugName , billdrug.itemQty, stock.unitPrice from billdrug,drug, stock where billdrug.PharmacyBillID = ? AND drug.drugID = billdrug.drugId and stock.drugID = billdrug.drugId order by billdrug.drugId");
            
            insert.setString(1,billNo);
            
            ResultSet rs1 = insert.executeQuery();
            ResultSetMetaData res = rs1.getMetaData();
            c = res.getColumnCount();
            DefaultTableModel df = (DefaultTableModel) drugbill.getModel();
            int selectedIndex = drugbill.getSelectedRow();
            df.setRowCount(0);
            
            int ttprice = 0;
            int price = 0;
            int quty = 0;
            
            
            
            //price = Double.parseDouble(billNo);
            
            while(rs1.next())
            {
                Vector v2=new Vector();
                for(int a=1;a<=c;a++)
                {
                    v2.add(rs1.getString("drug.drugName"));
                    v2.add(rs1.getString("billdrug.itemQty"));
                    v2.add(rs1.getString("stock.unitPrice"));
                    //v2.add(rs1.getString("DoctorName"));
                }
                df.addRow(v2);    
                
                price = Integer.parseInt(rs1.getString("stock.unitPrice"));
                quty = Integer.parseInt(rs1.getString("billdrug.itemQty"));
                ttprice = ttprice + (quty * price);
                
            }
            
           
           String num="";
           num+=ttprice;
           totpriceTxt.setText(num);
           
           insert = con1.prepareStatement("Update pharmacybill set totPrice = ? Where PharmacyBillId = ?");
           insert.setString(1,totpriceTxt.getText());
           insert.setString(2, bno.getText());
           
           insert.executeUpdate();
           
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(billDrugInsert.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) {
            Logger.getLogger(billDrugInsert.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel(){
            public void paintComponent(Graphics g){

                ImageIcon im = new ImageIcon("C:\\Users\\Chathunika Heenkenda\\Desktop\\ITP Project\\Main Project\\interfaces\\HospitalManagmentSystem\\src\\images\\backg1.jpg");
                Image i =im.getImage();

                g.drawImage(i,0,0,this.getSize().width,this.getSize().height,this);

            }};
            jPanel2 = new javax.swing.JPanel();
            jButton1 = new javax.swing.JButton();
            jButton2 = new javax.swing.JButton();
            jButton3 = new javax.swing.JButton();
            jScrollPane1 = new javax.swing.JScrollPane();
            drugbill = new javax.swing.JTable();
            jButton4 = new javax.swing.JButton();
            jLabel1 = new javax.swing.JLabel();
            jLabel2 = new javax.swing.JLabel();
            bno = new javax.swing.JLabel();
            totpriceTxt = new javax.swing.JLabel();
            jButton6 = new javax.swing.JButton();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

            jPanel2.setBackground(new java.awt.Color(214, 234, 245));
            jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Pharmacy Bill"));

            jButton1.setBackground(new java.awt.Color(53, 92, 125));
            jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
            jButton1.setForeground(new java.awt.Color(255, 255, 255));
            jButton1.setText("Add");
            jButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
                }
            });

            jButton2.setBackground(new java.awt.Color(53, 92, 125));
            jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
            jButton2.setForeground(new java.awt.Color(255, 255, 255));
            jButton2.setText("Done");
            jButton2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton2ActionPerformed(evt);
                }
            });

            jButton3.setBackground(new java.awt.Color(53, 92, 125));
            jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
            jButton3.setForeground(new java.awt.Color(255, 255, 255));
            jButton3.setText("Cancel");
            jButton3.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton3ActionPerformed(evt);
                }
            });

            drugbill.setAutoCreateRowSorter(true);
            drugbill.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
            drugbill.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Drug ", "Quantity", "Price"
                }
            ));
            drugbill.setRowHeight(30);
            jScrollPane1.setViewportView(drugbill);

            jButton4.setBackground(new java.awt.Color(53, 92, 125));
            jButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
            jButton4.setForeground(new java.awt.Color(255, 255, 255));
            jButton4.setText("Update");
            jButton4.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton4ActionPerformed(evt);
                }
            });

            jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
            jLabel1.setText("Total Price");

            jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
            jLabel2.setText("Bill Number");

            bno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
            bno.setBorder(javax.swing.BorderFactory.createEtchedBorder());

            totpriceTxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
            totpriceTxt.setBorder(javax.swing.BorderFactory.createEtchedBorder());

            jButton6.setBackground(new java.awt.Color(53, 92, 125));
            jButton6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
            jButton6.setForeground(new java.awt.Color(255, 255, 255));
            jButton6.setText("Delete");
            jButton6.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton6ActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
            jPanel2.setLayout(jPanel2Layout);
            jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap(44, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(117, 117, 117))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(66, 66, 66)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(96, 96, 96)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(80, 80, 80)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(totpriceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 763, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(bno, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGap(59, 59, 59))
            );
            jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addComponent(bno, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 16, Short.MAX_VALUE)))
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(totpriceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(47, 47, 47)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(22, 22, 22))
            );

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 41, Short.MAX_VALUE))
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(46, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 50, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        billDrugInsert nd = new billDrugInsert();
        nd.setVisible(true);
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        pharmacyFinalBill nd = new pharmacyFinalBill();
        nd.setVisible(true);
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con1=DriverManager.getConnection("jdbc:mysql://localhost:3308/channelingcenter","root","");
            String billno = bno.getText();

            delete = con1.prepareStatement("delete from billdrug where PharmacyBillID = ?");
            delete.setString(1, billno);

            delete.executeUpdate();

            delete = con1.prepareStatement("delete from pharmacybill where PharmacyBillId = ?");
            delete.setString(1, billno);

            delete.executeUpdate();

            JOptionPane.showMessageDialog(this, "Pharmacy Bill Canceled");
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(pharmacyBill.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
            Logger.getLogger(pharmacyBill.class.getName()).log(Level.SEVERE, null, ex);
        }
        pharmacyBillMain nd = new pharmacyBillMain();
        nd.setVisible(true);
        this.dispose();      // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        pharmacyBillUpdate nd = new pharmacyBillUpdate();
        nd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        String Did = null;
        try {
            con1 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3308/channelingcenter","root", "");
            int row = drugbill.getSelectedRow();

            String cell = drugbill.getModel().getValueAt(row, 0).toString();

            insert = con1.prepareStatement("Select drugID from drug where drugName = ?");

            insert.setString(1, cell);

            ResultSet r = insert.executeQuery();

            while(r.next()){
                Did = r.getString("drugID");
            }

            String billno = bno.getText();

            delete = con1.prepareStatement("DELETE FROM billdrug where drugId = ? and PharmacyBillID = ?") ;

            delete.setString(1, Did);
            delete.setString(2, billno);

            delete.executeUpdate();

            DefaultTableModel tblModel = (DefaultTableModel) drugbill.getModel();

            //delete row
            if(drugbill.getSelectedRowCount()==1 ){
                //if single row is selected thatn delete
                tblModel.removeRow(drugbill.getSelectedRow());

                JOptionPane.showMessageDialog(null,"Drug Deleted");

            }
            else{
                if(drugbill.getRowCount() == 0){
                    //if table is empty
                    JOptionPane.showMessageDialog(this,"Table is Empty");
                }
            }

        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Can not delete");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(pharmacyBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pharmacyBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pharmacyBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pharmacyBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pharmacyBill().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bno;
    private javax.swing.JTable drugbill;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel totpriceTxt;
    // End of variables declaration//GEN-END:variables
}