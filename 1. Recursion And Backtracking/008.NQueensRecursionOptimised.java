import java.util.*;
public class Main {

    public static boolean isQueenSafe(boolean[][]board, int r, int c, int [][]dir){
        int n = board.length;

        for(int i=0; i<dir.length; i++){
            for(int rad=1; rad<n; rad++){
                int sr = r + (rad * dir[i][0]);
                int sc = c + (rad * dir[i][1]);

                if(sr>=0 && sc>=0 && sr<n && sc<n){
                    if(board[sr][sc]){
                        return false;
                    }
                }else{
                    break;
                }
            }
        }

        return true;
    }

    public static int NQueenCombination(boolean[][]board, int r, String ans, int [][]dir){
        int n = board.length;

        if(r==n){
            System.out.println(ans);
            return 1;
        }

        int count = 0;

        for(int i=0; i<n; i++){
            int c = i;
            if(isQueenSafe(board,r,c,dir)){
                board[r][c] = true;
                count+= NQueenCombination(board,r+1,ans + "(" + r + "," + c + ") " , dir);
                board[r][c] = false;
            }
        }

        return count;
    }

    public static void NQueen(){
        int [][]dir = {{-1,0}, {-1,1}, {0,1},{1,1}, {1,0},{1,-1},{0,-1},{-1,-1}};
        boolean[][]board = new boolean[4][4];
        int tnq = 4;

        System.out.println(NQueenCombination(board,0,"",dir));
    }

    public static int NQueenCombinationsSubsequence(boolean[][]board, int r, int c, String ans, int [][]dir){
        int n = board.length;
        if (r == n || c == n) {
            if(r==n){
                System.out.println(ans);
                return 1;
            }

            return 0;
        }

        int count = 0;

        if(isQueenSafe(board,r,c,dir)){
            board[r][c] = true;
            count+= NQueenCombinationsSubsequence(board,r+1,0,ans + "(" + r + "," + c + ") ",dir);
            board[r][c] = false;
        }

        count+= NQueenCombinationsSubsequence(board,r,c+1,ans,dir);

        return count;
    }

    public static int NQueenPermutationSubsequence(boolean[][]board, int r,  int tnq, String ans, int [][]dir){
        int n = board.length;

        if(r==n || tnq==0){
            if(tnq==0){
                System.out.println(ans);
                return 1;
            }

            return 0;
        }

        int count = 0;

        for(int c=0; c<n; c++){
            if(!board[r][c] && isQueenSafe(board,r,c,dir)){
                board[r][c] = true;
                count+= NQueenPermutationSubsequence(board,0,tnq-1,ans + "(" +r + "," + c + ") ", dir);
                board[r][c] = false;
            }
        }

        count+= NQueenPermutationSubsequence(board,r+1,tnq,ans,dir);

        return count;
    }

    public static void NQueenSubsequence(){
        int [][]dir = {{-1,0}, {-1,1}, {0,1},{1,1}, {1,0},{1,-1},{0,-1},{-1,-1}};
        boolean[][]board = new boolean[4][4];
        int tnq = 4;

        System.out.println(NQueenCombinationsSubsequence(board,0,0,"",dir));
        System.out.println(NQueenPermutationSubsequence(board,0,tnq,"",dir));
    }


    public static void main(String[] args) {
        NQueen();
        NQueenSubsequence();
    }
}
