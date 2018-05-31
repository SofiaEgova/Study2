
package Entities;

import java.sql.PreparedStatement;

/**
 *
 * @author Sofia
 */
public class Specialization {
    private final int id;
    private String description;
    
    public Specialization(int id, String description){
        this.id = id;
        this.description=description;
    }
    
    public int getId(){
        return id;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void setDescription(String description){
        this.description=description;
    }
    
    @Override
    public String toString(){
        return description;
    }
}
