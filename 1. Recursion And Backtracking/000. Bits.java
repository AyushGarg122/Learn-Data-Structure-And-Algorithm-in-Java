import java.util.*;
public class Main {

    public static void leftShift(){
        int n = 5;
        for(int i=1; i<=4; i++){
            System.out.println((n<<i));
        }

        int a = 5 * (int)Math.pow(2,10);
        int b = (5 << 10);
        System.out.println(a);
        System.out.println(b);
    }

    public static void rightShift(){
        int n = 80;
        for(int i=1; i<=4; i++){
            System.out.println((n>>i));
        }

        int a = 40 / 4;
        int b = (40 >> 2);

        System.out.println(a);
        System.out.println(b);
    }

    public static void tripleRightShift(){
        int n = 80;
        for(int i=1; i<=4; i++){
            System.out.println((n>>>i));
        }
    }

    public static void OffOn(int n, int k){
        int mask = (1 << k);
        int ans = (n | mask);
        System.out.println(ans);
    }

    public static void onOff(int n, int k){
        int mask = (~(1<<k));
        int ans = (n & mask);
        System.out.println(ans);
    }

    // LeetCode 191
    public int hammingWeight_01(int n) {

        int count = 0;
        for(int i=0; i<32; i++){
            if((n & (1<<i))!=0){
                count++;
            }
        }

        return count;
    }

    // LeetCode 191
    public int hammingWeight_02(int n) {

        int count = 0;

        while(n!=0){
            if((n & 1)!=0){
                count++;
            }

            n = n>>>1;
        }

        return count;
    }

    // LeetCode 338
    public int[] countBits(int n) {
        int []ans = new int[n + 1];
        for(int i=1; i<=n; i++){
            ans[i] = ans[(i & (i-1))] + 1;
        }

        return ans;
    }


    // LeetCode 231
    public boolean isPowerOfTwo(int n) {
        return  n>0 && (n & (n-1)) == 0;
    }

    // LeetCode 342
    public boolean isPowerOfFour(int n) {

        if(n<=0 || (n & (n-1)) != 0){
            return false;
        }

        int count = 0;

        while(n!=0){

            if((n & 1) == 0){
                count++;
            }

            n = n >>> 1;
        }

        return (count & 1) == 0;
    }

    // Leetcode 136
    public int singleNumber(int[] nums) {

        int ans = 0;
        for(int ele: nums){
            ans = (ans ^ ele);
        }

        return ans;
    }
}
