class Solution {
    public boolean isPowerOfTwo(int n) {
        int count = 0;
        if(n<=0) 
            return false;
        while(n>0) {
            int lsb = n&1;
            if(lsb == 1) {
                count ++;
            }
            if(count > 1) {
                return false;
            }
            n = n>>1;
        }
        return true;
    }
}