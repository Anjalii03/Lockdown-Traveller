package Client;

import java.io.Serializable;

/**
 *
 * @author Priyanshi Dixit
 */
public class BookingRequest  implements Serializable{
    String name,age,gender;
    public String getName(){
        return name;
    }
    public String getAge(){
        return age;
    }
    public String getGender(){
        return gender;
    }
    public BookingRequest(String name,String age,String gender){
        this.name=name;
        this.age=age;
        this.gender=gender;
    }
}
