/**
 * @description: 普通反转链表
 * @example: [1,2,3,4,5] -> [5,4,3,2,1]
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    // 时间O(n) 空间O(1)
    public ListNode reverseList(ListNode head) {
        // 这里的dummy可以也去掉的
        ListNode dummy = new ListNode(0, head);
        ListNode pre=null;
        ListNode cur=head;

        // 用三个指针 pre,cur,next [pre->cur->next] => [pre<-cur<-next]
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        dummy.next=pre;
        return dummy.next;
    }
}