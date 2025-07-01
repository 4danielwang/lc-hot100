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