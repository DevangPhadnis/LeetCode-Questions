class Solution {
    public int maxProfit(int[] prices, int fee) {
        int dp[][] = new int[prices.length][2];
        for(int[] dpArr: dp)
            Arrays.fill(dpArr, -1);
        return helper(prices, dp, 0, 1, fee);
    }

    public int helper(int[] prices, int dp[][], int index, int buy, int fee) {
        if(index >= prices.length) return 0;

        if(dp[index][buy] != -1) return dp[index][buy];
        int profit = 0;
        if(buy == 1) {
            int pick = helper(prices, dp, index+1, 0, fee) - prices[index];
            int notpick = helper(prices, dp, index+1, 1, fee);

            profit = Math.max(pick, notpick);
        }
        else {
            int pick = helper(prices, dp, index+1, 1, fee) + prices[index] - fee;
            int notpick = helper(prices, dp, index+1, 0, fee);

            profit = Math.max(pick, notpick);
        }

        dp[index][buy] = profit;
        return dp[index][buy];
    }
}