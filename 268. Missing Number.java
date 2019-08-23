class Solution {
    public int missingNumber(int[] nums) {
        // using hash map to check the missing number
        boolean[] hashMap = new boolean[nums.length+1];
        for (int i = 0; i < nums.length; ++i)
            hashMap[nums[i]] = true;
        for (int i = 0; i < hashMap.length; ++i){
            if (!hashMap[i])
                return i;
        }
        return 5;
    }
}