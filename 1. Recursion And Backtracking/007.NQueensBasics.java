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

    public static int NQueenCombinations(boolean[][]board, int idx, int tnq, String ans, int [][]dir){
        if(tnq==0){
            System.out.println(ans);
            return 1;
        }

        int n = board.length;
        int count = 0;


        for(int i=idx; i<n*n; i++){
            int r = i / n;
            int c = i % n;

            if(isQueenSafe(board,r,c,dir)){
                board[r][c] = true;
                count+= NQueenCombinations(board,i+1,tnq-1,ans + "(" + r + ", " + c + ") ",dir);
                board[r][c] = false;
            }
        }

        return count;
    }

    public static int NQueenPermutations(boolean[][]board, int tnq, String ans, int [][]dir){
        if(tnq==0){
            System.out.println(ans);
            return 1;
        }

        int n = board.length;
        int count = 0;

        for(int i=0; i<n * n; i++){
            int r = i / n;
            int c = i % n;

            if(!board[r][c] && isQueenSafe(board,r,c,dir)){
                board[r][c] = true;
                count+= NQueenPermutations(board,tnq-1,ans + "(" + r + ", " + c + ") ",dir);
                board[r][c] = false;
            }
        }

        return count;
    }

    public static void NQueen(){
        int [][]dir = {{-1,0}, {-1,1}, {0,1},{1,1}, {1,0},{1,-1},{0,-1},{-1,-1}};
        boolean[][]board = new boolean[4][4];
        int tnq = 4;
        System.out.println(NQueenCombinations(board,0,tnq,"",dir));
        System.out.println(NQueenPermutations(board,tnq,"",dir));
    }

    public static int NQueenCombinationsSubsequence(boolean[][]board, int idx, int tnq, String ans, int[][]dir){
        int n = board.length;

        if(idx==n*n || tnq==0){
            if(tnq==0){
                System.out.println(ans);
                return 1;
            }

            return 0;
        }

        int count = 0;
        int r = idx / n;
        int c = idx % n;

        if(isQueenSafe(board,r,c,dir)){
            board[r][c] = true;
            count+= NQueenCombinationsSubsequence(board,idx+1,tnq-1,ans + "(" + r + ", " + c + ") ",dir);
            board[r][c] = false;
        }

        count+= NQueenCombinationsSubsequence(board,idx+1,tnq,ans,dir);

        return count;
    }

    public static int NQueenPermutationsSubsequence(boolean[][]board, int idx, int tnq, String ans, int [][]dir){
        int n = board.length;
        if(idx==n*n || tnq==0){
            if(tnq==0){
                System.out.println(ans);
                return 1;
            }

            return 0;
        }

        int r = idx / n;
        int c = idx % n;
        int count = 0;

        if(!board[r][c] && isQueenSafe(board,r,c,dir)){
            board[r][c] = true;
            count+= NQueenPermutationsSubsequence(board,0,tnq-1,ans + "(" + r + ", " + c + ") ",dir);
            board[r][c] = false;
        }

        count+= NQueenPermutationsSubsequence(board,idx+1,tnq,ans,dir);

        return count;
    }

    public static void NQueenSubsequence(){
        int [][]dir = {{-1,0}, {-1,1}, {0,1},{1,1}, {1,0},{1,-1},{0,-1},{-1,-1}};
        boolean[][]board = new boolean[4][4];
        int tnq = 4;

        System.out.println(NQueenCombinationsSubsequence(board,0,tnq,"",dir));
        System.out.println(NQueenPermutationsSubsequence(board,0,tnq,"",dir));
    }

    public static void main(String[] args) {
        NQueen();
        NQueenSubsequence();
    }
}
