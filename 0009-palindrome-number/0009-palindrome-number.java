class Solution {
    public boolean isPalindrome(int x) {
        int tempNumber = x;
        int temp = 0;
        int reverseNumber = 0;
        while(x > 0) {
            temp = x % 10;
            reverseNumber = (reverseNumber * 10) + temp;
            x = x/10;
        }
        if(reverseNumber == tempNumber) {
            return true;
        }
        else {
            return false;
        }
    }
}