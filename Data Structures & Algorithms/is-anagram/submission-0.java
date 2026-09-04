class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (Character x : s.toCharArray())
        {
            if (map1.containsKey(x))
            {
                int currentCount = map1.get(x);
                currentCount += 1;
                map1.put(x, currentCount);
            }
            else{
                map1.put(x, 1);
            }
        }
        for (char x : t.toCharArray())
        {
            if (map2.containsKey(x))
            {
                int currentCount = map2.get(x);
                currentCount += 1;
                map2.put(x, currentCount);
            }
            else{
                map2.put(x, 1);
            }
        }
        if (map1.equals(map2))
            return true;
        return false;
        

    }
}
