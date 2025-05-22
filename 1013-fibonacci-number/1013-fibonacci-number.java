class Solution {
    public int fib(int n) {
        int start = 0;
        int next = 1;
        int sum = 0;
        do {
            if(n == 0) {
                break;    
            }
            sum = start + next;
            start = next;
            next = sum;
            n--;
        } while(n>1);
        return sum;
    }
}