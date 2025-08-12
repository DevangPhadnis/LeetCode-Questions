class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        ans.add(words[0]);
        for(int i=1;i<words.length;i++) {
            if(checkAnagram(words[i], ans.getLast())) continue;
            else ans.add(words[i]);
        }

        return ans;
    }

    public boolean checkAnagram(String firstWord, String secondWord) {
        char[] charFirstWord = firstWord.toCharArray();
        char[] charSecondWord = secondWord.toCharArray();
        Arrays.sort(charFirstWord);
        Arrays.sort(charSecondWord);

        firstWord = new String(charFirstWord);
        secondWord = new String(charSecondWord);
        if(firstWord.equals(secondWord)) return true;
        else return false;
    }
}