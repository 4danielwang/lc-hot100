/**
 * @description: 重排链表
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
        ListNode l2 = mid.next; // 中点的下一个节点 是后半部分链表的头节点
        mid.next = null;

        // 链表逆序
        l2 = reverseList(l2);

        // 合并链表
        mergeList(l1, l2);
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
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