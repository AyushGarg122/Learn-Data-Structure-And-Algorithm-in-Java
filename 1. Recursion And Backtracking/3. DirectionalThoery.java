package RecursionAndBacktracking;
import java.util.*;
public class DirectionalTheory {

    public static int mazePath_HVD(int sr, int sc, int er, int ec, int [][]dir, String []dirS, ArrayList<String>ans, String psf){
        if(sr==er && sc==ec){
            ans.add(psf);
            return 1;
        }

        int count = 0;

        for(int d=0; d<dir.length; d++){
            int x = sr + dir[d][0];
            int y = sc + dir[d][1];

            if(x<=er && y<=ec){
                count+= mazePath_HVD(x,y,er,ec,dir,dirS,ans,psf + dirS[d]);
            }
        }

        return count;
    }

    public static int floodFill(int sr, int sc, boolean[][]vis, int [][]dir, String[]dirS, ArrayList<String>ans, String psf){
        int n = vis.length; int m = vis[0].length;

        if(sr==n-1 && sc==m-1){
            ans.add(psf);
            return 1;
        }

        int count = 0;

        vis[sr][sc] = true;

        for(int d=0; d<dir.length; d++){
            int x = sr + dir[d][0];
            int y = sc + dir[d][1];

            if(x>=0 && x<n && y>=0 && y<m && !vis[x][y]){
                count+= floodFill(x,y,vis,dir,dirS,ans,psf + dirS[d]);
            }
        }

        vis[sr][sc] = false;
        return count;
    }

    public static int floodFillMulti(int sr, int sc, boolean[][]vis, int [][]dir, String[]dirS, ArrayList<String>ans, String psf){
        int n = vis.length; int m = vis[0].length;

        if(sr==n-1 && sc==m-1){
            ans.add(psf);
            return 1;
        }

        int count = 0;

        vis[sr][sc] = true;

        for(int d=0; d<dir.length; d++){
            for(int rad=1; rad<=Math.max(m,n); rad++) {
                int x = sr + (rad * dir[d][0]);
                int y = sc + (rad * dir[d][1]);

                if (x >= 0 && x < n && y >= 0 && y < m) {
                    if(!vis[x][y]) {
                        count += floodFillMulti(x, y, vis, dir, dirS, ans, psf + dirS[d] + rad);
                    }
                }else{
                    break;
                }
            }
        }

        vis[sr][sc] = false;
        return count;
    }

    public static void mazePath(){
        int [][]dir = {{1,0}, {1,1}, {0,1}};
        String[]dirS = {"V","D","H"};

        ArrayList<String> ans = new ArrayList<>();
        System.out.println(mazePath_HVD(0,0,2,2,dir,dirS,ans,""));
        System.out.println(ans);
    }

    public static void floodFill(){
        int [][]dir = {{-1,0}, {0,-1}, {1,0}, {0,1}};
        String[]dirS = {"U","L","D","R"};

        ArrayList<String> ans = new ArrayList<>();
        boolean[][]visited = new boolean[3][3];

//        System.out.println(floodFill(0,0,visited,dir,dirS,ans,""));
//        System.out.println(ans);

        System.out.println(floodFillMulti(0,0,visited,dir,dirS,ans,""));
        System.out.println(ans);
    }

    public static void main(String[] args) {
//        mazePath();
        floodFill();
    }
}
