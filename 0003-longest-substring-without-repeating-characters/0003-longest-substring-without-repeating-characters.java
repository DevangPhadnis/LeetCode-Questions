class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int ans = 0;
        HashMap<Character, Integer> freq = new HashMap<>();
        while(end < s.length()) {
            int value = freq.getOrDefault(s.charAt(end), 0);
            freq.put(s.charAt(end), ++value);
            while(freq.get(s.charAt(end)) > 1) {
                int val = freq.getOrDefault(s.charAt(start), 0);
                freq.put(s.charAt(start), --val);
                start++;
            }
            ans = Math.max(ans, (end-start+1));
            end++;
        }
        return ans;
    }
}