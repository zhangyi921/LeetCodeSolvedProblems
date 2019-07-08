class Solution {
    // Your runtime beats 100.00 % of java submissions
    // Your memory usage beats 99.98 % of java submissions.
    public void rotate(int[] nums, int k) {
        while (k >= nums.length){
             k -= nums.length;  
        }
        int[] last = new int[k];
        // copy last k number
        for (int i = nums.length-k, j = 0; i < nums.length; ++i, ++j){
            last[j] = nums[i];
        }
        // shift first numbers
        for (int i = nums.length-k-1; i > -1; --i){
            // System.out.println(nums[i+k] + " is replaced by " + nums[i]);
            nums[i+k] = nums[i];   
        }
        // put last in the front of nums
        for (int i = 0; i < last.length; ++i){
            nums[i] = last[i];   
        }
    }
}