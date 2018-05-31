/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Client.Clients;
import Doctor.Doctors;
import Record.Records;
import Service.Services;
import RecordStatus.RecordStatuses;
import Specialization.Specializations;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Sofia
 */
public class Main extends javax.swing.JFrame {

    Connection connection = null;
    
    public Main() {
        initComponents();
        NewConnect nc = new NewConnect(this, true);
        nc.setVisible(true);
        if (nc.isConnect) {
            connection = nc.getConnection();
        }
        try {
            if (connection != null) {
                DatabaseMetaData dmd = connection.getMetaData();
                String url = dmd.getURL();
                jTextFieldStatus.setText("Подключено к базе данных " 
                        + url.substring(url.lastIndexOf("/") + 1));
            } else {
                jTextFieldStatus.setText("No connection");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldStatus = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        NewConnectionMenu = new javax.swing.JMenuItem();
        DisconnectMenu = new javax.swing.JMenuItem();
        ExitMenu = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        ClientsMenu = new javax.swing.JMenuItem();
        DoctorsMenu = new javax.swing.JMenuItem();
        ServicesMenu = new javax.swing.JMenuItem();
        SpecializationsMenu = new javax.swing.JMenuItem();
        RecordsMenu = new javax.swing.JMenuItem();
        RecordStatusesMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextFieldStatus.setEnabled(false);

        jLabel1.setText("Статус:");

        jMenu1.setText("Подключение к БД");

        NewConnectionMenu.setText("Новое подключение");
        NewConnectionMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewConnectionMenuActionPerformed(evt);
            }
        });
        jMenu1.add(NewConnectionMenu);

        DisconnectMenu.setText("Отключиться");
        DisconnectMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DisconnectMenuActionPerformed(evt);
            }
        });
        jMenu1.add(DisconnectMenu);

        ExitMenu.setText("Выход");
        ExitMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitMenuActionPerformed(evt);
            }
        });
        jMenu1.add(ExitMenu);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Справочники");

        ClientsMenu.setText("Клиенты");
        ClientsMenu.setName("ClientsMenu"); // NOI18N
        ClientsMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClientsMenuActionPerformed(evt);
            }
        });
        jMenu2.add(ClientsMenu);

        DoctorsMenu.setText("Доктора");
        DoctorsMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DoctorsMenuActionPerformed(evt);
            }
        });
        jMenu2.add(DoctorsMenu);

        ServicesMenu.setText("Услуги");
        ServicesMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ServicesMenuActionPerformed(evt);
            }
        });
        jMenu2.add(ServicesMenu);

        SpecializationsMenu.setText("Специализации");
        SpecializationsMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SpecializationsMenuActionPerformed(evt);
            }
        });
        jMenu2.add(SpecializationsMenu);

        RecordsMenu.setText("Записи");
        RecordsMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecordsMenuActionPerformed(evt);
            }
        });
        jMenu2.add(RecordsMenu);

        RecordStatusesMenu.setText("Статусы записи");
        RecordStatusesMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecordStatusesMenuActionPerformed(evt);
            }
        });
        jMenu2.add(RecordStatusesMenu);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NewConnectionMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewConnectionMenuActionPerformed

        NewConnect nc = new NewConnect(this, true);
        nc.setVisible(true);
        if (nc.isConnect) {
            connection = nc.getConnection();
        }
        try {
            if (connection != null) {
                DatabaseMetaData dmd = connection.getMetaData();
                String url = dmd.getURL();
                jTextFieldStatus.setText("Подключено к базе данных: "
                    + url.substring(url.lastIndexOf("/") + 1));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    }//GEN-LAST:event_NewConnectionMenuActionPerformed

    private void DisconnectMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DisconnectMenuActionPerformed

        try {
            connection.close();
            JOptionPane.showMessageDialog(new JFrame(), "Соединение прервано");
            connection = null;
            jTextFieldStatus.setText("Нет соединения");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    }//GEN-LAST:event_DisconnectMenuActionPerformed

    private void ExitMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitMenuActionPerformed

        dispose();
        System.exit(0);
    }//GEN-LAST:event_ExitMenuActionPerformed

    private void ClientsMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClientsMenuActionPerformed

        if (connection != null) {
            try {
                Clients clients = new Clients(this, true, connection);
                clients.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "No connection");
        }
    }//GEN-LAST:event_ClientsMenuActionPerformed

    private void DoctorsMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DoctorsMenuActionPerformed

        if (connection != null) {
            Doctors d;
            try {
                d = new Doctors(this, true, connection);
                d.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "No connection");
        }
    }//GEN-LAST:event_DoctorsMenuActionPerformed

    private void ServicesMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ServicesMenuActionPerformed

        if (connection != null) {
            try {
                Services s = new Services(this, true, connection);
                s.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "No connection");
        }
    }//GEN-LAST:event_ServicesMenuActionPerformed

    private void SpecializationsMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SpecializationsMenuActionPerformed

        if (connection != null) {
            try {
                Specializations s = new Specializations(this, true, connection);
                s.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "No connection");
        }
    }//GEN-LAST:event_SpecializationsMenuActionPerformed

    private void RecordsMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecordsMenuActionPerformed

        if (connection != null) {
            try {
                Records su = new Records(this, true, connection);
                su.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "No connection");
        }
    }//GEN-LAST:event_RecordsMenuActionPerformed

    private void RecordStatusesMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecordStatusesMenuActionPerformed
                if (connection != null) {
            try {
                RecordStatuses su = new RecordStatuses(this, true, connection);
                su.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "No connection");
        }
    }//GEN-LAST:event_RecordStatusesMenuActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Sofia".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException 
                | IllegalAccessException 
                | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ClientsMenu;
    private javax.swing.JMenuItem DisconnectMenu;
    private javax.swing.JMenuItem DoctorsMenu;
    private javax.swing.JMenuItem ExitMenu;
    private javax.swing.JMenuItem NewConnectionMenu;
    private javax.swing.JMenuItem RecordStatusesMenu;
    private javax.swing.JMenuItem RecordsMenu;
    private javax.swing.JMenuItem ServicesMenu;
    private javax.swing.JMenuItem SpecializationsMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JTextField jTextFieldStatus;
    // End of variables declaration//GEN-END:variables
}
