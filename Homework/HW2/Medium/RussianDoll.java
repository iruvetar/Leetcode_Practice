public class Solution {
    public int maxEnvelopes(int[][] envelopes) {            
        //sort the matrix by widths in ascending order, if widths are the same, sort by heights
            Arrays.sort(envelopes, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] > o2[0]) {
                        return 1;
                    } else if (o1[0] < o2[0]) {
                        return -1;
                    } else {
                        if (o1[1] > o2[1]) {
                            return 1;
                        } else if (o1[1] < o2[1]){
                            return -1;
                        } else {
                            return 0;
                        }
                    }
                }
            });
            //store the optimal solution until each envelope
            int[] DPsolution = new int[envelopes.length];
            int maxEnvelopes = 0;
            //default value for the first envelope
            if (envelopes.length >= 1) {
                DPsolution[0] = 1;
                maxEnvelopes = 1;
            }
            for (int out = 1; out < DPsolution.length; out++) {
                int maxOut = 1;
                for (int in = 0; in < out; in++) {
                    if (envelopes[out][0] > envelopes[in][0] && envelopes[out][1] > envelopes[in][1]) {
                    //valid for Russian doll

                    int currentNumber = DPsolution[in] + 1;
                    //System.out.println("Out: " + out + " find a valid inside pair, current number: " + currentNumber);
                    maxOut = currentNumber > maxOut? currentNumber : maxOut;
                    }
                }
                DPsolution[out] = maxOut;
                maxEnvelopes = maxOut > maxEnvelopes? maxOut : maxEnvelopes; 
            }
            return maxEnvelopes;
    }
}