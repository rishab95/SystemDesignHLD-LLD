package Coding.LinkedIn;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> targetMap = new HashMap<>();
        for(char c : t.toCharArray()){
            targetMap.put(c, targetMap.getOrDefault(c, 0)+1);
        }
        Map<Character, Integer> windowMap = new HashMap<>();
        int start = 0, end = 0, minLen = Integer.MAX_VALUE, minStart = 0;
        int matchedChar = 0;
        while(end < s.length()){
            char c = s.charAt(end);
            windowMap.put(c, windowMap.getOrDefault(c, 0)+1);
            if(targetMap.containsKey(c) && windowMap.get(c).equals(targetMap.get(c))){
                matchedChar++;
            }
            while(matchedChar == targetMap.size()){
                if(end - start + 1 < minLen){
                    minLen = end - start + 1;
                    minStart = start;
                }
                char startChar = s.charAt(start);
                windowMap.put(startChar, windowMap.get(startChar) - 1);
                if (targetMap.containsKey(startChar) && windowMap.get(startChar) < targetMap.get(startChar)) {
                    matchedChar--;
                }
                start++;
            }
            end++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);

    }
}
