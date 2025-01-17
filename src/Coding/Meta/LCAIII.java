package Coding.Meta;

/**
 * Given two nodes of a binary tree p and q, return their lowest common ancestor (LCA).
 * Each node will have a reference to its parent node. The definition for Node is below:
 * class Node {
 *     public int val;
 *     public Node left;
 *     public Node right;
 *     public Node parent;
 * }
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor of two nodes p and q in a tree T is the lowest node that
 * has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 */
public class LCAIII {
    public TreeNode lowestCommonAncestor(TreeNode p, TreeNode q) {
        if(p == null || q == null) {
            return null;
        }
        TreeNode a = p, b = q;
        while(a != b){
            a = a == null ? q : a.parent;
            b = b == null ? p : b.parent;
        }
        return a; // or b , since they are essentially the same now.
    }

}
