class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        /* dp[0] = 1;
        dp[1] = 1; */
        int prev = 1;
        int prev2 = 1;
        for(int index=2;index<=n;index++) {
            int curr = prev + prev2;
            dp[index] = curr;
            prev2 = prev;
            prev = curr;
        }
        return prev;
        /* Arrays.fill(dp, -1);
        return helper(n, dp); */
    }

    /* public int helper(int index, int dp[]) {
        if(index <= 1) return 1;

        if(dp[index] != -1) return dp[index];

        int left = helper(index - 1, dp);
        int right = helper(index - 2, dp);

        dp[index] = left + right;
        return dp[index];
    } */
}