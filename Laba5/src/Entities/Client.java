/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Sofia
 */
//@Entity
public class Client implements Serializable {
    private final int id;
    private String fullName;
    private int phoneNumber;
    
    public Client(int id,String fullName,int phoneNumber){
        this.id=id;
        this.fullName=fullName;
        this.phoneNumber=phoneNumber;
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
    
    public int getPhoneNumber(){
        return phoneNumber;
    }
    
    public void setPhoneNumber(int phoneNumber){
        this.phoneNumber=phoneNumber;
    }
    
    @Override
    public String toString(){
        return fullName;
    }
}
