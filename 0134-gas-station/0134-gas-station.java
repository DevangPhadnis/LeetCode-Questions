class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0, currentGas = 0, totalGas = 0, totalCost = 0;
        for(int i=0;i<gas.length;i++) {
            totalGas+=gas[i];
            totalCost+=cost[i];
            currentGas+= gas[i] - cost[i];
            if(currentGas < 0) {
                start = i+1;
                currentGas = 0;
            }
        }

        return totalGas < totalCost ? -1 : start;
    }
}