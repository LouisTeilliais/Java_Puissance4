package puissance4;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Server {
    

    SocketChannel socket = null;

    public static void main(String[] args) {
        Server server = new Server();
        server.accept();
        try {
            server.write("Turn X");
        }catch(IOException e){
            System.out.println("Can't connect to the host");
        }
    }

    public void accept(){

        try {

            System.out.println("Waiting for connection...");
            ServerSocketChannel serverSocket = ServerSocketChannel.open();
            serverSocket.socket().bind(new InetSocketAddress(8000)); // definir le port du serv
            socket = serverSocket.accept(); 
            System.out.println("Connection etablished");

        }catch (IOException e){
            System.err.println("Can't lauch the server");
        }
    }

    public void write(String message) throws IOException{

        try {
            ByteBuffer buffer = ByteBuffer.wrap(message.getBytes("UTF-8"));
            while(buffer.hasRemaining()){
                socket.write(buffer);
            }
            System.out.println("Message sent");
        }catch(UnsupportedEncodingException e){
            System.err.println("Unsupported encoding ");
        }
    }

    
}
