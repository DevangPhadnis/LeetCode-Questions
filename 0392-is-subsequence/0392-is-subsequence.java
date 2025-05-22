class Solution {
    public boolean isSubsequence(String s, String t) {
        int dp[][] = new int[s.length()][t.length()];
        for(int[] dpArr: dp)
            Arrays.fill(dpArr, -1);
        return helper(s, t, s.length() - 1, t.length() - 1, dp) == s.length();
    }

    public static int helper(String text1, String text2, int len1, int len2, int dp[][]) {
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