class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        if(s.length() != t.length()) 
            return false;
        for(int i=0;i<s.length();i++) {
            int value = map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i), ++value);
            int val = map.getOrDefault(t.charAt(i), 0);
            map.put(t.charAt(i), --val);
        }
        Set<Character> keys = map.keySet();
        for(Character key: keys) {
            if(map.get(key) != 0) {
                return false;
            }
        }
        return true;
    }
}