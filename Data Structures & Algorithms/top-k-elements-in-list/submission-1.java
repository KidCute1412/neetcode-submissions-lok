class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Bucket sort: An array which its indexes represent frequency, its values represent an array containing all elements appearing that many times -> traverse from the end of the array until we get k elements
        Map<Integer, Integer> map = new HashMap<>();
        for(var x : nums)
        {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        List<Integer> arr[] = new ArrayList[nums.length + 1]; // plus 1 cause index is smaller than max frequency 1 unit
        for(int i = 0; i < arr.length; ++i)
        {
            arr[i] = new ArrayList<>();
        }
        for(Map.Entry<Integer, Integer> x : map.entrySet())
        {
            arr[x.getValue()].add(x.getKey());
        }
        int count = 0;
        int res[] = new int[k];
        for (int i = arr.length - 1; i >= 0 && count < k; --i)
        {
            for (int j = 0; j < arr[i].size(); ++j)
            {
                res[count] = arr[i].get(j);
                count++;
                if (count > k)
                    break;
            }
        }
        return res;
    }
}
