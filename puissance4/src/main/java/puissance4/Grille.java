package puissance4;

import java.io.*;
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
    

    // String line8 = "########";
    // String line9 = " abcdef ";

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


    public void AddPlayerList(Boolean player, String ltr){
        if (player){
            if (ltr.equals("a")){
                columns.get(0).add(Cell.player1);
            }
        }
        else{
            if (ltr.equals("a")){
                columns.get(0).add(Cell.player2);
            }
        }
    }



    public void CreateList(){

        columns = new ArrayList<>();
        for(int i=0; i<8; i++){ //faire une variable pour faire plaiz au J.
            List<Cell> column = new ArrayList<Cell>();
            columns.add(column);
        }
    }

}
