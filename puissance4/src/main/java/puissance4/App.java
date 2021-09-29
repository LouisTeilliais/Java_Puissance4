package puissance4;

import java.io.*;

public class App {
    public static void main( String[] args ){
        App newApp = new App();
    }

    Grille grid = new Grille();


    public Boolean player = true;
    public String choosePlayer1 = "";
    public String choosePlayer2= "";

    App(){
        int randomTurn = (int) (Math.random() * 2 + 1);
        // System.out.println(randomTurn);
        // do {
        //     switch(randomTurn){
        //         case 1:
        //         PlayerTurn(); // Joueur 1 commence
        //         case 2:
        //         // Joueur 2 commence 
        //     }

        // }while(grid.verifWin());
        this.choosePlayer1 = chooseColumn("X");
        player = true;
        grid.AddPlayerList(player, choosePlayer1);
        grid.PrintGrid();

        this.choosePlayer2 = chooseColumn("O");
        player = false;
        grid.AddPlayerList(player, choosePlayer2);
        grid.PrintGrid();
        
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

    void PlayerTurn(){
        
        this.choosePlayer1 = chooseColumn("X");
        player = true;
        grid.AddPlayerList(player, choosePlayer1);
        grid.PrintGrid();

        this.choosePlayer2 = chooseColumn("O");
        player = false;
        grid.AddPlayerList(player, choosePlayer2);
        grid.PrintGrid();
    }
}


