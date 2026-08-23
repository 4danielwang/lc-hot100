/**
 * @description: temperatures[i]表示第i天的温度，计算数组answer，其中answer[i]是指对于第i天，下一个更高温度出现在几天后，如果不存在更高温度，那么answer[i] = 0
 * 思路：单调栈，栈中存储下一个更大的元素的下标
 */
class Solution {
    // 时间O(n) 空间O(n)
    public int[] dailyTemperatures(int[] temperatures) {
        // 单调栈
        Deque<Integer> stack = new ArrayDeque<>();
        int n = temperatures.length;
        int[] ans = new int[temperatures.length];

        // 逆序访问
        for(int i=n-1;i>=0;i--){
            int t = temperatures[i];
            // 只记录更大的元素 弹出<=当前温度t的元素
            // 栈顶元素是下一个更大的元素的下标
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