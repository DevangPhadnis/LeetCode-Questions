class Solution {
    public int[] shuffle(int[] nums, int n) {
        int ans[] = new int[nums.length];
        int cnt = 0;
        for(int i=0;i<nums.length;i+=2) {
            ans[i] = nums[cnt];
            ans[i+1] = nums[((nums.length)/2)+cnt];
            cnt++;
        }
        return ans;  
    }
}