class Solution {
    
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result = new ArrayList<>();
        
        int i = 0;
        int j = 0;
        while(i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int size = result.size();
        int[] intersect = new int[size];
        for(i=0; i<size; i++) {
            intersect[i] = result.get(i);
        }
        return intersect;
    }
    // my solutin
    public int[] intersect1(int[] nums1, int[] nums2) {

        // <number, # of times appears in this array>
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i: nums1)
            // if i not in map then put i in map
            // if i in map then increment 1
            map.merge(i, 1, Integer::sum);
        
        List<Integer> list = new ArrayList<Integer>();
        for (int i: nums2){
            if (map.merge(i, -1, Integer::sum) > -1)
                list.add(i);
        }
        
        int[] result = new int[list.size()];
        
        // put numbers in result in list
        for (int i = 0; i < list.size(); ++i)
            result[i] = list.get(i);
        
        return result;
    }
}