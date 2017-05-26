//Use built-in sorting (quicksort) to sort two arrays first
import java.util.*;
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int pointer1 = 0;
        int pointer2 = 0;
        //the matching stops when the pointer reaches the end of any array
        while (pointer1 < nums1.length && pointer2 < nums2.length) {
        	if (nums1[pointer1] == nums2[pointer2]) {
        		result.add(nums1[pointer1]);
        		pointer1++;
        		pointer2++;
        	} else if (nums1[pointer1] < nums2[pointer2]) {
        		pointer1++;
        	} else {
        		pointer2++;
        	}
        }

        //copy the result to an array
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < resultArray.length; i++) {
        	resultArray[i] = result.get(i);
        }
        return resultArray;
    }
}