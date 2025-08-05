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
    public ListNode trainingPlan(ListNode head, int cnt) {
        ListNode pre = head;
        ListNode post = head;
        for(int i=0;i<cnt;i++){
            post = post.next;
        }

        while(post != null){
            pre = pre.next;
            post=post.next;
        }
        return pre;

    }
}