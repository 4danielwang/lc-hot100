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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode rear = dummy;

        Integer carry = 0;
        while(l1 != null && l2 != null){
            ListNode p = new ListNode((l1.val + l2.val + carry)%10);
            carry = (l1.val + l2.val + carry)/10;
            rear.next=p;
            rear=rear.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!=null){
            ListNode p = new ListNode((l1.val + carry)%10);
            carry = (l1.val + carry)/10;
            rear.next=p;
            rear=rear.next;
            l1=l1.next;
        }
        while(l2!=null){
            ListNode p = new ListNode((l2.val + carry)%10);
            carry = (l2.val + carry)/10;
            rear.next=p;
            rear=rear.next;
            l2=l2.next;
        }
        if(carry > 0){
            ListNode p = new ListNode(carry);
            rear.next = p;
            rear=rear.next;
        }
        rear.next=null;

        return dummy.next;
    }
}