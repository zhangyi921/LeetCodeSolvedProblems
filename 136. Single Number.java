class Solution {
    
    public int singleNumber2(int[] nums) {
        int temp = 0;
        for (int i:nums){
            temp ^=i;
        }
        return temp;
    }
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i:nums){
            if (!set.remove(i)){
                // doesn't contain this number
                set.add(i);
            }
        }
        Integer[] temp  = set.toArray(new Integer[0]);
        return temp[0];
    }
    public int singleNumber1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i:nums){
            // put() a existing key pair will return this key's old value

            if (map.put(i, 1) != null){
                map.put(i, 2);
            }
        }
        for (int i:map.keySet()){
            if (map.get(i) == 1)
                return i;
        }
        return 5;
    }
    public int singleNumber0(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i:nums){
            if (map.containsKey(i))
                map.put(i, map.get(i)+1);
            else
                map.put(i, 1);
        }
        for (int i:map.keySet()){
            if (map.get(i) == 1)
                return i;
        }
        return 5;
    }
}