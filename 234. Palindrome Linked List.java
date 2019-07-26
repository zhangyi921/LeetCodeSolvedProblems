/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    // Your memory usage beats 99.80 % of java submissions
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> al = new ArrayList<>();
        
        // put all nodes in an arraylist
        while (head != null){
            al.add(head.val);
            head = head.next;
        }
        
        // check if it is palindrome
        for (int i = 0, j = al.size()-1; i < j; ++i, --j){
            if (!al.get(i).equals(al.get(j)))
                return false;   
        }
        
        return true;
    }
}