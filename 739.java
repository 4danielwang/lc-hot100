class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // 单调栈 记录下一个更大的元素可能的下标
        Deque<Integer> stack = new ArrayDeque<>();
        int n = temperatures.length;
        int[] ans = new int[temperatures.length];

        // 逆序访问
        for(int i=n-1;i>=0;i--){
            int t = temperatures[i];
            // 只记录更大的元素 删除比自己小的元素
            // 保证栈结果 顺序递增
            while(!stack.isEmpty() && t >= temperatures[stack.peek()]){
                stack.pop();
            }
            // 有比自己更大的元素 更新ans
            if(!stack.isEmpty()){
                ans[i]=stack.peek() - i;
            }
            stack.push(i);
        } 
        return ans;
    }
}