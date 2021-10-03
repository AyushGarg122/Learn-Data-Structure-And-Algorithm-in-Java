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

    public static boolean solveSudoku(char[][]board, ArrayList<Integer>emptyIndex, int idx, boolean[][]row, boolean[][]col, boolean[][][]matrix){
        if(idx==emptyIndex.size()){
            return true;
        }

        int ele = emptyIndex.get(idx);
        int r = ele / 9;
        int c = ele % 9;

        for(int num=1; num<=9; num++){
            if(!row[r][num] && !col[c][num] && !matrix[r/3][c/3][num]){
                row[r][num] = col[c][num] = matrix[r/3][c/3][num] = true;
                board[r][c] = (char)(num + '0');

                if(solveSudoku(board,emptyIndex,idx+1,row,col,matrix)){
                    return true;
                }

                board[r][c] = '.';
                row[r][num] = col[c][num] = matrix[r/3][c/3][num] = false;
            }
        }

        return false;
    }

    public static void solveSudoku(char [][]board){
        boolean [][]row = new boolean[9][10];
        boolean [][]col = new boolean[9][10];
        boolean [][][] matrix = new boolean[3][3][10];

        ArrayList<Integer> emptyIndex = new ArrayList<>();
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == '.'){
                    emptyIndex.add((i * 9) + j);
                }else{
                    int num = board[i][j] - '0';
                    row[i][num] = true;
                    col[j][num] = true;
                    matrix[i/3][j/3][num] = true;
                }
            }
        }

        solveSudoku(board,emptyIndex,0,row,col,matrix);
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
