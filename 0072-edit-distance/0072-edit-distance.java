class Solution {
    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()][word2.length()];
        for(int[] dpArr: dp)
            Arrays.fill(dpArr, -1);
        return helper(word1, word2, word1.length() - 1, word2.length() - 1, dp);
    }

    public int helper(String word1, String word2, int len1, int len2, int[][] dp) {
        if(len1<0) return len2+1;

        else if(len2<0) return len1+1;

        if(dp[len1][len2] != -1) return dp[len1][len2];

        if(word1.charAt(len1) == word2.charAt(len2)) {
            dp[len1][len2] = helper(word1, word2, len1-1, len2-1, dp);
            return dp[len1][len2];
        } 

        else {
            int operation1 = 1 + helper(word1, word2, len1, len2-1, dp);
            int operation2 = 1 + helper(word1, word2, len1-1, len2, dp);
            int operation3 = 1 + helper(word1, word2, len1-1, len2-1, dp);
            dp[len1][len2] = Math.min(operation1, Math.min(operation2, operation3));
            return dp[len1][len2];
        }
    }
}