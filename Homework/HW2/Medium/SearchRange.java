/**
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 **/
 
public class Solution {
    public int[] searchRange(int[] nums, int target) {        
        //The case of empty array
        if (nums.length == 0) {
            int[] result = {-1, -1};
            return result;
        }
        
        //Search for start of the target range in O(logn)
        int rangeStart = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[end] == target) {
            rangeStart = end;
        }
        if (nums[start] == target) {
            rangeStart = start;
        }
        
        //Search for end of the target range in O(logn)
        int rangeEnd = -1;
        start = 0;
        end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                start = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (nums[start] == target) {
            rangeEnd = start;
        }
        if (nums[end] == target) {
            rangeEnd = end;
        }

        int[] result = {rangeStart, rangeEnd};
        return result;
    }
}