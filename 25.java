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
    public ListNode reverseKGroup(ListNode head, int k) {
        // 创建dummy
        ListNode dummy = new ListNode(0, head);

        // 求长度
        int n=0;
        ListNode p = head;
        while(p!=null){
            p=p.next;
            n++;
        }

        ListNode pre=null;
        ListNode cur=head;
        // 找到这段需要翻转的前一个节点p0
        ListNode p0=dummy;
        ListNode next;

        // 剩余k以上的才继续
        while(n>=k){
            n-=k;
            for(int i=0;i<k;i++){
                next=cur.next;
                cur.next=pre;
                pre=cur;
                cur=next;
            }
            next=p0.next;
            // cur就是下一轮要翻转的头节点
            // 因此在之前需要保存p0.next，并且更新为下一个p0
            p0.next.next=cur; 
            p0.next=pre;
            p0=next;
        }
        return dummy.next;
    }
}