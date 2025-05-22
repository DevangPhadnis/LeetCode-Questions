class Solution {
    public int mySqrt(int x) {
        Long start = 1L, end = x/2L;
        if(x == 1) return 1;
        while(start<=end) {
            Long mid = (start + end)/2;
            if(mid*mid == x) return Integer.parseInt(mid.toString());
            else if(mid*mid > x) end = mid-1;
            else start = mid+1;
        }
        return Integer.parseInt((end).toString());
    }
}