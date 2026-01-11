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
    // 时间复杂度O(N)，空间复杂度O(1)
    public ListNode reverseKGroup(ListNode head, int k) {
        
        // 求链表长度
        int n=0;
        ListNode p = head;
        while(p!=null){
            p=p.next;
            n++;
        }
        
        // 利用三个节点翻转链表：pre, cur, next
        // 翻转前：pre->cur->next, 翻转后：pre<-cur<-next

        // 创建dummy
        ListNode dummy = new ListNode(0, head);

        // p0前一组链表的末节点 用于翻转后链接
        ListNode p0=dummy;
        ListNode pre=null;
        ListNode cur=head;
        
        // 不够k个节点就不翻转 k个一组处理
        while(n>=k){
            n-=k;
            // 开始翻转k个节点
            for(int i=0;i<k;i++){
                ListNode next=cur.next; // 计算next
                cur.next=pre; // [pre->cur] => [pre<-cur]
                pre=cur; // pre, cur, next后移
                cur=next;
            }

            // 翻转结束后 cur指向下一组的头节点, pre指向翻转后的头节点, p0.next指向翻转后的尾节点
            ListNode nxt=p0.next; // 获取翻转后的尾节点，下一轮的p0
            nxt.next=cur; // 连接下一组链表
            p0.next=pre; // 连接前一组链表
            p0=nxt; // 更新p0
            pre=null; // 重置pre
        }
        return dummy.next;
    }

}