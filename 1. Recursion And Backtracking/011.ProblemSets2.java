import java.util.*;
public class Main {

    // Leet Code Question  39
    public static void combinationsSum(int []arr, int idx, int tar, List<Integer>ans, List<List<Integer>>myAns){
        if(idx==arr.length || tar==0){
            if(tar==0){
                List<Integer> base = new ArrayList<>(ans);
                myAns.add(base);
            }

            return;
        }


        if(tar - arr[idx]>=0){
            ans.add(arr[idx]);
            combinationsSum(arr,idx,tar - arr[idx], ans,myAns);
            ans.remove(ans.size()-1);
        }

        combinationsSum(arr,idx + 1,tar, ans,myAns);
    }

    // Leet Code Question  39
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> myAns = new ArrayList<>();

        combinationsSum(candidates, 0, target, ans,myAns);

        return myAns;
    }

    // LeetCode Question 40
    public static void combinationSum2(int []arr, int idx, int tar, List<Integer> ans, List<List<Integer>>myAns){
        if(tar==0){
            List<Integer> base = new ArrayList<>(ans);
            myAns.add(base);
            return;
        }

        int prev = -1;

        for(int i=idx; i<arr.length; i++){
            if(prev!=arr[i] && tar - arr[i]>=0 ){
                ans.add(arr[i]);
                combinationSum2(arr,i+1,tar - arr[i], ans,myAns);
                ans.remove(ans.size()-1);
                prev = arr[i];
            }
        }
    }

    // LeetCode Question 40
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> myAns = new ArrayList<>();

        Arrays.sort(candidates);

        combinationSum2(candidates, 0, target, ans,myAns);

        return myAns;
    }

    // LeetCode Question 322
    public int CoinChange(int[] coins, int amount) {
        if(amount==0){
            return 0;
        }

        int min = (int)1e9;

        for(int ele: coins){
            if(amount-ele>=0){
                int recAns = CoinChange(coins, amount - ele);
                if(recAns!= (int)1e9 && recAns+1 < min){
                    min = recAns + 1;
                }
            }
        }

        return min;
    }

    // LeetCode Question 322
    public int coinChange(int[] coins, int amount) {
        int ans = CoinChange(coins, amount);
        return ans==(int)1e9? -1: ans;
    }
}
