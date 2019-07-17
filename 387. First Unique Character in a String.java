class Solution {
    
    public int firstUniqChar(String s) {
        int min = Integer.MAX_VALUE;
        
        for (char c = 'a' ; c <= 'z'; c++) {
            int i = s.indexOf(c);
            int j = s.lastIndexOf(c);
            
            if(i == j && i != -1 && i < min)
                min = i;
        }
        
        if (min == Integer.MAX_VALUE) return -1;
        
        return min;
    }
    // my solution
    public int firstUniqChar1(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        // store every char in a hashmap
        for (int i = 0; i < s.length(); ++i){
            map.merge(s.charAt(i), 1, Integer::sum);
        }

        // find the first non-repeating char
        for (int i = 0; i < s.length(); ++i){
            if (map.get(s.charAt(i)) == 1){
                return i;
            }
        }

        // if not fond
        return -1;
    }
}