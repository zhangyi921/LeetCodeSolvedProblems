class Solution {
    public int maxSubArray1(int[] nums) {
        int max = nums[0];
        int[] results = new int[nums.length];
        for (int i = 0; i < nums.length; ++i){
            for (int j = 0; j < i; ++j){
                results[j] += nums[i];
                if (results[j]>max)
                    max = results[j];
                // max = results[j]>max?results[j]:max;
            }
            results[i] = nums[i];
            if (nums[i]>max)
                max = nums[i];
            // max = nums[i]>max?nums[i]:max;
        }
        return max;
    }
    
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int currentMax = nums[0];
        int currentSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            if (currentSum > currentMax) {
                currentMax = currentSum;
            }
            
            if (currentSum < 0) {
                currentSum = 0;
            }
        }   
        
        return currentMax;
    }
}