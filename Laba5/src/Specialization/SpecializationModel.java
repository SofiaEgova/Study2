
package Specialization;

import Entities.Specialization;
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
public class SpecializationModel extends AbstractTableModel {
        final static String selectStr="SELECT * FROM specialization";
        final static String selectByIdStr = "SELECT * FROM specialization specialization_id =?;";
        final String insertStr = "insert into specialization (specialization_id,description) values (?,?)";
        final String deleteStr = "delete from specialization where specialization_id=?";          
        final String updateStr = "update specialization set descroption=? where specialization_id=? ";
        
    List<Specialization> list = new ArrayList<>();

    Connection c;
    
    public SpecializationModel(Connection c) throws SQLException {
        super();
        this.c = c;
        list = selectSpecializations(c);
        rowsCount = list.size();
    }

    public void updateData() throws SQLException {
        list = new ArrayList<>();
        list = selectSpecializations(c);
        rowsCount = list.size();
    }
    
    int rowsCount = 3;
    int colCount = 2;
    
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
                return list.get(rowIndex).getDescription();
            
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "specialization_id";
            case 1:
                return "description";

        }
        return null;
    }

    public Specialization getSelectesItem(int row) {
        return list.get(row);
    }

    public static List<Specialization> selectSpecializations(Connection c) throws SQLException{
       PreparedStatement statement = c.prepareStatement(selectStr);
       ResultSet rs = statement.executeQuery();
        List<Specialization> specializations = new ArrayList<>(); 
        while (rs.next()) {
            Specialization item = new Specialization(rs.getInt("specialization_id"), rs.getString("description"));
            specializations.add(item);
        }
        return specializations;
    }
    
    public static List<Integer> selectIdSpecializations(Connection c) throws SQLException{
       PreparedStatement statement = c.prepareStatement(selectStr);
       ResultSet rs = statement.executeQuery();
        List<Integer> specializations = new ArrayList<>(); 
        while (rs.next()) {
            specializations.add(rs.getInt("specialization_id"));
        }
        return specializations;
    }
    
//    public static Specialization selectSpecializationById(Specialization c, int id) throws SQLException{
//    PreparedStatement statement = c.prepareStatement(selectByIdStr);
//        statement.setInt(1, id);
//        ResultSet rs = statement.executeQuery();
//        Specialization specializations = null;
//            while (rs.next()) {
//                specializations = new Specialization(rs.getInt("specialization_id"), rs.getString("description"));
//            }
//        return specializations;
//    }
    
    public void insertOrUpdate(Specialization editItem,int specializationId,String description) {
       try {
            if (editItem == null) {
                PreparedStatement statement = c.prepareStatement(insertStr);
                statement.setInt(1, specializationId);
                statement.setString(2, description);
                statement.execute();    
            } else {
                PreparedStatement statement = c.prepareStatement(updateStr);
                statement.setString(1, description);
                statement.setInt(2, specializationId);
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
