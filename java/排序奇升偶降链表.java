/**
 * @description: 一个位置奇升偶降的链表排序
 * @example: 18365472->12345678
 * 思路： 按奇偶位置拆分链表、反转偶链表、合并两个链表
 */

public class Solution {
    // 时间O(n) 空间O(1)
    public ListNode sortOddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 1. 拆分
        ListNode[] splitLists = splitList(head);
        ListNode oddHead = splitLists[0];
        ListNode evenHead = splitLists[1];

        // 2. 反转偶数部分
        evenHead = reverseList(evenHead);

        // 3. 合并两个升序链表
        return mergeTwoLists(oddHead, evenHead);
    }

    /**
     * Step 1: 将链表按奇偶位拆分为两个链表
     * 返回的数组中，res[0] 为奇数链表头，res[1] 为偶数链表头
     */
    private ListNode[] splitList(ListNode head) {
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        
        ListNode odd = oddHead;
        ListNode even = evenHead;
        
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        // 断开原链表中odd与even链表连接
        odd.next = null;
        return new ListNode[]{oddHead, evenHead};
    }

    /**
     * Step 2: 反转链表（LeetCode 206）
     */
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    /**
     * Step 3: 合并两个升序链表（LeetCode 21）
     */
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        
        tail.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}