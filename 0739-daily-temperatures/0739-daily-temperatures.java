class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int answer[] = new int[temperatures.length];
        int n = temperatures.length;
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--) {
            if(st.isEmpty()) {
                answer[i] = 0;
            }
            else if(!st.isEmpty() && temperatures[st.peek()] > temperatures[i]) {
                answer[i] = st.peek() - i;
            }
            else {
                while(!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]) {
                    st.pop();
                    if(st.isEmpty()) {
                        answer[i] = 0;
                    }
                    else {
                        answer[i] = st.peek() - i;
                    }
                }
            }
            st.push(i);
        }
        return answer;
    }
}