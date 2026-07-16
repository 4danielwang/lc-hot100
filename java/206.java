/**
 * @description: 普通反转链表
 * @example: [1,2,3,4,5] -> [5,4,3,2,1]
 * 思路: pre-cur-next 反转指针
 */
class Solution {
    // 时间O(n) 空间O(1)
    public ListNode reverseList(ListNode head) {
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