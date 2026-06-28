/**
 * @description: 逆序的两个链表,把两个链表数字按对应位置相加,返回最终的链表
 * @example: [2,4,3] + [5,6,4] = [7,0,8]
 */
class Solution {
    // 时间O(max(m,n)) 空间O(1)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode rear = dummy;

        // 带上进位一起相加
        Integer carry = 0;
        while (l1 != null && l2 != null) {
            ListNode p = new ListNode((l1.val + l2.val + carry) % 10);
            carry = (l1.val + l2.val + carry) / 10;
            rear.next = p;
            rear = rear.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        // 处理剩余的l1或l2
        while (l1 != null) {
            ListNode p = new ListNode((l1.val + carry) % 10);
            carry = (l1.val + carry) / 10;
            rear.next = p;
            rear = rear.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            ListNode p = new ListNode((l2.val + carry) % 10);
            carry = (l2.val + carry) / 10;
            rear.next = p;
            rear = rear.next;
            l2 = l2.next;
        }
        // 处理最后的进位
        if (carry > 0) {
            ListNode p = new ListNode(carry);
            rear.next = p;
            rear = rear.next;
        }
        rear.next = null;

        return dummy.next;
    }
}