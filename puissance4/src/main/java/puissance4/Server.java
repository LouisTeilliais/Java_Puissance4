package puissance4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Server {
    

    public static void main(String[] args) {
        Server server = new Server();
        
    }

    public void accept(){

        try {

            System.out.println("Waiting for connection...");
            ServerSocketChannel serverSocket = ServerSocketChannel.open();
            serverSocket.socket().bind(new InetSocketAddress(8000)); // definir le port du serv
            SocketChannel socketChannel = serverSocket.accept(); 
            System.out.println("Connection etablished");

        }catch (IOException e){
            System.err.println("Can't lauch the server");
        }
    }
}
