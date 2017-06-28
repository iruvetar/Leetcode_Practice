public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        //the max number a rub can have if he rubs the current house
        int maxRob = 0;
        //the max number a rub can have if he doesn't rubs the current house
        int maxNoRob = 0;
        
        for (int money : nums) {
            int lastMaxNoRob = maxNoRob;
            //if the current i house is not robbed, the max we can have is the max from previous rounds
            maxNoRob = Math.max(maxRob, lastMaxNoRob);
            //if the current house is robbed, we shouldn't have robbed the last house
            maxRob = money + lastMaxNoRob;
        }
        return Math.max(maxRob, maxNoRob);
    }
}