package Server;
/*
*
* PRIYANSHI DIXIT
*
*/
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {

    public static void main(String args[]) {
        ServerSocket serverSocket = null;
        Socket socket;
        System.out.println("Server started");
        try {
            serverSocket = new ServerSocket(6090);
        } catch (IOException e) {
            System.out.println(e);
        }
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