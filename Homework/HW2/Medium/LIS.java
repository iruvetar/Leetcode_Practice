//O(n^2) solution, using Dynamic Programming to solve it.
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] optimalLength = new int[nums.length];
        int longestLength = 0;
        if (nums.length >= 1) {
            optimalLength[0] = 1;
            longestLength = 1;
        }
        //go through the nums array
        for (int current = 1; current < nums.length; current++) {
            int largest = 0; //to get the largest length for the current integer
            for (int prev = 0; prev < current; prev++) {
                if (nums[prev] < nums[current] && optimalLength[prev] > largest) {//increasing
                    largest = optimalLength[prev];
                }
            }
            optimalLength[current] = largest + 1;
            if (optimalLength[current] > longestLength) {
                longestLength = optimalLength[current]; //update the answer
            }
        }
        return longestLength;
    }
}