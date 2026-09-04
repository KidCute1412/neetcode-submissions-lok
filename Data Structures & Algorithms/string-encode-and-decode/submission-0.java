class Solution {
    public String encode(List<String> strs) {
        String res = "";
        for(String str : strs)
        {
            for (char x : str.toCharArray())
            {
                int asciiCode = (int) x;
                res += Integer.toString(asciiCode);
                res += ',';
            }
            res += ';';
        }
        System.out.println(res);
        return res;
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        String element = "";
        for(int i = 0; i < str.length(); ++i)
        {
            String character = "";
            while (i < str.length() && 
            str.charAt(i)!=',' && 
            str.charAt(i) !=';')
            {
                character += str.charAt(i);
                i++;
            }
            if (character != ""){
                char charArray = (char) Integer.parseInt(character);
                element += charArray;
            }
            if(i < str.length() && str.charAt(i) == ';')
            {
                res.add(element);
                element = "";
            }
            
        }
        return res;
    }
}
