class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        
        // i, lo, hi are the indexes, for each number, we do a 2 sum sweep for the rest numbers
        for (int i = 0; i < nums.length-2; ++i){
            if (nums[i] > 0) continue;
            int lo = i+1, hi = nums.length-1;
            while (lo < hi){
                int sum = nums[i] + nums[lo] + nums[hi];
                // System.out.println("sum: "+sum+" ||| "+res+" "+i+" "+lo+" "+hi);
                if (sum == 0){
                    res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    while (lo < hi && nums[lo] == nums[lo+1]) lo++;
                    while (lo < hi && nums[hi] == nums[hi-1]) hi--;
                    lo++; hi--;
                }
                else if(sum < 0)
                    ++lo;
                else
                    --hi;
            }
            while (i < nums.length-2 && nums[i] == nums[i+1]) ++i;
        }
        return res;
    }
}