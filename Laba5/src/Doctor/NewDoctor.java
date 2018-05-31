
package Doctor;

import Entities.Doctor;
import Entities.Specialization;
import Specialization.SpecializationModel;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Sofia
 */
public class NewDoctor extends javax.swing.JDialog {

    Connection c;
    Doctor editItem;
    List<Doctor> list;
    int id;
    
    public NewDoctor(java.awt.Frame parent, boolean modal, Connection c , int id ) throws SQLException {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.c = c;
        this.id = id;
        list = new ArrayList<>();
        specializationId.setModel(new DefaultComboBoxModel(SpecializationModel.selectSpecializations(c).toArray())); 
    }
    
    public NewDoctor(java.awt.Frame parent, boolean modal, Connection c, Doctor u) throws SQLException {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        id=u.getId();
        this.c = c;
        editItem = u;
        list = new ArrayList<>();
        specializationId.setModel(new DefaultComboBoxModel(SpecializationModel.selectSpecializations(c).toArray())); 
        fillFields();
    }

    private void fillFields() {
        JTextFieldFullName.setText(editItem.getFullName());
        for (Doctor d : list) {
            if (d.getId()== editItem.getSpecializationId()) {
                specializationId.setSelectedItem(d);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JTextFieldFullName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButtonOk = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        specializationId = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        JTextFieldFullName.setToolTipText("");
        JTextFieldFullName.setName(""); // NOI18N

        jLabel3.setText("Специализация:");

        jButtonOk.setText("OK");
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });

        jLabel2.setText("ФИО:");

        specializationId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonOk)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(specializationId, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JTextFieldFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 16, Short.MAX_VALUE))
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
                    .addComponent(specializationId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonOk)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public boolean check() {
       
        if ("".equals(JTextFieldFullName.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Неверно введено ФИО");
            return false;
        }
        if(specializationId.getSelectedItem()==null){
            JOptionPane.showMessageDialog(new JFrame(), "Не выбрана специализация");
            return false;
        }
        return true;
    }
    
    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed

        if (!check()) {
            return;
        }
        try {
            DoctorModel dm = new DoctorModel(c);
            dm.insertOrUpdate(editItem, id,JTextFieldFullName.getText(), ((Specialization) specializationId.getSelectedItem()).getId());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            return;
        }
        dispose();
    }//GEN-LAST:event_jButtonOkActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTextFieldFullName;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox<String> specializationId;
    // End of variables declaration//GEN-END:variables
}
