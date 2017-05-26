//Use built-in sorting (quicksort) to sort two arrays first
//Use one set to avoid duplicate
//Use one arraylist to store the intersection results
//Binary search is used to search for the element, which takes O(log n)
//So the running time is bounded by quicksort, which is in average O(nlogn)
import java.util.*;
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> checkedSet = new HashSet<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            //check whether this number has be checked to avoid duplicate
            if (! checkedSet.contains(nums1[i])) {
                checkedSet.add(nums1[i]);
                if (binarySearch(nums2, nums1[i])) {
                    result.add(nums1[i]);
                }
            }
        }
        //copy a integer array for return
        int[] resultArray = new int[result.size()];
        for (int index = 0; index < resultArray.length; index ++) {
            resultArray[index] = result.get(index);
        }
        return resultArray;
    }
    public boolean binarySearch(int[] array, int target) {
        if (array == null || array.length == 0) {
            return false;
        }
        int start = 0;
        int end = array.length - 1;

        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (array[mid] == target) {
                return true;
            } else if (array[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (array[start] == target || array[end] == target) {
            return true;
        }
        return false;
    }
}