public class Solution {
    public int numTrees(int n) {
        //stores number of unique trees given 0 to n
        int[] uniqueTrees = new int[n + 1];
        //base case
        uniqueTrees[0] = 1;
        uniqueTrees[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                uniqueTrees[i] += uniqueTrees[j - 1] * uniqueTrees[i - j];
            }
        }
        return uniqueTrees[n];
    }
}