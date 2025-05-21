class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1;i<=numRows;i++) {
            ans.add(generateRow(i));
        }
        return ans;
    }

    public List<Integer> generateRow(int rowNumber) {
        int ans = 1;
        List<Integer> temp = new ArrayList<>();
        temp.add(ans);
        for(int i=1;i<rowNumber;i++) {
            ans = ans * (rowNumber - i);
            ans = ans / i;
            temp.add(ans);
        }
        return temp;
    }
}