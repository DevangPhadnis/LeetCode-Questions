class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] indexArray = new int[2];
        int count = 0;
        for(int i=0; i<nums.length;i++) {
            for(int j=0; j<nums.length; j++) {
                if(((nums[i]+nums[j]) == target)) {
                    if(i != j) {
                    indexArray[0] = i;
                    indexArray[1] = j;
                    count = count + 1;
                    break;
                    }
                    else {
                        continue;
                    }
                }
            }
            if(count > 0) {
                break;
            }
        }
        return indexArray;
    }
}