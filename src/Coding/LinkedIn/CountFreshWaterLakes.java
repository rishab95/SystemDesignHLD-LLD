package Coding.LinkedIn;

/* You are given a 2D grid where '1' represents land and '0' represents water. The grid is implicitly surrounded by an infinite ocean.
 * Water can flow horizontally and vertically (not diagonally).
 * Find the number of freshwater lakes in the grid. A freshwater lake is a connected body of water completely surrounded by land.
 * Example:
 * Input:grid =
 * [
 *   [0,0,1,0,0,0,0,1,0,0,0,0,0],
 *   [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *   [0,1,1,1,1,0,0,0,0,0,0,0,0],
 *   [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *   [0,1,0,1,1,1,0,0,1,1,1,0,0],
 *   [0,0,1,0,0,0,0,0,1,0,1,0,0],
 *   [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *   [0,0,0,0,0,0,0,1,1,0,0,0,0]
 * ]
 * Output: 2
 * Explanation:
 *
 * This question focuses on graph traversal (DFS or BFS) and identifying connected components.
 * It requires careful consideration of edge cases and the implicit ocean boundary.
 *
 * Key Considerations for the Interview:
 *
 * Clarifying Questions:
 * "Can you clarify the definition of 'connected body of water'?" (Ensure understanding of how water bodies are
 * defined and connected)
 * "Are there any restrictions on the size of the grid?" (Understand potential constraints)
 * Algorithm Design:
 * Discuss the choice of algorithm (DFS or BFS) and explain the reasoning behind it.
 * Explain how to handle edge cases (e.g., water touching the boundaries of the grid).
 * Consider space and time complexity of the chosen approach.
 * Coding:
 * Implement the chosen algorithm in Java.
 * Write clean, well-structured, and easy-to-read code.
 * Include appropriate comments to explain the logic.
 * Testing:
 * Discuss test cases, including edge cases and corner cases.
 * Test the code with different input matrices to ensure correctness.
 * Follow-up Questions:
 *
 * "How would you modify your solution if the grid could have islands of different types
 * (e.g., freshwater, saltwater)?"
 *
 * "How would you optimize the solution for a very large grid?"
 * "Can you implement a solution using Union-Find (Disjoint Set)?"
 * This comprehensive approach effectively frames the "Freshwater Lakes" problem as a challenging and engaging
 * LeetCode-style interview question.
 * Use int grid and mark boundary elements as -1 which are 0 as they are salt water.
 *
 * @param grid A 2D character array representing the grid.
 * @return The number of fresh water lakes in the grid.
 */
public class CountFreshWaterLakes {
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int countFreshWaterLakes(int[][] grid){
        int lakes = 0;
        int rows = grid.length, cols = grid[0].length;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(i == 0 || j == 0 || i == rows- 1 || j == cols - 1){
                    if (grid[i][j] == 0) {
                        grid[i][j] = -1;
                    }
                }
            }
        }
        boolean[][] visited = new boolean[rows][cols];
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if (grid[r][c] == 0) {
                    lakes ++;
                    findLakes(grid, r, c, visited);
                }
            }
        }
        return lakes;
    }

    private void findLakes(int[][] grid, int row, int col, boolean[][] visited){
        visited[row][col] = true;
        for(int[] dir : dirs){
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            if(isValid(grid, nextRow, nextCol) && grid[nextRow][nextCol] == 0 && !visited[nextRow][nextCol]){
                findLakes(grid, nextRow, nextCol, visited);
            }
        }
    }

    private boolean isValid(int[][] grid, int row, int col){
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }
}
