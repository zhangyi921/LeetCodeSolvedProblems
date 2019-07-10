class Solution {
    // Your runtime beats 80.72 % of java submissions
    // Your memory usage beats 58.42 % of java submissions.
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int temp:nums){
            if (!set.add(temp)){
                return true;
            }
        }
        return false;
    }
}