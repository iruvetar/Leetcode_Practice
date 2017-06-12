/**
 * Iteration solution 2, O(n), doesn't use any other data structure
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prevNode = null;
        while (head != null) {
            ListNode originalNext = head.next;
            head.next = prevNode;
            prevNode = head;
            head = originalNext;
        }

        return prevNode;
    }
}