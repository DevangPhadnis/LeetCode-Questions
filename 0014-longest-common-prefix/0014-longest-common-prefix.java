class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ans = "";
        int minLength = Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++) {
            minLength = Math.min(minLength, strs[i].length());
        }

        for(int i=0;i<minLength;i++) {
            char temp = strs[0].charAt(i);
            boolean stop = false;
            for(int j=1;j<strs.length;j++) {
                if(strs[j].charAt(i) != temp) {
                    stop = true;
                    break;
                }
            }
            if(stop) return ans;
            else ans = ans + Character.toString(temp);
        }
        return ans;
    }
}