package Coding.LinkedIn;

import java.util.HashMap;
import java.util.Map;

/**
 * The problem requires the design of a data structure to manage a stream of integers and provides two functionalities.
 *
 * Adding an integer to the collection.
 * Querying to find out if there are any two distinct integers already in the collection that add up to a specified target sum.
 * This data structure should efficiently support the insertion of numbers and the checking for the existence of a pair of numbers
 * that meet the target sum condition.
 */
public class TwoSumIII {
    Map<Integer, Integer> seenMap;
    public TwoSumIII() {
        seenMap = new HashMap<>();
        // Initialize your data structure here.
    }

    public void add(int number) {
        seenMap.put(number, seenMap.getOrDefault(number, 0) + 1);
    }

    public boolean find(int value) {
        for(Map.Entry<Integer, Integer> entry : seenMap.entrySet()) {
            int complement = value - entry.getKey();
            if(complement != entry.getKey()) {
                if(seenMap.containsKey(complement)) {
                    return true;
                }
            } else {
                if(entry.getValue() > 1) {
                    return true;
                }
            }
        } // O(n)
        return false;
    }

}
