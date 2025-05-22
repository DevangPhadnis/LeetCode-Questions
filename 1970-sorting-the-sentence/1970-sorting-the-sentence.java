class Solution {
    public String sortSentence(String s) {
        String str[] = new String[9];
        Arrays.fill(str, "");
        int start = 0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == ' ' || i == (s.length() - 1)) {
                if(i == s.length() - 1) 
                    str[s.charAt(i) - '1'] = s.substring(start, i);
                else 
                   str[s.charAt(i-1) - '1'] = s.substring(start, i-1); 
                start = i+1;
            }
        }
        s = String.join(" ", str);
        String str1 = new String(s);
        return str1.trim();
    }
}