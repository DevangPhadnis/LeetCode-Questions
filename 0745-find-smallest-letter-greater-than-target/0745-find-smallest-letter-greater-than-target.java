class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;
        while(start <= end) {
            int mid = (start + end) /2;
            if(letters[mid] > target) end = mid - 1;
            else start = mid +1;
        }

        return start == letters.length ? letters[0] : letters[start];
    }
}