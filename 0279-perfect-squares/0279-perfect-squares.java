class Solution {
    public int numSquares(int n) {
        if(n<=3) return n;
        ArrayList<Integer> squares = new ArrayList<>();
        for(int i=1;i*i<=n;i++) {
            squares.add(i*i);
        }

        int dp[] = new int[n+1];
        dp[0] = 0;

        for(int i=1;i<=n;i++) {
            int ans = Integer.MAX_VALUE;
            for(int j=0;j<squares.size();j++) {
                if(squares.get(j) <= i) {
                    int remainder = i - squares.get(j);
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

        return dp[n];
    }
}