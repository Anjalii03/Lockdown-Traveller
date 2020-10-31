/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

/**
 *
 * @author Priyanshi Dixit
 */
public class VerifyProvidedPassword {
    String providedPassword;
    String securePassword;
    String salt;
    public void setsecurePassword(String securePassword){
        this.securePassword=securePassword;
    }
    public void setSalt(String salt){
        this.salt=salt;
    }
    public void setProvidedPassword(String providedPassword){
        this.providedPassword=providedPassword;
    }
    public boolean check(){
         
        boolean passwordMatch = PasswordUtils.verifyUserPassword(providedPassword, securePassword, salt);
        
        if(passwordMatch) 
        {
            System.out.println("Provided user password " + providedPassword + " "+salt+" "+securePassword+" is correct.");
            return true;
        } else {
            System.out.println("Provided password is incorrect");
            
        }
     return false;   
    }
}