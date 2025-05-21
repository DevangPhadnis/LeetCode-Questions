class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int first = 0;first<n-2;first++) {
            if(first>0 && nums[first]==nums[first-1]) continue;
            int second = first+1;
            int third = n-1;
            while(second<third) {
                int value = nums[first]+nums[second]+nums[third];
                if(value == 0) {
                    List<Integer> ans = new ArrayList<>();
                    ans.add(nums[first]);
                    ans.add(nums[second]);
                    ans.add(nums[third]);
                    answer.add(ans);
                    while(second<third && nums[second] == nums[second+1]) second++;
                    while(second<third && nums[third] == nums[third-1]) third--;
                    second++;
                    third--;
                }
                else if(value < 0) {
                    second++;
                }
                else 
                    third--;
            }
        }
        return answer;
    }
}