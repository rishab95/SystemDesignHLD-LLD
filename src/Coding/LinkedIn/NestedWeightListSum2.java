package Coding.LinkedIn;

import java.util.List;

/**
 * You are given a nested list of integers nestedList. Each element is either an integer or a list whose
 * elements may also be integers or other lists.
 *
 * The depth of an integer is the number of lists that it is inside of. For example,
 * the nested list [1,[2,2],[[3],2],1] has each integer's value set to its depth.
 * Let maxDepth be the maximum depth of any integer.
 *
 * The weight of an integer is maxDepth - (the depth of the integer) + 1.
 *
 * Return the sum of each integer in nestedList multiplied by its weight.
 *
 */

public class NestedWeightListSum2 {
    public int depthSum(List<NestedInteger> nestedList) {
        int depth = maxDepth(nestedList);
        return findDfsSum(nestedList, depth);
    }

    private int maxDepth(List<NestedInteger> nestedList) {
        int depth = 1;
        for (NestedInteger item : nestedList){
            if(item.isInteger()){
                depth = Math.max(depth, 1 + maxDepth(item.getList()));
            }
        }
        return depth;
    }
    private int findDfsSum(List<NestedInteger> nestedList, int maxDepth){
        int depthSum = 0;
        for(NestedInteger item : nestedList) {
            // If an integer, multiply by depth
            if (item.isInteger()) {
                depthSum += item.getInteger() * maxDepth;
            } else {
                depthSum += findDfsSum(item.getList(), maxDepth - 1);
            }
        }
        return depthSum;
    }
}
