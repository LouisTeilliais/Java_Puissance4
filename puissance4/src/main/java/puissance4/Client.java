package puissance4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class Client {
    

    public static void main(String[] args) {
        
    }

    void connect(){

        try {
            System.out.println("Connecting to host...");
            SocketChannel clientSocket = SocketChannel.open();
            clientSocket.connect(new InetSocketAddress(8000)); 
            System.out.println("Connection etablished");
            
        }catch(IOException e){
            System.out.println("Can't connect to server...");
        }
        
    }
}
