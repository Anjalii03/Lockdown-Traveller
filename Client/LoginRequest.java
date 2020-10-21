package Client;

import java.io.Serializable;

public class LoginRequest implements Serializable {

      String username,password;

         public void setusername(String username){
         this.username= username;
         }
         public void setpassword(String password){
         this.password= password;
         }
         public String getusername(){
         return username;
         }
         public String getpassword(){
         return password;
        }   
    public LoginRequest (String user , String pass){
        this.username=user;
        this.password=pass;
    }

    @Override
    public String toString(){
        return String.valueOf(username+" "+password);
    }
}