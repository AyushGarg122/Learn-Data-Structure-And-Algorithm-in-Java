import java.util.*;
public class Main {

    public static void display(char [][]board){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafeToPlaceNumber(char [][]board, int r, int c, int num){

        for(int i=0; i<9; i++){
            if(board[r][i] - '0' == num){
                return false;
            }
        }

        for(int i=0; i<9; i++){
            if(board[i][c] - '0' == num){
                return false;
            }
        }

        r = (r / 3) * 3;
        c = (c / 3) * 3;

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(board[r + i][c + j] - '0' == num){
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean solveSudoku(char[][]board, ArrayList<Integer>emptyIndex, int idx){
        if(idx==emptyIndex.size()){
            return true;
        }

        int ele = emptyIndex.get(idx);

        int r = ele / 9;
        int c = ele % 9;

        for(int num=1; num<=9; num++){
            if(isSafeToPlaceNumber(board,r,c,num)){
                board[r][c] = (char) (num + '0');
                if(solveSudoku(board,emptyIndex,idx+1)){
                    return true;
                }
                board[r][c] = '.';
            }
        }

        return false;
    }

    public static void solveSudoku(char[][]board){
        ArrayList<Integer> emptyIndex = new ArrayList<>();
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j]=='.'){
                    emptyIndex.add((i * 9) + j);
                }
            }
        }

        solveSudoku(board,emptyIndex,0);
        display(board);
    }

    public static void main(String[] args) {

        char [][]board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                          {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                          {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                          {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                          {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                          {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                          {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                          {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                          {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        solveSudoku(board);
    }
}
