//I am not sure how to calculate the memory space O(1)
//This solution seems to be slower than most of the submissions online
//Most of them traverse two linkedlists to get the length
//
import java.util.*;
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> nodeSet = new HashSet<ListNode>();
        //put linkedlist started with headA into the hashset
        //O(n)
        ListNode tempNode = headA;
        while (tempNode != null) {
            nodeSet.add(tempNode);
            tempNode = tempNode.next;
        }
        //traverse the secondd linkedlist
        //O(n)
        ListNode targetNode = headB;
        while (targetNode != null) {
            if (nodeSet.contains(targetNode)) {
                return targetNode;
            }
            targetNode = targetNode.next;
        }
        return null;
    }
}