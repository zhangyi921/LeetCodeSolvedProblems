class Solution {
    HashMap<Character, Integer> map;

    public int romanToInt(String s) {
        int result = 0;
        if (map == null){
            map = new HashMap<>();
            map.put('I', 1);
            map.put('V', 5);
            map.put('X', 10);
            map.put('L', 50);
            map.put('C', 100);
            map.put('D', 500);
            map.put('M', 1000);
        }

        for (int i = 0; i < s.length(); ++i){
            if (i+1 < s.length()){
                if (map.get(s.charAt(i+1)) > map.get(s.charAt(i))){
                    // this digit is represented by two letters
                    result += map.get(s.charAt(i+1)) - map.get(s.charAt(i));
                    ++i;
                }
                else{
                    result += map.get(s.charAt(i));
                }
            }
            else{
                result += map.get(s.charAt(i));
            }
        }
        
        return result;
    }
}