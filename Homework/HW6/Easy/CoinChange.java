public class Solution {
    public int coinChange(int[] coins, int amount) {
        return coinHelper(coins, amount, new int[amount + 1]);
    }
    //count array stores the minimum number of coins sum to the index
    //0 means not calculated yet, -1 means can't find any match
    private int coinHelper(int[] coins, int amount, int[] count) {
        Arrays.sort(coins);
        if (amount < 0) return -1; //not valid
        if (amount == 0) return 0; //valid
        if (count[amount] != 0) return count[amount]; //get the answer directly
        //has to compute to get the minimum coins required for given amount
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int remainCount = coinHelper(coins, amount - coin, count);
            if (remainCount >= 0 && remainCount < min) {
                //update min for current amount
                min = remainCount + 1;
            }
        }
        count[amount] = min == Integer.MAX_VALUE? -1 : min;
        return count[amount];
    }
}