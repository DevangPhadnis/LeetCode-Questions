class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        int count = 0;
        int startIndex = -1;
        int start = 0, end = 0;
        int minLen = Integer.MAX_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<m;i++) {
            int value = map.getOrDefault(t.charAt(i), 0);
            map.put(t.charAt(i), ++value);
        }

        while(end<n) {
            if(map.getOrDefault(s.charAt(end), 0) > 0) {
                count++;
            }
            int value = map.getOrDefault(s.charAt(end), 0);
            map.put(s.charAt(end), --value);
            while(count == m) {
                int val = map.getOrDefault(s.charAt(start), 0);
                map.put(s.charAt(start), ++val);
                if(end - start + 1 <= minLen) {
                    minLen = end - start + 1;
                    startIndex = start;
                }
                if(map.getOrDefault(s.charAt(start), 0) > 0) {
                    --count;
                }
                start++;
            }
            end++;
        }
        return startIndex != -1 ? s.substring(startIndex, startIndex + minLen) : "";
    }
}