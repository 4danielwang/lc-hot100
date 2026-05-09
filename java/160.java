/**
 * @description: 相交链表，给定两个单链表头节点，找出它们相交的节点，不存在返回null
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 如果有链表为空 直接返回null
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        // 直到相交或者都为null
        while (pA != pB) {
            // 链表到末尾返回head
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
