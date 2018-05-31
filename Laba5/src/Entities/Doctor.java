
package Entities;

/**
 *
 * @author Sofia
 */
public class Doctor {
    private final int id;
    private String fullName;
    private final int specializationId;
    private String description;
    
    public Doctor(int id,String fullName,int specializationId, String description){
        this.id=id;
        this.fullName=fullName;
        this.specializationId=specializationId;
        this.description = description;
    }
    
    public int getId(){
        return id;
    }
    
    public String getFullName(){
        return fullName;
    }
    
    public void setFullName(String fullName){
        this.fullName=fullName;
    }
    
    public int getSpecializationId(){
        return specializationId;
    }
    
    public String getDescription(){
        return description;
    }
    
    @Override
    public String toString(){
        return fullName;
    }
}
