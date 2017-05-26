import java.util.*;
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        //the key is the integer value, the value is the index of the integer in the nums array
        Map<Integer, Integer> integerMap = new HashMap<Integer, Integer>();
        int[] result = null;
        for (int index = 0; index < nums.length; index++) {
            if (integerMap.get(target - nums[index]) != null) {
                result = new int[2];
                result[0] = integerMap.get(target - nums[index]);
                result[1] = index;
                return result;
            }
            //if not found yet, put element into hashmap
            integerMap.put(nums[index], index);
        }
        return result;
    }
}