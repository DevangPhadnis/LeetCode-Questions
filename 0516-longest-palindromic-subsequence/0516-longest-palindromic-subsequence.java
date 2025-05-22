class Solution {
    public int longestPalindromeSubseq(String s) {
        String s1 = "";
        for(int i=s.length()-1;i>=0;i--) {
            s1 = s1 + s.charAt(i);
        }
        int dp[][] = new int[s.length()][s1.length()];
        for(int[] dpArr: dp)
            Arrays.fill(dpArr, -1);
        return helper(s, s1, s.length() - 1, s1.length() - 1, dp);
    }

    public int helper(String text1, String text2, int len1, int len2, int dp[][]) {
        if(len1 == -1 || len2 == -1) return 0;

        if(dp[len1][len2] != -1) return dp[len1][len2];

        if(text1.charAt(len1) == text2.charAt(len2)) {
            dp[len1][len2] = 1 + helper(text1, text2, len1-1, len2-1, dp);
            return dp[len1][len2];
        }
        else {
            int operation1 = helper(text1, text2, len1-1, len2, dp);
            int operation2 = helper(text1, text2, len1, len2-1, dp);

            dp[len1][len2] = Math.max(operation1, operation2);
            return dp[len1][len2];
        }
    }
}