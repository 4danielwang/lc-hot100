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
    public void reorderList(ListNode head) {
        // 把节点保存在数组中，随机查找
        List<ListNode> list = new ArrayList<>();
        
        ListNode t = head;
        while(t!=null){
            list.add(t);
            t = t.next;
        }

        // 左右指针
        int left=0,right=list.size()-1;

        while(left<right){
            list.get(left).next = list.get(right);
            left++;

            // 中间再判断一次 不然就漏了
            if(left == right) break;

            list.get(right).next = list.get(left);
            right--;
        }
        list.get(left).next=null;

    }
}

// 也可以用链表法 会一种即可