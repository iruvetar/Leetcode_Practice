//Running time complexity is O(n)
//Which is slow amoung the submissions
//Unfortunately I don't get the fast solution which uses Binary Search
//Still trying to understand the logic of other solutions
public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        for (int i = 1; i <= num / 2; i++) {
            if (i * i == num) {
                return true;
            }
        }
        return false;
    }
}