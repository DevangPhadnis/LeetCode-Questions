class Solution {
    public int minCut(String s) {
        int dp[][] = new int[2000][2000];
        for(int[] dpArr: dp)
            Arrays.fill(dpArr, -1);
        return helper(0, s.length() - 1, s, dp);
    }

    public int helper(int i, int j, String s, int dp[][]) {
        if(i>=j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(isPallindrome(s, i, j)) return 0;


        int min = Integer.MAX_VALUE;
        for(int k=i;k<j;k++) {
            if(!isPallindrome(s, i, k)) continue;
            int temp = helper(k+1, j, s, dp) + 1;
            min = Math.min(min, temp);
        }

        dp[i][j] = min;
        return dp[i][j];
    }

    public boolean isPallindrome(String s, int i, int j) {
        while(i<j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}