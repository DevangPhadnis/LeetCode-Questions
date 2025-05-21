class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        int start = 0;
        int end = 0;
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        while(end<n) {
            if(dq.size() == 0) {
                dq.addLast(nums[end]);
            }
            else {
                if(nums[end] > dq.peekLast()) {
                    while(dq.size() != 0 && nums[end] > dq.peekLast()) {
                        dq.removeLast();
                    }
                }
                dq.addLast(nums[end]);
            }
            if((end - start) + 1 < k) end++;
            else if((end - start) + 1 == k) {
                ans.add(dq.peekFirst());
                if(dq.peekFirst() == nums[start]) {
                    dq.removeFirst();
                }
                start++;
                end++;
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
}