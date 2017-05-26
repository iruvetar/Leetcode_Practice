public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
    	int reverseResult = 0;
		for (int rightShift = 0; rightShift < 32; rightShift++) {
			int temp = n >> rightShift;
			//to keep the value of specific digit
			int keepDigit = temp & 1;
			//move it to the correct position
			keepDigit = keepDigit << (31 - rightShift);
			//update the result value
			reverseResult = reverseResult | keepDigit;
		}
		return reverseResult;
    }
}