/**
 * @description: 原地判断链表是否存在环,如果存在返回环的入口节点,否则返回null
 *               思路: 双指针 快慢指针相遇则存在环
 */
public class Solution {
    // 时间O(n) 空间O(1)
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // 不存在环的结束条件是快指针走到null
        while (fast != null && fast.next != null) {
            // 快慢指针前进
            slow = slow.next;
            fast = fast.next.next;
            // 相遇代表存在环
            if (fast == slow) {
                // 根据Floyd判圈算法,slow和head同时前进,相遇点就是环的入口节点
                while (slow != head) {
                    slow = slow.next;
                    head = head.next;
                }
                return slow;
            }
        }
        return null;
    }
}