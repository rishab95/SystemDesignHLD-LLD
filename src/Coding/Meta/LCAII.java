package Coding.Meta;

/**
 * Given the root of a binary tree, return the lowest common ancestor (LCA) of two given nodes,
 * p and q. If either node p or q does not exist in the tree, return null. All values of the nodes
 * in the tree are unique.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor of two nodes p
 * and q in a binary tree T is the lowest node that has both p and q as descendants
 * (where we allow a node to be a descendant of itself)”. A descendant of a node x is a node y
 * that is on the path from node x to some leaf node.
 * <p>
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * </p>
 *
 */
public class LCAII {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }

        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightRCA = lowestCommonAncestor(root.right, p, q);

        if(leftLCA != null && rightRCA != null){
            return root;
        }

        return (leftLCA != null) ? leftLCA : rightRCA;
    }

}
