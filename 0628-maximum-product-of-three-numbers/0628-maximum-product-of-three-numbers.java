class Solution {
    public int maximumProduct(int[] nums) {
        int input[] = nums;
        Arrays.sort(input);
        int arrLength = input.length;
        int first = input[0] * input[1] * input[input.length - 1];

        int second = input[arrLength - 1] * input[arrLength - 2] * input[arrLength - 3];

        return Math.max(first, second);
    }
}