import java.util.*;
public class Main {

    public static int NQueenCombinations(int n, int m, int r, String ans, boolean []row, boolean []col, boolean []d1, boolean []d2){
        if(r==n){
            System.out.println(ans);
            return 1;
        }

        int count = 0;

        for(int c = 0; c<m; c++){
            if(!row[r] && !col[c] && !d1[r + c] && !d2[(r-c) + (m-1)]){
                row[r] = col[c] = d1[r + c] = d2[(r-c) + (m-1)] = true;
                count+= NQueenCombinations(n,m,r+1,ans + "(" + r + "," + c + ") ", row,col,d1,d2);
                row[r] = col[c] = d1[r + c] = d2[(r-c) + (m-1)] = false;
            }
        }

        return count;
    }

    public static void NQueen(){
        int n = 4;
        int m = 4;

        boolean[]row = new boolean[n];
        boolean[]col = new boolean[m];
        boolean[]d1 = new boolean[n + m - 1];
        boolean[]d2 = new boolean[n + m - 1];

//        System.out.println(NQueenCombinations(n,m,0,"",row,col,d1,d2));
    }

    public static int NQueenCombinationsSubsequence(int n, int m, int r, int c,String ans, boolean []row, boolean []col, boolean []d1, boolean []d2){
        if(r==n || c==m){
            if(r==n){
                System.out.println(ans);
                return 1;
            }
            return 0;
        }

        int count = 0;


        if(!row[r] && !col[c] && !d1[r + c] && !d2[(r-c) + (m-1)]){
            row[r] = col[c] = d1[r + c] = d2[(r-c) + (m-1)] = true;
            count+= NQueenCombinationsSubsequence(n,m,r+1,0,ans + "(" + r + "," + c + ") ", row,col,d1,d2);
            row[r] = col[c] = d1[r + c] = d2[(r-c) + (m-1)] = false;
        }

        count+= NQueenCombinationsSubsequence(n,m,r,c+1,ans,row,col,d1,d2);
        return count;
    }

    public static int NQueensPermutationsSubsequence(int n, int m, int r, int tnq, String ans, boolean []row, boolean []col, boolean []d1, boolean []d2){
        if(r==n || tnq==0){
            if(tnq==0){
                System.out.println(ans);
                return 1;
            }
            return 0;
        }

        int count = 0;

        for(int c = 0; c<m; c++){
            if(!row[r] && !col[c] && !d1[r + c] && !d2[(r-c) + (m-1)]){
                row[r] = col[c] = d1[r + c] = d2[(r-c) + (m-1)] = true;
                count+= NQueensPermutationsSubsequence(n,m,0,tnq-1,ans + "(" + r + "," + c + ") ", row,col,d1,d2);
                row[r] = col[c] = d1[r + c] = d2[(r-c) + (m-1)] = false;
            }
        }

        count+=  NQueensPermutationsSubsequence(n,m,r+1,tnq,ans,row,col,d1,d2);
        return count;
    }
    
    public static void NQueenSubsequence(){
        int n = 4;
        int m = 4;

        boolean[]row = new boolean[n];
        boolean[]col = new boolean[m];
        boolean[]d1 = new boolean[n + m - 1];
        boolean[]d2 = new boolean[n + m - 1];

//        System.out.println(NQueenCombinationsSubsequence(n,m,0,0,"",row,col,d1,d2));
        System.out.println(NQueensPermutationsSubsequence(n,m,0,4,"",row,col,d1,d2));
    }

    public static void main(String[] args) {
        NQueen();
        NQueenSubsequence();
    }
}
