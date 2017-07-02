public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] number = s.toCharArray();
        if (number[0] == '0') return 0;
        
        int[] count = new int[s.length() + 1];
        //initialization
        count[0] = 1;
        count[1] = 1;

        for (int i = 2; i <= number.length; i++) {
            int curDigit = number[i - 1] - '0';
            int num = Integer.parseInt(s.substring(i - 2, i));
            if (num >= 10 && num <= 26) {
                count[i] += count[i - 2];
            }
            if (curDigit != 0) {
                count[i] += count[i - 1];
            }
        }
        return count[number.length];
    }
}