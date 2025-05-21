class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        helper(nums, new ArrayList<>());
        return ans;    
    }
    public void helper(int arr[], List<Integer> usedElement) {
        if(arr.length == usedElement.size()) {
            ans.add(new ArrayList<>(usedElement));
            return;
        }
        for(int i=0;i<arr.length;i++) {
            if(!usedElement.contains(arr[i])) {
                usedElement.add(arr[i]);
                helper(arr, usedElement);
                usedElement.removeLast();
            }
        }
    }
}