package puissance4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Communicator {
 
    static SocketChannel socket = null; 
    final static int BUFFER_LENGTH = 256;
    static Communicator comm = null; 
    
    // public static void main(String[] args) throws IOException {
        
    //     Communicator comm = new Communicator();
    //     String message = "";

    //     if (args.length > 0){
            
    //         comm.connect(args[0]);
    //         message = sendMessage();
    //     } else {
    //         comm.accept();
    //     }

    //     do{
    //         message = comm.read();

    //         System.out.print(">>");
    //         System.out.print(message);
    //         System.out.print("\n");
    //         message = sendMessage();

    //     }while(!message.equals("Quit"));
        

    //     System.out.println("Game is finished");
    // }

    public static void connect(String address){

        try {
            System.out.println("Connecting to host...");
            socket = SocketChannel.open();
            socket.connect(new InetSocketAddress(address, 8000)); 
            System.out.println("Connection etablished");
            
        }catch(IOException e){
            System.out.println("Can't connect to server...");
        }
        
    }

    public static void accept(){

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


    public static void write(String message) throws IOException{

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

    public static String read() {
        
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


    public static String getMessage() throws IOException{

        System.out.print("> ");

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String input = br.readLine();

        if (input == ""){
            throw new IOException("Can't be empty");
        }
        return input; 
    }

    public static String sendMessage(){
        
        try{
            String message = getMessage();
            Communicator.write(message);
            return message;
        }
        catch(IOException e){
            System.err.println("Could not send message. " + e.getMessage());
        }
        return "";
    }


    public static void close(){
        try{
            socket.close();
        }
        catch(IOException e){
            System.err.println("Could not close socket");
        }
    }
}
