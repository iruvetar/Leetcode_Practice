/**
 * Iteration Solution1, probably to slow
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        ListNode newhead = stack.pop();
        cur = newhead;
        while (!stack.isEmpty()) {
            cur.next = stack.pop();
            cur = cur.next;
        }
        //reset the final node to point to null to prevent loop
        cur.next = null;
        return newhead;
    }
}