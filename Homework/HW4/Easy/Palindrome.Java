/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fastPointer = head;
        ListNode slowPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }
        
        ListNode secondHead;
        //slowPointer is now pointing to the middle of the linked list
        if (fastPointer != null) { //the number of elements in the linked list is a odd number
            secondHead = reverseHelper(slowPointer.next);
        } else {
            secondHead = reverseHelper(slowPointer);
        }
        
        while (secondHead != null) {
            if (secondHead.val != head.val) {
                return false;
            }
            secondHead = secondHead.next;
            head = head.next;
        }
        return true;
    }
    /**
     * Return the end of the list starting from head and reverse it.
     */ 
    private ListNode reverseHelper(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}