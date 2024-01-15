class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int sSz = s.length();
        Set<String> dict = new HashSet<>();
        for(var word : wordDict)dict.add(word);
        int []safeState = new int[sSz+1];
        safeState[0] = 1;
        for(int len = 1; len <= sSz; len++){
            for(int left = len-1; left > -1; left--){
                if(safeState[left] == 1){
                    int right = len;
                    if(dict.contains(s.substring(left, right))){
                        safeState[len] = 1;
                        break; 
                    }
                }    
            }
        }
        return safeState[sSz] == 1;
    }
}