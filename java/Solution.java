/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 两个链表都不为空才可能相交
        if (headA == null || headB == null) {
            return null;
        }
        // 双指针 到了链表末尾重表头继续遍历
        ListNode pA = headA, pB = headB;
        // 相交点一定为链表焦点
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
