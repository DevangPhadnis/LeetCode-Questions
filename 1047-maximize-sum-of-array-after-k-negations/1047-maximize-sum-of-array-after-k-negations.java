class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        /* PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = nums.length;
        int sum = 0;

        for(int i=0;i<n;i++) pq.add(nums[i]);

        for(int i=0;i<k;i++) {
            int number = (-1) * pq.poll();
            pq.add(number);
        }

        while(!pq.isEmpty()) {
            sum+= pq.poll();
        }

        return sum; */

        Arrays.sort(nums);
        int i=0;
        int sum = 0;
        while(i<nums.length && k>0) {
            if(nums[i] < 0) {
                nums[i] = (-1) * nums[i];
                i++;
                k--;
            }
            else break;
        }

        if(k > 0) {
            Arrays.sort(nums);
            if((k&1) == 1) nums[0] = (-1) * nums[0];
        }
        for(int p=0;p<nums.length;p++) sum+= nums[p];
        return sum;
    }
}