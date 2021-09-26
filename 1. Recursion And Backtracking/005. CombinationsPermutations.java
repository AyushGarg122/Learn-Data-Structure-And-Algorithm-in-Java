import java.util.*;
public class Main {

    public static int permutationsInfiCoins(int []arr, int tar, String ans){
        if(tar==0){
            System.out.println(ans);
            return 1;
        }

        int count = 0;

        for(int ele: arr){
            if(tar-ele>=0){
                count+= permutationsInfiCoins(arr,tar-ele,ans + ele);
            }
        }

        return count;
    }

    public static int combinationsInfiCoins(int []arr, int idx, int tar, String ans){
        if(tar==0){
            System.out.println(ans);
            return 1;
        }

        int count = 0;

        for(int i=idx; i<arr.length; i++){
            if(tar-arr[i]>=0){
                count+= combinationsInfiCoins(arr,i,tar-arr[i],ans + arr[i]);
            }
        }

        return count;
    }

    public static int combinationsSingleCoins(int []arr, int idx, int tar, String ans){
        if(tar==0){
            System.out.println(ans);
            return 1;
        }

        int count = 0;

        for(int i=idx; i<arr.length; i++){
            if(tar-arr[idx]>=0){
                count+= combinationsSingleCoins(arr,i+1,tar-arr[i],ans + arr[i]);
            }
        }

        return count;
    }

    public static int permutationsSingleCoins(int []arr, int tar, String ans){
        if(tar==0){
            System.out.println(ans);
            return 1;
        }

        int count = 0;

        for(int i=0; i<arr.length; i++){
            if(arr[i]>0 && tar-arr[i]>=0){
                int val = arr[i];
                arr[i] = -1;
                count+= permutationsSingleCoins(arr,tar-val,ans + val);
                arr[i] = val;
            }
        }

        return count;
    }

    public static void permutationsCombinations(){
        int []arr = {2,3,5,7};
        int tar = 10;

//        System.out.println(permutationsInfiCoins(arr,tar,""));
//        System.out.println(combinationsInfiCoins(arr,0,tar,""));
//        System.out.println(combinationsSingleCoins(arr,0,tar,""));
//        System.out.println(permutationsSingleCoins(arr,tar,""));
    }

    public static int subsequence(String str, int idx, String ans){
        System.out.println(ans);

        int count = 0;

        for(int i=idx; i<str.length(); i++){
            count+= subsequence(str,i+1,ans + str.charAt(i));
        }

        return count;
    }

    public static int combinationsSingleCoinsSubsequence(int []arr, int idx, int tar, String ans){
        if (idx == arr.length || tar == 0) {
            if(tar==0){
                System.out.println(ans);
                return 1;
            }

            return 0;
        }

        int count = 0;

        if(tar - arr[idx]>=0){
            count+= combinationsSingleCoinsSubsequence(arr,idx+1,tar - arr[idx],ans + arr[idx]);
        }

        count+= combinationsSingleCoinsSubsequence(arr,idx+1,tar,ans);
        return count;
    }

    public static int permutationsInfiCoinsSubsequence(int []arr, int idx, int tar, String ans){
        if(idx==arr.length || tar==0){
            if(tar==0){
                System.out.println(ans);
                return 1;
            }

            return 0;
        }

        int count = 0;

        if(tar-arr[idx]>=0){
            count+= permutationsInfiCoinsSubsequence(arr,0,tar-arr[idx],ans + arr[idx]);
        }

        count+= permutationsInfiCoinsSubsequence(arr,idx+1,tar,ans);
        return count;
    }

    public static int permutationsSingleCoinsSubsequence(int []arr, int idx, int tar, String ans){
        if(idx==arr.length || tar==0){
            if(tar==0){
                System.out.println(ans);
                return 1;
            }

            return 0;
        }

        int count = 0;

        if(arr[idx]>0 && tar-arr[idx]>=0){
            int val = arr[idx];
            arr[idx] = -val;
            count+= permutationsSingleCoinsSubsequence(arr,0,tar-val,ans+val);
            arr[idx] = val;
        }

        count+= permutationsSingleCoinsSubsequence(arr,idx+1,tar,ans);
        return count;
    }

    public static int combinationsInfiCoinsSubsequence(int []arr, int idx, int tar, String ans){
        if(idx==arr.length || tar==0){
            if (tar == 0) {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }

        int count = 0;

        if(tar-arr[idx]>=0){
            count+= combinationsInfiCoinsSubsequence(arr,idx,tar-arr[idx],ans+arr[idx]);
        }

        count+= combinationsInfiCoinsSubsequence(arr,idx+1, tar,ans);
        return count;
    }

    public static void combinationPermutationsUsingSubsequence(){
        int []arr = {2,3,5,7};
        int tar = 10;

//        System.out.println(combinationsSingleCoinsSubsequence(arr,0,tar,""));
//        System.out.println(permutationsInfiCoinsSubsequence(arr,0,tar,""));
//        System.out.println(permutationsSingleCoinsSubsequence(arr,0,tar,""));
//        System.out.println(combinationsInfiCoinsSubsequence(arr,0,tar,""));
    }



    public static void main(String[] args) {
//        permutationsCombinations();
//        subsequence("abc", 0, "");
//        combinationPermutationsUsingSubsequence();
    }
}
