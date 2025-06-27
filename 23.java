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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        // 小顶堆
        Queue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode dummy = new ListNode(0, null);
        ListNode last = dummy;

        // 每个链表头入堆
        for(ListNode t: lists){
            if(t!=null)
                pq.add(t);
        }

        while(!pq.isEmpty()){
            ListNode minNode = pq.remove();
            if(minNode.next!=null){
                pq.add(minNode.next);
            }
            last.next=minNode;
            last = last.next;
        }
        return dummy.next;
    }
}