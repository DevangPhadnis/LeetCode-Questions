class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int first = 0;first<n-3;first++) {
            for(int second = first+1;second<n-2;second++) {
                int third = second+1;
                int fourth = n-1;
                while(third<fourth) {
                    Long value = Long.parseLong(String.valueOf(nums[first]))+ Long.parseLong(String.valueOf(nums[second]))+ Long.parseLong(String.valueOf(nums[third]))+ Long.parseLong(String.valueOf(nums[fourth]));
                    if(value.equals(Long.parseLong(String.valueOf(target)))) {
                        List<Integer> ans = new ArrayList<>();
                        ans.add(nums[first]);
                        ans.add(nums[second]);
                        ans.add(nums[third]);
                        ans.add(nums[fourth]);
                        if(!answer.contains(ans)) {
                            answer.add(ans);
                        }
                    }
                    if(value < target) {
                        third++;
                    }
                    else 
                        fourth--;
                }
            }
        }
        return answer;
    }
}