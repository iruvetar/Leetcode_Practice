/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == cur.val) {
                //duplicate found, delete the following node
                cur.next = cur.next.next;
            } else {
                //move forward
                cur = cur.next;
            }
        }
        return head;
    }
}