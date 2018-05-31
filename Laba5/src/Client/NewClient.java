/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Entities.Client;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;

/**
 *
 * @author Sofia
 */
public class NewClient extends javax.swing.JDialog {

    Connection c;
    Client editItem;
    List<Client> list;
    int id;
    
    public NewClient(java.awt.Frame parent, boolean modal, Connection c , int id ) throws SQLException {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.c = c;
        this.id = id;
        list = new ArrayList<>();
    }

    public NewClient(java.awt.Frame parent, boolean modal, Connection c, Client u) throws SQLException {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.c = c;
        this.id = u.getId();
        editItem = u;
        list = new ArrayList<>();
        fillFields();
    }
    
    private void fillFields() {
        JTextFieldPhoneNumber.setText(editItem.getPhoneNumber()+"");
        JTextFieldFullName.setText(editItem.getFullName());
    }

    public boolean check() {
       
        if ("".equals(JTextFieldFullName.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Неверно введено ФИО");
            return false;
        }
        try{
            Integer.parseInt(JTextFieldPhoneNumber.getText());
        }
        catch(NumberFormatException e) {  
            System.err.println("Неверный формат номера телефона!"); 
            return false;
        }   
        return true;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonOk = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        JTextFieldFullName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JTextFieldPhoneNumber = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonOk.setText("OK");
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });

        jLabel2.setText("ФИО:");

        JTextFieldFullName.setToolTipText("");
        JTextFieldFullName.setName(""); // NOI18N

        jLabel3.setText("т.");

        JTextFieldPhoneNumber.setToolTipText("");
        JTextFieldPhoneNumber.setName(""); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonOk))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JTextFieldFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(JTextFieldPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTextFieldFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTextFieldPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonOk)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed

        if (!check()) {
            return;
        }
        try {
            ClientModel cm = new ClientModel(c);
            cm.insertOrUpdate(editItem, id,JTextFieldFullName.getText(),Integer.parseInt(JTextFieldPhoneNumber.getText()));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            return;
        }
        dispose();
    }//GEN-LAST:event_jButtonOkActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTextFieldFullName;
    private javax.swing.JTextField JTextFieldPhoneNumber;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
