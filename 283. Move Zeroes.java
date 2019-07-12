class Solution {
    // this is my solutin, which already is the best
    // Your runtime beats 100.00 % of java submissions.
    // Your memory usage beats 99.96 % of java submissions.
    public void moveZeroes(int[] nums) {
        
        
        int i = 0, j;
        // i will points to the first zeor
        while (i < nums.length && nums[i] != 0){
            ++i;
        }
        j = i+1;
        
        // two pointers
        // i points to the number to be replaced
        // j points to the number to be ckecked
        for (; j < nums.length; ++j){
            if (nums[j] != 0){
                // put current number at ith place
                nums[i] = nums[j];
                ++i;
            }
        }
        
        // put 0s in the position after i
        for (; i < nums.length; ++i){
            nums[i] = 0;
        }
    }
}