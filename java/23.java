/**
 * @description: 已经升序排列的链表数组，合并为一个升序链表
 * 思路：递归分治，归并排序
 */
class Solution {
    // 时间O(KNlogK) 空间O(logK) N是所有链表中节点总数，K是链表条数
    public ListNode mergeKLists(ListNode[] lists) {
       return merge(lists, 0, lists.length - 1);
    }

    // 递归分治 left right表示需要合并的lists数组左右区间 返回合并后的链表头节点
    public ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if(left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

    // 21. 合并两个有序链表 返回合并后的链表头节点
    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(); // 用哨兵节点简化代码逻辑
        ListNode cur = dummy; // cur 指向新链表的末尾
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1; // 把 list1 加到新链表中
                list1 = list1.next;
            } else { // 注：相等的情况加哪个节点都是可以的
                cur.next = list2; // 把 list2 加到新链表中
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 != null ? list1 : list2; // 拼接剩余链表
        return dummy.next;
    }
}