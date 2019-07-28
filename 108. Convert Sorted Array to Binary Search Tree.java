/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    // fastest solution
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        return constructTree(nums, 0, nums.length-1);
    }
    
    public TreeNode constructTree(int[] nums, int start, int end){
        int middle = (start + end) / 2;
        TreeNode head = new TreeNode(nums[middle]);
        if (end > middle)
            head.right = constructTree(nums, middle+1, end);
        if (start < middle)
            head.left = constructTree(nums, start, middle-1);
            
        return head;
    }
}