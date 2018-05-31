
package Doctor;

import Entities.Doctor;
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

/**
 *
 * @author Sofia
 */
public class DoctorModel extends AbstractTableModel {
        final static String selectStr="SELECT t.doctor_id as doctor_id, t.full_name as full_name, t.specialization_id as specialization_id, s.description as description FROM doctor t join specialization s on t.specialization_id = s.specialization_id";
        final static String selectByIdStr = "SELECT * FROM doctor doctor_id =?;";
        final String insertStr = "insert into doctor (doctor_id,full_name,specialization_id) values (?,?,?)";
        final String deleteStr = "delete from doctor where doctor_id=?";          
        final String updateStr = "update doctor set full_name=?,specialization_id=? where doctor_id=? ";
        
    List<Doctor> list = new ArrayList<>();

    Connection c;
    
    public DoctorModel(Connection c) throws SQLException {
        super();
        this.c = c;
        list = selectDoctors(c);
        rowsCount = list.size();
    }

    public void updateData() throws SQLException {
        list = new ArrayList<>();
        list = selectDoctors(c);
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
                return list.get(rowIndex).getSpecializationId();
            
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "doctor_id";
            case 1:
                return "full_name";
            case 2:
                return "specialization_id";

        }
        return null;
    }

    public Doctor getSelectesItem(int row) {
        return list.get(row);
    }

    public static List<Doctor> selectDoctors(Connection c) throws SQLException{
       PreparedStatement statement = c.prepareStatement(selectStr);
       ResultSet rs = statement.executeQuery();
        List<Doctor> doctors = new ArrayList<>(); 
        while (rs.next()) {
            Doctor item = new Doctor(rs.getInt("doctor_id"), rs.getString("full_name"), rs.getInt("specialization_id"), rs.getString("description"));
            doctors.add(item);
        }
        return doctors;
    }
    
    public static List<Integer> selectIdDoctors(Connection c) throws SQLException{
       PreparedStatement statement = c.prepareStatement(selectStr);
       ResultSet rs = statement.executeQuery();
        List<Integer> doctors = new ArrayList<>(); 
        while (rs.next()) {
            doctors.add(rs.getInt("doctor_id"));
        }
        return doctors;
    }
    
    public static Doctor selectDoctorById(Connection c, int id) throws SQLException{
    PreparedStatement statement = c.prepareStatement(selectByIdStr);
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
        Doctor doctors = null;
            while (rs.next()) {
            doctors = new Doctor(rs.getInt("doctor_id"), rs.getString("full_name"), rs.getInt("specialization_id"), rs.getString("description"));
            }
        return doctors;
    }
    
    public void insertOrUpdate(Doctor editItem,int doctorId,String fullName, int specializationId) {
       try {
            if (editItem == null) {
                PreparedStatement statement = c.prepareStatement(insertStr);
                statement.setInt(1, doctorId);
                statement.setString(2, fullName);
                statement.setInt(3, specializationId);
                statement.execute();    
            } else {
                PreparedStatement statement = c.prepareStatement(updateStr);
                statement.setString(1, fullName);
                statement.setInt(2, specializationId);
                statement.setInt(3, doctorId);
                statement.executeUpdate();
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
