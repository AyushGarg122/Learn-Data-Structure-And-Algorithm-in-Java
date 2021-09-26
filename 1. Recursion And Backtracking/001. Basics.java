import java.util.*;
public class Main {

    public static void printIncreasing(int a, int b){
        if(a>b){
            return;
        }

        System.out.println(a);
        printIncreasing(a+1,b);
    }

    public static void printDecreasing(int a, int b){
        if(a>b){
            return;
        }

        printDecreasing(a+1,b);
        System.out.println(a);
    }

    public static void printIncreasingDecreasing(int a, int b){
        if(a>b){
            return;
        }

        System.out.println(a);
        printIncreasingDecreasing(a+1,b);
        System.out.println(a);
    }

    public static void printOddEven(int a, int b){
        if(a>b){
            return;
        }

        if(a%2!=0){
            System.out.println(a);
        }

        printOddEven(a+1,b);

        if(a%2==0){
            System.out.println(a);
        }
    }

    public static int factorial(int n){
        if(n==0){
            return 1;
        }

        int ans = factorial(n - 1);
        ans = ans * n;
        return ans;
    }

    public static int power(int a, int x){
        if(x==0){
            return 1;
        }

        int ans = power(a,x-1);
        ans = ans * a;
        return ans;
    }

    public static int powerBetter(int a, int x){
        if(x==0){
            return 1;
        }

        int ans = powerBetter(a,x/2);
        ans = ans * ans;

        return x%2==0? ans : ans * a;
    }

    public static void basicsRecursion(){
        printIncreasing(5,10);
        printDecreasing(5,10);
        printIncreasingDecreasing(5,10);
        printOddEven(5,10);
        System.out.println(factorial(5));
        System.out.println(powerBetter(5,4));
        System.out.println(power(5,4));
    }


    public static void printArray(int []arr, int idx){
        if(idx==arr.length){
            return;
        }

        System.out.println(arr[idx]);
        printArray(arr,idx+1);
    }

    public static void printReverseArray(int []arr, int idx){
        if(idx==arr.length){
            return;
        }

        printReverseArray(arr,idx+1);
        System.out.println(arr[idx]);
    }

    public static int maximum(int []arr, int idx){
        if(idx==arr.length){
            return (int)-1e9;
        }

        int ans = maximum(arr,idx+1);
        return Math.max(ans,arr[idx]);
    }

    public static int minimum(int []arr, int idx){
        if(idx==arr.length){
            return (int)1e9;
        }

        int ans = minimum(arr,idx+1);
        return Math.min(ans,arr[idx]);
    }

    public static boolean find(int []arr, int idx, int tar){
        if(idx==arr.length){
            return false;
        }

        return arr[idx]==tar || find(arr,idx+1,tar);
    }

    public static int firstIndex(int []arr, int idx, int tar){
        if(idx==arr.length){
            return -1;
        }

        return arr[idx]==tar? idx: firstIndex(arr,idx+1,tar);
    }

    public static int lastIndex(int []arr, int idx, int tar){
        if(idx==arr.length){
            return -1;
        }

        int ans = lastIndex(arr,idx+1,tar);
        if(ans!=-1){
            return ans;
        }else{
            return arr[idx]==tar? idx: -1;
        }
    }

    public static int[] allIndex(int []arr, int idx, int count, int tar){
        if(idx==arr.length){
            int []base = new int[count];
            return base;
        }

        if(arr[idx]==tar){
            count++;
        }

        int []ans = allIndex(arr,idx+1,count,tar);

        if(arr[idx]==tar){
            ans[count-1] = idx;
        }

        return ans;
    }


    public static void recursionInArrays(){
        int []arr = {5,10,47,1,5,1,6,147,14,15,5,1,5,6,5};
        printArray(arr,0);
        printReverseArray(arr,0);
        System.out.println(minimum(arr,0));
        System.out.println(maximum(arr,0));
        System.out.println(find(arr,0,14));
        System.out.println(find(arr,0,447));
        System.out.println(firstIndex(arr,0,5));
        System.out.println(lastIndex(arr,0,5));

        int []ans = allIndex(arr,0,0,5);
        for(int ele: ans){
            System.out.println(ele);
        }
    }

    public static void PrintSubsequence(String str, String ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }

        char ch = str.charAt(0);
        String rest = str.substring(1);

        PrintSubsequence(rest,ans);
        PrintSubsequence(rest,ans + ch);
    }

    public static void printStairsPath(int n, String ans){
        if(n==0){
            System.out.println(ans);
            return;
        }

        for(int i=1; i<=3; i++){
            if(n-i>=0){
                printStairsPath(n-i, ans + i);
            }
        }
    }

    public static void recursionOnWayUp(){
        PrintSubsequence("abc","");
        printStairsPath(4,"");
    }

    public static ArrayList<String> getSub(String str){
        if(str.length()==0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> recAns = getSub(str.substring(1));

        ArrayList<String> myAns = new ArrayList<>(recAns);

        char ch = str.charAt(0);
        for(String s: recAns){
            myAns.add(ch + s);
        }

        return myAns;
    }

    public static ArrayList<String> getStairsPath(int n){
        if(n==0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> myAns = new ArrayList<>();

        for(int i=1; i<=3; i++){
            if(n-i>=0){
                ArrayList<String> recAns = getStairsPath(n - i);
                for(String s: recAns){
                    myAns.add(i + s);
                }
            }
        }

        return myAns;
    }

    public static void recursionWithArrayList(){
        System.out.println(getSub("abc"));
        System.out.println(getStairsPath(4));
    }

    public static void main(String[] args) {
        basicsRecursion();
        recursionInArrays();
        recursionOnWayUp();
        recursionWithArrayList();
    }
}
