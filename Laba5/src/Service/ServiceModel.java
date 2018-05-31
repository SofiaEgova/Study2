
package Service;

import Entities.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sofia
 */
public class ServiceModel extends AbstractTableModel {
        final static String selectStr="SELECT * FROM service";
        final static String selectByIdStr = "SELECT * FROM service WHERE service_id =?;";
        final String insertStr = "insert into service (service_id,name,description,doctor_id) values (?,?,?,?)";
        final String deleteStr = "delete from service where service_id=?";          
        final String updateStr = "update service set name=?,description=?,doctor_id=? where service_id=? ";
        
    List<Entities.Service> list = new ArrayList<>();

    Connection c;
    
    public ServiceModel(Connection c) throws SQLException {
        super();
        this.c = c;
        list = selectServices(c);
        rowsCount = list.size();
    }

    public void updateData() throws SQLException {
        list = new ArrayList<>();
        list = selectServices(c);
        rowsCount = list.size();
    }
    
    int rowsCount = 3;
    int colCount = 4;
    
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
                return list.get(rowIndex).getName();
            case 2:
                return list.get(rowIndex).getDescription();
            case 3:
                return list.get(rowIndex).getDoctorId();
            
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "service_id";
            case 1:
                return "name";
            case 2:
                return "description";
            case 3:
                return "doctor_id";

        }
        return null;
    }

    public Service getSelectesItem(int row) {
        return list.get(row);
    }

    public static List<Service> selectServices(Connection c) throws SQLException{
       java.sql.PreparedStatement statement = c.prepareStatement(selectStr);
       ResultSet rs = statement.executeQuery();
        List<Service> services = new ArrayList<>(); 
        while (rs.next()) {
            Service item = new Service(rs.getInt("service_id"), rs.getString("name"), rs.getString("description"),rs.getInt("doctor_id"));
            services.add(item);
        }
        return services;
    }
    
    public static Service selectServicesById(Connection c, int id) throws SQLException{
    PreparedStatement statement = c.prepareStatement(selectByIdStr);
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
        Service services = null;
            while (rs.next()) {
            Service item = new Service(rs.getInt("service_id"), rs.getString("name"), rs.getString("description"),rs.getInt("doctor_id"));
            }
        return services;
    }
    
    public void insertOrUpdate(Service editItem,int serviceId,String name, String description,int doctor_id) {
       try {
            if (editItem == null) {
                PreparedStatement statement = c.prepareStatement(insertStr);
                statement.setInt(1, serviceId);
                statement.setString(2, name);
                statement.setString(3, description);
                statement.setInt(4, doctor_id);
                statement.execute();    
            } else {
                PreparedStatement statement = c.prepareStatement(updateStr);
                statement.setString(1, name);
                 statement.setString(2, description);
                statement.setInt(3, doctor_id);
                statement.setInt(4, serviceId);
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
