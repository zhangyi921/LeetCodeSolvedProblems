class Solution {

    // my solution O(nlogn)
    public boolean isAnagram(String s, String t) {
        
        if (s.length() != t.length())
            return false;
        
        char[] temp1 = s.toCharArray();
        char[] temp2 = t.toCharArray();
        Arrays.sort(temp1);
        Arrays.sort(temp2);
        
        
        for (int i = 0; i < temp1.length; ++i){
            if (temp1[i] != temp2[i]){
                return false;
            }
        }
        return true;
        
    }

    // best solution O(n)
    public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
        return false;
    }
    int[] table = new int[26];
    for (int i = 0; i < s.length(); i++) {
        table[s.charAt(i) - 'a']++;
    }
    for (int i = 0; i < t.length(); i++) {
        table[t.charAt(i) - 'a']--;
        if (table[t.charAt(i) - 'a'] < 0) {
            return false;
        }
    }
    return true;
}
}