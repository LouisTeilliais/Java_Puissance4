package puissance4;

import java.io.*;

public class App 
{
    public static void main( String[] args ){
    
        // do {
        //     PlayerTurn("X");

        //     PlayerTurn("O");
        // }
        // while(); 
    }

    static void menu(){



    }

    static String PlayerTurn(String player){

        try {
            String choose = getStringFromConsole("Player " + player +  ", What column do you choose ?");
            if ( choose.charAt(0) >= 'a' && choose.charAt(0) <= 'f'){
                System.out.println(choose);
                
            }else {
                throw new IOException("Bad colummn");
            } 
            return choose;
            
        }
        catch(Exception e){
            System.err.println("Please, input a valid column");
            return PlayerTurn(player);
        }
        
    }

    static String getStringFromConsole(String message) throws IOException{

        System.out.println(message);
        System.out.print("> ");

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String input = br.readLine();

        if (input == ""){
            throw new IOException("Can't be empty");
        }
        return input; 
    }

    
}


