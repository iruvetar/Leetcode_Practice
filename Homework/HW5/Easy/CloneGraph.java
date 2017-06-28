/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> cloneMap = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        //put the first node into hashmap for clone and queue for traverse
        queue.offer(node);
        cloneMap.put(node, new UndirectedGraphNode(node.label));
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode temp = queue.poll();
            for (UndirectedGraphNode neighbor : temp.neighbors) {
                UndirectedGraphNode clone = cloneMap.get(neighbor);
                if (cloneMap.get(neighbor) == null) {
                    cloneMap.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    queue.offer(neighbor);
                }
                cloneMap.get(temp).neighbors.add(cloneMap.get(neighbor));
            }
            
        }
        return cloneMap.get(node);
    }
}