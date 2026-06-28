/**
 * @description: 删除倒数第n个节点,n是小于链表长度m的
 *               删除节点需要找到他的前一个节点
 */
class Solution {
    // 时间O(m) 空间O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 由于可能会删除链表第一个节点，用哨兵节点简化代码
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy;
        ListNode right = dummy;
        // 右指针先向右走 n 步
        while (n-- > 0) {
            right = right.next;
        }
        // 走到最后一个节点时，左指针正好指向倒数第 n 个节点的前一个节点
        while (right.next != null) {
            left = left.next;
            right = right.next; // 左右指针一起走
        }
        left.next = left.next.next; // 左指针的下一个节点就是倒数第 n 个节点
        return dummy.next;
    }
}