import java.util.*;
public class Main {

    public static void display(char[][]board){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean solveSudoku(char[][]board, ArrayList<Integer> emptyIndex, int idx, int []row, int []col, int [][]matrix){
        if(idx==emptyIndex.size()){
            return true;
        }

        int ele = emptyIndex.get(idx);
        int r = ele / 9;
        int c = ele % 9;

        for(int num=1; num<=9; num++){
            int mask = (1 << num);

            if((row[r] & mask)==0 && (col[c] & mask)==0 && (matrix[r/3][c/3] & mask)==0){
                row[r] = row[r] ^ mask;
                col[c] = col[c] ^ mask;
                matrix[r/3][c/3] = matrix[r/3][c/3] ^ mask;
                board[r][c] = (char) (num + '0');

                if(solveSudoku(board,emptyIndex,idx+1,row,col,matrix)){
                    return true;
                }

                board[r][c] = '.';
                row[r] = row[r] ^ mask;
                col[c] = col[c] ^ mask;
                matrix[r/3][c/3] = matrix[r/3][c/3] ^ mask;
            }
        }

        return false;
    }

    public static void solveSudoku(char[][]board){
        int []row = new int[9];
        int []col = new int[9];
        int [][]matrix = new int[3][3];

        ArrayList<Integer> emptyIndex = new ArrayList<>();

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == '.'){
                    emptyIndex.add((i * 9) + j);
                }else{
                    int num = board[i][j] - '0';
                    int mask = (1 << num);
                    row[i] = row[i] ^ mask;
                    col[j] = col[j] ^ mask;
                    matrix[i/3][j/3] = matrix[i/3][j/3] ^ mask;
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
