package Client;
/*
*
* PRIYANSHI DIXIT
*
*/
import java.io.IOException;
import java.net.Socket;

public class Client {

    static Socket socket;
    public static void main(String args[]) {
        try {
            socket = new Socket("localhost", 6090);
        
            System.out.println("Client created.");
        
           new Client().login();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    public void login() throws IOException{
        System.out.println("in login area");
        LoginPage log=new LoginPage();
        log.setVisible(true);
    }
}