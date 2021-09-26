import java.util.*;
public class Main {

    public static int queenCombinations(int tnb, int tnq, int bno, int qno, String ans){
        if(qno==tnq){
            System.out.println(ans);
            return 1;
        }

        int count = 0;

        for(int i=bno; i<tnb; i++){
            count+= queenCombinations(tnb,tnq,i+1,qno+1,ans + "b" + i + "q" + qno + " ");
        }

        return count;
    }

    public static int queenPermutations(boolean[]box, int tnq, int qno, String ans){
        if(qno==tnq){
            System.out.println(ans);
            return 1;
        }

        int count = 0;

        for(int i=0; i<box.length; i++){
            if(!box[i]){
                box[i] = true;
                count+= queenPermutations(box,tnq,qno+1, ans + "b" + i + "q" + qno + " ");
                box[i] = false;
            }
        }

        return count;
    }

    public static int queenCombinations2D(int[][]board, int tnq, int bno, int qno, String ans){
        if(qno==tnq){
            System.out.println(ans);
            return 1;
        }

        int count = 0, n = board.length, m = board[0].length;

        for(int i=bno; i<n * m; i++){
            int r = i / m;
            int c = i % m;
            count+= queenCombinations2D(board,tnq,i+1,qno+1,ans + "(" + r + "," + c + ") ");
        }

        return count;
    }


    public static int queenPermutations2D(int[][]board, int tnq, int qno, String ans){
        if(qno==tnq){
            System.out.println(ans);
            return 1;
        }

        int count = 0, n = board.length, m = board[0].length;

        for(int i=0; i<n * m; i++){
            int r = i / m;
            int c = i % m;

            if(board[r][c]==0){
                board[r][c]=1;
                count+= queenPermutations2D(board,tnq,qno+1, ans + "(" + r + "," + c + ") ");
                board[r][c]=0;
            }
        }

        return count;
    }


    public static void combinationsPermutations(){
        boolean[]box = new boolean[5];
        int [][]board = new int[4][4];

//        System.out.println(queenCombinations(5,3,0,0,""));
//        System.out.println(queenPermutations(box,3,0,""));
//        System.out.println(queenCombinations2D(board,4,0,0,""));
//        System.out.println(queenPermutations2D(board,4,0,""));
    }

    public static int queenCombinationsSubsequence(int tnb, int tnq, int bno, int qno, String ans){
        if(bno==tnb || qno==tnq){
            if(qno==tnq){
                System.out.println(ans);
                return 1;
            }

            return 0;
        }

        int count = 0;

        count+= queenCombinationsSubsequence(tnb,tnq,bno+1,qno+1,ans + "b" + bno + "q" + qno + " ");
        count+= queenCombinationsSubsequence(tnb,tnq,bno+1,qno,ans);

        return count;
    }

    public static int queenPermutationsSubsequence(boolean[]box, int tnq, int bno, int qno, String ans){
        if(bno==box.length || qno==tnq){
            if(qno==tnq){
                System.out.println(ans);
                return 1;
            }

            return 0;
        }

        int count = 0;

        if(!box[bno]){
            box[bno] = true;
            count+= queenPermutationsSubsequence(box,tnq,0,qno+1,ans + "b" + bno + "q" + qno + " ");
            box[bno] = false;
        }

        count+= queenPermutationsSubsequence(box,tnq,bno+1,qno,ans);
        return count;
    }


    public static int queenCombinations2DSubsequence(int [][]board, int bno, int tnq, int qno, String ans){
        int n = board.length, m = board[0].length;

        if(bno==n*m || qno==tnq){
            if(qno==tnq){
                System.out.println(ans);
                return 1;
            }

            return 0;
        }

        int count = 0;

        int r = bno / m;
        int c = bno % m;

        count+= queenCombinations2DSubsequence(board,bno+1,tnq,qno+1,ans + "(" + r + "," + c + ")");
        count+= queenCombinations2DSubsequence(board,bno+1,tnq,qno,ans);

        return count;
    }

    public static int queenPermutations2DSubsequence(int [][]board, int bno, int tnq, int qno, String ans){
        int n = board.length, m = board[0].length;

        if(bno==n*m || qno==tnq){
            if(qno==tnq){
                System.out.println(ans);
                return 1;
            }

            return 0;
        }

        int count = 0;

        int r = bno / m;
        int c = bno % m;

        if(board[r][c]==0){
            board[r][c] = 1;
            count+= queenPermutations2DSubsequence(board,0,tnq,qno+1,ans + "(" + r + "," + c + ")");
            board[r][c] = 0;
        }

        count+= queenPermutations2DSubsequence(board,bno+1,tnq,qno,ans);

        return count;
    }

    public static void combinationsPermutationsSubsequence(){
        boolean[]box = new boolean[5];
        int [][]board = new int[4][4];
//        System.out.println(queenCombinationsSubsequence(5,3,0,0,""));
//        System.out.println(queenPermutationsSubsequence(box,3,0,0,""));
//        System.out.println(queenCombinations2DSubsequence(board,0,4,0,""));
//        System.out.println(queenPermutations2DSubsequence(board,0,4,0,""));
    }

    public static void main(String[] args) {
        combinationsPermutations();
        combinationsPermutationsSubsequence();
    }
}
