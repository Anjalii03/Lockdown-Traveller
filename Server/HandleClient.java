package Server;
/*
*
* PRIYANSHI DIXIT
*
*/
import Client.*;
import java.io.IOException;
import java.io.*;
import java.net.Socket;

public class HandleClient implements Runnable {
    ObjectInputStream objectInputStream;
    ObjectOutputStream objectOutputStream;
    public HandleClient(Socket socket) {
         try {
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            objectOutputStream=new ObjectOutputStream(socket.getOutputStream());  
        } catch (IOException e) {
            System.out.println(e+"infinite here");
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                DatabaseManager db=new DatabaseManager();
                String func=(String)objectInputStream.readUTF();
                System.out.println("Action is "+func);
                switch (func){
                    case "1":
                            System.out.println("action in progress");
                            LoginRequest log = (LoginRequest) objectInputStream.readObject();
                            System.out.println("Message received");
                            System.out.println(log); 
                            if(db.Checklogin(log.toString())){
                            System.out.println("got u"); 
                            objectOutputStream.writeUTF("got u");
                            objectOutputStream.flush();
                            }
                            else{
                            objectOutputStream.writeUTF("ur not here");
                            objectOutputStream.flush();
                            break;
                            }
                    case "2":
                            break;    
                }
                System.out.println("closing connection");
                db.CloseConnection();
            }catch(Exception e){
                System.out.println(e+" here");
                break;
            }
        }

    }
}