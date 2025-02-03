package Coding.LinkedIn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi]
 * indicates that there is an edge between ai and bi in the graph.
 * Return the number of connected components in the graph.
 */
public class NumberofConnectedComponentsUndirectedGraph {
    private Map<Integer, List<Integer>> graph;
    private boolean[] visited;
    public int countComponents(int n, int[][] edges) {
        graph = new HashMap<>();
        visited = new boolean[n];
        for(int[] edge : edges){
            int a = edge[0], b = edge[1];
            graph.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            graph.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
        }
        int compoonents = 0;
        for(int idx = 0; idx < n; idx++){
            compoonents += dfs(idx);
        }
        return compoonents;
    }
    private int dfs(int node){
        if(visited[node]){
            return 0;
        }
        visited[node] = true;
        for(int vertex : graph.get(node)){
            dfs(vertex);
        }
        return 1;
    }
}
