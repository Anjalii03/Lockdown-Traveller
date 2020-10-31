/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class temp {
    public static void main(String[] args){
          try{            
            Connection con;
	    Statement st;
            con=DriverManager.getConnection("jdbc:mysql://localhost:3308/softablitz","root","");  //edit 3306 in your case
            st=con.createStatement();
            DatabaseManager dbm=new DatabaseManager();
            dbm.setConnection();
             
            ProtectPassword pp=new ProtectPassword();
            pp.setPassword("anji@03");
            pp.setProtection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO admin (username,password,salt) "
                      + "values(?,?,?) ");
		ps.setString(1, "Anjali");
                ps.setString(2, pp.getSecurePassword());
                ps.setString(3, pp.getSalt());
		ps.executeUpdate();	   
                System.out.println("done");
            
        }catch(SQLException e){
            System.out.println(e+"heres the error");
        }
}

    } 
    