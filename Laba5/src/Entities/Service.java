
package Entities;

/**
 *
 * @author Sofia
 */
public class Service {
    private final int id;
    private String name;
    private String description;
    private final int doctorId;
    
    public Service(int id,String name,String description,int doctorId){
        this.id=id;
        this.name=name;
        this.description=description;
        this.doctorId=doctorId;
    }
    
    public int getId(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name=name;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void setDescription(String description){
        this.description=description;
    }
    public int getDoctorId(){
        return doctorId;
    }
}
