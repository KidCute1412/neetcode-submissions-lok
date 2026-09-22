class Solution {
    public int findDuplicate(int[] nums) {
        // 21/9 + 22/9 (Damn this must be hard problem...)
        // Intuition: This problem requires O(1) extra space, so I'm not gonna use hash table or set to count the frequency of number.
        // Without modifying the array, so i'm not gonna sort the array.
        // Special: length 5 -> values in 1, 2, 3, 4, 5 (values in a specific boundary)
        // The APPROACH of this is singly linked list and HARD to figure out, i guess.
        // Recaller: Floyd's Cycle Detection. Slow and fast -> intersection. Then start a second slow from the beginning of the linked list, move both slow gradually until they meet each other -> That is the beginning of the loop.
        // The really hard thing is to figure out this is linked list problem. We have n + 1 cows, n slots -> at least 1 slot holds 2 cows -> at least 1 number is duplicated. The values are actually SPECIAL. The value of each element will point to 1 index in [1, n] of the array [0, n]. So treat that value like a pointer -> new position (id of that position is its index).
        int slow = nums[0], fast = nums[0];
        while (true)
        {
            // Move first, because there no value 0 to jump to index 0
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast)
                break;
        }
        int secondSlow = nums[0];
        while (true)
        {
            if (secondSlow == slow)
                break;
            secondSlow = nums[secondSlow];
            slow = nums[slow];   
        }
        return slow;
    }
}
