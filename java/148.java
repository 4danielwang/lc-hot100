/**
 * @description: 对链表进行归并排序
 * 思路: 递归归并排序+合并两个有序链表
 */
class Solution {
    // 时间O(nlogn) 空间O(1)
    public ListNode sortList(ListNode head) {
       // 递归结束条件：链表为空或只有一个节点，天然有序，直接返回
        if (head == null || head.next == null) {
            return head;
        }

        // 快慢指针找中点，将链表一分为二,结束时slow指向前半部分的最后一个节点,前半部分长度>=后半部分长度
        // fast 初始化为 head.next，而不是 head
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // mid 是右半部分链表的头节点
        ListNode mid = slow.next;
        // 断开链表，分成 left 和 right 两部分
        slow.next = null;

        // 递归排序左半部分和右半部分
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        // 4. 合并两个有序链表
        return merge(left, right);
    }

    // leetcode 21：合并两个有序链表
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        // 哪个链表还有剩余，直接挂到最后
        curr.next = l1 != null ? l1 : l2;
        
        return dummy.next;
    }
}