//long is used in treeset to handle overflow
//running time is O (n * logk)
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length == 0 || nums == null || k < 0) return false;
        TreeSet<Long> set = new TreeSet<Long>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) { //maintain the valid range inside set
                set.remove((long)nums[i - k - 1]);
            }
            //floor is the largest number that is smaller or equal to nums[i] + upperbound t
            Long floor = set.floor((long)nums[i] + t);
            //floor is the smallest number that is larger or equal to nums[i] - lowerbound t
            Long ceiling = set.ceiling((long)nums[i] - t);
            //need to make sure either floor is in the valid range or ceiling is in the valid range
            if ((floor != null && floor >= nums[i]) || 
                    (ceiling != null && ceiling <= nums[i])) {
                return true;
            }
            set.add((long)nums[i]);
        }
        return false;
    }
}