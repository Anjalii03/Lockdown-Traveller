package Server;
/**
 *
 * @author Priyanshi Dixit
*/
public class ProtectPassword {
      String Password;
      String salt;
      String SecurePassword;
       public void setPassword(String Password){
           this.Password=Password;
       }
       public String getSalt(){
           return salt;
       }
       public String getSecurePassword(){
           return SecurePassword;
       }
       public void setProtection(){
            salt = PasswordUtils.getSalt(30);
            SecurePassword = PasswordUtils.generateSecurePassword(Password, salt);   
       }
   
}