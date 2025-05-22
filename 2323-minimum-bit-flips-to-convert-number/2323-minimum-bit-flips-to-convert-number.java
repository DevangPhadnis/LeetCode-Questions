class Solution {
    public int minBitFlips(int start, int goal) {
        int newNumber = start ^ goal;
        int ans = 0;
        while(newNumber > 0) {
            if((newNumber&1) == 1) 
                ans++;
            newNumber>>=1;
        }
        return ans;
    }
}