class Solution {
    public boolean isTrionic(int[] nums) {
        int p=-1;
        int q=-1;
        for(int i=1;i<nums.length;i++) {
            if(nums[i] > nums[i-1]) p = i;
            else break;
        }
        if((p == nums.length - 1) || p == -1) return false;
        for(int j=p+1;j<nums.length;j++) {
            if(nums[j] < nums[j-1]) q = j;
            else break;
        }
        if((q == nums.length - 1) || q == -1) return false;
        for(int m=q+1;m<nums.length;m++) {
            if(nums[m] > nums[m-1]) continue;
            else return false;
        }
        return true;
    }
}