package RecursionAndBacktracking;
import java.util.*;
public class MazePaths {

    public static ArrayList<String> mazePath_HVD(int sr, int sc, int er, int ec){
        if(sr==er && sc==ec){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> myAns = new ArrayList<>();

        if(sr+1<=er){
            ArrayList<String> vertical = mazePath_HVD(sr+1,sc,er,ec);
            for(String s: vertical){
                myAns.add("V" + s);
            }
        }

        if(sr+1<=er && sc+1<=ec){
            ArrayList<String> diagonal = mazePath_HVD(sr+1,sc+1,er,ec);
            for(String s: diagonal){
                myAns.add("D" + s);
            }
        }

        if(sc+1<=ec){
            ArrayList<String> horizontal = mazePath_HVD(sr,sc+1,er,ec);
            for(String s: horizontal){
                myAns.add("H" + s);
            }
        }

        return myAns;
    }

    public static int mazePath_HVD(int sr, int sc, int er, int ec, ArrayList<String>ans, String psf) {
        if(sr==er && sc==ec){
            ans.add(psf);
            return 1;
        }

        int count = 0;

        if(sr + 1<=er){
            count+= mazePath_HVD(sr+1,sc,er,ec,ans,psf + "V");
        }

        if(sr + 1<=er && sc+1<=ec){
            count+= mazePath_HVD(sr+1,sc+1,er,ec,ans,psf + "D");
        }

        if(sc + 1<=ec){
            count+= mazePath_HVD(sr,sc+1,er,ec,ans,psf + "H");
        }

        return count;
    }

    public static ArrayList<String> mazePath_HVD_Multi(int sr, int sc, int er, int ec){
        if(sr==er && sc==ec){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> myAns = new ArrayList<>();

        for(int jump=1; sr+jump<=er; jump++){
            ArrayList<String> vertical = mazePath_HVD_Multi(sr+jump,sc,er,ec);
            for(String s: vertical){
                myAns.add("V" + jump + s);
            }
        }

        for(int jump=1; sr+jump<=er && sc+jump<=ec; jump++){
            ArrayList<String> diagonal = mazePath_HVD_Multi(sr+jump,sc+jump,er,ec);
            for(String s: diagonal){
                myAns.add("D" + jump + s);
            }
        }

        for(int jump=1; sc+jump<=ec; jump++){
            ArrayList<String> horizontal = mazePath_HVD_Multi(sr,sc+jump,er,ec);
            for(String s: horizontal){
                myAns.add("H" + jump + s);
            }
        }

        return myAns;
    }

    public static int mazePath_HVD_Multi(int sr, int sc, int er, int ec, ArrayList<String>ans, String psf){
        if(sr==er && sc==ec){
            ans.add(psf);
            return 1;
        }

        int count = 0;

        for(int jump=1; sr + jump<=er; jump++){
            count+= mazePath_HVD_Multi(sr+jump,sc,er,ec,ans,psf + "V" + jump);
        }

        for(int jump=1; sr + jump<=er && sc+jump<=ec; jump++){
            count+= mazePath_HVD_Multi(sr+jump,sc+jump,er,ec,ans,psf + "D" + jump);
        }

        for(int jump=1; sc + jump<=ec; jump++){
            count+= mazePath_HVD_Multi(sr,sc+jump,er,ec,ans,psf + "H" + jump);
        }

        return count;
    }

    public static void MazePathUsingSimpleRecursion(){
        ArrayList<String> ans = new ArrayList<>();
//        System.out.println(mazePath_HVD(0,0,2,2));
//        System.out.println(mazePath_HVD(0,0,2,2,ans,""));
//        System.out.println(ans);
//        System.out.println(mazePath_HVD_Multi(0,0,2,2));
//        System.out.println(mazePath_HVD_Multi(0,0,2,2,ans,""));
//        System.out.println(ans);
    }

    public static void main(String[] args) {
        MazePathUsingSimpleRecursion();
    }
}
