package Coding.LinkedIn;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class AllOneDataStructure {
    private Map<String, Integer> map;
    private TreeSet<Pair<Integer, String>> set;

    public AllOneDataStructure(){
        map = new HashMap<>();
        set = new TreeSet<Pair<Integer, String>>((a,b)
                -> a.getKey().equals(b.getKey()) ? a.getValue().compareTo(b.getValue()) : a.getKey().compareTo(b.getKey()));
    }

    public void inc(String key){
        int count = map.getOrDefault(key, 0);
        map.put(key, count + 1);
        set.remove(new Pair<>(count, key));
        set.add(new Pair<>(count+1, key));
    }

    public void dec(String key){
        int count = map.getOrDefault(key, 0);
        set.remove(new Pair<>(count, key));
        if (count == 1) {
            map.remove(count);
        } else {
            map.put(key, count - 1);
            set.add(new Pair<>(count - 1, key));
        }
    }

    public String getMaxKey() {
        return set.isEmpty() ? "" : set.last().getValue();
    }
    public String getMinKey(){
        return set.isEmpty() ? "" : set.first().getValue();
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
