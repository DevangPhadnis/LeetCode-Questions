class Solution {
    public boolean isPerfectSquare(int num) {
        Long start = 1L;
        Long end = num/2L;

        while(start <= end) {
            Long mid = start + (end-start)/2;
            if(mid*mid == Long.valueOf(num)) return true;
            else if(mid*mid > Long.valueOf(num)) {
                end = mid-1;
            }
            else start = mid+1;
        }

        return num == 1 ? true : false;
    }
}