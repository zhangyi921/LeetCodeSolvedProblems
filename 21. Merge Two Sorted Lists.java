/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    // Runtime: faster than 100.00% of Java online submissions for Merge Two Sorted Lists.
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        ListNode head, cursor;
        if (l1.val < l2.val){
            head = l1;
            l1 = l1.next;
        } else{
            head = l2;
            l2 = l2.next;
        }
        cursor = head;
        
        // merge
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                cursor.next = l1;
                cursor = cursor.next;
                l1 = l1.next;
            } else{
                cursor.next = l2;
                cursor = cursor.next;
                l2 = l2.next;
            }
        }
        
        // append the rest nodes at end
        cursor.next = l1 == null ? l2:l1;
        
        return head;
    }
}