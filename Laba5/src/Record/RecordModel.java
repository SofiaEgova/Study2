
package Record;

import Entities.Record;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Sofia
 */
public class RecordModel extends AbstractTableModel {
        final static String selectStr="SELECT * FROM record";
        final static String selectByIdStr = "SELECT * FROM record record_id =?;";
        final String insertStr = "insert into record (record_id,date,client_id,doctor_id,recordstatus_id) values (?,?,?,?,?)";
        final String deleteStr = "delete from record where doctor_id=?";          
        final String updateStr = "update record set date=?,client_id=?,doctor_id=?,recordstatus_id=? where record_id=? ";
        
    List<Record> list = new ArrayList<>();

    Connection c;
    
    public RecordModel(Connection c) throws SQLException {
        super();
        this.c = c;
        list = selectRecords(c);
        rowsCount = list.size();
    }

    public void updateData() throws SQLException {
        list = new ArrayList<>();
        list = selectRecords(c);
        rowsCount = list.size();
    }
    
    int rowsCount = 5;
    int colCount = 5;
    
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
                return list.get(rowIndex).getDate();
            case 2:
                return list.get(rowIndex).getClientId();
            case 3:
                return list.get(rowIndex).getDoctorId();
            case 4:
                return list.get(rowIndex).getRecordStatusId();
            
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "record_id";
            case 1:
                return "date";
            case 2:
                return "client_id";
            case 3:
                return "doctor_id";
            case 4:
                return "recordstatus_id";

        }
        return null;
    }

    public Record getSelectesItem(int row) {
        return list.get(row);
    }

    public static List<Record> selectRecords(Connection c) throws SQLException{
       PreparedStatement statement = c.prepareStatement(selectStr);
       ResultSet rs = statement.executeQuery();
        List<Record> records = new ArrayList<>(); 
        while (rs.next()) {
            Record item = new Record(rs.getInt("record_id"), rs.getString("date"), rs.getInt("client_id"), rs.getInt("doctor_id"), rs.getInt("recordstatus_id"));
            records.add(item);
        }
        return records;
    }
    
    public static List<Integer> selectIdRecords(Connection c) throws SQLException{
       PreparedStatement statement = c.prepareStatement(selectStr);
       ResultSet rs = statement.executeQuery();
        List<Integer> records = new ArrayList<>(); 
        while (rs.next()) {
            records.add(rs.getInt("doctor_id"));
        }
        return records;
    }
    
    public static Record selectRecordById(Connection c, int id) throws SQLException{
    PreparedStatement statement = c.prepareStatement(selectByIdStr);
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
        Record records = null;
            while (rs.next()) {
             Record item = new Record(rs.getInt("record_id"), rs.getString("date"), rs.getInt("client_id"), rs.getInt("doctor_id"), rs.getInt("recordstatus_id"));
            }
        return records;
    }
    
    public void insertOrUpdate(Record editItem,int recordId,String date, int clientId, int doctorId, int recordstatusId) {
       try {
            if (editItem == null) {
                PreparedStatement statement = c.prepareStatement(insertStr);
                statement.setInt(1, recordId);
                statement.setString(2, date);
                statement.setInt(3, clientId);
                statement.setInt(4, doctorId);
                statement.setInt(5, recordstatusId);
                statement.execute();    
            } else {
                PreparedStatement statement = c.prepareStatement(updateStr);
                statement.setString(1, date);
                statement.setInt(2, clientId);
                statement.setInt(3, doctorId);
                statement.setInt(4, recordstatusId);
                statement.setInt(5, recordId);
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
