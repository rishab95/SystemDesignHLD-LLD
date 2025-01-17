package Coding.LinkedIn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Design a data structure that will be initialized with a string array, and then it should answer queries of
 * the shortest distance between two different strings from the array.
 * Implement the WordDistance class:
 * WordDistance(String[] wordsDict) initializes the object with the strings array wordsDict.
 * int shortest(String word1, String word2) returns the shortest distance between word1 and word2 in
 * the array wordsDict.
 * Example 1:
 * Input
 * ["WordDistance", "shortest", "shortest"]
 * [[["practice", "makes", "perfect", "coding", "makes"]], ["coding", "practice"], ["makes", "coding"]]
 * Output
 * [null, 3, 1]
 * Explanation
 * WordDistance wordDistance = new WordDistance(["practice", "makes", "perfect", "coding", "makes"]);
 * wordDistance.shortest("coding", "practice"); // return 3
 * wordDistance.shortest("makes", "coding");    // return 1
 */


public class ShortestWordDistanceII {
    Map<String, List<Integer>> indexMap;
    public ShortestWordDistanceII(String[] words){
        indexMap = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            indexMap.computeIfAbsent(words[i], k -> new ArrayList<>()).add(i);
        }
    }

    public int shortestDistance(String word1, String word2){
        int ans = Integer.MAX_VALUE;
        List<Integer> word1List = indexMap.get(word1);
        List<Integer> word2List = indexMap.get(word2);

        int word1Idx = 0, word2Idx = 0;
        while(word1Idx < word1List.size() && word2Idx < word2List.size()){
            ans = Math.min(ans, Math.abs(word1List.get(word1Idx) - word2List.get(word2Idx)));
            if(word1List.get(word1Idx) <= word2List.get(word2Idx)){
                word1Idx++;
            } else {
                word2Idx++;
            }
        }
        return ans;
    }
}
