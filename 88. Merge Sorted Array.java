class Solution {
    
    // speed & memory beats 100% solutions!
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // shift numbers in nums1 to its end
        for (int i = m-1; i > -1; --i){
            nums1[i+n] = nums1[i];
        }
        
        // merge
        int i = nums2.length, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length){
            if (nums1[i] < nums2[j]){
                nums1[k] = nums1[i];
                ++i;
            }
            else{
                nums1[k] = nums2[j];
                ++j;
            }
            ++k;
        }
        
        // fill the rest numbers in nums1

        while (i < nums1.length){
            nums1[k] = nums1[i];
            ++i;
            ++k;
        }

        while (j < nums2.length){
            nums1[k] = nums2[j];
            ++j;
            ++k;
        }
    }
}