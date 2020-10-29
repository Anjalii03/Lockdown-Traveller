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
                    case 3 :
                        System.out.println("action in progress");
                        TrainsBetweenRequest tb = (TrainsBetweenRequest) objectInputStream.readObject();
                        System.out.println("Message received");
                        System.out.println(tb);
                        objectOutputStream.writeObject(db.CheckTrains(tb));
                        objectOutputStream.flush();
                        break;
                    case 4 :
                        System.out.println("action in progress");
                        BookingRequest br = (BookingRequest) objectInputStream.readObject();
                        System.out.println("Message received");
                        System.out.println(br);
                        objectOutputStream.writeBoolean(db.addPassenger(br));
                        objectOutputStream.flush();
                        break;    
                    case 5 :
                        System.out.println("action in progress");
                        SeatsConfirmation cs = (SeatsConfirmation) objectInputStream.readObject();
                        System.out.println("Message received");
                        System.out.println(cs);
                        objectOutputStream.writeBoolean(db.ConfirmSeats(cs));
                        objectOutputStream.flush();
                        break;    
                }
                
                System.out.println("closing connection");
                db.CloseConnection();
                
            }catch(Exception e){
                System.out.println(e+" here all the errors");
                break;
            } 
        }

    }
}