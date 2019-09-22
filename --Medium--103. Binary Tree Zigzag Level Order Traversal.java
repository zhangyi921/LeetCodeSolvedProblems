class Solution {
    
    // Your runtime beats 98.75 % of java submissions.
    // Your memory usage beats 99.04 % of java submissions.
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        // toRight == true means this row's order is from left to right
        //            false                               right to left
        Boolean toRight = true;
        TreeNode node;
        while (q.size() != 1){
            List<Integer> row = new ArrayList<>();
            while ((node = q.poll()) != null){
                row.add(node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            q.add(null);
            if (!toRight){
                Collections.reverse(row);  
            }
            res.add(row);
            toRight = !toRight;
        }
        return res;
    }
}