class Solution {
    
    // second solution
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        
        // store every number in a hashmap
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i){
            // check if the current number is target*1/2 and appeared second time in this array
            if (map.containsKey(target-nums[i])){
                result[0] = map.get(target-nums[i]);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }

        
        return new int[0];
    }

    // this is my first solution
    public int[] twoSumv1(int[] nums, int target) {
        int[] result = new int[2];
        
        // store every number in a hashmap
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i){
            // check if the current number is target*1/2 and appeared second time in this array
            if (map.containsKey(nums[i])){
                // System.out.println(map);
                // System.out.println("2*nums[i]: "+(2*nums[i])+" target: "+target);
                if (2*nums[i]== target){
                    // two same numbers add up to target but they have different index
                    result[0] = map.get(nums[i]);
                    result[1] = i;
                    return result;
                }
            }
            map.put(nums[i], i);
        }
        
        // check each number if there exist another number that sum to target
        
        for (int i: nums){
            if (map.containsKey(target-i) && 2*i != target){
                // return result
                result[0] = map.get(i);
                result[1] = map.get(target-i);
                return result;
            }
        }
        
        return new int[0];
    }
}