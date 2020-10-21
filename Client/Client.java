package Client;

import java.io.IOException;
import java.net.Socket;

public class Client {

    static Socket socket;
    public static void main(String args[]) {
        try {
            socket = new Socket("localhost", 6090);
          //   BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Client created.");
          //  new Client().logreq(socket,bufferedReader);
           new Client().login();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    public void login() throws IOException{
        System.out.println("in login area");
        Login log=new Login();
        log.setVisible(true);     
            /*ObjectOutputStream objectOutputStream =new ObjectOutputStream(socket.getOutputStream());
            LoginRequest lg=new LoginRequest(LoginRequest.username,LoginRequest.password);
            objectOutputStream.writeObject(lg);
            objectOutputStream.flush();   */
        
    }
    
    
    /*public void logreq(Socket socket,BufferedReader bufferedReader) throws IOException {
        ObjectOutputStream objectOutputStream =
                new ObjectOutputStream(socket.getOutputStream());
        while(true){
               user = bufferedReader.readLine();
               pass = bufferedReader.readLine();
               LoginRequest lg=new LoginRequest(user,pass);
               objectOutputStream.writeObject(lg);
               objectOutputStream.flush();
        }
         
    }*/
}