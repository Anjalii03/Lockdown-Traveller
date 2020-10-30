package Client;

import java.io.Serializable;

/**
 *
 * @author Priyanshi Dixit
 */
public class BookingRequest  implements Serializable{
    String name,age,gender,source,destination,username,date,coach;
    public String getName(){
        return name;
    }
    public String getAge(){
        return age;
    }
    public String getGender(){
        return gender;
    }
    public String getSource(){
        return source;
    }
    public String getDestination(){
        return destination;
    }
    public String getUsername(){
        return username;
    }
    public String getDate(){
        return date;
    }
    public String getCoach(){
        return coach;
    }
    public BookingRequest(String name,String age,String gender,String username,String date,String coach,String source,String destination){
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.source=source;
        this.destination=destination;
        this.date=date;
        this.username=username;
        this.coach=coach;
    }
}
