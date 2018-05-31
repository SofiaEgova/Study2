package Client;

import Entities.Client;
import Client.NewClient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class ClientModel extends AbstractTableModel {
        final static String selectStr="SELECT * FROM client";
        final static String selectByIdStr = "SELECT * FROM client WHERE client_id =?;";
        final String insertStr = "insert into client (client_id,full_name,phone_number) values (?,?,?)";
        final String deleteStr = "delete from client where client_id=?";          
        final String updateStr = "update client set full_name=?,phone_number=? where client_id=? ";
        
    List<Client> list = new ArrayList<>();

    Connection c;
    
    public ClientModel(Connection c) throws SQLException {
        super();
        this.c = c;
        list = selectClients(c);
        rowsCount = list.size();
    }

    public void updateData() throws SQLException {
        list = new ArrayList<>();
        list = selectClients(c);
        rowsCount = list.size();
    }
    
    int rowsCount = 3;
    int colCount = 3;
    
    @Override
    public int getRowCount() {
        return rowsCount;
    }

    @Override
    public int getColumnCount() {
        return colCount;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getId();
            case 1:
                return list.get(rowIndex).getFullName();
            case 2:
                return list.get(rowIndex).getPhoneNumber();
            
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "client_id";
            case 1:
                return "full_name";
            case 2:
                return "phone_number";

        }
        return null;
    }

    public Client getSelectesItem(int row) {
        return list.get(row);
    }

    public static List<Client> selectClients(Connection c) throws SQLException{
       PreparedStatement statement = c.prepareStatement(selectStr);
       ResultSet rs = statement.executeQuery();
        List<Client> clients = new ArrayList<>(); 
        while (rs.next()) {
            Client item = new Client(rs.getInt("client_id"), rs.getString("full_name"), rs.getInt("phone_number"));
            clients.add(item);
        }
        return clients;
    }
    
    
    public static List<Integer> selectIdClients(Connection c) throws SQLException{
       PreparedStatement statement = c.prepareStatement(selectStr);
       ResultSet rs = statement.executeQuery();
        List<Integer> clients = new ArrayList<>(); 
        while (rs.next()) {
            clients.add(rs.getInt("client_id"));
        }
        return clients;
    }
    
    public static Client selectClientById(Connection c, int id) throws SQLException{
    PreparedStatement statement = c.prepareStatement(selectByIdStr);
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
        Client clients = null;
            while (rs.next()) {
            clients = new Client(rs.getInt("client_id"), rs.getString("full_name"), rs.getInt("phone_number"));
            }
        return clients;
    }
    
    public void insertOrUpdate(Client editItem,int clientId,String fullName, int phoneNumber) {
       try {
            if (editItem == null) {
                PreparedStatement statement = c.prepareStatement(insertStr);
                statement.setInt(1, clientId);
                statement.setString(2, fullName);
                statement.setInt(3, phoneNumber);
                statement.execute();    
            } else {
                PreparedStatement statement = c.prepareStatement(updateStr);
                statement.setString(1, fullName);
                statement.setInt(2, phoneNumber);
                statement.setInt(3, clientId);
                statement.execute();   
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    } 
    
    public void delete(int id){
         try {   
            PreparedStatement statement = c.prepareStatement(deleteStr);
            statement.setInt(1, id);
            statement.execute();    
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            }
    }
}
