/**
 * @description: 判断环形链表，判断链表是否存在环
 * 思路：快慢指针（都从head开始），快指针每次走两步，慢指针每次走一步，如果存在环，那么快慢指针一定会相遇
 */
public class Solution {
    // 时间O(n) 空间O(1)
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        //
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 快慢指针相遇，说明存在环
            if (fast == slow) {
                return true;
            }
        }
        return false; // 访问到了链表末尾，无环
    }
}