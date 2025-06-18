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
import java.util.*;
class Solution {
    // p0是需要翻转链表段的前一个节点,p0.next就是原来需要翻转的链表头节点
    // 增加dummy 在left=1的时候 才有p0
    // 翻转后的链表段cur是原来末尾节点的下一个节点，pre是原链表段的末尾节点
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 增加一个dummy 方便处理left=1的情况
        ListNode dummy = new ListNode(0, head.next);

        // 找到需要翻转的这段链表之前的节点p0
        ListNode p0 = dummy;
        for(int i=0;i<left-1;i++){
            p0=p0.next;
        }
        ListNode pre = null;
        ListNode cur=p0.next;
        for(int i=0;i<right-left+1;i++){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }

        p0.next.next=cur; // p0.next是原链表头节点
        p0.next=pre; // p0是原链表的上一个节点
        return dummy.next;
    }
}