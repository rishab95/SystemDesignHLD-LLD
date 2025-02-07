package Coding.LinkedIn;

public class Trie {
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        private static final int size = 26;
        public TrieNode(){
            children = new TrieNode[size];
        }

        public boolean containsKey(char key){
            return children[key - 'a'] != null;
        }

        public TrieNode get(char key){
            return children[key - 'a'];
        }

        public void putNode(TrieNode node, char key){
            children[key - 'a'] = node;
        }

        public void setEnd(){
            isEnd = true;
        }
        public boolean isEnd(){
            return isEnd;
        }
    }
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()){
            if(!node.containsKey(c)){
                node.putNode(new TrieNode(), c);
            }
            node = node.get(c);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        TrieNode wordNode = searchPrefix(word);
        return wordNode != null && wordNode.isEnd();
    }

    public boolean startsWith(String prefix) {
        TrieNode prefixNode = searchPrefix(prefix);
        return prefixNode != null;
    }

    private TrieNode searchPrefix(String word){
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(node.containsKey(c)){
                node = node.get(c);
            } else {
                return null;
            }
        }
        return node;
    }
}
