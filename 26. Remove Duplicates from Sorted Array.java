class Solution {
    // got the solution on my frist try
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2){
            return nums.length;
        }
        int p1 = 1, p2 = 1;
        while (p2 != nums.length){
            if (nums[p2] == nums[p2-1]){
                ++p2;
            }
            else{
                nums[p1] = nums[p2];
                ++p1;
                ++p2;
            }
        }
        return p1;
    }
}