class MyQueue {
    Stack<Integer> input;
    Stack<Integer> output;

    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();    
    }
    
    public void push(int x) {
        input.push(x);
    }
    
    public int pop() {
        if(!output.isEmpty()) return output.pop();
        else {
            while(!input.isEmpty()) {
                int val = input.pop();
                output.push(val);
            }
            return output.isEmpty() ? -1 : output.pop();
        }
    }
    
    public int peek() {
        if(!output.isEmpty()) return output.peek();
        else {
            while(!input.isEmpty()) {
                int val = input.pop();
                output.push(val);
            }
            return output.isEmpty() ? -1 : output.peek();
        }
    }
    
    public boolean empty() {
        if(input.isEmpty() && output.isEmpty()) return true;
        else return false;
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