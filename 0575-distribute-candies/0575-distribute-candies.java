class Solution {
    public int distributeCandies(int[] candyType) {
        int rule = candyType.length / 2;
        int count = 1;
        Arrays.sort(candyType);

        for(int i=1;i<candyType.length;i++) {
            if(candyType[i] != candyType[i-1]) count++;
            if(count > rule) return count - 1;
        }

        return count;
    }
}