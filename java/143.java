/**
 * @description: 重排链表： 寻找链表中点+链表逆序+合并链表
 * [1,2,3,4] -> [1,4,2,3]
 */
class Solution {
    // 时间O(n) 空间O(1)
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        // 寻找链表中点
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next; // 中点的下一个节点 是后半部分链表的头节点（链表长奇数个节点的话，l2比l1少一个节点）
        mid.next = null;

        // 链表逆序
        l2 = reverseList(l2);

        // 合并链表
        mergeList(l1, l2);
    }

    // 寻找中点：快慢指针 一个走两步 一个走一步，快指针到达末尾时慢指针正好在中点
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // fast停在倒数第二个（偶数个节点）或者倒数第一个节点（奇数个节点）
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    // [1,2] [3,4] => [1,3,2,4]
    public void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_next;
        ListNode l2_next;
        while (l1 != null && l2 != null) {
            // 防丢失
            l1_next = l1.next;
            l2_next = l2.next;

            // l1链接l2 l1移动 l2链接l1 l2移动
            l1.next = l2;
            l1 = l1_next;

            l2.next = l1;
            l2 = l2_next;
        }
    }
}