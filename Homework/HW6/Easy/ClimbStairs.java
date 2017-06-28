public class Solution {
    //f(n) = f(n-1) + f(n-2)
    public int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n == 1 || n == 2) return n;
        
        int[] climbWay = new int[n + 1];
        //base case
        climbWay[1] = 1;
        climbWay[2] = 2;
        for (int i = 3; i <= n; i++) {
            climbWay[i] = climbWay[i - 1] + climbWay[i - 2];
        }
        return climbWay[n];
    }
}