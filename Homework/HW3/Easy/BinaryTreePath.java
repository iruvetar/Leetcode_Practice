/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        return binaryTreePathsHelper(root, new ArrayList<String>(), new StringBuilder());
    }
    private List<String> binaryTreePathsHelper(TreeNode root, List<String> list, StringBuilder sb) {
        int sbLength = sb.length();
        if (root == null) {
            return list;
        }

        //when root exists
        sb.append(root.val);
        if (root.left == null && root.right == null) { //reach the leaf
            //only add the string into the result list when we reach the leaf
            list.add(sb.toString());
        } else {
            sb.append("->");
            if (root.left != null) {
                binaryTreePathsHelper(root.left, list, sb);
            }
            if (root.right != null) {
                binaryTreePathsHelper(root.right, list, sb);
            }
        }
        //reset the string builder to prevent the sb passed to the other recursion is inherited incorrectly
        sb.setLength(sbLength);
        return list;
    }
}