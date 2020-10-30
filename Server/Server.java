package Server;
/*
*
* PRIYANSHI DIXIT
*
*/
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;
public class Server {

    public static void main(String args[]) throws ParseException {
        ServerSocket serverSocket = null;
        Socket socket;
        System.out.println("Server started");
        try {
            serverSocket = new ServerSocket(6090);
        } catch (IOException e) {
            System.out.println(e);
        }
        DatabaseManager db=new DatabaseManager();
        db.setConnection();
        db.updateDate();
        new AdminLoginPage().setVisible(true);
        while (true) {
            try {
                socket = serverSocket.accept();
                Thread t = new Thread(new HandleClient(socket));
                t.start();
            } catch (IOException e) {
                System.out.println(e+"hey there");
            }

        }
    }

}