class Solution {
    public boolean isPalindrome(String s) {
        String checkString = "";
        for (int i = 0; i < s.length(); ++i)
        {
            if(isAlphanumeric(s.charAt(i)))
            {
                checkString += Character.toLowerCase(s.charAt(i));
            }
        }
        int start = 0, end = checkString.length() - 1;
        while (start < end)
        {
            if (checkString.charAt(start) != checkString.charAt(end))
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
