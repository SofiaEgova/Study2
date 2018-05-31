
package Record;

import Client.ClientModel;
import Doctor.DoctorModel;
import Entities.Client;
import Entities.Doctor;
import Entities.Record;
import Entities.RecordStatus;
import RecordStatus.RecordStatusModel;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Sofia
 */
public class NewRecord extends javax.swing.JDialog {

    Connection c;
    Record editItem;
    List<Record> list;
    int id;
    
    public NewRecord(java.awt.Frame parent, boolean modal, Connection c , int id ) throws SQLException {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.c = c;
        this.id = id;
        list = new ArrayList<>();
        clientId.setModel(new DefaultComboBoxModel(ClientModel.selectClients(c).toArray())); 
        doctorId.setModel(new DefaultComboBoxModel(DoctorModel.selectDoctors(c).toArray())); 
        recordstatusId.setModel(new DefaultComboBoxModel(RecordStatusModel.selectRecordStatuses(c).toArray())); 
    }
    
    public NewRecord(java.awt.Frame parent, boolean modal, Connection c, Record u) throws SQLException {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.c = c;
        this.id = u.getId();
        editItem = u;
        list = new ArrayList<>();
        clientId.setModel(new DefaultComboBoxModel(ClientModel.selectClients(c).toArray())); 
        doctorId.setModel(new DefaultComboBoxModel(DoctorModel.selectDoctors(c).toArray())); 
        recordstatusId.setModel(new DefaultComboBoxModel(RecordStatusModel.selectRecordStatuses(c).toArray())); 
        fillFields();
    }

    private void fillFields() {
        JTextFieldDate.setText(editItem.getDate().toString());
    }              

    public boolean check() {
       
        if ("".equals(JTextFieldDate.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Неверно введено ФИО");
            return false;
        }
        if(clientId.getSelectedItem()==null){
            JOptionPane.showMessageDialog(new JFrame(), "Не выбран клиент");
            return false;
        }
        if(doctorId.getSelectedItem()==null){
            JOptionPane.showMessageDialog(new JFrame(), "Не выбран доктор");
            return false;
        }
        if(recordstatusId.getSelectedItem()==null){
            JOptionPane.showMessageDialog(new JFrame(), "Не выбран статус");
            return false;
        }
        return true;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JTextFieldDate = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButtonOk = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        clientId = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        doctorId = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        recordstatusId = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        JTextFieldDate.setToolTipText("");
        JTextFieldDate.setName(""); // NOI18N

        jLabel3.setText("Клиент:");

        jButtonOk.setText("OK");
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });

        jLabel2.setText("Дата:");

        clientId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Доктор:");

        doctorId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Статус заказа:");

        recordstatusId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(recordstatusId, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(40, 40, 40)
                                .addComponent(doctorId, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonOk)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(clientId, 0, 174, Short.MAX_VALUE)
                                    .addComponent(JTextFieldDate))))))
                .addGap(128, 128, 128))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTextFieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clientId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(doctorId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(recordstatusId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonOk)
                .addContainerGap(145, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed

        if (!check()) {
            return;
        }
        try {
            RecordModel dm = new RecordModel(c);
            dm.insertOrUpdate(editItem, id,JTextFieldDate.getText(), ((Client)clientId.getSelectedItem()).getId(),((Doctor)doctorId.getSelectedItem()).getId(),((RecordStatus) recordstatusId.getSelectedItem()).getId());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            return;
        }
        dispose();
    }//GEN-LAST:event_jButtonOkActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTextFieldDate;
    private javax.swing.JComboBox<String> clientId;
    private javax.swing.JComboBox<String> doctorId;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JComboBox<String> recordstatusId;
    // End of variables declaration//GEN-END:variables
}
