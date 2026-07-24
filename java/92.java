/**
 * @description: 反转链表2: 反转第left个基点到第right个节点(不是下标)之间的链表,
 * 思路: pre->cur->next => pre<-cur<-next 翻转后 pre是翻转段的最后一个节点, cur是翻转段后的第一个节点
 */
// 时间O(n) 空间O(1)
class Solution {
    // p0是需要翻转链表段的前一个节点,p0.next就是原来需要翻转的链表头节点
    // 增加dummy 在left=1的时候 才有p0
    // 翻转后的链表段cur是原来末尾节点的下一个节点，pre是原链表段的末尾节点
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 增加一个dummy 方便处理left=right=1的情况
        ListNode dummy = new ListNode(0, head);

        // 找到第left-1个节点的前一个节点p0,从dummy开始走left-1步
        ListNode p0 = dummy;
        for(int i=0;i<left-1;i++){
            p0=p0.next;
        }
        ListNode pre = null;
        ListNode cur=p0.next;
        // 对于完整的链表翻转可以用cur!=null判断,这里只能用right-left+1次循环
        for(int i=0;i<right-left+1;i++){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        p0.next.next=cur; // p0.next是翻转前left节点
        p0.next=pre; // p0是原链表的上一个节点
        return dummy.next;
    }
}