package Coding.LinkedIn;


/**
 * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green.
 * The cost of painting each house with a certain color is different. You have to paint all the houses
 * such that no two adjacent houses have the same color.
 * <p>
 * The cost of painting each house with a certain color is represented by a n x 3 cost matrix.
 * For example, costs[0][0] is the cost of painting house 0 with color red;
 * costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.
 * Input: [[17,2,17],[16,16,5],[14,3,19]]
 * Output: 10
 * Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
 *              Minimum cost: 2 + 5 + 3 = 10.
 * </p>
 */


public class PaintHouse {

    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0){
            return 0;
        }

        int n = costs.length;


        int[][] dp = new int[n][3];

        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        for(int idx = 1; idx < n; idx++){
            // For 0, take 0 cost and min of 1 and 2
            dp[idx][0] = costs[idx][0] + Math.min(dp[idx-1][1], dp[idx-1][2]);
            // For 1, take 1 cost and min of 2 and 0
            dp[idx][1] = costs[idx][1] + Math.min(dp[idx-1][0], dp[idx-1][2]);
            // For 2, take 2 cost and min of 1 and 0
            dp[idx][2] = costs[idx][2] + Math.min(dp[idx-1][1], dp[idx-1][0]);
        }

        return Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
    }
    // Essentially a DP problem


}
