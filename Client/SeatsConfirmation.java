package Client;

import java.io.Serializable;

/**
 *
 * @author Priyanshi Dixit
 */
public class SeatsConfirmation implements Serializable{
    String Train_no,Source,Destination,Date,NoPassg,Coach;
    public String getTrainNo(){
        return Train_no;
    }
    public String getSource(){
        return Source;
    }
    public String getDestination(){
        return Destination;
    }
    public String getDate(){
        return Date;
    }
    public String getNoPassg(){
        return NoPassg;
    }
    public String getCoach(){
        return Coach;
    }
    public SeatsConfirmation(String Train_no,String Source,String Destination,String Date,String NoPassg,String Coach){
        this.Train_no=Train_no;
        this.Source=Source;
        this.Destination=Destination;
        this.Date=Date;
        this.NoPassg=NoPassg;
        this.Coach=Coach;
    }
}
