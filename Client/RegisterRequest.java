package Client;

/**
 *
 * @author PRIYANSHI DIXIT
 */
import java.io.Serializable;
public class RegisterRequest implements Serializable{
    String FirstName,LastName,username,password,contact,DOB,gender,Email;
    public String getUsername(){
         return username;
         }
    public String getFirstNmae(){
         return FirstName;
         }
    public String getLastNmae(){
         return LastName;
         }
    public String getPassword(){
         return password;
         }
    public String getContact(){
         return contact;
         }
    public String getDOB(){
         return DOB;
         }   
    public String getGender(){
         return gender;
         }
    public String getEmail(){
        return Email;
    }
    public RegisterRequest(String FirstName,String LastName,String username,
            String password,String contact,String DOB,String gender,String Email){
        this.FirstName=FirstName;
        this.LastName=LastName;
        this.username=username;
        this.password=password;
        this.contact=contact;
        this.DOB=DOB;
        this.gender=gender;
        this.Email=Email;
    }
}
