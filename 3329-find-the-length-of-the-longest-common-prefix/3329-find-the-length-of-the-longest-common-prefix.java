class Solution {
    public HashSet<Integer> set = new HashSet<>();

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int ans = 0;
        for(int i=0;i<arr1.length;i++) {
            findPrefix(arr1[i]);
        }

        for(int i=0;i<arr2.length;i++) {
            int afterChecking = checkPrefix(arr2[i]);
            if(afterChecking != 0) {
                String strValue = String.valueOf(afterChecking);
                ans = Math.max(ans, strValue.length());
            }
        }

        return ans;
    }

    public void findPrefix(int number) {
        set.add(number);
        while(number != 0) {
            int temp = number % 10;
            number = number / 10;
            set.add(number);
        }
    }

    public int checkPrefix(int number) {
        if(set.contains(number)) return number;
        while(number != 0) {
            int temp = number % 10;
            number = number / 10;
            if(set.contains(number)) return number;
        }
        return 0;
    }
}