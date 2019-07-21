class Solution {

    // my second solution
    // it turns out that string native compare method is way faster than mine
    // Your runtime beats 100.00 % of java submissions. 
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (needle.length() > haystack.length()) return -1;
        char n = needle.charAt(0);
        for (int i = 0; i < haystack.length() - needle.length()+1; ++i){
            if (haystack.charAt(i) == n){
                // first char match, check the rest
                
                if (needle.equals(haystack.substring(i, i+needle.length())))
                    return i;
            }
        }
        return -1;
    }

    // my first solution
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (needle.length() > haystack.length()) return -1;
        char n = needle.charAt(0);
        for (int i = 0; i < haystack.length(); ++i){
            if (haystack.charAt(i) == n){
                // first char match, check the rest
                int j;
                for (j = 1; j < needle.length(); ++j){
                    if (i+j > haystack.length()-1 || needle.charAt(j) != haystack.charAt(i+j))
                        break;
                }
                if (j == needle.length())
                    return i;
            }
        }
        return -1;
    }
}