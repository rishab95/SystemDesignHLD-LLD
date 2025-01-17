package Coding.LinkedIn;


/**
 * There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house
 * with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
 * The cost of painting each house with a certain color is represented by an n x k cost matrix costs.
 * For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house
 * 1 with color 2, and so on...
 * Return the minimum cost to paint all houses.
 * Input: costs = [[1,5,3],[2,9,4]]
 * Output: 5
 * Explanation:
 * Paint house 0 into color 0, paint house 1 into color 2. Minimum cost: 1 + 4 = 5;
 * Or paint house 0 into color 2, paint house 1 into color 0. Minimum cost: 3 + 2 = 5.
 *
 */

public class PaintHouse2 {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0){
            return 0;
        }

        int houses = costs.length;
        int colors = costs[0].length;

        int[][] dp = new int[houses][colors];

        // default case for 1st row

        for(int color = 0; color < colors; color++){
            dp[0][color] = costs[0][color];
        }

        // Now run for other n - 1 houses to calculate min cost.

        for(int house = 1; house < houses; house++){
            for(int currentColor = 0; currentColor < colors; currentColor++){
                int currentCost = costs[house][currentColor];
                int prevMinSum = Integer.MAX_VALUE;
                for(int nextColor = 0; nextColor < colors; nextColor++){
                    if(currentColor == nextColor){
                        continue;
                    }
                    prevMinSum = Math.min(prevMinSum, dp[house - 1][nextColor]);
                }
                dp[house][currentColor] = prevMinSum + currentCost;
            }
        }

        return -1;
    }
}
