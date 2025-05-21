class Solution {
    List<List<String>> ans;
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        helper(s, new ArrayList<>());
        return ans;
    }
    public void helper(String s, List<String> partitions) {
        if(s.isEmpty()) {
            ans.add(new ArrayList<>(partitions));
            return;
        }
        for(int i=1;i<=s.length();i++) {
            String prefix = s.substring(0, i);
            String suffix = s.substring(i);
            if(isPallindrome(prefix)) {
                partitions.add(prefix);
                helper(suffix, partitions);
                partitions.removeLast();
            }
        }
    }
    public boolean isPallindrome(String s) {
        int l = 0, r = s.length() - 1;
        while(l<r) {
            if(s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}