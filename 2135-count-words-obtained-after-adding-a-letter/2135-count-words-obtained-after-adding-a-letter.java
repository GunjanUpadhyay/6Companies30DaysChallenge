class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        Set<Integer> s = new HashSet<>();
        int res = 0;
        for(String sw : startWords) s.add(bitMask(sw));
        
        for(String tw : targetWords) {
            int twBitmask = bitMask(tw);
            for(char c : tw.toCharArray()) {
                if(s.contains(twBitmask - (1 << c - 'a'))) {
                    res++;
                    break;
                }
            }
        } 
        return res;
    }
    
    private int bitMask(String s) {
        int res = 0;
        for(char c : s.toCharArray()) res += 1 << c - 'a';
        return res;
    }
}