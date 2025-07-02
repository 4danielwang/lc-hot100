/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    private List<ListNode> list = new ArrayList<>();
    
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode p = head;
        while(p!=null && !list.contains(p)){
            list.add(p);
            p = p.next;
        }    
        return p==null?null:p;
    }
}