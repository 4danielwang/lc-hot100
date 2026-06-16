/**
 * @description: LCR 链表中的倒数第k个节点
 */
class Solution {
    // 时间O(n)，空间O(1)
    public ListNode trainingPlan(ListNode head, int cnt) {
        ListNode pre = head;
        ListNode post = head;
        // 快指针先走cnt步
        for(int i=0;i<cnt;i++){
            post = post.next;
        }
        // 快指针到null时，慢指针就是倒数第cnt个节点
        while(post != null){
            pre = pre.next;
            post=post.next;
        }
        return pre;
    }
}