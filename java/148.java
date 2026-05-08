/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        for(ListNode t=head; t!=null; t=t.next){
            list.add(t);
        }
        Collections.sort(list, (a, b)->a.val-b.val);
        ListNode dummy = new ListNode(0);
        ListNode rear = dummy;
        for(ListNode t: list){
            rear.next = t;
            rear = rear.next;
        }
        rear.next=null;
        return dummy.next;
    }
}