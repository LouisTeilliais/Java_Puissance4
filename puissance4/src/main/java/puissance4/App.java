package puissance4;

import java.io.*;
// import java.lang.ref.Cleaner;
// import java.lang.Thread.State;


public class App {
  
    public static void main( String[] args ){
        int input = 0; 
        Communicator comm = new Communicator();
        String message = "";
       
        input = menu();
        switch(input){
            case 1:
            //create a game
            Communicator.accept();
            // App Serv = new App();
            // message = Communicator.read();
            break;
            
            case 2:      
            // join a game
            try {
                Communicator.connect(AskIP());
                // App Client = new App();
                message = Communicator.sendMessage();
            
            }catch(ArrayIndexOutOfBoundsException e){
                System.err.print("Please enter anything" +e.getMessage());
            }
            
            break;
            
            case 3:
            App newApp = new App();
            break;
            case 4: 
            break;
        }
        do{
            message = Communicator.read();

            System.out.print(">>");
            System.out.print(message);
            System.out.print("\n");
            message = Communicator.sendMessage();
    
        }while(!message.equals("Quit"));
        
        System.out.println("Goodbye!");

    }
    
    Grille grid = new Grille();

    public Boolean player = true;
    public String choosePlayer1 = "";
    public String choosePlayer2= "";
 
    App(){
        for(int i = 0; i <= 46; i += 2){
            this.choosePlayer1 = chooseColumn("X");
            player = true;
            grid.AddPlayerList(player, choosePlayer1);
            grid.PrintGrid();
            if(CheckWin(player)){
                break;
            }
            this.choosePlayer2 = chooseColumn("O");
            player = false;
            grid.AddPlayerList(player, choosePlayer2);
            grid.PrintGrid();
            if(CheckWin(player)){
                break;
            }
            if(i == 46){
                System.out.println("There is no winner ... It was a boring game zzz");
            }
        }
    }

    static String chooseColumn(String player){
        try {
            String choose = getStringFromConsole("Player " + player +  ", What column do you choose ?");
            if ( choose.charAt(0) >= 'a' && choose.charAt(0) <= 'h'){               
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

    Boolean CheckWin(Boolean player){
        int firstSide = 0;
        int secondSide = 0;
        if (player){
            // Check win par la vertical 
            if (grid.verifWinVertical(player, choosePlayer1)){
                return true;
            }
            // Check si win par l'horizontal
            firstSide = grid.verifWinHorizontal(player, choosePlayer1, 1);
            secondSide = grid.verifWinHorizontal(player, choosePlayer1, -1);
            if (firstSide + secondSide >= 3){
                System.out.println("GG ! The player who played with the X won!");
                return true;
            }
            // Check si win par la diagonale droite
            firstSide = grid.verifWinDiagonalRight(player, choosePlayer1, 1);
            secondSide = grid.verifWinDiagonalRight(player, choosePlayer1, -1);
            if (firstSide + secondSide >= 3){
                System.out.println("GG ! The player who played with the X won!");
                return true;
            }
            // Check si win par la diagonale gauche
            firstSide = grid.verifWinDiagonalLeft(player, choosePlayer1, 1);
            secondSide = grid.verifWinDiagonalLeft(player, choosePlayer1, -1);
            if (firstSide + secondSide >= 3){
                System.out.println("GG ! The player who played with the X won!");
                return true;
            }
        } else {
            // Check win par la vertical 
            if (grid.verifWinVertical(player, choosePlayer2)){
                return true;
            }
            // Check si win par l'horizontal
            firstSide = grid.verifWinHorizontal(player, choosePlayer2, 1);
            secondSide = grid.verifWinHorizontal(player, choosePlayer2, -1);
            if (firstSide + secondSide >= 3){
                System.out.println("GG ! The player who played with the O won!");
                return true;
            }
            // Check si win par la diagonale droite
            firstSide = grid.verifWinDiagonalRight(player, choosePlayer2, 1);
            secondSide = grid.verifWinDiagonalRight(player, choosePlayer2, -1);
            if (firstSide + secondSide >= 3){
                System.out.println("GG ! The player who played with the O won!");
                return true;
            }
            // Check si win par la diagonale gauche
            firstSide = grid.verifWinDiagonalLeft(player, choosePlayer2, 1);
            secondSide = grid.verifWinDiagonalLeft(player, choosePlayer2, -1);
            if (firstSide + secondSide >= 3){
                System.out.println("GG ! The player who played with the O won!");
                return true;
            }
        }
        return false;
    }

    public static int menu(){

        System.out.println("Please choose what you want to do:");
        System.out.println("1. Create a game ? ");
        System.out.println("2. Join a game ? ");
        System.out.println("3. Play in local ? ");
        System.out.println("4. Quit ");

        try {
            int input = Integer.parseInt(getStringFromConsole("Please input your choice's number : "));
            if (input < 1 || input > 4){
                throw new IOException("Bad number");
            }
            return input;

        }catch(Exception e){
            System.out.println("Please enter a valid number:");
            return menu();
        }
    }

    public static String AskIP(){
        System.out.println("What is the IP of the server ? ");

        try {
            String IP = App.getStringFromConsole("Enter the IP adress");
            return IP;

        }catch(IOException e){
            System.err.println("Enter a valid IP");
            return AskIP();
        }
    }
}


