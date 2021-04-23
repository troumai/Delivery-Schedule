import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket( 2222);
        while(true){
            System.out.println("Waiting for clients");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            ServerThread serverThread = new ServerThread(socket);
            serverThread.start();
        }
    }
}
