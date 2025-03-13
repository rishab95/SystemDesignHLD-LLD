package Coding.LinkedIn;

import java.util.List;

/**
 * The problem provides us with a binary search tree (BST) and a target value target.
 * Our goal is to find k values in the BST that are closest to the target value.
 * The values can be returned in any order.
 * The problem guarantees that there is a unique set of k values in the tree that are closest to the target.
 */
public class FindClosestValuesBSTII {
    private List<Integer> values;
    private double target;
    private int k;
    public List<Integer> closestKValues(TreeNode root, double target, int k){
        this.target = target;
        this.k = k;

        return values;
    }

    private void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        if(values.size() < this.k){
            values.add(root.val);
        } else {
            if(Math.abs(root.val - this.target) >= Math.abs(values.get(0) - this.target)){
                return;
            }
            values.remove(0);
            values.add(root.val);
        }
        inOrder(root.right);
    }

}
