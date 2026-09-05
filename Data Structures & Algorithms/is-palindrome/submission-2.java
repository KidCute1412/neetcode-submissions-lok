class Solution {
    public boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end)
        {
            if(!isAlphanumeric(s.charAt(start)))
            {
                start++;
                continue;
            }
            if(!isAlphanumeric(s.charAt(end)))
            {
                end--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end)))
                return false;
            start++;
            end--;
        }
        return true;
    }
    public boolean isAlphanumeric(char c)
    {
        return ((c >= '0' && c <= '9') ||
                (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z'));
    }
}
