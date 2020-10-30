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
public class CancelBookingRequest implements Serializable {
    
    String date,source,destination;
    int coach_no,passenger_id;
    
    public int getPassengerId()
    {
        return passenger_id;
    }
    
    public String getDate()
    {
        return date;
    }
    
    public int getCoachNo()
    {
        return coach_no;
    }
    
    public String getSource()
    {
        return source;
    }
    
    public String getDestination()
    {
        return destination;
    }
    
    public CancelBookingRequest(int passenger_id,String date,int coach_no,String source,String destination)
    {
        this.date = date;
        this.coach_no = coach_no;
        this.source = source;
        this.destination = destination;
        this.passenger_id = passenger_id;
    }
    
    public String toString()
    {
        return String.valueOf(date+" "+coach_no+" "+source+" "+destination);
    }

    
}
