/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int a = rand7();
        int b = rand7();
        int val = (a-1)*7+b;
        if(val > 40) return rand10();
        else return (val%10) + 1;
    }
}