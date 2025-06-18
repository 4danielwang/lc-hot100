import java.util.*;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // 优先队列 默认是小顶堆 大顶堆传入Collections.reverseOrder()
        Queue<Integer> minHeap = new PriorityQueue<>(k);

        for(int i : nums){
            minHeap.add(i);
        }

        // 弹出n-k个元素
        for(int i=0;i<nums.length-k;i++){
            minHeap.remove();
        }
        // 剩下k个最大的 堆顶是其中最小的
        return minHeap.peek();
    
    }
}