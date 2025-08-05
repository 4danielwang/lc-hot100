class MinStack {
    private Deque<Integer> stack = new ArrayDeque<>();
    // 栈顶保存当前元素的最小值
    private Deque<Integer> helpStack = new ArrayDeque<>();

    public MinStack() {
        helpStack.push(Integer.MAX_VALUE);
    }
    
    // 入栈需要找到最小值 更新helpStack
    public void push(int val) {
        stack.push(val);
        // 把最小栈顶和当前值比较取最小放入栈顶
        helpStack.push(Math.min(val, helpStack.peek()));
    }
    
    // 出栈直接出
    public void pop() {
        stack.pop();
        helpStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return helpStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */