/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        //sort the array by the start time
        Arrays.sort(intervals, new meetingComparator());
        //go through the array to see if for every interval, the later one starts after the previous one ends
        for (int i = 1; i < intervals.length; i++) {
            if (Integer.compare(intervals[i - 1].end, intervals[i].start) > 0) {
                return false;
            }
        }
        return true;
    }
}

class meetingComparator implements Comparator<Interval> {
    @Override
    /** Compare the start point of two events
     * @return integer value, 0 if the two events starts from the same time, a positive integer if interval 2 comes after interval 1
     */
    public int compare(Interval i1, Interval i2) {
        return Integer.compare(i1.start, i2.start);
    }
}