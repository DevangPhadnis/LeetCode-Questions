class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Long start = 1L, middle = 0L;
        Long end = Long.MIN_VALUE;
        int ans = 0;
        for(int i=0;i<piles.length;i++) {
            end = Long.valueOf(Math.max(end, Long.valueOf(piles[i])));
        }
        Long maxValue = end;
        while(start<=end) {
            middle = start + (end - start) /2;
            if(isPossible(middle, piles, Long.valueOf(h))) {
                ans = Integer.parseInt(middle.toString());
                end = middle - 1;
            }
            else {
                start = middle + 1;
            }
        }

        return ans == 0 ? Integer.parseInt(maxValue.toString()) : ans;
    }

    public boolean isPossible(Long speed, int piles[], Long h) {
        Long hourCount = 0L;
        for(int i=0;i<piles.length;i++) {
            hourCount+= (Long.valueOf(piles[i]) + speed - 1) / speed;
        }

        return hourCount <= h ? true : false;
    }
}