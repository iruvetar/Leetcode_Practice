public class NumArray {
    //sumArray is the sum adding up from 0 index to the current index
    int[] sumArray;
    public NumArray(int[] nums) {
        sumArray = new int[nums.length];
        if (nums != null && nums.length != 0) {
            sumArray[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sumArray[i] = sumArray[i - 1] + nums[i];
            }
        }
    }
    
    public int sumRange(int i, int j) {
        return i == 0 ? sumArray[j] : sumArray[j] - sumArray[i - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */