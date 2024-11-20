package Backtracking;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class nQueens {
    public static boolean nqueens(char board[][], int row){
        //base case
        if(row == board.length){
            count++;
            printBoard(board);
            return true;
        }
        //column loop
        for (int j=0; j<board.length; j++){
            if (isSafe(board,row,j)){
                board[row][j] = 'Q';
                nqueens(board,row+1);
//                if (nqueens(board,row+1)){  //function call
//                    return true;
//                }
                board[row][j] = 'x'; //backtracking step
            }
        }
        return false;
    }
    public static boolean isSafe(char board[][],int row,int col){
        //vertical up
        for (int i=row-1; i>=0; i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        //diagonal left
        for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        //diagonal right
        for (int i=row-1, j=col+1; i>=0 && j<board.length; i--, j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
    public static void printBoard(char board[][]){
        System.out.println("------Chess Board------");
        for(int i=0; i<board.length; i++){
            for (int j=0; j<board.length; j++){
                System.out.printf(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int count = 0;

    public static void main(String[] args) {
        int n = 4;
        char board[][] = new char[n][n];
        //List<List<String>> board = new List<List<String>>();
        //initialize
        for(int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                board[i][j] = 'x';
            }
        }

        nqueens(board,0);
        //System.out.println("TOTAL WAYS TO SOLVE N QUEENS : "+count);
    }
}
