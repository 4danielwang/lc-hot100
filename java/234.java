/**
 * @description: 判断链表是否为回文链表
 * @example: 输入: 1->2 输出: false
 * @example: 输入: 1->2->2->1 输出: true
 * 思路：快慢指针。找到前半部分链表的最后一个节点，翻转后半部分链表，判断是否回文，最后再恢复链表。
 */
class Solution {
    // 时间O(n) 空间O(1)
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        
        int n=0;
        for(ListNode t=head;t!=null;t=t.next){
            n++;
        }

        // 双指针分割链表为l1和l2，l1链表长度>=l2长度
        ListNode slow = head; 
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow最后指向l1的最后一个节点
        // 翻转后半段链表 拼接到一起
        slow.next = reverse(slow.next);

        // 比较前后两半部分是否回文
        ListNode p1 = head; // 前半部分指针
        ListNode p2 = slow.next; // 后半部分指针

        boolean result=true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
       
        // 翻转后半段链表
        slow.next = reverse(slow.next);
        return result;
    }


    // 反转链表
    private ListNode reverse(ListNode head){
      ListNode prev=null; // cur的上一个指针翻转后就是next
      ListNode cur=head;
     
      while(cur != null){
        // 这里修改了cur.next 后面要用到 先保存
        ListNode next = cur.next;
        cur.next=prev;
        prev=cur;
        cur=next;
      }
      return prev;
    }
}