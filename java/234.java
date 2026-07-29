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

        // 约定：前半部分链表长度更长
        // 找到前半个链表的最后一个节点 n/2向上取整 = (n+1)/2
        ListNode last=head;
        for(int i=1;i<(n+1)/2;i++){
            last = last.next;
        }

        // 翻转后半段链表 拼接到一起
        last.next = reverse(last.next);

        ListNode slow=head; // 前半部分链表
        ListNode fast=last.next; // 后半部分链表

        // 比较链表节点 后链表更短 作为结束条件
        // 用变量保存结果 因为需要把链表翻转回去 不复原可以直接return
        boolean result=true;
        while(result && fast!=null){
            if(slow.val != fast.val){
                result=false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        // 翻转后半段链表
        last.next = reverse(last.next);
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