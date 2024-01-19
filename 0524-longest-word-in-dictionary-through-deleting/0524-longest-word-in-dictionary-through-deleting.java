class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
      int maxLength = 0;
        String maxWord = "";

        for(String word : dictionary) {
            int length = checkIfWordPresentInString(s, word);

            if(length > maxLength || (length == maxLength && maxWord.compareTo(word) > 0)) {
                maxLength = length;
                maxWord = word;
            }
        }

        return maxWord;  
    }
     public int checkIfWordPresentInString(String s, String word) {

        for(int i = 0, j = 0; i <= s.length() - 1; i++) {
            if(s.charAt(i) == word.charAt(j)) {
                j++;

                if(j == word.length()) {
                    return j;
                }
            }
        }
        return 0;
    }
}