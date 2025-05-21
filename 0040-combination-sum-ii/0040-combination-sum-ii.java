class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>(), 0, ans);
        return ans;
    }

    public void helper(int[] candidates, int target, int index, ArrayList<Integer> 
    combination, int sum, List<List<Integer>> ans) {
        if(sum == target) {
            ans.add(new ArrayList<>(combination));
            return;
        }
        if(sum > target) return;
        for(int i=index;i<candidates.length;i++) {
            if(i>index && candidates[i] == candidates[i-1]) continue;

            combination.add(candidates[i]);
            helper(candidates, target, i+1, combination, sum + candidates[i], ans);
            combination.remove(combination.size() - 1);
        }
    }
}