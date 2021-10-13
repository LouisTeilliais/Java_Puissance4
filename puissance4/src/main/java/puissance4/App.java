package puissance4;

import java.io.*;
import java.lang.Thread.State;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class App extends Application {
    private Stage mainWindow = null;
    private Stage confirmationWindow = null;
    private Scene mainScene = null;
    public static void main( String[] args ){
        launch(args);
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

    Grille grid = new Grille();

    public Boolean player = true;
    public String choosePlayer1 = "";
    public String choosePlayer2= "";

    private Scene test(){
        Label l = new Label("Bonsoir non.");
        Button game = new Button("Game ?");
        Button quit = new Button("Quit ?");
        HBox forButton = new HBox();
        forButton.getChildren().addAll(game, quit);
        VBox box1 = new VBox();
        box1.getChildren().addAll(l, forButton);
        box1.setAlignment(Pos.CENTER);
        return new Scene(box1, 200, 100);
    }
    @Override
    public void start(Stage mainWindow) throws Exception {
        this.mainWindow = mainWindow;
        Button welcome = new Button("Start ?");
        Label l1 = new Label("Hey ! Welcome on this game !");
        Scene confirmationScene = test();
        this.confirmationWindow = new Stage();
        confirmationWindow.setTitle("test");
        confirmationWindow.setScene(confirmationScene);
        confirmationWindow.initModality(Modality.APPLICATION_MODAL);
        welcome.setOnMouseClicked(e -> {
            confirmationWindow.show();
        });
        VBox box1 = new VBox();
        box1.getChildren().addAll(l1, welcome);
        box1.setAlignment(Pos.CENTER);
        box1.setSpacing(20);
        Scene mainScene = new Scene(box1, 300, 200);
        this.mainScene = mainScene;
        mainWindow.setTitle("My first window!");
        mainWindow.setScene(mainScene);
        mainWindow.show();
    }
 
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
