/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg260javaapp;

import java.util.ArrayList;
import java.sql.Date;

/**
 *
 * @author Robert
 */
public class AdvisorController {
    ArrayList members = new ArrayList();
    
    public ArrayList getMembers(){
        return members;
    }
    
    public void setMembers(ArrayList aList){
        members = aList;
    }
    
    public void register(int id, String firstName, String lastName, String email, String contact, String membership, Date regDate){
        
        Member member = new Member();
        member.setID(id);
        member.setFirstName(firstName);
        member.setLastName(lastName);
        member.setEmail(email);
        member.setContact(contact);
        member.setMembership(membership);
        member.setRegDate(regDate);
        
        members.add(member);
    }
    
    public String viewMembers(){
        String text = "";
        
        for (int i = 0; i<members.size(); i++){
            Member temp = (Member)members.get(i);
            String data = "\n Member ID: " + temp.getID() 
                    + "\n\t Name: " + temp.getFirstName() + " " + temp.getLastName() 
                    + "\n\t Email: " + temp.getEmail()
                    + "\n\t Contact Number: " + temp.getContact()
                    + "\n\t Membership type: " + temp.getMembership()
                    + "\n\t Date of registration: " + temp.getRegDate()
                    + ";\n\n";
            text = text + data;
        }
        return text;
    }
    
    
    
    
}
