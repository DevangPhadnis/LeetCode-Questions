class MinStack {

    Stack<Long> st;
    Long min;

    public MinStack() {
        st = new Stack<>();
        min = Long.MAX_VALUE;    
    }
    
    public void push(int value) {
        Long val = Long.valueOf(value);
        if(st.isEmpty()) {
            st.push(val);
            min = val;
        }
        else {
            if(val >= min) st.push(val);
            else {
                Long newValue = 2 * val - min;
                min = val;
                st.push(newValue);
            }
        }
    }
    
    public void pop() {
        if(st.isEmpty()) return;
        else {
            Long val = st.peek();
            st.pop();
            if(val >= min) {
                return;
            }
            else {
                min = 2 * min - val;
                return;
            }
        }
    }
    
    public int top() {
        if(st.peek() >= min) {
            Long value = st.peek();
            return value.intValue();
        }
        else {
            return min.intValue();
        }
    }
    
    public int getMin() {
        return min.intValue();
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