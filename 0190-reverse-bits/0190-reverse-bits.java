public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        for(int curr = 0;curr < 32;curr++) {
            int new_position = (32 - curr) - 1;
            int bit = (n>>curr)&1;
            int mask = bit<<new_position;
            ans = ans | mask;
        }
        return ans;
    }
}