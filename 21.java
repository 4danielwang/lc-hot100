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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(0, null);
        ListNode last=dummy;
        // list2和list2都还有 互相比较
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                last.next=list1;
                list1 = list1.next;
            }else{
                last.next=list2;
                list2 = list2.next;
            }
            // 更新尾节点
            last = last.next;
        }
        // list1的所有节点拼在last后面
        while(list1!=null){
            last.next=list1;
            list1=list1.next;
            last=last.next;
        }
        // list2的所有节点拼在last后面
        while(list2!=null){
            last.next=list2;
            list2=list2.next;
            last=last.next;
        }
        return dummy.next;
    }
}