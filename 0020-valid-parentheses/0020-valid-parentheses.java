class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                st.push(s.charAt(i));
            }
            else {
                if(st.isEmpty()) return false;
                Character charVal = (Character) st.pop();
                switch (charVal) {
                    case '(' : {
                        if(s.charAt(i) != ')') return false;
                        break;
                    }
                    case '[': {
                        if(s.charAt(i) != ']') return false;
                        break;
                    }
                    case '{': {
                        if(s.charAt(i) != '}') return false;
                        break;
                    }
                }
            }
        }
        return st.isEmpty() ? true : false;
    }
}