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
    // 递归版
    public ListNode reverseList2(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }

    public ListNode reverseList(ListNode head) {
        if(head == null) return head;

        ListNode p = head.next;
        head.next=null;
        ListNode t;
        while(p != null){
            t = p.next;
            head = pushFront(head, p);
            p = t;
        }
        return head;
    }

    // 通用方法 用三个指针pre,cur,next实现
    // [1,2,3,4,5] 
    // 翻转过后
    // pre是这段链表 原链表最后一个节点 next是这段链表下一个节点
    public ListNode reverseList0(ListNode head) {
    ListNode pre=null;
    ListNode cur=head;

    while(cur!=null){
        ListNode next=cur.next;
        cur.next=pre;
        pre=cur;
        cur=next;
    }
    return pre;
    }

    private ListNode pushFront(ListNode head, ListNode p){
        p.next = head;
        head = p;
        return head;
    }
}