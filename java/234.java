/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        for(ListNode p = head; p!=null; p=p.next){
            list.add(p);
        }
        int i=0,j=list.size()-1;
        while(i<j){
            if(list.get(i).val != list.get(j).val){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // 快慢指针法 实现o(1)时间复杂度
    // 链表分为两部分，把后面的一部分翻转，判断完成后再恢复
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        
        int n=0;
        for(ListNode t=head;t!=null;t=t.next){
            n++;
        }

        // 规定前半部分链表长度更长
        // 找到前半个链表的最后一个节点 n/2向上取整 = (n+1)/2
        ListNode last=head;
        for(int i=1;i<(n+1)/2;i++){
            last = last.next;
        }

        // 翻转后半段链表
        last.next = reverse(last.next);

        ListNode slow=head;
        ListNode fast=last.next;

        // 比较链表节点 后链表更短 作为结束条件
        // 用变量保存结果 因为需要把链表翻转回去 不复原可以直接return
        boolean result=true;
        while(fast!=null){
            if(slow.val != fast.val){
                result=false;
                break;
            }
            slow = slow.next;
            fast = fast.next;
        }
        // 翻转后半段链表
        last.next = reverse(last.next);
        return result;
    }


    // prev, cur, next三指针
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