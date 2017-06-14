/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //corner case
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        //attach node bottom up
        ListNode headNode = null;
        if (l1.val <= l2.val) {
            headNode = l1;
            headNode.next = mergeTwoLists(l1.next, l2);
        } else {
            headNode = l2;
            headNode.next = mergeTwoLists(l1, l2.next);
        }
        return headNode;
    }
}