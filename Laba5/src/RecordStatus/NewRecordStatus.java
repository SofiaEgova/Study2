
package RecordStatus;

import java.sql.Connection;
import Entities.RecordStatus;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Sofia
 */
public class NewRecordStatus extends javax.swing.JDialog {

    Connection c;
    RecordStatus editItem;
    List<RecordStatus> list;
    int id;
    
    public NewRecordStatus(java.awt.Frame parent, boolean modal, Connection c , int id ) throws SQLException {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.c = c;
        this.id = id;
        list = new ArrayList<>();
    }
    
    public NewRecordStatus(java.awt.Frame parent, boolean modal, Connection c, RecordStatus u) throws SQLException {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.c = c;
        this.id=u.getId();
        editItem = u;
        list = new ArrayList<>();
        fillFields();
    }

    private void fillFields() {
        JTextFieldDescription.setText(editItem.getName());
    }                   

    public boolean check() {
       
        if ("".equals(JTextFieldDescription.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Неверно введено имя");
            return false;
        }
        return true;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonOk = new javax.swing.JButton();
        JTextFieldDescription = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonOk.setText("OK");
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });

        JTextFieldDescription.setToolTipText("");
        JTextFieldDescription.setName(""); // NOI18N

        jLabel4.setText("Описание:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonOk)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(JTextFieldDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTextFieldDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            RecordStatusModel dm = new RecordStatusModel(c);
            dm.insertOrUpdate(editItem, id,JTextFieldDescription.getText());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            return;
        }
        dispose();
    }//GEN-LAST:event_jButtonOkActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTextFieldDescription;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
