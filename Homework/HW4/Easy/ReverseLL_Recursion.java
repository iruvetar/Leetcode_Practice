/**
 * Recursive solution.
 * 
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        return reverseHelper(null, head);
    }
    /**
     * Recusive helper method, terminates when the list is consumed or the list is empty
     */
    private ListNode reverseHelper(ListNode prev, ListNode cur) {
        //base case
        if (cur == null) {
            return prev;
        }
        //recursive case
        ListNode nextNode = cur.next;
        cur.next = prev;
        return reverseHelper(cur, nextNode);
    }
}