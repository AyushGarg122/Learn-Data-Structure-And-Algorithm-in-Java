import java.util.*;
public class Main {

    public static int Nqueens(int n, int row, int col, int d1, int d2, String ans){
        if(row==n){
            System.out.println(ans);
            return 1;
        }

        int count = 0;

        for(int c = 0; c<n; c++){
            if((col & (1<<c)) == 0 && (d1 & (1<<(row + c)))==0 && (d2 & (1<<((row - c) + (n-1))))==0){
                col = col ^ (1<<c);
                d1 = (d1 ^ (1<<(row + c)));
                d2 = (d2 ^ (1<<((row - c) + (n-1))));

                count+= Nqueens(n,row+1,col,d1,d2,ans + "(" + row + "," + c + ") ");

                col = col ^ (1<<c);
                d1 = (d1 ^ (1<<(row + c)));
                d2 = (d2 ^ (1<<((row - c) + (n-1))));
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int row = 0;
        int col = 0;
        int d1 = 0;
        int d2 = 0;

        System.out.println(Nqueens(4,row,col,d1,d2,""));
    }
}
