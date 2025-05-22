class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        int res[] = new int[2];

        while(start < end) {
            int result = numbers[start] + numbers[end];
            if(result == target) {
                res[0] = start + 1;
                res[1] = end + 1;
            }
            if(result < target) start++;
            else end--;
        }
        return res;
    }
}