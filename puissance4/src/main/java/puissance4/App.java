package puissance4;

import java.io.*;
import java.lang.Thread.State;


public class App {

    public static void main( String[] args ){
        App newApp = new App();
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
}


