package Coding.Uber;

import java.util.*;

/**
 * Given a list of currency exchange rates (e.g., USD -> EUR: 0.85), find the conversion rate between two currencies.
 * Extend the problem to explore all basic graph algorithms like BFS, weighted BFS, and Dijkstra's algorithm.
 *
 */
public class CurrencyConversion {

    static  class Edge {
        double weight;
        String target;

        public Edge(String target, double weight){
            this.weight = weight;
            this.target = target;
        }
    }

    static class Pair {
        String currency;
        double rate;

        public Pair(String currency, double rate){
            this.rate = rate;
            this.currency = currency;
        }
    }

    private final Map<String, List<Edge>> graph = new HashMap<>();

    public void addEdge(String source, String target, double weight){
        graph.putIfAbsent(source, new ArrayList<>());
        graph.putIfAbsent(target, new ArrayList<>());
        graph.get(source).add(new Edge(target, weight));
        graph.get(target).add(new Edge(source, 1 / weight));
    }

    public double findConversionRate(String source, String target){
        Set<String> visited = new HashSet<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(source, 1.0));

        while(!queue.isEmpty()){
            Pair current = queue.poll();
            String currency = current.currency;
            double rate = current.rate;

            if(currency.equals(target)){
                return rate;
            }
            visited.add(currency);

            for(Edge edge : graph.get(currency)){
                if(!visited.contains(edge.target)){
                    queue.add(new Pair(edge.target, rate*edge.weight));
                }
            }
        }
        return -1;
    }
}
