/**
 * @description: 删除链表的倒数第N个节点
 * @example: 输入：head = [1,2,3,4,5], n = 2 输出：[1,2,3,5]
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    // 时间O(N) 空间O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 需要一个dummy 防止删除的是头节点
        ListNode dummy = new ListNode(0, head);
        // 快慢指针，快指针到达最后一个节点，慢指针到达要删除节点的上一个节点
        ListNode slow = dummy;
        ListNode fast = dummy;
        for(int i=0;i<n;i++){
            fast = fast.next;
        }

        // 找到倒数n的前一个节点 才能删除
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}