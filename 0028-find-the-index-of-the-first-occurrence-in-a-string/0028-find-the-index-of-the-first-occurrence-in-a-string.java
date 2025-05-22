class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length()) return -1;
        int count = 0;
        int index = -1;
        int p;
        int j;
        for(int i = 0; i<haystack.length(); i++) {
            count = 0;
                for(j=0, p=i; j<needle.length() && p<haystack.length(); j++, p++) {
                    if(needle.charAt(j) == haystack.charAt(p)) {
                        index = i;
                        count += 1;
                    }
                    else {
                        count = 0;
                        index = -1;
                        break;
                    }
                }
            if(count == 0 || j<needle.length()) {
                index = -1;
            }
            else {
                break;
            }
        }
        return index;
    }
}