public class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        int carryNextDigit = 0;
        while (index1 >= 0 || index2 >= 0 ||carryNextDigit > 0) {
            int integer1 = index1 >= 0? Character.getNumericValue(num1.charAt(index1--)) : 0;
            int integer2 = index2 >= 0? Character.getNumericValue(num2.charAt(index2--)) : 0;
            int sum = integer1 + integer2 + carryNextDigit;
            //update the carry variable which marks the value accumulated to the current digit
            carryNextDigit = sum/10;
            sum = sum % 10;
            sb.insert(0, sum);
        }
        return sb.toString();
    }
}