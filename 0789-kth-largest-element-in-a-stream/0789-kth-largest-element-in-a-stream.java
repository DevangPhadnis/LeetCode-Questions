class KthLargest {

    PriorityQueue<Integer> pq;
    int size;
    public KthLargest(int k, int[] nums) {
        size = k;
        pq = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++) {
            if(pq.size() == k) {
                pq.add(nums[i]);
                pq.poll();
            }
            else {
                pq.add(nums[i]);
            }
        }
    }
    
    public int add(int val) {
        if(pq.size() == size) {
            pq.add(val);
            pq.poll();
        }
        else {
            pq.add(val);
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */