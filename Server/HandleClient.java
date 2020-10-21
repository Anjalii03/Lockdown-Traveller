package Server;

import Client.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class HandleClient implements Runnable {
    ObjectInputStream objectInputStream;

    public HandleClient(Socket socket) {
         try {
            objectInputStream = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                LoginRequest log = (LoginRequest) objectInputStream.readObject();
                System.out.println("Message received");
                System.out.println(log); 
                DatabaseManager db=new DatabaseManager();
                if(db.Checklogin(log.toString())){
                    System.out.println("got u");
                }
                System.out.println("closing connection");
                db.CloseConnection();
                
            }catch(Exception e){
                System.out.println(e+"here");
            }
        }

    }
}