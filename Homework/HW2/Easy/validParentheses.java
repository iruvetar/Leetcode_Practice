import java.util.*;
public class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<Character>();
        for (int i = 0; i < s.length(); i++) {
            //if encounter left, push it into stack as its paired Parentheses for easier matching
            if (s.charAt(i) == '(') {
                stack.push(')');
            } else if (s.charAt(i) == '[') {
                stack.push(']');
            } else if (s.charAt(i) == '{') {
                stack.push('}');
            } else { //the right Parentheses
                if (stack.size() == 0) {
                    return false;
                    //no left Parentheses
                }
                char left = stack.pop();
                if (left != s.charAt(i)) {
                    return false;
                }
            }
        }

        if (stack.size() != 0) {
            return false;
        }
        return true;
    }
}