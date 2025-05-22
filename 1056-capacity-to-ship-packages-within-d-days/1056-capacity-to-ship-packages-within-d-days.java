class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int minPackageWeight = Integer.MAX_VALUE;
        int maxPackageWeight = 0;
        int middle = 0;
        int ans = 0;
        for(int i=0;i<weights.length;i++) {
            maxPackageWeight+=weights[i];
            minPackageWeight = Math.min(minPackageWeight, weights[i]);
        }

        while(minPackageWeight<=maxPackageWeight) {
            middle = (minPackageWeight + maxPackageWeight)/ 2;
            if(isPossibleShip(middle, weights, days)) {
                ans = middle;
                maxPackageWeight = middle - 1;
            }
            else {
                minPackageWeight = middle + 1;
            }
        }
        return ans;
    }

    public boolean isPossibleShip(int wt, int weights[], int days) {
        int sum = 0;
        int dayCount = 0;
        for(int i=0;i<weights.length;i++) {
            sum+=weights[i];
            if(weights[i] > wt) return false;
            else if(sum > wt) {
                dayCount++;
                sum = 0;
                sum+=weights[i];
            }
        }

        return (dayCount < days) ? true : false;
    }
}