class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<tokens.length;i++) {
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") 
            || tokens[i].equals("/")) {
                Integer second = st.peek();
                st.pop();
                Integer first = st.peek();
                st.pop();
                switch (tokens[i].charAt(0)) {
                    case '+' : {
                        Integer value = first + second;
                        st.push(value);
                        break;
                    }
                    case '*' : {
                        Integer value = first * second;
                        st.push(value);
                        break;
                    }
                    case '-' : {
                        Integer value = first - second;
                        st.push(value);
                        break;
                    }
                    case '/' : {
                        int value = first/second;
                        st.push(value);
                        break;
                    }
                }
            }
            else {
                st.push(Integer.parseInt(tokens[i]));
            }
        }
        return st.peek();
    }
}