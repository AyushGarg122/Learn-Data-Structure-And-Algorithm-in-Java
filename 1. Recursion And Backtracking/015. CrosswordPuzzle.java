import java.util.*;
public class Main {

    public static void display(char [][]board){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafeToPlace_H(char[][]board, int r, int c, String word){
        int l = word.length();
        int m = board[0].length;

        if(l + c > m){
            return false;
        }

        if(c==0 && c + l<m && board[r][c + l] != '+'){
            return false;
        }

        if(c + l==m && c!=0 && board[r][c - 1] != '+'){
            return false;
        }

        if(c!=0 && c + l<m && (board[r][c-1]!='+' || board[r][c+l]!='+')){
            return false;
        }

        for(int i=0; i<word.length(); i++){
            if(board[r][c+i]!='-' && board[r][c+i]!=word.charAt(i)){
                return false;
            }
        }

        return true;
    }

    public static int place_H(char[][]board, int r, int c, String word){
        int loc = 0;
        for(int i=0; i<word.length(); i++){
            if(board[r][c+i] == '-'){
                int mask = (1 << i);
                loc = loc ^ mask;
                board[r][c+i] = word.charAt(i);
            }
        }

        return loc;
    }

    public static void unPlace_H(char[][]board, int r, int c, int loc, String word){
        for(int i=0; i<word.length(); i++){
            int mask = (1 << i);
            if((mask & loc)!=0){
                board[r][c + i] = '-';
            }
        }
    }

    public static boolean isSafeToPlace_V(char[][]board, int r, int c, String word){
        int l = word.length();
        int n = board.length;

        if(l + r > n){
            return false;
        }

        if(r==0 && r + l<n && board[r + l][c] != '+'){
            return false;
        }

        if(r + l==n && r!=0 && board[r - 1][c] != '+'){
            return false;
        }

        if(r!=0 && r + l<n && (board[r - 1][c]!='+' || board[r + l][c]!='+')){
            return false;
        }

        for(int i=0; i<word.length(); i++){
            if(board[r + i][c]!='-' && board[r + i][c]!=word.charAt(i)){
                return false;
            }
        }

        return true;
    }

    public static int place_V(char[][]board, int r, int c, String word){
        int loc = 0;
        for(int i=0; i<word.length(); i++){
            if(board[r + i][c] == '-'){
                int mask = (1 << i);
                loc = loc ^ mask;
                board[r + i][c] = word.charAt(i);
            }
        }

        return loc;
    }

    public static void unPlace_V(char[][]board, int r, int c, int loc, String word){
        for(int i=0; i<word.length(); i++){
            int mask = (1 << i);
            if((mask & loc)!=0){
                board[r + i][c] = '-';
            }
        }
    }

    public static int crosswordPuzzle(char[][]board, String[]words, int idx){
        if(idx==words.length){
            display(board);
            return 1;
        }

        int n = board.length, m = board[0].length;
        String word = words[idx];

        int count = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){

                if(board[i][j] == '-' || board[i][j] == word.charAt(0)){

                    if(isSafeToPlace_H(board,i,j,word)){
                        int loc = place_H(board,i,j,word);
                        count+= crosswordPuzzle(board,words,idx+1);
                        unPlace_H(board,i,j,loc,word);
                    }

                    if(isSafeToPlace_V(board,i,j,word)){
                        int loc = place_V(board,i,j,word);
                        count+= crosswordPuzzle(board,words,idx+1);
                        unPlace_V(board,i,j,loc,word);
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        char[][] box = { { '+', '-', '+', '+', '+', '+', '+', '+', '+', '+' },
                { '+', '-', '+', '+', '+', '+', '+', '+', '+', '+' }, { '+', '-', '-', '-', '-', '-', '-', '-', '+', '+' },
                { '+', '-', '+', '+', '+', '+', '+', '+', '+', '+' }, { '+', '-', '+', '+', '+', '+', '+', '+', '+', '+' },
                { '+', '-', '-', '-', '-', '-', '-', '+', '+', '+' }, { '+', '-', '+', '+', '+', '-', '+', '+', '+', '+' },
                { '+', '+', '+', '+', '+', '-', '+', '+', '+', '+' }, { '+', '+', '+', '+', '+', '-', '+', '+', '+', '+' },
                { '+', '+', '+', '+', '+', '+', '+', '+', '+', '+' } };

        String[]words = {"agra", "norway", "england", "gwalior"};

        System.out.println(crosswordPuzzle(box,words,0));
    }
}
