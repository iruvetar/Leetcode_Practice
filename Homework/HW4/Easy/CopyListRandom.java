/**
 * I use a HashMap to map the new copied node to the original node.
 * But according to the top solution, I can map the pair of nodes by adding the to the original list.
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode cur = head;
        //1st iteration
        //create new copied nodes, and associate them with their original versioin
        while (cur != null) {
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
        //2nd iteration
        cur = head;
        while (cur != null) {
            map.get(cur).random = map.get(cur.random);
            map.get(cur).next = map.get(cur.next);
            cur = cur.next;
        }
        return map.get(head);
    }
}