class Solution {
    public int maxProfit(int k, int[] prices) {
        int dp[][][] = new int[prices.length][2][k+1];
        for(int[][] dpArr: dp) {
            for(int[] dparr: dpArr)
                Arrays.fill(dparr, -1);
        }
        return helper(prices, dp, 0, 1, k);
    }

    public int helper(int[] prices, int dp[][][], int index, int buy, int capacity) {
        if(index >= prices.length || capacity == 0) return 0;

        if(dp[index][buy][capacity] != -1) return dp[index][buy][capacity];
        int profit = 0;
        if(buy == 1) {
            int pick = helper(prices, dp, index+1, 0, capacity) - prices[index];
            int notpick = helper(prices, dp, index+1, 1, capacity);

            profit = Math.max(pick, notpick);
        }
        else {
            int pick = helper(prices, dp, index+1, 1, capacity - 1) + prices[index];
            int notpick = helper(prices, dp, index+1, 0, capacity);

            profit = Math.max(pick, notpick);
        }

        dp[index][buy][capacity] = profit;
        return dp[index][buy][capacity];
    }
}