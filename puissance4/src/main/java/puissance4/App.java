package puissance4;

import java.io.*;

public class App {
    public static void main( String[] args ){
        int input = 0; 
        
        do {
            input = menu();
            switch(input){
                case 1:
            
                //  create a game
                break;
                case 2:
                // join a game
                AskIP();
                break;
                case 3:
                App newApp = new App();
                break;
            }

        }while(input != 4);
        System.out.println("Goodbye!");
    }

    Grille grid = new Grille();


    public Boolean player = true;
    public String choosePlayer1 = "";
    public String choosePlayer2= "";

    App(){
        
        
        do {
            this.choosePlayer1 = chooseColumn("X");
            player = true;
            grid.AddPlayerList(player, choosePlayer1);
            grid.PrintGrid();
            grid.verifWinHorizontal(player, choosePlayer1);
            this.choosePlayer2 = chooseColumn("O");
            player = false;
            grid.AddPlayerList(player, choosePlayer2);
            grid.PrintGrid();
            grid.verifWinHorizontal(player, choosePlayer2);
        }while(!grid.WinOrLoose);
    
    }

    static String chooseColumn(String player){
        try {
            String choose = getStringFromConsole("Player " + player +  ", What column do you choose ?");
            if ( choose.charAt(0) >= 'a' && choose.charAt(0) <= 'h'){
                // System.out.println(choose);
                
            }else {
                throw new IOException("Bad colummn");
            } 
            return choose;
            
        }catch(Exception e){
            System.err.println("Please, input a valid column");
            return chooseColumn(player);
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

    public static int menu(){

        System.out.println("Please choose what you want to do:");
        System.out.println("1. Create a game ? ");
        System.out.println("2. Join a game ? ");
        System.out.println("3. Play in local ? ");
        System.out.println("4. Quit ");

        try {
            int input = Integer.parseInt(getStringFromConsole("Please input your choice's number : "));
            if (input < 1 || input > 3){
                throw new IOException("Bad number");
            }
            return input;

        }catch(Exception e){
            System.out.println("Please enter a valid number:");
            return menu();
        }
    }

    public static int AskIP(){
        System.out.println("What is the IP of the server ? ");

        try {
            int IP = Integer.parseInt(getStringFromConsole("Enter the IP adress"));
            return IP;

        }catch(IOException e){
            System.err.println("Enter a valid IP");
            return AskIP();
        }
    }
}


