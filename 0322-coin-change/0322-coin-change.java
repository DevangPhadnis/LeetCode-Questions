class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        dp[0] = 0;

        for(int i=1;i<=amount;i++) {
            int ans = Integer.MAX_VALUE;
            for(int j=0;j<coins.length;j++) {
                if(coins[j] <= i) {
                    int remainder = i - coins[j];
                    if(dp[remainder] != -1) {
                        ans = Math.min(ans, 1+dp[remainder]);
                    }
                }
            }
            if(ans == Integer.MAX_VALUE) {
                dp[i] = -1;
            }
            else {
                dp[i] = ans;
            }
        }

        return dp[amount];
    }
}