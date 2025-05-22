class Solution {
    public boolean isPowerOfFour(int n) {        
        for(int i=0;i<31;i+=2) {
            if(n == (1<<i)) 
                return true;
        }
        return false;
    }
}