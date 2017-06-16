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
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        
        //sort the array by the start time
        Arrays.sort(intervals, new startComparator());
        
        //use a Heap structure to store the occupid intervals of the meeting room
        PriorityQueue<Interval> minHeap = new PriorityQueue<Interval>(intervals.length, new endComparator());
        //at least one room and one interval is required
        minHeap.offer(intervals[0]);
        
        for (int i = 1; i < intervals.length; i++) {
            if (Integer.compare(minHeap.peek().end, intervals[i].start) > 0) {
                //require a new room because the earliest available room is still too late for intervals[i]
                minHeap.offer(intervals[i]);
            } else {
                //the current root meeting room is available for intervals[i]
                Interval root = minHeap.poll();
                root.end = intervals[i].end;
                minHeap.offer(root);
            }
        }
        return minHeap.size();
    }
}

class startComparator implements Comparator<Interval> {
    @Override
    /** Compare the start point of two events
     * @return integer value, 0 if the two events starts from the same time, a positive integer if interval 2 comes after interval 1
     */
    public int compare(Interval i1, Interval i2) {
        return Integer.compare(i1.start, i2.start);
    }
}

class endComparator implements Comparator<Interval> {
    @Override
    /** Compare the start point of two events
     * @return integer value, 0 if the two events starts from the same time, a positive integer if interval 2 comes after interval 1
     */
    public int compare(Interval i1, Interval i2) {
        return Integer.compare(i1.end, i2.end);
    }
}