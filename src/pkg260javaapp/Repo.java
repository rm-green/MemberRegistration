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
public interface Repo {
    
    public ArrayList read(Connection connection);
    void write(Connection connection, ArrayList list);
}
