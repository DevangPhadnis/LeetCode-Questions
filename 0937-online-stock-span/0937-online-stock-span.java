class StockSpanner {

    Stack<Map.Entry<Integer, Integer>> st;
    int index;

    public StockSpanner() {
        st = new Stack<>();
        index = 0;
    }
    
    public int next(int price) {
        int ans = 0;
        if(st.isEmpty()) {
            ans = 1;
            st.push(Map.entry(price, 0));
        }
        else {
            while(!st.isEmpty() && price >= st.peek().getKey() && st.peek().getKey() != -1) {
                st.pop();
            }
            index = index+1;
            ans = st.isEmpty() ? index + 1 : (index - (st.peek().getValue()));
            st.push(Map.entry(price, index));
        }
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */