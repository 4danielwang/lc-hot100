/**
 * @description: 两两交换链表中的节点
 * [1,2,3,4] 输出: [2,1,4,3]
 */
class Solution {
    // 时间O(n) 空间O(1)
    public ListNode swapPairs(ListNode head) {
        // 用一个dummy节点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        // temp表示当前到达的节点 每次交换temp后面的两个节点
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            // 交换node1和node2
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1; // 下一个temp 后续两个节点需要交换
        }
        return dummyHead.next;
    }
}