
package Specialization;

import Entities.Specialization;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Sofia
 */
public class NewSpecialization extends javax.swing.JDialog {

    Connection c;
    Specialization editItem;
    List<Specialization> list;
    int id;
    
    
    public NewSpecialization(java.awt.Frame parent, boolean modal, Connection c , int id ) throws SQLException {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.c = c;
        this.id = id;
        list = new ArrayList<>();
        
    }

    public NewSpecialization(java.awt.Frame parent, boolean modal, Connection c, Specialization u) throws SQLException {
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
        JTextFieldDescription.setText(editItem.getDescription());
    }

    public boolean check() {
       
        if ("".equals(JTextFieldDescription.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Неверно введено описание");
            return false;
        } 
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        JTextFieldDescription = new javax.swing.JTextField();
        jButtonOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel3.setText("Описание:");

        JTextFieldDescription.setToolTipText("");
        JTextFieldDescription.setName(""); // NOI18N

        jButtonOk.setText("OK");
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(JTextFieldDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonOk)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTextFieldDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
            SpecializationModel sm = new SpecializationModel(c);
            sm.insertOrUpdate(editItem, id,JTextFieldDescription.getText());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            return;
        }
        dispose();
    }//GEN-LAST:event_jButtonOkActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTextFieldDescription;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
