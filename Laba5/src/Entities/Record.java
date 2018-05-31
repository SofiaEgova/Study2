
package Entities;

import java.sql.Date;

/**
 *
 * @author Sofia
 */
public class Record {
    private final int id;
    private String date;
    private final int clientId;
    private final int doctorId;
    private final int recordstatusId;
    
    public Record(int id,String date,int clientId, int doctorId,int recordstatusId){
        this.id=id;
        this.date=date;
        this.clientId=clientId;
        this.doctorId=doctorId;
        this.recordstatusId=recordstatusId;
    }
    
    public int getId(){
        return id;
    }
    
    public String getDate(){
        return date;
    }
    
    public void setDate(String date){
        this.date=date;
    }
    
    public int getClientId(){
        return clientId;
    }
    
    public int getDoctorId(){
        return doctorId;
    }
    
    public int getRecordStatusId(){
        return recordstatusId;
    }
}
