/**
 * @description: 支持 push、pop、top 操作，并能在常数时间内检索到最小元素的栈。
 */
// 时间O(1) 空间O(n)
class MinStack {
    Deque<Integer> xStack; // 元素栈
    Deque<Integer> minStack; // 最小值栈,栈顶元素为当前xStack栈顶元素对应的最小值

    public MinStack() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    // 入栈时更新最小值栈
    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    // 出栈时更新最小值栈
    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}