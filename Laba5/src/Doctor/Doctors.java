
package Doctor;

import Main.Main;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sofia
 */
public class Doctors extends javax.swing.JDialog {

    Connection connection;
    DoctorModel model;
    int columnWidth=50;
    static int currentIdDoctor;
    
    public Doctors(java.awt.Frame parent, boolean modal, Connection c) throws SQLException {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        connection = c;
        currentIdDoctor = DoctorModel.selectDoctors(c).size()+1;
        model = new DoctorModel(connection);
        jTable1.setModel(model);
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonADD = new javax.swing.JButton();
        jButtonALTER = new javax.swing.JButton();
        jButtonDELETE = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonADD.setText("ADD");
        jButtonADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonADDActionPerformed(evt);
            }
        });

        jButtonALTER.setText("ATLER");
        jButtonALTER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonALTERActionPerformed(evt);
            }
        });

        jButtonDELETE.setText("DELETE");
        jButtonDELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDELETEActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonADD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonALTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonDELETE, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonADD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonALTER)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDELETE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(126, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonADDActionPerformed

        try {
            NewDoctor nd = new NewDoctor((Frame) this.getParent(), true, connection,currentIdDoctor);
            nd.setVisible(true);
            model.updateData();
            currentIdDoctor++;
        } catch (SQLException ex) {
            Logger.getLogger(Doctors.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((AbstractTableModel) jTable1.getModel()).fireTableDataChanged();
    }//GEN-LAST:event_jButtonADDActionPerformed

    private void jButtonALTERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonALTERActionPerformed
        try { if (jTable1.getSelectedRow() >= 0) {
            NewDoctor nd = new NewDoctor((Frame) this.getParent(), true,
                connection, model.getSelectesItem(jTable1.getSelectedRow()));
            nd.setVisible(true);
            model.updateData();
            ((AbstractTableModel) jTable1.getModel()).fireTableDataChanged();
        }
        } catch (SQLException ex) {
            Logger.getLogger(Doctors.class.getName()).log(Level.SEVERE, null, ex);

        }
    }//GEN-LAST:event_jButtonALTERActionPerformed

    private void jButtonDELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDELETEActionPerformed
        if (jTable1.getSelectedRow() >= 0) {
            model.delete(model.getSelectesItem(jTable1.getSelectedRow()).getId());
        }
        try {
            model.updateData();
        } catch (SQLException ex) {
            Logger.getLogger(Doctors.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((AbstractTableModel) jTable1.getModel()).fireTableDataChanged();
    }//GEN-LAST:event_jButtonDELETEActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonADD;
    private javax.swing.JButton jButtonALTER;
    private javax.swing.JButton jButtonDELETE;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
