/**
 * @description: 用栈实现队列
 *               思路: 两个栈,输入栈用于存push的数据,输出栈用于pop和peek
 */
// 时间O(1) 空间O(n)
class MyQueue {

    private Deque<Integer> inStack; // 输入栈
    private Deque<Integer> outStack; // 输出栈

    public MyQueue() {
        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        // 输出栈为空 需要将输入栈的数据放入输出栈
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.pop();
    }

    public int peek() {
        // 输出栈为空 需要将输入栈的数据放入输出栈
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    // 输入栈放入输出栈 顺序翻转
    private void in2out() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}
