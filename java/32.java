class Solution {
    public int longestValidParentheses(String s) {
        int ans=0;
        // 栈保存遍历的括号下标
        // 栈底保存的是最后一个没有被匹配的右括号下标
        Deque<Integer> stack = new LinkedList<>();
        // 初始化第一个没有被匹配的右括号 -1
        stack.push(-1);

        char[] ar = s.toCharArray();
        for(int i=0;i<ar.length;i++){
            if(ar[i] == '('){
                // 遇到左括号入栈
                stack.push(i);
            }else{
                // 遇到右括号出栈
                stack.pop();
                // 如果原来只剩下栈底元素，要更新新的栈底元素
                // 保证栈底保存的是最后一个没有被匹配的右括号下标
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    // 不止剩下一个栈底元素的话
                    // 括号子串长度=当前下标-栈顶元素
                    ans = Math.max(ans, i-stack.peek());
                }
            }
        }

        return ans;
    }
}