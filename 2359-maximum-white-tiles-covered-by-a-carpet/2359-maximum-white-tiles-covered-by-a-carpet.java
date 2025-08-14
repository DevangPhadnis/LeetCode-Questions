class Solution {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, (a, b) -> Integer.compare(a[0], b[0]));
        int i = 0;
        int j=0;
        int covered = 0;
        int ans = 0;

        while(i < tiles.length && ans < carpetLen) {
            long carpetEnd = Long.valueOf(tiles[i][0] + carpetLen - 1);

            while(j < tiles.length && tiles[j][1] <= carpetEnd) {
                covered = covered + (tiles[j][1] - tiles[j][0] + 1);
                j++;
            }

            int currentCovered = covered;
            if(j<tiles.length && tiles[j][0] <= carpetEnd) {
                currentCovered = currentCovered + (int) (carpetEnd - tiles[j][0] + 1);
            }

            ans = Math.max(ans, currentCovered);

            if(ans == carpetLen) break;

            if(i < j) {
                covered = covered - (tiles[i][1] - tiles[i][0] + 1);
            }
            i++;
        }
        return ans;
    }
}