class MyQueue {

    private Deque<Integer> stack1 = new LinkedList<>(); // 当栈用
    private Deque<Integer> stack2 = new LinkedList<>(); // 用来翻转

    public MyQueue() {
        
    }
    
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
        mvStack1();
        Integer t = stack2.pop();
        mvStack2();
        return t;
    }
    
    public int peek() {
        mvStack1();
        Integer t = stack2.peek();
        mvStack2();
        return t;
    }
    
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    // 把stack1放入stack2
    private void mvStack1(){
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
    }

    // 把stack2放回stack1
    private void mvStack2(){
         while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */