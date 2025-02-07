package Coding.LinkedIn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NarryToKarryTree {

    class TreeNode {
        int val;
        List<TreeNode> children;
        TreeNode(int val) {
            this.val = val;
            this.children = new ArrayList<>();
        }
    }

    public TreeNode convertTree(TreeNode root, int K){
        if(root == null){
            return null;
        }
        Boolean specialNodeNotUsed = false;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            List<TreeNode> children = current.children;
            List<TreeNode> newChildren = new ArrayList<>();

            int size = children.size();
            if (size == 0){
                continue;
            }

            if(size == K){
                newChildren.addAll(children);
            } else {
                int idx = 0;
                while(idx + K <= size){
                    // add new parent to these k nodes
                    newChildren.add(children.get(idx));
                    for(int j = 1; j < K; j++){
                        // add the remaining k nodes
                        newChildren.get(newChildren.size() - 1).children.add(children.get(idx + j));
                    }
                    idx += K; // move to next k group.
                }

                if(idx < size && !specialNodeNotUsed){
                    newChildren.add(children.get(idx));
                    for(int j = 1; j < K; j++){
                        newChildren.get(newChildren.size() - 1).children.add(children.get(j));
                    }
                    specialNodeNotUsed = true;
                }
            }
            // Update Children;
            current.children = newChildren;
            queue.addAll(newChildren);
        }

        return root;
    }
}
