class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if(n < 0) {
            double answer = helper(x, -N);
            return 1/answer;
        }
        else {
            return helper(x, Long.valueOf(n));
        }
    }

    public double helper(double a, Long n) {
        if(n==0 || a == 1) return 1;

        if(n == 1) return a;

        if((n & 1) == 0) {
            double answer = helper(a, n/2);
            return answer*answer;
        }
        else {
            double answer = helper(a, ((n-1)/2));
            return answer*answer*a;
        }
    }
}