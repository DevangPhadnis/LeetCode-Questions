class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        Long res = 1L;
        ans.add(1);
        for(int i=1;i<rowIndex+1;i++) {
            res = res*Long.valueOf((rowIndex+1-i));
            res = res / Long.valueOf(i);
            ans.add(Integer.parseInt(res.toString()));
        }
        return ans;
    }
}