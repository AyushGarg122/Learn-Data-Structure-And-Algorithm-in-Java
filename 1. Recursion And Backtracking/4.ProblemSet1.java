import java.util.*;
public class Main {

    public static int equalSets(int []arr, int idx, int sum1, int sum2, String ans1, String ans2){
        if(idx==arr.length){
            if(sum1==sum2){
                System.out.println(ans1 + "= " + ans2);
                return 1;
            }

            return 0;
        }

        int count = 0;

        count+= equalSets(arr,idx+1, sum1 + arr[idx], sum2, ans1 + arr[idx] + " ", ans2);
        count+= equalSets(arr,idx+1,sum1, sum2 + arr[idx], ans1, ans2 + arr[idx] + " ");

        return count;
    }

    public static void equalSets(){
        int []arr = {10,20,30,40,50,60,70,80};
        int ans = equalSets(arr,1,arr[0],0,arr[0] + " ", "");
        System.out.println(ans);
    }

    public static int permutations(String str, String ans){
        if(str.length()==0){
            System.out.println(ans);
            return 1;
        }

        int count = 0;

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            String rest = str.substring(0, i) + str.substring(i+1);
            count+= permutations(rest,ans + ch);
        }

        return count;
    }

    public static ArrayList<String> permutations(String str){
        if(str.length()==0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> myAns = new ArrayList<>();

        for(int i=0; i<str.length(); i++){
            String rest = str.substring(0,i) + str.substring(i+1);
            ArrayList<String> recAns = permutations(rest);
            for(String s: recAns){
                myAns.add(str.charAt(i) + s);
            }
        }

        return myAns;
    }

    public static int permutationsUnique(String str, String ans){
        if(str.length()==0){
            System.out.println(ans);
            return 1;
        }

        int count = 0;

        boolean[]visit = new boolean[26];

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(!visit[ch - 'a']){
                visit[ch - 'a'] = true;
                String rest = str.substring(0,i) + str.substring(i+1);
                count+= permutationsUnique(rest,ans + ch);
            }
        }

        return count;
    }

    public static int permutationsUniqueTwo(String str, String ans){
        if(str.length()==0){
            System.out.println(ans);
            return 1;
        }

        int count = 0;

        char prev = '$';

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(prev!=ch) {
                prev = ch;
                String rest = str.substring(0, i) + str.substring(i + 1);
                count += permutationsUniqueTwo(rest, ans + ch);
            }
        }

        return count;
    }

    public static void permutations(){
//        System.out.println(permutations("abc", ""));
//        System.out.println(permutations("abc"));
//        System.out.println(permutationsUnique("aaaa",""));
        System.out.println(permutationsUniqueTwo("aab",""));
    }

    public static void main(String[] args) {
//        equalSets();
        permutations();
    }
}
