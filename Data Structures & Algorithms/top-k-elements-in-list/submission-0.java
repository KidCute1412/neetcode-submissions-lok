class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (var x : nums)
        {
            map.putIfAbsent(x, 0);
            int plus = map.get(x) + 1;
            map.put(x, plus);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        // Sort descending
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        int res[] = new int[k];
        for (int i = 0; i < k; ++i)
        {
            res[i] = list.get(i).getKey();
        }
        return res;
    }
}
