/**
 * @description: nums数组有一个大小为k的滑动窗口每次滑动1位，返回每个位置下窗口内的最大值
 * 思路：单调队列（双端队列）存储当前窗口内从大到小元素下标 deque.getFirst()是最大值下标，deque.getLast()是最小值下标
 */
class Solution {
    // 时间O(n) 空间O(k)
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] ans = new int[n-k+1];
        // 单调队列 队首是最大值下标
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i=0;i<n;i++){
            // 1. 入窗口：移除队尾的小于等于当前元素的下标
            while(!deque.isEmpty() && nums[deque.getLast()] <= nums[i]){
                deque.removeLast();
            }
            // 入队当前元素下表
            deque.addLast(i);

            // 2. 出窗口: 窗口大于k时，移除队首元素
            if(i-deque.getFirst()+1 > k){
                deque.removeFirst();
            }

            // 3. 首次到达窗口大小k时 开始记录窗口最大值下标
            if(i >= k-1){
                ans[i-k+1] = nums[deque.getFirst()];
            }
        }

        return ans;
    }
}