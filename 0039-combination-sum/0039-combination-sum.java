class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>(), 0, ans);
        return ans;
    }

    public void helper(int[] candidates, int target, int index, List<Integer> combination
    , int sum, List<List<Integer>> ans) {
        if(sum == target) {
            ans.add(new ArrayList<>(combination));
            return;
        }
        if(sum > target || index >= candidates.length) return;

        // pick
        combination.add(candidates[index]);
        helper(candidates, target, index, combination, sum + candidates[index], ans);
        combination.removeLast();

        // not pick
        helper(candidates, target, index + 1, combination, sum, ans);
    }
}