class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pointer1 = 0;
        int pointer2 = 0;
        int index = 0;
        int nums[] = new int[m+n];
        int val = nums1[0];
        while(pointer1 < m && pointer2 < n) {
            if(nums1[pointer1] < nums2[pointer2]) {
                nums[index] = nums1[pointer1];
                pointer1++;
            }
            else {
                nums[index] = nums2[pointer2];
                pointer2++;
            }
            index++;
        }
        while(pointer1<m) {
            nums[index++] = nums1[pointer1];
            pointer1++;
        }
        while(pointer2<nums2.length) {
            nums[index++] = nums2[pointer2];
            pointer2++;
        }

        for(int i=0;i<m+n;i++) {
            nums1[i] = nums[i];
        }
    }
}