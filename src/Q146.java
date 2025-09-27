import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q146 {
    class LRUCache {
        Map<Integer,Integer> map;
        List<Integer> keyList = new LinkedList<>();
        int capacity;

        public LRUCache(int capacity) {
            map = new HashMap<>(capacity);
            this.capacity = capacity;
        }

        public int get(int key) {
            int val = map.getOrDefault(key,-1);
            if(val==-1){
                return -1;
            }
            keyList.remove(Integer.valueOf(key));
            keyList.add(key);
            return val;
        }

        public void put(int key, int value) {
            map.put(key,value);
            keyList.remove(Integer.valueOf(key));
            keyList.add(key);
            if(keyList.size()>capacity){
                int evictedKey = keyList.remove(0);
                map.put(evictedKey,-1);
            }
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
