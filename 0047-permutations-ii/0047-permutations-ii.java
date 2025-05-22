class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, new ArrayList<>(), new boolean[nums.length]);
        return ans;
    }
    public void helper(int nums[], List<Integer> usedElement, boolean visited[]) {
        if(nums.length == usedElement.size()) {
            ans.add(new ArrayList<>(usedElement));
            return;
        }
        for(int i=0;i<nums.length;i++) {
            if(visited[i] || (i > 0 && nums[i] == nums[i-1] && !visited[i-1]))
                continue;
            visited[i] = true;
            usedElement.add(nums[i]);
            helper(nums, usedElement, visited);
            usedElement.removeLast();
            visited[i] = false;
        }
    }
}