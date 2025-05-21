class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        int number = maxHeap.poll();
        minHeap.add(number);
        if(minHeap.size() > maxHeap.size()) {
            int numbers = minHeap.poll();
            maxHeap.add(numbers);
        }
    }
    
    public double findMedian() {
        if(maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        else {
            return Double.valueOf(Double.valueOf(minHeap.peek() + maxHeap.peek())/2);
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */