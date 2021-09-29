package puissance4;


import java.util.*;


enum Cell{
    empty, player1, player2
}

public class Grille {

    List<List<Cell>> columns = new ArrayList<>();

    Grille(){
        CreateList();
        PrintGrid();
    }

    public Boolean WinOrLoose = false;

    public void PrintGrid(){
        for (int i=5; i>=0; i--){
            System.out.print("#");
            for (int j =0; j<=7; j++){
                if (columns.get(j).size() <= i){
                    System.out.print(" ");
                }
                else{
                    if (columns.get(j).get(i) == Cell.player1){
                        System.out.print("X");
                    }
                    else if (columns.get(j).get(i) == Cell.player2){
                        System.out.print("O");
                    }
                }
            }
            System.out.print("#");
            System.out.print('\n');
        }
        System.out.println(" ########");
        System.out.println(" abcdefgh ");

    }

    int colonne;

    public void AddPlayerList(Boolean player, String ltr){
        colonne = Character.getNumericValue(ltr.charAt(0)) - 10;
        if (player){
            columns.get(colonne).add(Cell.player1);
        }
        else {
            columns.get(colonne).add(Cell.player2);
        }
    }

    public void CreateList(){

        columns = new ArrayList<>();
        for(int i=0; i<8; i++){ //faire une variable pour faire plaiz au J.
            List<Cell> column = new ArrayList<Cell>();
            columns.add(column);
        }
    }



    Boolean verifWin(){

        for (int i = 0; i <= 5; i++){
            
            for (int j = 0; j <= 7; j++){

                if (j <= 4){
                    if (columns.get(j).get(i) == Cell.player1 && columns.get(j+1).get(i) == Cell.player1 && columns.get(j+2).get(i) == Cell.player1 && columns.get(j+3).get(i) == Cell.player1){ // Verif a droite 
                        System.out.println("Player X Win ! "); // Win sur l'horizontal du joueur 1
                        WinOrLoose = true;
                    }
                    else if (columns.get(j).get(i) == Cell.player2 && columns.get(j+1).get(i) == Cell.player2 && columns.get(j+2).get(i) == Cell.player2 && columns.get(j+3).get(i) == Cell.player2){ // Verif a droite 
                        System.out.println("Player O Win ! ");
                        WinOrLoose = true;
                    }
                }
                if (i <= 2){
                    if (columns.get(j).get(i) == Cell.player1 && columns.get(j).get(i+1) == Cell.player1 && columns.get(j).get(i+2) == Cell.player1 && columns.get(j).get(i+3) == Cell.player1){ // en haut
                        System.out.println("Player X Win ! "); // Win sur la vertical du joueur 1
                        WinOrLoose = true;
                    }
                    else if (columns.get(j).get(i) == Cell.player2 && columns.get(j).get(i+1) == Cell.player2 && columns.get(j).get(i+2) == Cell.player2 && columns.get(j).get(i+3) == Cell.player2){ // en haut
                        System.out.println("Player O Win ! ");               
                        WinOrLoose = true;
                    }
                }
                if (j<=4 && i <= 2){
                    if (columns.get(j).get(i) == Cell.player1 && columns.get(j+1).get(i+1) == Cell.player1 && columns.get(j+2).get(i+2) == Cell.player1 && columns.get(j+3).get(i+3) == Cell.player1){ // diagonale droite
                        System.out.println("Player X Win ! "); // Win sur la diagonale droite par le joueur 1
                        WinOrLoose = true;
                    }
                    else if (columns.get(j).get(i) == Cell.player2 && columns.get(j+1).get(i+1) == Cell.player2 && columns.get(j+2).get(i+2) == Cell.player2 && columns.get(j+3).get(i+3) == Cell.player2){ // diagonale droite
                        System.out.println("Player O Win ! ");
                        WinOrLoose = true;
                    }
                }
                if (j >=3 && i <= 2){
                    if (columns.get(j).get(i) == Cell.player1 && columns.get(j-1).get(i+1) == Cell.player1 && columns.get(j-2).get(i+2) == Cell.player1 && columns.get(j-3).get(i+3) == Cell.player1){ // diagonale gauche
                        System.out.println("Player X Win ! ");
                        WinOrLoose = true;
                    }
                    else if (columns.get(j).get(i) == Cell.player2 && columns.get(j-1).get(i+1) == Cell.player2 && columns.get(j-2).get(i+2) == Cell.player2 && columns.get(j-3).get(i+3) == Cell.player2){ // diagonale gauche
                        System.out.println("Player O Win ! ");
                        WinOrLoose = true;
                    }
                }
            }
        }
    }
    return WinOrLoose;
}
