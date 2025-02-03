package Coding.LinkedIn;

import java.util.Stack;

public class BinarySearchTreeIterator {
    Stack<TreeNode> stack;
    public BinarySearchTreeIterator(TreeNode root){
        this.stack = new Stack<>();
        this.pushAllLeftNodes(root);

    }

    private void pushAllLeftNodes(TreeNode root){
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
    public boolean hasNext(){
        return !stack.isEmpty();
    }

    public int next(){
        TreeNode topNode = this.stack.pop();
        this.pushAllLeftNodes(topNode.right);
        return topNode.val;
    }
}
