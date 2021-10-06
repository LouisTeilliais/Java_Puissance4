package puissance4;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
// import java.text.NumberFormat.Style;

public class Client {
    
    SocketChannel socket = null; 
    final int BUFFER_LENGTH = 256;

    public static void main(String[] args) {

        Client client = new Client();
        client.connect();
        client.read();
        // client.close();
        
    }

    public void connect(){

        try {
            System.out.println("Connecting to host...");
            socket = SocketChannel.open();
            socket.connect(new InetSocketAddress(8000)); 
            System.out.println("Connection etablished");
            
        }catch(IOException e){
            System.out.println("Can't connect to server...");
        }
        
    }

    public String read() {
        
        ByteBuffer buffer = ByteBuffer.allocate(BUFFER_LENGTH);
       
        try {
            int bytesRead = socket.read(buffer);
            try {
                String message = new String(buffer.array(), 0, bytesRead, "UTF-8");
                return message;
            }catch(UnsupportedEncodingException e){
                System.out.println("Unsupported encoding !");
            }
        }catch(IOException e){
            System.err.println("Can't read");
        }
        return "";
    }

    public void close(){

        try {
            socket.close();
        }catch(IOException e){
            System.err.println("Can't close socket");
        }
        
    }
}
