import java.util.*;
public class Main {

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

    public static class Pair{
        String psf;
        int len;

        Pair(String psf, int len){
            this.psf = psf;
            this.len = len;
        }
    }

    public static Pair maxiumumPath(int [][]visit, int sr, int sc, int [][]dir, String []dirS){
        int n = visit.length, m = visit[0].length;

        if(sr==n-1 && sc==m-1){
            Pair base = new Pair("",0);
            return base;
        }

        Pair myAns = new Pair("",-1);

        visit[sr][sc] = 0;

        for(int i=0; i<dir.length; i++){
            for(int rad=1; rad<=Math.max(n,m); rad++){
                int r = sr + (rad * dir[i][0]);
                int c = sc + (rad * dir[i][1]);

                if(r>=0 && c>=0 && r<n && c<m){
                    if(visit[r][c]==1){
                        Pair ans = maxiumumPath(visit,r,c,dir,dirS);
                        if(ans.len!=-1 && ans.len+1>myAns.len){
                            myAns.len = ans.len + 1;
                            myAns.psf = dirS[i] + rad + ans.psf;
                        }
                    }
                }else{
                    break;
                }
            }
        }

        visit[sr][sc] = 1;
        return myAns;
    }

    public static Pair shortestPath(int [][]visit, int sr, int sc, int [][]dir, String []dirS){
        int n = visit.length, m = visit[0].length;

        if(sr==n-1 && sc==m-1){
            Pair base = new Pair("",0);
            return base;
        }

        Pair myAns = new Pair("",(int)1e9);

        visit[sr][sc] = 0;

        for(int i=0; i<dir.length; i++){
            for(int rad=1; rad<=Math.max(n,m); rad++){
                int r = sr + (rad * dir[i][0]);
                int c = sc + (rad * dir[i][1]);

                if(r>=0 && c>=0 && r<n && c<m){
                    if(visit[r][c]==1){
                        Pair ans = shortestPath(visit,r,c,dir,dirS);
                        if(ans.len!=(int)1e9 && ans.len+1<myAns.len){
                            myAns.len = ans.len + 1;
                            myAns.psf = dirS[i] + rad +  ans.psf;
                        }
                    }
                }else{
                    break;
                }
            }
        }

        visit[sr][sc] = 1;
        return myAns;
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

//        System.out.println(floodFillMulti(0,0,visited,dir,dirS,ans,""));
//        System.out.println(ans);

        int [][]arr = {{1,1,1}, {1,1,1}, {1,1,1}};
//        Pair myans = maxiumumPath(arr,0,0,dir,dirS);
//        System.out.println(myans.len);
//        System.out.println(myans.psf);

        Pair myans = shortestPath(arr,0,0,dir,dirS);
        System.out.println(myans.len);
        System.out.println(myans.psf);
    }

    // Geeks for Geeks rat in a maze problem 1

    public static ArrayList<String> findPath(int[][] m, int n, int sr, int sc, int [][]dir, String []dirS) {
        if(sr==n-1 && sc==n-1){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        m[sr][sc] = 0;

        ArrayList<String> myAns = new ArrayList<>();

        for(int i=0; i<dir.length; i++){
            int r = sr + dir[i][0];
            int c = sc + dir[i][1];

            if(r>=0 && r<n && c>=0 && c<n && m[r][c]==1){
                ArrayList<String>recAns = findPath(m,n,r,c,dir,dirS);
                for(String s: recAns){
                    myAns.add(dirS[i] + s);
                }
            }
        }

        m[sr][sc] = 1;
        return myAns;
    }

    public static int FindWays(boolean[][]visit, int sr, int sc, int n, int m, int [][]dir){
        if(sr==n && sc==m){
            return 1;
        }

        int count = 0;

        for(int i=0; i<dir.length; i++){
            int r = sr + dir[i][0];
            int c = sc + dir[i][1];

            if(r<=n && c<=m && !visit[r][c]){
                count+= FindWays(visit,r,c,n,m,dir);
            }
        }

        return count % (((int)Math.pow(10,9)) + 7);
    }

    // Special Matrix Geeks for geeks
    public int FindWays(int n, int m, int[][] blocked_cells)
    {
        boolean[][]visit = new boolean[n+1][m+1];
        for(int []arr: blocked_cells){
            int r = arr[0];
            int c = arr[1];

            visit[r][c] = true;
        }

        if(visit[1][1] || visit[n][m]){
            return 0;
        }

        int [][]dir = {{1,0}, {0,1}};
        int ans = FindWays(visit,1,1,n,m,dir);
        return ans;
    }

    // Rat in a maze with multi jumps geeks for geeks
    public static void display(int [][]arr){
        for(int []a: arr){
            for(int ele: a){
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }

    public static void ratInAMaze(int [][]arr, int sr, int sc, int [][]dir, int [][]ans){
        int n = arr.length, m = arr[0].length;

        if(sr==n-1 && sc==m-1){
            ans[sr][sc] = 1;
            display(ans);
            ans[sr][sc] = 0;
            return;
        }

        ans[sr][sc] = 1;

        for(int i=0; i<dir.length; i++){
            for(int j=1; j<=arr[sr][sc]; j++){
                int r = sr + (j * dir[i][0]);
                int c = sc + (j * dir[i][1]);

                if(r<n && c<m && arr[r][c]!=0){
                    ratInAMaze(arr,r,c,dir,ans);
                }
            }
        }

        ans[sr][sc] = 0;
    }

    public static void ratInAMaze(){
        int [][]arr= {{2,1,0,0}, {3,0,0,1}, {0,1,0,1}, {0,0,0,1}};

        int [][]dir = {{1,0}, {0,1}};
        int [][]ans = new int[arr.length][arr[0].length];

        ratInAMaze(arr,0,0,dir,ans);
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        if(m[0][0]==0 || m[n-1][n-1]==0){
            return new ArrayList<>();
        }

        String []dirS = {"D", "L", "R", "U"};
        int [][]dir = {{1,0} , {0,-1}, {0,1}, {-1,0}};

        ArrayList<String> ans = findPath(m,n,0,0,dir,dirS);
        return ans;
    }

    public static void main(String[] args) {
//        mazePath();
        floodFill();
//        ratInAMaze();
    }
}
