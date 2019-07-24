/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    // beats 100% sulutions on runtime and memory
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<ListNode> al = new ArrayList<>();
        ListNode node = head;
        
        // put all nodes in the arraylist
        while (node.next != null){
            al.add(node);
            node = node.next;
        }
        al.add(node);
        al.add(null);
        
        // remove the node
        // set the node before the node that needs to be deleted .next  = the node after the node that needs to be deleted
        if (al.size()-n-2 > -1){
            al.get(al.size()-n-2).next = al.get(al.size()-n);
        }
        else if (al.size()-n-2 == -1){
            // return second node if delete the first node
            return al.get(1);
        }
        return al.get(0);
    }
}