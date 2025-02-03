package Coding.LinkedIn;

/**
 * Problem: Given two binary trees root1 and root2, determine if they are structurally equivalent,
 * considering the following conditions:
 *
 * Structure: Both trees must have the same structure, meaning the same arrangement of nodes (left, right children).
 * Value Equality: Corresponding nodes at the same level in both trees must have the same value.
 */
public class SymmetricTrees {
    public boolean isSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if(root1 == null || root2 == null){
            return false;
        } else if(root1.val != root2.val){
            return false;
        }
        return isSymmetric(root1.left, root2.left) && isSymmetric(root1.right, root2.right);
    }
}
