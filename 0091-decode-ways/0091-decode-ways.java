class Solution {
    public int numDecodings(String s) {
        int dp[] = new int[s.length()];
        Arrays.fill(dp, -1);
        return numberWays(s, 0, dp);
    }

    public int numberWays(String s, int index, int[] dp) {
        if(index >= s.length()) return 1;

        if(s.charAt(index) == '0') return 0;

        if(dp[index] != -1) return dp[index];

        int waysSingle = numberWays(s, index + 1, dp);
        
        if(index + 2 <= s.length()) {
            String str = s.substring(index, index + 2);
            if(Integer.parseInt(str) <= 26) {
                waysSingle+= numberWays(s, index + 2, dp);
            }
        }
        dp[index] = waysSingle;
        return dp[index];
    }
}