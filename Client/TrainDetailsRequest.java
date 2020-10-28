package Client;

import java.io.Serializable;

/**
 *
 * @author Priyanshi Dixit
 */
public class TrainDetailsRequest implements Serializable{
    String arrival,departure,source,destination;
    public String getArrival(){
        return arrival;
    }
    public String getDeparture(){
        return departure;
    }
    public void setArrival(String arrival){
        this.arrival=arrival;
    }
    public void setDeparture(String departure){
        this.departure=departure;
    }
    public String getSource(){
        return source;
    }
    public String getDestination(){
        return destination;
    }   

    public TrainDetailsRequest(String source,String destination){
        this.source=source;
        this.destination=destination;
    }
}
