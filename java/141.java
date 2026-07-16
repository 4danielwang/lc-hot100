/**
 * @description: 判断环形链表，判断链表是否存在环
 */
public class Solution {
    // 时间O(n) 空间O(1)
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        // 快慢指针相遇
        while (slow != fast) {
            // 快指针访问完链表
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}