/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // shift the node left one positon
        // Your memory usage beats 98.84 % of java submissions.
        while (node.next != null){
            node.val = node.next.val;
            if (node.next.next == null){
                node.next = null;
                return;
            }
            node = node.next;
        }
    }
}