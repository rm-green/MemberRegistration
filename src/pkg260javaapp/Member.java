/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg260javaapp;

import java.sql.Date;

/**
 *
 * @author Robert
 */
public class Member {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String contact;
    private String membership;
    private Date regDate;
    
    public int getID(){
        return id;
    }
    
    public void setID(int aID){
        id = aID;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public void setFirstName(String aFirstName){
        firstName = aFirstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public void setLastName(String aLastName){
        lastName = aLastName;
    }
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String aEmail){
        email = aEmail;
    }
    
    public String getContact(){
        return contact;
    }
    
    public void setContact(String aContact){
        contact = aContact;
    }
    
    public String getMembership(){
        return membership;
    }
    
    public void setMembership(String aMembership){
        membership = aMembership;
    }
    
    public Date getRegDate(){
        return regDate;
    }
    
    public void setRegDate(Date aRegDate){
        regDate = aRegDate;
    }
 
}
