/**
 * The time complexity is O(n * log k) mainly due to the insertion process for the priority queue
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.length, new minComparator());
        for (ListNode node : lists) {
            if (node != null) {
                heap.offer(node);
            }
        }
        ListNode dummyHead = new ListNode(0);
        ListNode head = dummyHead;
        while (heap.size() != 0) {
            head.next = heap.poll();
            head = head.next;
            if (head.next != null) {
                heap.offer(head.next);
            }
        }
        return dummyHead.next;
    }
}

class minComparator implements Comparator<ListNode> {
    @Override
    public int compare(ListNode node1, ListNode node2) {
        return Integer.compare(node1.val, node2.val);
    }
}