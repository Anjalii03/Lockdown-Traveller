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
public class CancelledTrainsRequest implements Serializable {
     
    int train_no;
    String date;
    
    public int getTrainNo()
    {
        return train_no;
    }
    
    public String getDate()
    {
        return date;
    }
    
}
