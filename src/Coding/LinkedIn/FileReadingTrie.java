package Coding.LinkedIn;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileReadingTrie {
    class TrieNode {
        Map<Character, TrieNode> children;
        String value;

        public TrieNode() {
            children = new HashMap<>();
            value = null;
        }
    }

    class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String key, String value) {
            TrieNode node = root;
            for (char c : key.toCharArray()) {
                node.children.putIfAbsent(c, new TrieNode());
                node = node.children.get(c);
            }
            node.value = value;
        }

        public String get(String key) {
            TrieNode node = root;
            for (char c : key.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    return null;
                }
                node = node.children.get(c);
            }
            return node.value;
        }
    }
    public Trie readAndStoreFile(String filePath) throws IOException {
        Trie trie = new Trie();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("; ", 2);
                if (parts.length == 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    trie.insert(key, value);
                }
            }
        }
        return trie;
    }
}
