class Solution {
    
    HashMap<Integer, Integer> map = new HashMap<>();
    public int rob(int[] nums) {
        map.clear();
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        return Math.max(robThis(nums, 0), robThis(nums, 1));
    }
    
    public int robThis(int[] nums, int toBeRobbed){
        // try to rob the house after one house of current house
        // try to rob the house after two house of current house
        // choose the one with max profit
        int profit = 0, attempt1 = 0, attempt2 = 0;
        Integer temp;
        if (toBeRobbed+2<nums.length){
            temp = map.get(toBeRobbed+2);
            attempt1 = temp == null ? robThis(nums, toBeRobbed+2) : temp;
        }
            
        if (toBeRobbed+3<nums.length){
            temp = map.get(toBeRobbed+3);
            attempt2 = temp == null ? robThis(nums, toBeRobbed+3) : temp;
        }
        profit = attempt1>attempt2?attempt1:attempt2;
        profit += nums[toBeRobbed];
        
        map.put(toBeRobbed, profit);
        return profit;
        
    }
}