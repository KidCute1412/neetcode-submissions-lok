class TimeMap {
    static Map<String, List<Pair<Integer, String>>> map = null;
    public TimeMap() {
        map = new HashMap<>();
    }
    public void set(String key, String value, int timestamp) {
        Pair<Integer, String> pair = new Pair<>(timestamp, value);
        if (!map.containsKey(key))
        {
            map.put(key, new ArrayList<>());
        }   
        map.get(key).add(pair);
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> values = map.get(key);
        if (values == null) return "";
        int n = values.size();
        int start = 0, end = n - 1;
        String res = "";
        while(start <= end)
        {
            int mid = (start + end) / 2;
            if(values.get(mid).getKey() <= timestamp)
            {
                res = values.get(mid).getValue();
                start = mid + 1;
            }
            else
                end = mid - 1;
        }
        return res;
    }
    public class Pair<K, V>
    {
        private final K key;
        private final V value;
        public Pair(K k, V v)
        {
            key = k;
            value = v;
        }
        public K getKey()
        {
            return key;
        }
        public V getValue()
        {
            return value;
        }
    }
}
