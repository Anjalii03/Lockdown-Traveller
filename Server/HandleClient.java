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
   
    Socket socket;
    public HandleClient(Socket socket) throws IOException {
        this.socket=socket;
               
    }

    @Override
    public void run() {
        while (true) {
            try {  
                 ObjectInputStream objectInputStream=new ObjectInputStream(socket.getInputStream());
                 ObjectOutputStream objectOutputStream=new ObjectOutputStream(socket.getOutputStream());
                DatabaseManager db=new DatabaseManager();
                db.setConnection();                                //database connection established
                int func=(int)objectInputStream.readInt();        //client returns action number
                System.out.println("Action is "+func);
                switch (func){
                    case 1 : 
                        System.out.println("action in progress");
                        LoginRequest log = (LoginRequest) objectInputStream.readObject();
                        System.out.println("Message received");
                        System.out.println(log);
                        objectOutputStream.writeBoolean(db.Checklogin(log));
                        objectOutputStream.flush();
                    break;
                    case 2 :
                         System.out.println("action in progress");
                        RegisterRequest reg = (RegisterRequest) objectInputStream.readObject();
                        System.out.println("Message received");
                        System.out.println(reg);
                        objectOutputStream.writeBoolean(db.Register(reg));
                        objectOutputStream.flush();
                        break;
                }
                
                System.out.println("closing connection");
                db.CloseConnection();
                
            }catch(IOException | ClassNotFoundException e){
                System.out.println(e+" here all the errors");
                break;
            }
        }

    }
}