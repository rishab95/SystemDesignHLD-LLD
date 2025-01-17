package Coding.LinkedIn;

/**
 *
 * Given an array of strings wordsDict and two different strings that already exist in the array word1 and word2,
 * return the shortest distance between these two words in the list.
 * Example 1:
 * Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "coding", word2 = "practice"
 * Output: 3
 * Example 2:
 * Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "coding"
 * Output: 1
 */

public class ShortestWordDistance {
    public int shortestDistance(String[] wordsDict, String word1, String word2){
        int word1Idx = -1, word2Idx = -1, ans = Integer.MAX_VALUE;
        for(int i = 0; i < wordsDict.length; i++){
            if(wordsDict[i].equals(word1)){
                word1Idx = i;
            }
            if(wordsDict[i].equals(word2)){
                word2Idx = i;
            }
            if(word1Idx != -1 && word2Idx != -1){
                ans = Math.min(ans, Math.abs(word1Idx - word2Idx));
            }
        }
        return ans;

    }
}
