package puissance4;

import java.io.*;
import java.lang.Thread.State;

import javafx.application.Application;

public class App extends Application {
    private Stage mainWindow = null;
    public static void main( String[] args ){
        int input = 0; 
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
            
            case 4:
            break;
        }
        System.out.println("Goodbye!");
    }

    public void start(Stage mainWindow) throws Exception{
        this.mainWindow = mainWindow;
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


