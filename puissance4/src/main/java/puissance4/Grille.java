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



    Boolean verifWinVertical(Boolean player, String ltr){
        colonne = Character.getNumericValue(ltr.charAt(0)) - 10;
        int alignpieces = 0;
        if (player){
            try{
                for (int i = 2; i < 5; i++){
                    if(columns.get(colonne).get((columns.get(colonne).size())-i) == columns.get(colonne).get((columns.get(colonne).size())-1)){
                        alignpieces++;
                    } else {
                        break;
                    }
                }
                if (alignpieces == 3){
                    System.out.println("GG, the player who used the X won !");
                    return true;
                }
            }
            catch(IndexOutOfBoundsException e){
                return false;
            }
            // columns.get(colonne).get((columns.get(colonne).size())-1);  // Récupérer le dernier pions jouer
        } else {
            try{
                for (int i = 2; i < 5; i++){
                    if(columns.get(colonne).get((columns.get(colonne).size())-i) == columns.get(colonne).get((columns.get(colonne).size())-1)){
                        alignpieces++;
                    } else {
                        break;
                    }
                }
                if (alignpieces == 3){
                    System.out.println("GG, the player who used the O won !");
                    return true;
                }
            }
            catch(IndexOutOfBoundsException e){
                return false;
            }
        }

        return false;
    }
    
}
