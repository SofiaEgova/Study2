
package Entities;

/**
 *
 * @author Sofia
 */
public class RecordStatus {
    private final int id;
    private String name;
    
    public RecordStatus(int id, String name){
        this.id = id;
        this.name=name;
    }
    
    public int getId(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    @Override
    public String toString(){
        return name;
    }
}
