class Solution {
    public boolean isPalindrome(String s) {
        ArrayList<Character> charList = new ArrayList<>();
        for(int i=0;i<s.length();i++) {
            if(Character.isLetterOrDigit(s.charAt(i)) 
            && !Character.isDigit(s.charAt(i))) {
                charList.add(Character.toLowerCase(s.charAt(i)));
            }
            else if(Character.isLetterOrDigit(s.charAt(i)) 
            && Character.isDigit(s.charAt(i))) {
                charList.add(s.charAt(i));
            }
        }
        int start = 0;
        int end = charList.size() - 1;
        while(start < end) {
            if(charList.get(start) != charList.get(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}