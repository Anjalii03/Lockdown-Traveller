/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.Serializable;

/**
 *
 * @author Anjali
 */
public class BookingHistoryRequest implements Serializable{
    
    String username;
    
    public String getUsername()
    {
        return username;
    }
    
    public BookingHistoryRequest(String username)
    {
        this.username = username;
    }
    
    @Override
    public String toString()
    {
        return String.valueOf(username);
    }

}
