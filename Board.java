import java.io.*;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;

public class Board {


     //variables
    public static Piece[][] array = new Piece[8][8];
    public static int score1 =0, score2 =0;

    /*
        this function starts the board by placing four pieces onto the board
     */
    public void start(){
        Piece p1 = new Piece(1,false, true, true, false);
        array[3][3] = p1;
        array[4][3] = new Piece(0,false, true, false, true);
       Piece p3 = new Piece(1,true, false, false, true);
        array[4][4]= p3;
        Piece p4 = new Piece(0,true, false, true, false);
        array[3][4]=p4;

        System.out.println();

    }
    /*
        this creates a piece by asking the user the row and the column they want to place their piece
     */
    public boolean createPiece(char col, int row, int player,Scanner in){


        col = Character.toLowerCase(col);

        if (col < 'a' || col > 'h') {
            System.out.println("Enter a valid letter");
            col = in.next().charAt(0);
        }
        if (row < 0 || row > 8) {
            System.out.println("Enter a valid number");
            row = in.nextInt();
        }

        int column = (int) col - 'a';

        boolean ready = checkValid(row, column);//check if the row and col are correct and piece is ready to be placed

        Piece a = new Piece(player, false, false, false, false); //places piece
        if(ready && array[row][column] == null && isPlacable(a,row,column)){

                array[row][column] = a;
                changePieces(a,row, column);
                return true;
        }else {
            System.out.println("Position not valid. Try again.");
            return false;
        }

    }
    /*
        this takes in a piece and row and column and returns true if the piece is placable onto the board
     */
    public boolean isPlacable(Piece a, int row, int column){


        boolean top = false;
        boolean bottom = false;
        boolean left = false;
        boolean right = false;
        //top = row -1
        //bottom = row +1
        //left = col-1
        //right = col+1

        if(checkValid(row-1,column) ){
            if(array[row-1][column] != null && array[row-1][column].color != a.color)
                top = true;
        }
        if(checkValid(row+1,column) ){
            if(array[row+1][column] != null && array[row+1][column].color != a.color)
                bottom = true;
        }
        if(checkValid(row,column-1)){
            if(array[row][column-1] != null && array[row][column-1].color != a.color)
                left = true;
        }
        if(checkValid(row,column+1) ){
            if(array[row][column+1] != null && array[row][column+1].color != a.color)
                right = true;
        }

       if(top || bottom || left || right)
         return true;
       else
           return false;

    }

    /*
        this goes thorugh the entire array to calcuate how many peieces each player has
     */
    public void calculateScores(){

         int playerOneScore =0;
         int playerTwoScore =0;
        for(int i=0; i < array.length; i++){
            for (int j =0; j < array[0].length; j++){
                if(array[i][j] != null) {
                    if (array[i][j].color == 1)
                        playerOneScore++;
                    if (array[i][j].color == 0)
                        playerTwoScore++;
                }
            }
        }

        System.out.println("Player 1 : " + playerOneScore + "        Player 2 : " + playerTwoScore );

        score1 = playerOneScore;
        score2 = playerTwoScore;

        if(playerOneScore > playerTwoScore)
            System.out.println("Player One is currently winning");
        else if (playerOneScore < playerTwoScore)
            System.out.println("Player Two is winning");
    }
    /*
        this changes the color of the pieces if one of the players puts pieves around another player's piece
     */
    public void changePieces(Piece a, int row, int column){

        //top = row -1
        //bottom = row +1
        //left = col-1
        //right = col+1


        if(checkValid(row-2,column)){
            if(array[row-2][column] != null)
            if(array[row-2][column].color == a.color)
                if(array[row-1][column] != null)
                 array[row-1][column].color = a.color;
        }

         if(checkValid(row+2,column)){
         if(array[row+2][column] != null)
            if(array[row+2][column].color == a.color)
                if(array[row+1][column] != null)
                array[row+1][column].color = a.color;
        }

       if(checkValid(row,column-2)){
          if(array[row][column-2] != null)
            if(array[row][column-2].color == a.color)
                if(array[row][column-1] != null)
                array[row][column-1].color = a.color;
        }

        if(checkValid(row,column+2)){
        if(array[row][column+2] != null)
            if(array[row][column+2].color == a.color)
                if(array[row][column+1] != null)
                array[row][column+1].color = a.color;
        }


    }

    /*
        this checks if the row and the column is valid to avoid out of bounds error.
        returns true if it is
     */
    public boolean checkValid(int r, int c){
        if(r >= 0 && r < 8 && c >= 0 && c < 8 ) {
            return true;
        }else {
            return false;
        }
    }

    /*
        this prints out the board
     */
    public void print(){

        System.out.println("   A   B   C   D   E   F   G   H    ");
        System.out.println(" _________________________________  ");
        for(int i=0; i < array.length; i++){
            System.out.print(i+1+ "|");
            for (int j =0; j < array[0].length; j++){
                //System.out.print(i+ " ");
                if(array[i][j] == null)
                    System.out.print(" . " + " ");
                else if(array[i][j].color == 1)
                    System.out.print(" * " + " ");
                else if(array[i][j].color == 0)
                   System.out.print(" o " + " ");
            }
            System.out.println("|");
           System.out.println(" ");
        }
    }

    /*
         this function contains the menu of thefunction
     */
    public void beginGame(Board board, Scanner in, String[] args){
        try {


            System.out.println("Welcome to the game! Lets play Othello");
            System.out.println("Choose one of the following options:");
            System.out.println("1)Play");
            System.out.println("2)Exit");
            System.out.println("Enter your choice (1 or 2):");

            int choice = in.nextInt();

            if (choice == 1) {


                int turn = 1,player = 1;
                System.out.println("Player 1 starts. GO!");
                board.start();
                while (turn < 65) {

                    board.print();

                    System.out.println("Enter the letter ");
                    char column = in.next().charAt(0);

                    System.out.println("Enter the number ");
                    int row = in.nextInt();

                    boolean pieceMade = board.createPiece(column, row-1, player, in);
                    if(pieceMade) {
                        board.calculateScores();
                        turn++;
                    }
                    System.out.println();
                    //board.print();

                    if(turn % 2 == 0){
                        System.out.println("Player 2's turn. Player 2 is O");
                        player = 0;

                    }else {
                        System.out.println("Player 1's turn.Player 2 is *");
                        player = 1;
                    }
                }
                if(score1 > score2)
                    System.out.println("Player One Won");
                else if (score1 < score2)
                    System.out.println("Player Two Won");
                else {
                    System.out.println("Game Tied");
                }

            } else if (choice == 2) {
                System.out.println("Bye");
                return;
            } else {
                System.out.println("Enter a valid input.");
                main(args);
            }
        }catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            main(args);
        }
    }
    /*
        this creates an object to get the game started
     */
    public static void main(String[] args){


        Board b = new Board();
        Scanner in = new Scanner(System.in);

        b.beginGame(b,in,args);
    }
}

