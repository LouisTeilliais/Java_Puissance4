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

        this.choosePlayer1 = PlayerTurn("X");
        player = true;
        ListRefresh();
        grid.PrintGrid();
        this.choosePlayer2 = PlayerTurn("O");
        player = false;
        ListRefresh();
        grid.PrintGrid();
    }

    static String PlayerTurn(String player){

        try {
            String choose = getStringFromConsole("Player " + player +  ", What column do you choose ?");
            if ( choose.charAt(0) >= 'a' && choose.charAt(0) <= 'f'){
                // System.out.println(choose);
                
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

    public void ListRefresh(){
        grid.AddPlayerList(player, choosePlayer1);
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


