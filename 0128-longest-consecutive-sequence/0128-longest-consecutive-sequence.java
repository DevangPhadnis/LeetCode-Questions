class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;

        int longest = 1;

        Set<Integer> elements = new HashSet<>();
        for(int i=0;i<nums.length;i++) {
            elements.add(nums[i]);
        }

        for(Integer it: elements) {
            if(!elements.contains(it-1)) {
                int count = 1;
                int number = it;
                while(elements.contains(number+1)) {
                    number = number + 1;
                    count = count + 1;
                }

                longest = Math.max(count, longest);
            }
        }

        return longest;
    }
}