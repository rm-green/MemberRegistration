/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg260javaapp;

import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author Robert
 */
public class MemberRepo implements Repo {
    private ArrayList<Member> members;
    
    @Override
    public ArrayList read(Connection connection){
        ArrayList temp = new ArrayList();
        System.out.println("Reading from database...");
        try(Statement state = connection.createStatement();) {
            ResultSet results;
            String query = "SELECT * FROM APP.MEMBERS";
            results = state.executeQuery(query);

            while(results.next()){
                Member member = new Member();
                member.setID(results.getInt("ID"));
                member.setFirstName(results.getString("FIRSTNAME"));
                member.setLastName(results.getString("LASTNAME"));
                member.setEmail(results.getString("EMAIL"));
                member.setContact(results.getString("CONTACT"));
                member.setMembership(results.getString("MEMBERSHIP"));
                member.setRegDate(results.getDate("REGDATE"));
                temp.add(member);
            }
            System.out.println("Read from database successfully");
            results.close();
            state.close();
            
        } 
        catch (SQLException e){
            System.out.println("SQL Exception in Repo read function");
            System.out.println(e);
        }
        
        members = temp;
        return members;
    }
    
    @Override
    public void write(Connection connection, ArrayList members){
        System.out.println("Writing to database...");
        System.out.println("Records entered in: " + members.size());
        
        Statement state;
        
        try {
            state = connection.createStatement();
            String query = "DELETE FROM APP.MEMBERS";
            state.executeUpdate(query);
            
            state.close();
        }
        catch (SQLException e){
            System.out.println("SQL Exception in Repo write() function: deleting from members");
            System.out.println(e);
        }
        
        for (int i = 0; i<members.size(); i++){
            Member member = (Member)members.get(i);
            try (PreparedStatement pstate = connection.prepareStatement(
                    "INSERT INTO APP.MEMBERS (ID, FIRSTNAME, LASTNAME, EMAIL, CONTACT, MEMBERSHIP, REGDATE) VALUES (?,?,?,?,?,?,?)")) {
                pstate.setInt(1, member.getID());
                pstate.setString(2, member.getFirstName());
                pstate.setString(3, member.getLastName());
                pstate.setString(4, member.getEmail());
                pstate.setString(5, member.getContact());
                pstate.setString(6, member.getMembership());
                pstate.setDate(7, member.getRegDate());
                
                
                pstate.executeUpdate();
                pstate.close();
            }
            catch (SQLException e){
                System.out.println("SQL Exception in Repo write() function: inserting into members");
                System.out.println(e);
            }
        }
    }
    
}
