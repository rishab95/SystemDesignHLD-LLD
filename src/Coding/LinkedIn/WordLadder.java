package Coding.LinkedIn;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Convert wordList to a HashSet for fast lookups
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        // Queue to store the current word and its transformation length
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(beginWord, 1));
        wordSet.remove(beginWord);

        while (!queue.isEmpty()) {
            String word = queue.peek().getKey();
            int steps = queue.poll().getValue();

            if (word.equals(endWord)) return steps;

            for (int i = 0; i < word.length(); i++) {
                char[] wordArr = word.toCharArray();
                char original = wordArr[i];
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    wordArr[i] = ch;
                    String newWord = new String(wordArr);
                    if (wordSet.contains(newWord)) {
                        wordSet.remove(newWord);
                        queue.offer(new Pair<>(newWord, steps + 1));
                    }
                }
            }
        }

        return 0; // No valid transformation found
    }

    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() { return key; }
        public V getValue() { return value; }
    }
}
