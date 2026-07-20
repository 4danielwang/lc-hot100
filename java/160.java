/**
 * @description: 相交链表，给定两个单链表头节点，找出它们相交的节点，不存在返回null
 * 思路：双指针
 */
public class Solution {
    // 时间O(m+n) 空间O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 如果有链表为空 直接返回null
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        // 直到相交或者都为null 访问都长度为m+n的链表
        while (pA != pB) {
            // 当到达末尾时，指针指向另一个链表的头节点，这样两个指针相交，要么同时到达null，要么在相交点相遇
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
