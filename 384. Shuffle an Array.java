class Solution {

    int[] nums;
    int[] shuffled;
    public Solution(int[] nums) {
        this.nums = nums;
        this.shuffled = Arrays.copyOf(nums, nums.length);
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle1() {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; ++i)
            result[i] = nums[i];
        shuffleArray(result);
        return result;
    }
    
    // improved solution
    public int[] shuffle(){
        Random random = new Random();
        for (int i = 0; i < nums.length; ++i){
            int swapIndex = i+random.nextInt(nums.length-i);
            // swap i and swapIndex
            int temp = shuffled[i];
            shuffled[i] = shuffled[swapIndex];
            shuffled[swapIndex] = temp;
        }
        return shuffled;
        
    }
    
    private static void shuffleArray(int[] array)
    {
        int index;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            if (index != i)
            {
                array[index] ^= array[i];
                array[i] ^= array[index];
                array[index] ^= array[i];
            }
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */