/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // 链表长度小于2
        if(head==null || head.next==null) return false;
        // 定义快慢指针
        ListNode slow = head;
        ListNode fast = head.next;

        // 为了进入循环 slow要不等于fast
        while(slow != fast){
            // 后面没有了 不可能有环
            if(fast==null || fast.next == null) return false;
            slow = slow.next; // p移动一格
            fast = fast.next.next; // q移动2格
        }
        return true;
    }
}