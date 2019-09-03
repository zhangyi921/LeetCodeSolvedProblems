class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        int result = 0;
        for (int i = 0; i < s.length(); ++i){
            char c = s.charAt(i);
            sb.append(c);
            System.out.println(set);
            if (!set.add(c)){
                // there is a duplicate
                // remove first char in string builder until it 
                // doesn't contain duplicate
                char temp = sb.charAt(0);
                System.out.println(c+" "+i);
                while (temp != c){
                    set.remove(temp);
                    sb.deleteCharAt(0);
                    temp = sb.charAt(0);
                }
                set.remove(sb.charAt(0));
                sb.deleteCharAt(0);
                set.add(c);
            }
            result = sb.length() > result? sb.length():result;
        }
        return result;
    }
}