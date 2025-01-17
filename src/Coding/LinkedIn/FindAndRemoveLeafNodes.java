package Coding.LinkedIn;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, collect a tree's nodes as if you were doing this:
 *
 * Collect all the leaf nodes.
 * Remove all the leaf nodes.
 * Repeat until the tree is empty.
 *
 * Input: root = [1,2,3,4,5]
 * Output: [[4,5,3],[2],[1]]
 * Explanation:
 * [[3,5,4],[2],[1]] and [[3,4,5],[2],[1]] are also considered correct
 * answers since per each level it does not matter the order on which elements are returned.
 */
public class FindAndRemoveLeafNodes {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        findLeafNodes(root);
        return result;
    }

    private int findLeafNodes(TreeNode root){
        if(root == null){
            return -1;
        }
        int left = findLeafNodes(root.left);
        int right = findLeafNodes(root.right);

        int currentLevel = Math.max(left, right) + 1;

        while(result.size() <= currentLevel){
            result.add(new ArrayList<>());
        }
        result.get(currentLevel).add(root.val);
        return currentLevel;
    }

}
