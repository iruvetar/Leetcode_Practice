/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        
        RandomListNode cur = head;
        //first loop: copy the linkedlist, attach the copied node after the original node
        while (cur != null) {
            RandomListNode temp = cur.next;
            cur.next = new RandomListNode(cur.label);
            cur.next.next = temp;
            cur = temp;
        }
        //second loop: assign the random node for the copied nodes
        cur = head;
        while (cur != null) {
            RandomListNode randomNode = cur.random;
            cur.next.random = randomNode == null ? null : randomNode.next;
            cur = cur.next.next;
        }
        
        //third loop: extract the new copy nodes, restore the original list in case we need it
        //a dummy head for copy list
        RandomListNode newHead = new RandomListNode(0);
        RandomListNode copyIter = newHead;
        cur = head;
        while (cur != null) {
            copyIter.next = cur.next;
            cur.next = cur.next.next;
            
            //move the pointer forward
            cur = cur.next;
            copyIter = copyIter.next;
        }
        
        return newHead.next;
    }
}