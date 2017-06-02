/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        //save all the elements on the most left branch
        TreeNode temp = root;
        while (temp != null) {
            stack.push(temp);
            temp = temp.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack.size() != 0;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode smallestNode = stack.pop();
        //add next smallest number by searching the right branch
        if (smallestNode.right != null) {
            TreeNode temp = smallestNode.right;
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
        }
        //if no right branch exist, the next element in stack is alread the next smallest number
        return smallestNode.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */