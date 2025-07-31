class Solution {
    public int reverse(int x) {
        if(x > Integer.MAX_VALUE) return 0;
        else if(x < Integer.MIN_VALUE) return 0;
        int newNumber = 0;
        while(x!=0) {
            int temp = x%10;
            if(newNumber > Integer.MAX_VALUE / 10 || 
            (newNumber == Integer.MAX_VALUE / 10 && temp > 7)) return 0;
            else if(newNumber < Integer.MIN_VALUE / 10 || 
            (newNumber == Integer.MIN_VALUE / 10 && temp < -8)) return 0;
            newNumber = newNumber * 10 + temp;
            x = x/10;
        }
        return newNumber;
    }
}