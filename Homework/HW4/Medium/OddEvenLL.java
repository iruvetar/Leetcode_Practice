/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        
        //split them into two lists, and reconnect them in the end
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;
        //stop conditions are listed below
        //       1->2->3->4->null         1->2->3->null
        //               even                      even    
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}