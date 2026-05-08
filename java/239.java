class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] ans = new int[n-k+1];
        // 单调队列 队首是最大值下标
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i=0;i<n;i++){
            // 1. 入窗口
            while(!deque.isEmpty() && nums[deque.getLast()] <= nums[i]){
                deque.removeLast();
            }
            deque.addLast(i);

            // 2. 出窗口
            if(i-deque.getFirst()+1 > k){
                deque.removeFirst();
            }

            // 3. 记录答案 最大值是队头
            if(i >= k-1){
                ans[i-k+1] = nums[deque.getFirst()];
            }
        }

        return ans;
    }
}