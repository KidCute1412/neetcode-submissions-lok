class Solution {

    public String encode(List<String> strs) {
        String ans = "";
        for(String str : strs)
        {
            int len = str.length();
            ans += Integer.toString(len) + '@' + str;
        }
        return ans;
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        String element = "";
        for (int i = 0; i < str.length(); ++i)
        {
            String number = "";
            while (i < str.length() && str.charAt(i) != '@')
            {
                number += str.charAt(i);
                i++;
            }
            int num = Integer.parseInt(number);
            for (int j = 0; j < num; ++j)
            {
                ++i;
                element += str.charAt(i);
            }
            ans.add(element);
            element = "";
        }
        return ans;
    }
}
