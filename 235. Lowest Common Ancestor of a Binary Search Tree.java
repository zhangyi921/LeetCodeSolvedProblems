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
    
    private HashSet<TreeNode> visited = new HashSet<>();
    private TreeNode result;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // if(p.val<root.val&&q.val<root.val)
        //     return lowestCommonAncestor(root.left,p,q);
        // if(p.val>root.val&&q.val>root.val)
        //     return lowestCommonAncestor(root.right,p,q);
        // return root;
        while (root != null){
            if (p.val > root.val && q.val > root.val){
                root = root.right;
            } else if (p.val < root.val && q.val < root.val){
                root = root.left;
            } else {
                return root;
            }
        }
        return null;
    }
    
    // this is my solution
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        // dfs from left and store all visited nodes
        // dfs from right and check if sees previous dfs visited nodes
        // the last visited nodes is lowes common ancestor
        
        if (p.val < q.val){
            dfsFromLeft(root, p);
            dfsFromRight(root, q);
        } else{
            dfsFromLeft(root, q);
            dfsFromRight(root, p);
        }
        
        
        return result;
    }
    public Boolean dfsFromLeft(TreeNode root, TreeNode node){
        if (root != null){
            System.out.println(root.val);
            visited.add(root);
            if (root == node){
                return true;
            }
            // if find this node, stop visting
            if (dfsFromLeft(root.left, node)){
                return true;
            }
            if (dfsFromLeft(root.right, node)){
                return true;
            }
            
        }
        return false;
    }
    public Boolean dfsFromRight(TreeNode root, TreeNode node){
        if (root != null){
            if (visited.contains(root)){
                result = root;
            } 
            if (root == node){
                return true;
            }
            if (dfsFromRight(root.right, node)){
                return true;
            }
            if (dfsFromRight(root.left, node)){
                return true;
            }
        }
        return false;
    }
}