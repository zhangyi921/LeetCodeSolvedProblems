class Solution {
    
    // beat 100% all other algorithms!!!
    HashMap<Integer, Integer> map = new HashMap<>();

    // DP solution
    public int rob(int[] nums){
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        // each number stores the max profit if rob this one
        int[] profits = new int[nums.length];
        
        // initial set up
        int maxProfit = 0;
        profits[0] = nums[0];
        profits[1] = nums[1];
        maxProfit = profits[0] > profits[1] ? profits[0] : profits[1];
        if (nums.length > 2){
            profits[2] = nums[2] + profits[0];
            maxProfit = maxProfit > profits[2] ? maxProfit : profits[2];
        }
        
        // if rob the current one, the max profit is
        // max(current-2's profit + current profit, current-3's profit + current profit)
        for (int i = 3; i < nums.length; ++i){
            profits[i] = profits[i-2]+nums[i] > profits[i-3]+nums[i] ? profits[i-2]+nums[i] : profits[i-3]+nums[i];
            maxProfit = maxProfit > profits[i] ? maxProfit : profits[i];
        }
        
        return maxProfit;
    }

    // recur solution
    public int rob1(int[] nums) {
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