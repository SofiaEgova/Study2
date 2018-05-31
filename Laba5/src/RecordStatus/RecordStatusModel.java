
package RecordStatus;

import Entities.RecordStatus;
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
public class RecordStatusModel extends AbstractTableModel {
        final static String selectStr="SELECT * FROM recordstatus";
        final static String selectByIdStr = "SELECT * FROM recordstatus WHERE recordstatus_id =?;";
        final String insertStr = "insert into recordstatus (recordstatus_id,name) values (?,?)";
        final String deleteStr = "delete from recordstatus where recordstatus_id=?";          
        final String updateStr = "update recordstatus set name=? where recordstatus_id=? ";
        
    List<RecordStatus> list = new ArrayList<>();

    Connection c;
    
    public RecordStatusModel(Connection c) throws SQLException {
        super();
        this.c = c;
        list = selectRecordStatuses(c);
        rowsCount = list.size();
    }

    public void updateData() throws SQLException {
        list = new ArrayList<>();
        list = selectRecordStatuses(c);
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
                return list.get(rowIndex).getName();
            
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "record_status_id";
            case 1:
                return "name";

        }
        return null;
    }

    public RecordStatus getSelectesItem(int row) {
        return list.get(row);
    }

    public static List<RecordStatus> selectRecordStatuses(Connection c) throws SQLException{
       PreparedStatement statement = c.prepareStatement(selectStr);
       ResultSet rs = statement.executeQuery();
        List<RecordStatus> recordStatuses = new ArrayList<>(); 
        while (rs.next()) {
            RecordStatus item = new RecordStatus(rs.getInt("recordstatus_id"), rs.getString("name"));
            recordStatuses.add(item);
        }
        return recordStatuses;
    }
    
    public static List<Integer> selectIdRecordStatuses(Connection c) throws SQLException{
       PreparedStatement statement = c.prepareStatement(selectStr);
       ResultSet rs = statement.executeQuery();
        List<Integer> recordStatuses = new ArrayList<>(); 
        while (rs.next()) {
            recordStatuses.add(rs.getInt("recordstatus_id"));
        }
        return recordStatuses;
    }
    
    public static RecordStatus selectRecordStatusById(Connection c, int id) throws SQLException{
    PreparedStatement statement = c.prepareStatement(selectByIdStr);
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
        RecordStatus services = null;
            while (rs.next()) {
            RecordStatus item = new RecordStatus(rs.getInt("recordstatus_id"), rs.getString("name"));
            }
        return services;
    }
    
    public void insertOrUpdate(RecordStatus editItem,int recordStatusId,String name) {
       try {
            if (editItem == null) {
                PreparedStatement statement = c.prepareStatement(insertStr);
                statement.setInt(1, recordStatusId);
                statement.setString(2, name);
                statement.execute();    
            } else {
                PreparedStatement statement = c.prepareStatement(updateStr);
                statement.setString(1, name);
                 statement.setInt(2, recordStatusId);
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
