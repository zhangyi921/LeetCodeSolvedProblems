class Solution {
    
    // used to different string container class
    // string builder and string class
    // similar performenca
    // Your memory usage beats 83.32 % of java submissions.
    // Your runtime beats 73.74 % of java submissions.
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1)
            return strs[0];
        String sb = "";
        
        // find the shortest length among first two strings
        int len = strs[0].length() > strs[1].length() ? strs[1].length(): strs[0].length();
        
        // find the Longest common prefix among first two
        for (int i = 0; i < len; ++i){
            if (strs[0].charAt(i) != strs[1].charAt(i))
                break;
            sb = sb.concat(Character.toString(strs[0].charAt(i)));
        }
    
        // find the longest common prefix among the rest strings
        for (int i = 2; i < strs.length; ++i){
            // compare 
            for (int j = 0; j < sb.length(); ++j){
                if (j > strs[i].length()-1 || sb.charAt(j) != strs[i].charAt(j)){
                    sb = sb.substring(0, j);
                    break;
                }
            }
        }
        return sb.toString();
    }
    
    public String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1)
            return strs[0];
        StringBuilder sb = new StringBuilder();
        
        // find the shortest length among first two strings
        int len = strs[0].length() > strs[1].length() ? strs[1].length(): strs[0].length();
        
        // find the Longest common prefix among first two
        for (int i = 0; i < len; ++i){
            if (strs[0].charAt(i) != strs[1].charAt(i))
                break;
            sb.append(strs[0].charAt(i));
        }
    
        // find the longest common prefix among the rest strings
        for (int i = 2; i < strs.length; ++i){
            // compare 
            for (int j = 0; j < sb.length(); ++j){
                if (j > strs[i].length()-1 || sb.charAt(j) != strs[i].charAt(j)){
                    sb.delete(j, sb.length());
                    break;
                }
            }
        }
        return sb.toString();
    }
}