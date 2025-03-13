package Coding.Atlassian;

import java.util.*;

/**
 * You are given a game board with positions numbered from 0 to lastNumber.
 * You start at startPosition. You have a standard die with values from 1 to maxValue. You are also given a list of
 * teleporters, where each teleporter is represented as a string "source,destination".
 * If you land on a source position, you are immediately teleported to the destination position.
 * If, after rolling the die, you would land on a position greater than lastNumber,
 * you are instead moved to lastNumber
 */
public class DiceRoll {
    public List<Integer> reachablePositions(int start, int maxValue, int lastNumber, List<String> teleporters){
        Map<Integer, Integer> teleporterMap = new HashMap<>();
        for(String teleporter : teleporters){
            String[] parts = teleporter.split(",");
            teleporterMap.put(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
        }
        List<Integer> reachable = new ArrayList<>();
        for(int roll = 1; roll <= 6; roll++){
            int current = start + roll;
            if(current > lastNumber){
                current = lastNumber;
            }
            if(teleporterMap.containsKey(current)){
                current = teleporterMap.get(current);
            }
            if(!reachable.contains(current)){
                reachable.add(current);
            }
        }
        return reachable;
    }

    public boolean canReachEnd(int start, int maxValue, int lastNumber, List<String> teleporters){
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i <= lastNumber; i++){
            graph.put(i, new ArrayList<>());
        }
        for(int i = 0; i <= lastNumber; i++){
            for(int roll = 1; roll <= maxValue; roll++){
                int next = i + roll;
                if(next > lastNumber){
                    next = lastNumber;
                }
                graph.get(i).add(next);
            }
        }
        Map<Integer, Integer> teleporterMap = new HashMap<>();
        for(String teleporter : teleporters){
            String[] parts = teleporter.split(",");
            int source = Integer.parseInt(parts[0]);
            int destination = Integer.parseInt(parts[1]);
            graph.get(source).clear();;
            graph.get(source).add(destination);
            teleporterMap.put(source, destination);
        }
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);

        while(!queue.isEmpty()){
            int current = queue.poll();
            if(current == lastNumber){
                return true;
            }
            for(int nextPos : graph.get(current)){
                if(!visited.contains(nextPos)){
                    queue.offer(nextPos);
                    visited.add(nextPos);
                }
            }
        }
        return false;
    }
}
