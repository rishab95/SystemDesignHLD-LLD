package Coding.LinkedIn;


/**
 * You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements
 * may also be integers or other lists.
 *
 * The depth of an integer is the number of lists that it is inside of. For example, t
 * he nested list [1,[2,2],[[3],2],1] has each integer's value set to its depth.
 *
 * Return the sum of each integer in nestedList multiplied by its depth.
 *
 * Input: nestedList = [[1,1],2,[1,1]]
 * Output: 10
 * Explanation: Four 1's at depth 2, one 2 at depth 1. 1*2 + 1*2 + 2*1 + 1*2 + 1*2 = 10.
 *
 * Input: nestedList = [1,[4,[6]]]
 * Output: 27
 * Explanation: One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3. 1*1 + 4*2 + 6*3 = 27.
 *
 */

import java.util.List;


public class NestedWeightListSum {
    public int depthSum(List<NestedInteger> nestedList) {
        return findDfsSum(nestedList, 1);
    }


    // Recursive function to find the sum via DFS
    private int findDfsSum(List<NestedInteger> nestedList, int depth){
        // start the seum
        int sumSofar = 0;
        for (NestedInteger item : nestedList) {
            // base case on leaf node
            if(item.isInteger()){
                sumSofar += item.getInteger() * depth;
            } else {
                // case when not leaf node and has another list in it.
                sumSofar += findDfsSum(item.getList(), depth + 1);
            }
        }
        return sumSofar;
    }

}
