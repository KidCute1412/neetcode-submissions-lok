class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // (x - a) / tA = (x -b) / tB with x >= a, b and x <= target, then car from a and car from b become a fleet. in case a < b, car a catches car b and run at the same speed at car b, can't surpass car b.
        int ans = 0;
        int n = position.length;
        float eta[] = new float[n];
        // calculate eta regardless of the rule of the game, with original speed of each cars
        for (int i = 0; i < n; ++i)
        {
            eta[i] = (float)(target - position[i]) / speed[i];
        }
        Deque<Integer> stack = new ArrayDeque<>();
        // My idea is to sort position and map each eta with the sorted position arrays
        Pair<Integer, Float>[] pairs = new Pair[n];
        for (int i = 0; i < n; ++i)
        {
            pairs[i] = new Pair(position[i], eta[i]);
        }
        // sort
        Arrays.sort(pairs, Comparator.comparing(Pair::getKey));
        for (int i = 0; i < n; ++i)
        {
            // System.out.println(pairs[i].getKey());
            position[i] =(int)pairs[i].getKey();
            eta[i] = (float)pairs[i].getValue();
        }
        // System.out.println(Arrays.toString(position));
        // System.out.println(Arrays.toString(eta));
        int i = n - 1;
        while(i >= 0)
        {
            ans++;
            float root = eta[i];
            while (i >= 0 && eta[i] <= root)
            {
                i--;
            }
           
        }
        return ans;
    }
}
